package com.nopCommerce.pages;

import com.nopCommerce.FormRegisterData;
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
        if(driver.findElement(RegisterNopCommerceLocators.NEWS_LETTER_CHECKBOX).isSelected()) {
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
        if(driver.findElement(RegisterNopCommerceLocators.NEWS_LETTER_CHECKBOX).isSelected()) {
            driver.findElement(RegisterNopCommerceLocators.NEWS_LETTER_CHECKBOX).click();
        }
        return driver.findElement(RegisterNopCommerceLocators.NEWS_LETTER_CHECKBOX).isSelected();
    }

    /**
     * Fills the registration form with the provided user data.
     *
     * @param data An instance of FormRegisterData containing the user data to fill the form.
     */
    public void fillRegisterForm(FormRegisterData data) {
        driver.findElement(RegisterNopCommerceLocators.FIRST_NAME_INPUT).sendKeys(data.getFirstName());
        driver.findElement(RegisterNopCommerceLocators.LAST_NAME_INPUT).sendKeys(data.getLastName());
        driver.findElement(RegisterNopCommerceLocators.EMAIL_INPUT).sendKeys(data.getEmail());
        driver.findElement(RegisterNopCommerceLocators.COMPANY_INPUT).sendKeys(data.getCompanyName());
        driver.findElement(RegisterNopCommerceLocators.PASSWORD_INPUT).sendKeys(data.getPassword());
        driver.findElement(RegisterNopCommerceLocators.CONFIRM_PASSWORD_INPUT).sendKeys(data.getConfirmPassword());
    }
}
