package com.nopCommerce.steps;

import com.nopCommerce.pages.HomeNopCommercePage;
import com.nopCommerce.pages.RegisterNopCommercePage;
import com.nopCommerce.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class RegisterSteps {
    private static final Logger logger = LoggerFactory.getLogger(RegisterSteps.class);
    WebDriver driver;

    @Given("the user is on the nonCommerce page")
    public void the_user_is_on_the_nonCommerce_page() {
        logger.info("--- Navigating to nonCommerce page");
        driver = Hooks.getDriver();
        driver.get(Hooks.getBaseUrl());
    }

    @When("the user clicks on register")
    public void the_user_clicks_on_register() {
        HomeNopCommercePage homeNopCommercePage = new HomeNopCommercePage(driver);
        homeNopCommercePage.clickOnRegisterButton();
    }

    @Then("the user checks the checkbox functionality working properly")
    public void the_user_checks_the_checkbox_functionality_working_properly() {
        RegisterNopCommercePage registerNopCommercePage = new RegisterNopCommercePage(driver);
        Assert.assertFalse(registerNopCommercePage.uncheckNewsLetterCheckbox());
    }
}
