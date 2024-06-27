Feature: Register and adding personal data

  @Smoke
  Scenario: Check checkbox functionality in the Register Page
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user checks the checkbox functionality working properly

  @Smoke
  Scenario: Register new user in the Register Page
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user adds the personal information, on the Register Page
      | firstName | lastName | email                | companyName | password     | confirmPassword |
      | John      | Doe      | john_doe@hotmail.com | NinjaOne    | abcABC123123 | abcABC123123    |

  @Smoke
  Scenario: Choose male gender in the Register Page
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user choose his gender, on the Register Page

  @Smoke
  Scenario: Check dropdown functionality in the Register Page
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user choose Day of birth, on the Register Page
      | day |
      | 21  |