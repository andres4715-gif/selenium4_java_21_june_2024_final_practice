package com.nopCommerce;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * This class represents the data for registering a user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormRegisterData {

    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String password;
    private String confirmPassword;
    private String day;
}
