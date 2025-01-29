package com.nopCommerce.steps;

import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotebookSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(NotebookSteps.class);

    @When("the user clicks on the Add to cart button for the {string} option")
    public void the_user_clicks_on_the_Add_to_cart_button_for_the_any_option(String option) {
        notebookNopCommercePage.clickOnSecondProductOption(option);
        logger.info("--- The user is able to click on {}" , option + " option to add a cart");
    }
}
