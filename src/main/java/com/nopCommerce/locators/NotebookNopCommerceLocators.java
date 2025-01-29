package com.nopCommerce.locators;

import org.openqa.selenium.By;

public class NotebookNopCommerceLocators {
    public static final By CATEGORY_NAME_TITLE = By.cssSelector("[class='page-title']");
    public static By addToCartButtonLocator(String option) {
        return By.xpath("(//div[@class='buttons'])[" + option + "]");
    }
}
