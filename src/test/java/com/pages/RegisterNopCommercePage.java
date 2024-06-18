package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterNopCommercePage {
    WebDriver driver;

    By male = By.id("gender-male");

    public RegisterNopCommercePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkMaleRadioButtonStatus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(male));
        System.out.println("--- The Male radio button is selected: " + driver.findElement(male).isSelected());
        return driver.findElement(male).isSelected();
    }

    public void selectMaleRadioButtonToActive() {
        driver.findElement(male).click();
    }
}
