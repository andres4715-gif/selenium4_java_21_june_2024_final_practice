package com.nopCommerce.pages;

import com.nopCommerce.locators.ComputersNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputerNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(ComputerNopCommercePage.class);

    public ComputerNopCommercePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnComputerType(String option) {
        WebElement computerOption = driver.findElement(ComputersNopCommerceLocators.computerOption(option));
        waitForElementToBeVisible(computerOption).click();
        logger.info("--- Clicked on {}", option);
    }
}
