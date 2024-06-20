package com.nopCommerce.steps;

import com.nopCommerce.pages.HomeNopCommercePage;
import com.nopCommerce.pages.RegisterNopCommercePage;
import io.cucumber.java.en.*;
import com.nopCommerce.utils.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterSteps {
    WebDriver driver;

    @Given("the user is on the nonCommerce page")
    public void the_user_is_on_the_nonCommerce_page() {
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
