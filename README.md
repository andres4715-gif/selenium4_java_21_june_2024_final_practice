# *Selenium4, WEB project 2024 - 2025*

## Stack: 
- Selenium4
- Cucumber BDD
- cucumber-java
- TestNG
- slf4j
- logback-classic
- Maven
- Webdrivermanager
- Lombok
- maven-cucumber-reporting

## *Structure*
![img.png](img.png)

# Description of the Project Structure

## src/main/java
Contains the main Java source files.

- `com/nopCommerce/helpers/FormRegisterDataHelper.java`: Helper class for form registration data.
- `com/nopCommerce/locators/RegisterNopCommerceLocators.java`: Locators for the registration page.
- `com/nopCommerce/pages/HomeNopCommercePage.java`: Page Object Model (POM) class for the home page.
- `com/nopCommerce/FormRegisterData.java`: Data class for form registration.

## src/main/resources
Contains configuration and resource files.

- `logback.xml`: Configuration for logging.

## src/test/java
Contains the test Java source files.

- `com/nopCommerce/runners/TestRunner.java`: Configuration for the test runner.
- `com/nopCommerce/steps/RegisterSteps.java`: Step definitions for Cucumber.
- `com/nopCommerce/utils/Hooks.java`: Hooks for setup and teardown.
- `com/nopCommerce/utils/GenerateReport.java`: Utility for generating test reports.

## src/test/resources
Contains the resources for tests.

- `features/Register.feature`: Feature file for Cucumber tests.
- `config.properties`: Configuration properties for the tests.

## Project Configuration Files

- `.gitignore`: Git ignore file.
- `pom.xml`: Maven configuration file.
- `testng.xml`: TestNG configuration file.

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
- [ ] Send data using env variables from TESTNG or from .properties file
- [ ] Create more TESTNG files to run test for regression, sanity y smock test 
- [ ] Create a new docker file to run on the cloud
- [ ] Fix setup on the github repository to protect the master branch and checks validations
- [ ] Update github action to send an email after finishing the merge into Master branch


# Ready
- [X] Made a new title interface to implement on specific pages
- [X] Edit the README file with the new folder structure and paths
- [X] Check execution in parallel and non parallel both executions working fine
- [X] Convert getter and setters to work with lombok
- [X] Reporting ExtentReports, Allure or Cucumber
- [X] Add more scenarios to run with TestNG (with more test added)
- [X] TESTNG's execution by class and methods or @tags
- [X] Tagging to run specific test or suite
- [X] CI/CD Jenkins, GitLab CI, CircleCI or github actions
- [X] Logging SLF4J and logback-classic
- [X] Update dependencies and vulnerability in the POM File
- [X] Implement explicit waits
- [X] Create a new method to handle a dropdown in Common file

🚀🚚 FRAMEWORK IN CONSTRUCTION 🚧🪚