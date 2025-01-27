package com.nopCommerce.pages;

import com.nopCommerce.locators.HomeNopCommerceLocators;
import org.openqa.selenium.WebDriver;

public class HomeNopCommercePage extends BasePage implements TitleInterface {

    public HomeNopCommercePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the register button on the home page.
     */
    public void clickOnRegisterButton() {
        driver.findElement(HomeNopCommerceLocators.REGISTER_BUTTON).click();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }
}
