package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    protected WebDriver driver;

    By multipleWindows = By.xpath("//*[text()= 'Multiple Windows']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMultipleWindows() {
        driver.findElement(multipleWindows).click();
    }
}
