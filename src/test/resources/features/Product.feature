@Product
Feature: Checkout and search products

  Background:
    Given the user is on the nonCommerce page

  @Smoke @Regression
  Scenario Outline: Search for a product and verify results
    When the user searches for the product "<search>"
    Then the user should see a list of products related to "<product>"

    Examples:
      | search  | product |
      | laptop  | laptop  |
      | samsung | samsung |
      | iphone  | iphone  |
      | ring    | ring    |

  @Sanity @Regression
  Scenario: Add a product to the shopping cart
    When the user navigates to the "computers" category
    And the user selects the product "notebooks"
    And the user clicks on the Add to cart button for the "2" option
    Then the user can see the validation message after adding a product

  @Sanity @Regression
  Scenario: Update product quantity in the shopping cart using DataTable
    When the user has added the product Build your own computer to the shopping cart
    When the user navigates to the shopping cart
    And the user updates the product quantity as follows:
      | productName             |
      | Build your own computer |
    Then the user can see the total price is updated according the quantity of products

  @Sanity @Regression
  Scenario: Update product quantity in the shopping cart using DataTable
    When the user choose "New products" on the Customer service footer area
    And the user clicks over the first product listed on the product page
    And the user fill data product information before add to cart
    And the user clicks on Add to cart button
    Then the user can see the validation message after adding a product

  @Sanity @Regression @poll
  Scenario: Community poll for register users
    When the user selects the "Community poll" option "Good" in the home page