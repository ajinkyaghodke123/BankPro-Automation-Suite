# BankPro Automation Suite

End-to-end test automation for the [ParaBank](https://parabank.parasoft.com/parabank/index.htm) demo banking application, covering both UI and API layers.

## Tech stack

| Area | Tool |
|------|------|
| Language | Java 11 |
| UI automation | Selenium WebDriver 4, WebDriverManager |
| API automation | REST Assured, JSONPath |
| Test runner | TestNG |
| Reporting | Extent Reports, Allure |
| Build | Maven |

## What is covered

- **UI:** login, open new account, account overview, funds transfer, logout
- **API:** account and funds-transfer endpoints, validated against the account created in the UI flow

## Project structure

```
src/test/java
├── base/      TestBase - browser setup and teardown
├── pages/     Page Object Model classes
├── tests/     UI tests (tests/APITests holds API tests for funds transfer)
├── api/       API tests
└── utils/     ConfigReader, TestDataStore, Extent reporting, API helpers
src/test/resources/config.properties   URL, credentials, browser, timeouts
testng.xml                             Suite definition (UI tests run first, then API)
```

## Prerequisites

- JDK 11 or newer
- Maven 3.8+
- Chrome, Firefox or Edge installed

## Run the tests

```bash
mvn clean test
```

Override settings from the command line:

```bash
mvn clean test -Dbrowser=firefox
```

## Reports

- **Extent / TestNG:** generated in `test-output/` after each run
- **Allure:** `mvn allure:serve` (after a run)

Report folders are git-ignored and are not committed.

## Notes

- The credentials in `config.properties` are the public demo login that ParaBank provides, not real secrets.
- Test order matters: `OpenNewAccountTest` stores the new account ID that the API tests read.
