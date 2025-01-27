package com.nopCommerce.pages;

import com.nopCommerce.locators.HomeNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(RegisterNopCommercePage.class);

    public HomeNopCommercePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the register button on the home page.
     */
    public void clickOnRegisterButton() {
        logger.info("--- Click on register button");
        driver.findElement(HomeNopCommerceLocators.REGISTER_BUTTON).click();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }
}
