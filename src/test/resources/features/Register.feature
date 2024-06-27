Feature: Register and adding personal data

  @Smoke
  Scenario: Check checkbox functionality
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user checks the checkbox functionality working properly

  Scenario: Register new user in the nopCommerce app
    Given the user is on the nonCommerce page
    When the user clicks on register
    Then the user adds the personal information, on the Register Page
      | firstName | lastName | email                | companyName | password     | confirmPassword |
      | John      | Doe      | john_doe@hotmail.com | NinjaOne    | abcABC123123 | abcABC123123    |