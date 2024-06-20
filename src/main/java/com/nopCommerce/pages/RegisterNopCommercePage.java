package com.nopCommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterNopCommercePage extends BasePage {
    private final By newsletter = By.id("Newsletter");

    public RegisterNopCommercePage(WebDriver driver) {
        super(driver);
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
