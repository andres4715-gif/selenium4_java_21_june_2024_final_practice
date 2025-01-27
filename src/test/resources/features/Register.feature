Feature: Register and adding personal data

  Background:
    Given the user is on the nonCommerce page

  @Smoke @Regression
  Scenario: Check checkbox functionality in the Register Page
    When the user clicks on register
    Then the user checks the checkbox functionality working properly

  @Sanity @Regression
  Scenario: Register new user in the Register Page
    When the user clicks on register
    Then the user adds the personal information, on the Register Page
      | firstName | lastName | email                | companyName | password     | confirmPassword |
      | John      | Doe      | john_doe@hotmail.com | NinjaOne    | abcABC123123 | abcABC123123    |

  @Smoke @Regression
  Scenario: Choose male gender in the Register Page
    When the user clicks on register
    Then the user choose his gender, on the Register Page

  @Sanity @Regression
  Scenario: Check dropdown functionality in the Register Page
    When the user clicks on register
    Then the user choose Day of birth, on the Register Page
      | day |
      | 21  |