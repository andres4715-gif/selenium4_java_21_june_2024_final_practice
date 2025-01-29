package com.nopCommerce.locators;

import org.openqa.selenium.By;

public class HomeNopCommerceLocators {
    public static final By REGISTER_BUTTON = By.cssSelector(".ico-register");
    public static final By SEARCH_BOX = By.id("small-searchterms");
    public static final By SEARCH_BUTTON = By.cssSelector("[type='submit']");
    public static final By MENU_COMPUTERS = By.xpath("//*[@class='top-menu notmobile']//a[@href='/computers']");
}
