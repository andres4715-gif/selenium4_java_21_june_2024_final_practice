package com.nopCommerce.steps;

import com.nopCommerce.pages.LoginPage;
import io.cucumber.java.en.*;
import com.nopCommerce.utils.Hooks;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = Hooks.getDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        System.out.println("--- Add your assertion here to verify user is on the homepage");
    }
}
