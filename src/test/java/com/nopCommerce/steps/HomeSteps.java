package com.nopCommerce.steps;

import com.nopCommerce.pages.HomeNopCommercePage;
import com.nopCommerce.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class HomeSteps {
    private static final Logger logger = LoggerFactory.getLogger(HomeSteps.class);
    private WebDriver driver = Hooks.getDriver();

    HomeNopCommercePage homeNopCommercePage;

    @Given("the user is on the nonCommerce page")
    public void the_user_is_on_the_nonCommerce_page() {
        logger.info("--- Navigating to nonCommerce page");
        driver = Hooks.getDriver();
        driver.get(Hooks.getBaseUrl());
    }

    @When("the user clicks on register")
    public void the_user_clicks_on_register() {
        homeNopCommercePage = new HomeNopCommercePage(driver);
        logger.info("--- The obtained Title on Home page is: " + homeNopCommercePage.getTitle());
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        homeNopCommercePage.clickOnRegisterButton();
    }
}
