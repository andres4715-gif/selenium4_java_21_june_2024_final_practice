@Product
Feature: Checkout and search products

  Background:
    Given the user is on the nonCommerce page

  @Smoke @Regression
  Scenario: Search for a product and verify results
    When the user searches for the product "laptop"
    Then the user should see a list of products related to "laptop"

#  @Sanity @Regression
#  Scenario: Add a product to the shopping cart
#    When the user navigates to the "Computers" category
#    And the user selects the product "Build your own computer"
#    And the user clicks on the "Add to cart" button
#    Then the product "Build your own computer" should be added to the shopping cart
#    And the user should see a confirmation message "The product has been added to your shopping cart"

#  @Smoke @Regression
#  Scenario: Proceed to checkout as a guest
#    Given the user has added the product "Build your own computer" to the shopping cart
#    When the user navigates to the shopping cart
#    And the user clicks on the "Checkout" button
#    And the user selects the "Checkout as Guest" option
#    Then the user should be redirected to the checkout page
#    And the user should see the "Billing address" form

#  @Sanity @Regression
#  Scenario: Update product quantity in the shopping cart using DataTable
#    Given the user has added the product "Build your own computer" to the shopping cart
#    When the user navigates to the shopping cart
#    And the user updates the product quantity as follows:
#      | productName               | quantity |
#      | Build your own computer   | 2        |
#    And the user clicks on the "Update shopping cart" button
#    Then the quantity of the product "Build your own computer" should be updated to "2"
#    And the total price should reflect the updated quantity