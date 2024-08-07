package com.nopCommerce.steps;

import com.nopCommerce.FormRegisterData;
import com.nopCommerce.helpers.FormRegisterDataHelper;
import com.nopCommerce.pages.RegisterNopCommercePage;
import com.nopCommerce.utils.Hooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class RegisterSteps {
    private static final Logger logger = LoggerFactory.getLogger(RegisterSteps.class);
    private WebDriver driver = Hooks.getDriver();
    RegisterNopCommercePage registerNopCommercePage;

    @Then("the user checks the checkbox functionality working properly")
    public void the_user_checks_the_checkbox_functionality_working_properly() {
        registerNopCommercePage = new RegisterNopCommercePage(driver);
        logger.info("--- The obtained Title on Register page is: " + registerNopCommercePage.gitTitle());
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Register");
        Assert.assertFalse(registerNopCommercePage.uncheckNewsLetterCheckbox());
    }

    @Then("the user adds the personal information, on the Register Page")
    public void the_user_adds_the_personal_information_on_the_Register_Page(io.cucumber.datatable.DataTable dataTable) {
        registerNopCommercePage = new RegisterNopCommercePage(driver);
        FormRegisterData formRegisterData = FormRegisterDataHelper.convertDataTableToFormRegisterData(dataTable);
        registerNopCommercePage.fillRegisterForm(formRegisterData);
    }

    @Then("the user choose his gender, on the Register Page")
    public void the_user_choose_his_gender_on_the_Register_Page() {
        registerNopCommercePage = new RegisterNopCommercePage(driver);
        Assert.assertFalse(registerNopCommercePage.checkGenderDefaultStatus());
        Assert.assertTrue(registerNopCommercePage.selectMaleGender());
    }

    @Then("the user choose Day of birth, on the Register Page")
    public void the_user_choose_Day_of_birth_on_the_Register_Page(io.cucumber.datatable.DataTable dataTable) {
        registerNopCommercePage = new RegisterNopCommercePage(driver);
        FormRegisterData formRegisterData = FormRegisterDataHelper.convertDataTableToFormRegisterData(dataTable);
        registerNopCommercePage.fillDayOfBirthDay(formRegisterData);
    }
}
