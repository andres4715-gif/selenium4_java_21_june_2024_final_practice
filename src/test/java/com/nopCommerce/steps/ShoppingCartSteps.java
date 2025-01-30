package com.nopCommerce.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ShoppingCartSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartSteps.class);

    double initialProductValue = 0;

    @When("the user updates the product quantity as follows:")
    public void the_user_updates_the_product_quantity_as_follows(DataTable dataTable) throws InterruptedException {
        String expectedProductName = "";
        String finalProductName = shoppingCartNopCommercePage.getProductName();
        logger.info("--- The product name displayed on the Shopping cart page is: {}", finalProductName);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            expectedProductName = row.get("productName");
        }
        Assert.assertEquals(finalProductName, expectedProductName, "Product name is not the same");
        initialProductValue = shoppingCartNopCommercePage.updateQuantity();
        Thread.sleep(4000);
    }

    @Then("the user can see the total price is updated according the quantity of products")
    public void the_user_can_see_the_total_price_is_updated_according_the_quantity_of_products() {
        double finalProductValue = shoppingCartNopCommercePage.getFinalTotal();
        Assert.assertEquals((initialProductValue * 2), finalProductValue, "Check the total amount to pay on shopping cart page");
        logger.info("--- The total final value after updating is: {}", finalProductValue);
    }
}
