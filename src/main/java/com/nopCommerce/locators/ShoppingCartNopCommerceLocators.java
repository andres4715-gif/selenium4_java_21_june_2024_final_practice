package com.nopCommerce.locators;

import org.openqa.selenium.By;

public class ShoppingCartNopCommerceLocators {
    public static final By SHOPPING_CART_BUTTON = By.className("ico-cart");
    public static final By PRODUCT_NAME = By.className("product-name");
    public static final By QUANTITY_ITEM = By.cssSelector("[class='quantity up']");
    public static final By PRODUCT_SUB_TOTAL = By.className("product-subtotal");
}
