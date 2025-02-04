package com.nopCommerce.steps;

import io.cucumber.datatable.DataTable;
import com.nopCommerce.helpers.Helpers;
import com.nopCommerce.models.FormRegisterData;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class RegisterSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(RegisterSteps.class);

    @Then("the user checks the checkbox functionality working properly")
    public void the_user_checks_the_checkbox_functionality_working_properly() {
        logger.info("--- The obtained Title on Register page is: {}", registerNopCommercePage.getTitle());
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Register");
        Assert.assertFalse(registerNopCommercePage.uncheckNewsLetterCheckbox());
    }

    @Then("the user adds the personal information, on the Register Page")
    public void the_user_adds_the_personal_information_on_the_Register_Page(DataTable dataTable) {
        logger.info("--- Filling data from dataTable");
        FormRegisterData formRegisterData = Helpers.convertDataTableToFormRegisterData(dataTable);
        registerNopCommercePage.fillRegisterForm(formRegisterData);
    }

    @Then("the user choose his gender, on the Register Page")
    public void the_user_choose_his_gender_on_the_Register_Page() {
        Assert.assertFalse(registerNopCommercePage.checkGenderDefaultStatus());
        Assert.assertTrue(registerNopCommercePage.selectMaleGender());
    }

    @Then("the user choose Day of birth, on the Register Page")
    public void the_user_choose_Day_of_birth_on_the_Register_Page(io.cucumber.datatable.DataTable dataTable) {
        FormRegisterData formRegisterData = Helpers.convertDataTableToFormRegisterData(dataTable);
        registerNopCommercePage.fillDayOfBirthDay(formRegisterData);
    }
}
