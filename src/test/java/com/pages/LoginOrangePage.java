package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginOrangePage {
    WebDriver driver;

    By userName = By.cssSelector("[name='username']");

    public LoginOrangePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addingUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        userNameElement.sendKeys("Admin");
    }
}
