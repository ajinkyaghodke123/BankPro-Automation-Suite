package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads framework settings from config.properties on the classpath.
 * Any key can be overridden with a JVM system property, e.g. -Dbrowser=firefox.
 */
public final class ConfigReader {

    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (in == null) {
                throw new IllegalStateException(CONFIG_FILE + " not found on the classpath");
            }
            PROPS.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load " + CONFIG_FILE, e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        return System.getProperty(key, PROPS.getProperty(key));
    }
}
