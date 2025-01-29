package com.nopCommerce.steps;

import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ComputerSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(ComputerSteps.class);

    @When("the user selects the product {string}")
    public void the_user_selects_the_product(String option) {
        logger.info("--- The user is able to click on {}" , option + " in the Computer page");
        computerNopCommercePage.clickOnComputerType(option);
        String categoryTitleName = notebookNopCommercePage.verifyCategoryNameTitle();
        Assert.assertEquals(categoryTitleName, option, "Category tittle name is not correct");
    }
}
