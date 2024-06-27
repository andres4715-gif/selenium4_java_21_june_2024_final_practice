# *Selenium4, WEB project 2024 - 2025*

## Stack: 
- Selenium4
- Cucumber BDD
- TestNG
- slf4j
- Maven
- Webdrivermanager

## *Structure*

![img_1.png](img_1.png)

## Directory Details

### `src/main/java/com/nopCommerce/locators`

- **HomeNopCommerceLocators.java**: Contains locators for the Home page elements.

### `src/main/java/com/nopCommerce/pages`

- **BasePage.java**: A base page class that other page classes extend.
- **HomeNopCommercePage.java**: Contains methods to interact with the Home page.

### `src/test/java/com/nopCommerce/steps`

- **LoginSteps.java**: Step definitions for the login feature.

### `src/test/java/com/nopCommerce/utils`

- **Hooks.java**: Contains setup and teardown methods for the tests.

### `src/test/java/com/nopCommerce/runners`

- **TestRunner.java**: Configures and runs the Cucumber tests with TestNG.

### `src/test/resources/features`

- **login.feature**: Contains the Cucumber feature file for login tests.

## Usage

### Prerequisites

- Java JDK
- Maven
- ChromeDriver (managed by WebDriverManager)
- An IDE like IntelliJ IDEA or Eclipse

### Running the Tests

1. Clone the repository.
2. Navigate to the project directory.
3. Run the following Maven command to execute the tests:

```bash
$ mvn test
```

## How install Maven dependencies: 
```bash
$ mvn install -U
```

## More cucumber options: 
- src/test/java/com/nopCommerce/runners/TestRunner.java
```text
monochrome = true, "Removes ANSI control characters to improve readability."
tags = "@smoke", "Executes only the scenarios tagged as @smoke."
strict = true, "Causes the tests to fail if there are undefined or unimplemented steps."
dryRun = false, "Runs the scenarios without actually executing the steps (false: normal execution)."
snippets = SnippetType.CAMELCASE "Generates snippets using camelCase."
```
---
# *TestNG*
## How to run the project:


```shell
* Command line: 

$ mvn test -DsuiteXmlFile=testng.xml

Or 

Also is possible to run the specific file just right click on the file: `testng.xml` 
then choose the TestNG option to run the file
```
## To run the specific Scenario with @tag 

1. Add a @tag to specific scenario.
```Gherkin
  @Smoke
  Scenario: Check checkbox functionality
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user checks the checkbox functionality working properly
```
2. Add this @tag on the cucumber options
```Properties
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.nopCommerce.steps", "com.nopCommerce.utils"},
        tags = "@Smoke",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
```
3. Run with command line: 
```shell
$ mvn test -Dcucumber.filter.tags="@Smoke" -DsuiteXmlFile=testng.xml
```
___

# *TODO*
- [X]  Reporting ExtentReports, Allure or Cucumber
- [X]  Logging SLF4J and logback-classic
- [ ]  CI/CD Jenkins, GitLab CI, CircleCI
- [X]  Tagging to run specific test or suite
- [X]  TESTNG's execution by class and methods or @tags
- [ ]  Add more scenarios to run with TestNG (with more test added)
- [ ]  Send data using env variables from TESTNG or from .properties file
- [ ]  Convert getter and setters to work with lombok
- [ ]  Create new folder structure and change image on the readme file. 
- [ ]  Check execution in parallel and non parallel both executions working fine