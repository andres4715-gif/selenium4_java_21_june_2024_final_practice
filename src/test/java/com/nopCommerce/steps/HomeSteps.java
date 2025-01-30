package com.nopCommerce.steps;

import com.nopCommerce.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class HomeSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(HomeSteps.class);

    @Given("the user is on the nonCommerce page")
    public void the_user_is_on_the_nonCommerce_page() {
        logger.info("--- Navigating to nonCommerce page");
        driver.get(Hooks.getBaseUrl());
    }

    @When("the user clicks on register")
    public void the_user_clicks_on_register() {
        logger.info("--- The obtained Title on Home page is: {}", homeNopCommercePage.getTitle());
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
        homeNopCommercePage.clickOnRegisterButton();
    }

    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String product) {
        logger.info("--- Searching product: {}, Adding it in the search box", product);
        homeNopCommercePage.addAnyProductInTheSearchBox(product);
        logger.info("--- Product: {}, Added in the search box", product);
        homeNopCommercePage.clickSubmit();
    }

    @When("the user navigates to the {string} category")
    public void the_user_navigates_to_the_Computers_category(String category) {
        homeNopCommercePage.clickComputerMenu(category);
        logger.info("--- The user was able to click on the computer button in the main menu");
    }

    @When("the user has added the product Build your own computer to the shopping cart")
    public void the_user_has_added_the_product_to_the_shopping_cart() {
        homeNopCommercePage.clickAddToCartButton();
        homeNopCommercePage.chooseRam();
        homeNopCommercePage.chooseHdd();
        homeNopCommercePage.clickAddToCart();
    }

    @When("the user navigates to the shopping cart")
    public void the_user_navigates_to_the_shopping_cart() {
        shoppingCartNopCommercePage.clickOnShoppingCartButton();
    }
}
