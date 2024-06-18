package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeNopCommercePage {
    WebDriver driver;

    By customerCurrency = By.cssSelector("[name='customerCurrency']");
    By registerButton = By.cssSelector(".ico-register");


    public HomeNopCommercePage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseCurrencyOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerCurrency));
        Select currencyOption = new Select(driver.findElement(customerCurrency));
        currencyOption.selectByVisibleText("Euro");
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
