package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewSystemUserPage {
    WebDriver driver;

    By userName = By.cssSelector("[class='oxd-input oxd-input--active']:nth-child(1)");

    public ViewSystemUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        driver.findElement(userName).sendKeys("AdminUserName");
    }
}
