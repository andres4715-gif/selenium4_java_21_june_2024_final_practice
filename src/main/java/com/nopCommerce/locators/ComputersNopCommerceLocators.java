package com.nopCommerce.locators;

import org.openqa.selenium.By;

public class ComputersNopCommerceLocators {
    public static By computerOption(String option) {
        return By.xpath("//h2[@class='title']//a[@href='/" + option + "']");
    }
}
