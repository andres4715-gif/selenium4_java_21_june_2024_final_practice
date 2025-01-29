package com.nopCommerce.pages;

import com.nopCommerce.locators.HomeNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(RegisterNopCommercePage.class);

    public HomeNopCommercePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnRegisterButton() {
        logger.info("--- Click on register button");
        waitForElementToBeClickable(
        driver.findElement(HomeNopCommerceLocators.REGISTER_BUTTON)).click();
    }

    public void addAnyProductInTheSearchBox(String product) {
        waitForElementToBeVisible(
        driver.findElement(HomeNopCommerceLocators.SEARCH_BOX)).sendKeys(product);
    }

    public void clickSubmit() {
        logger.info("--- Click on Search Button");
        WebElement searchButton = driver.findElement(HomeNopCommerceLocators.SEARCH_BUTTON);
        waitForElementToBeClickable(searchButton).click();
    }

    public void clickComputerMenu(String option) {
        logger.info("Click on {}",  option + " Menu");
        WebElement menuComputers = driver.findElement(HomeNopCommerceLocators.getMenuOption(option));
        waitForElementToBeClickable(menuComputers).click();
    }
}
