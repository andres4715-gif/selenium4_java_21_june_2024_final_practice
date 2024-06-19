package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterNopCommercePage {
    WebDriver driver;

    By male = By.id("gender-male");
    By newsletter = By.id("Newsletter");

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

    public void checkNewsLetterDefaultStatus() {
        if(driver.findElement(newsletter).isSelected()) {
            System.out.println("--- The news letter checkbox is selected by default.");
        } else {
            System.out.println("--- The news letter checkbox is not selected.");
        }
    }

    public boolean uncheckNewsLetterCheckbox() {
        checkNewsLetterDefaultStatus();
        if(driver.findElement(newsletter).isSelected()) {
            driver.findElement(newsletter).click();
        }
        return driver.findElement(newsletter).isSelected();
    }
}
