package com.nopCommerce.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class NotebookSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(NotebookSteps.class);

    @When("the user clicks on the Add to cart button for the {string} option")
    public void the_user_clicks_on_the_Add_to_cart_button_for_the_any_option(String option) throws InterruptedException {
        notebookNopCommercePage.clickOnSecondProductOption(option);
        logger.info("--- The user is able to click on {}" , option + " option to add a cart");
    }

    @Then("the user can see the validation message after adding a product")
    public void the_user_can_see_the_validation_message_after_adding_a_product() {
        String finalMessage = notebookNopCommercePage.verifySuccessAdditionToShoppingCartMessage();
        Assert.assertTrue(finalMessage.contains("The product has been added to your"));
        logger.info("--- the message to add products to the shopping cart is visible");
    }
}
