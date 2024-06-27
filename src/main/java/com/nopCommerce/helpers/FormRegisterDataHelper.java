package com.nopCommerce.helpers;

import com.nopCommerce.FormRegisterData;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class FormRegisterDataHelper {

    public static FormRegisterData convertDataTableToFormRegisterData(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        FormRegisterData formRegisterData = new FormRegisterData();

        formRegisterData.setFirstName(data.get(0).get("firstName"));
        formRegisterData.setLastName(data.get(0).get("lastName"));
        formRegisterData.setEmail(data.get(0).get("email"));
        formRegisterData.setCompanyName(data.get(0).get("companyName"));
        formRegisterData.setPassword(data.get(0).get("password"));
        formRegisterData.setConfirmPassword(data.get(0).get("confirmPassword"));
        formRegisterData.setDay(data.get(0).get("day"));
        return formRegisterData;
    }
}
