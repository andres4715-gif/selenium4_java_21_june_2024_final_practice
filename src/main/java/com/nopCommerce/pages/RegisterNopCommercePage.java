package com.nopCommerce.pages;

import com.nopCommerce.locators.RegisterNopCommerceLocators;
import org.openqa.selenium.WebDriver;

public class RegisterNopCommercePage extends BasePage {
    public RegisterNopCommercePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks the default status of the newsletter checkbox.
     * This method verifies whether the newsletter checkbox is selected by default
     * and prints the result to the console.
     */
    public void checkNewsLetterDefaultStatus() {
        if(driver.findElement(RegisterNopCommerceLocators.NEW_LETTER).isSelected()) {
            System.out.println("--- The news letter checkbox is selected by default.");
        } else {
            System.out.println("--- The news letter checkbox is not selected.");
        }
    }

    /**
     * Unchecks the newsletter checkbox if it is selected by default.
     * This method first checks the default status of the newsletter checkbox,
     * then unchecks it if it is selected. Finally, it returns the current
     * selected status of the checkbox.
     *
     * @return {@code false} if the newsletter checkbox is unchecked, {@code true} otherwise
     */
    public boolean uncheckNewsLetterCheckbox() {
        checkNewsLetterDefaultStatus();
        if(driver.findElement(RegisterNopCommerceLocators.NEW_LETTER).isSelected()) {
            driver.findElement(RegisterNopCommerceLocators.NEW_LETTER).click();
        }
        return driver.findElement(RegisterNopCommerceLocators.NEW_LETTER).isSelected();
    }
}
