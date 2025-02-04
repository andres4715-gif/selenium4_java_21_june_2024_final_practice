package com.nopCommerce.locators;

import org.openqa.selenium.By;

public class HomeNopCommerceLocators {
    public static final By REGISTER_BUTTON = By.cssSelector(".ico-register");
    public static final By SEARCH_BOX = By.id("small-searchterms");
    public static final By SEARCH_BUTTON = By.cssSelector("[type='submit']");
    public static final By ADD_PRODUCT_TO_CART = By.xpath("(//*[@class=\"product-item\"])[1]");
    public static final By RAM_DROPDOWN = By.xpath("//select[@name='product_attribute_2']");
    public static final By HDD_RADIO_BUTTON = By.xpath("//*[@id = 'product_attribute_3_7']");
    public static final By ADD_TO_CART = By.xpath("//button[@id = 'add-to-cart-button-1']");
    public static final By CUSTOMER_SERVICE_OPTION = By.xpath("(//*[@class='list'])[2]/li");

    public static By getMenuOption(String option) {
        return By.xpath("//*[@class='top-menu notmobile']//a[@href='/" + option + "']");
    }
}
