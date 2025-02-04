package com.nopCommerce.steps;

import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescriptionProductSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(DescriptionProductSteps.class);

    @When("the user fill data product information before add to cart")
    public void the_user_fill_data_product_information_before_add_to_cart() {
        descriptionProductNopCommercePage.inputRecipientName();
        logger.info("--- Product information successful added");
    }

    @When("the user clicks on Add to cart button")
    public void  the_user_clicks_on_Add_to_cart_button() {
        descriptionProductNopCommercePage.clickOnAddToCartButton();
    }
}
