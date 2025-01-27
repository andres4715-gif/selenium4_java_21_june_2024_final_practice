package com.nopCommerce.pages;

import com.nopCommerce.FormRegisterData;
import com.nopCommerce.locators.RegisterNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(RegisterNopCommercePage.class);

    public RegisterNopCommercePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks the default status of the newsletter checkbox.
     * This method verifies whether the newsletter checkbox is selected by default
     * and prints the result to the console.
     */
    public void checkNewsLetterDefaultStatus() {
        if (driver.findElement(RegisterNopCommerceLocators.NEWS_LETTER_CHECKBOX).isSelected()) {
            logger.info("--- The news letter checkbox is selected by default.");
        } else {
            logger.info("--- The news letter checkbox is not selected.");
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
        if (driver.findElement(RegisterNopCommerceLocators.NEWS_LETTER_CHECKBOX).isSelected()) {
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

    /**
     * Checks the default status of the gender male radio button.
     *
     * @return true if the male gender radio button is selected by default, false otherwise.
     */
    public boolean checkGenderDefaultStatus() {
        boolean genderMale = driver.findElement(RegisterNopCommerceLocators.GENDER_MALE_RADIO_BUTTON).isSelected();
        String result = String.format("--- The Default status is: %s", genderMale);
        logger.info(result);
        return genderMale;
    }

    /**
     * Selects the male gender radio button and checks its current status.
     *
     * @return true if the male gender radio button is selected, false otherwise.
     */
    public boolean selectMaleGender() {
        driver.findElement(RegisterNopCommerceLocators.GENDER_MALE_RADIO_BUTTON).click();
        boolean genderMaleCurrentStatus = driver.findElement(RegisterNopCommerceLocators.GENDER_MALE_RADIO_BUTTON).isSelected();
        String result = String.format("--- The Current status is: %s", genderMaleCurrentStatus);
        logger.info(result);
        return genderMaleCurrentStatus;
    }

    /**
     * Fills the day of birth dropdown with the provided day value from the given data.
     *
     * @param data An instance of FormRegisterData containing the day value to select in the dropdown.
     */
    public void fillDayOfBirthDay(FormRegisterData data) {
        WebElement dropdownDayElement = driver.findElement(RegisterNopCommerceLocators.DAY_BIRTH_DAY_DROP_DOWN);
        Select dropdown_day = new Select(dropdownDayElement);
        dropdown_day.selectByVisibleText(data.getDay());
        String dayToBeAdded = String.format("--- The Birth day to be added on the form is: %s", data.getDay());
        logger.info(dayToBeAdded);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }
}
