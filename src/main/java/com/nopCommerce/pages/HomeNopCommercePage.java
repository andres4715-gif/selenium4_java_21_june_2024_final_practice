package com.nopCommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeNopCommercePage extends BasePage{
    private final By registerButton = By.cssSelector(".ico-register");

    public HomeNopCommercePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
