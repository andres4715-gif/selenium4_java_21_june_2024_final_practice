package com.nopCommerce.locators;

import org.openqa.selenium.By;

public class NotebookNopCommerceLocators {
    public static final By CATEGORY_NAME_TITLE = By.cssSelector("[class='page-title']");
    public static final By SUCCESS_ADDED_PRODUCT_MESSAGE = By.id("bar-notification");

    public static By addToCartButtonLocator(String option) {
        return By.xpath("(//div[@class='buttons'])[" + option + "]");
    }
}
