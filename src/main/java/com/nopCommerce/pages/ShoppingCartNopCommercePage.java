package com.nopCommerce.pages;

import com.nopCommerce.locators.ShoppingCartNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShoppingCartNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartNopCommercePage.class);

    public ShoppingCartNopCommercePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnShoppingCartButton() {
        WebElement shoppingCart = driver.findElement(ShoppingCartNopCommerceLocators.SHOPPING_CART_BUTTON);
        waitForElementToBeVisible(shoppingCart).click();
        logger.info("--- Updated number of item on the shopping cart page");
    }

    public String getProductName() {
        WebElement productName = driver.findElement(ShoppingCartNopCommerceLocators.PRODUCT_NAME);
        String productNameText = waitForElementToBeVisible(productName).getText();
        logger.info("--- The obtained product name is: {} ", productNameText);
        return productNameText;
    }

    public double updateQuantity() {
        WebElement finalQuantityItem = driver.findElement(ShoppingCartNopCommerceLocators.QUANTITY_ITEM);
        String initialProductTotal = driver.findElement(ShoppingCartNopCommerceLocators.PRODUCT_SUB_TOTAL).getText();
        String cleanedPrice = initialProductTotal.replaceAll("[$,]", "");
        logger.info("--- The initial product total is: {}", cleanedPrice);
        waitForElementToBeVisible(finalQuantityItem).click();
        return Double.parseDouble(cleanedPrice);
    }

    public double getFinalTotal() {
        WebElement finalTotalAmount = driver.findElement(ShoppingCartNopCommerceLocators.PRODUCT_SUB_TOTAL);
        waitForElementToBeClickable(finalTotalAmount);
        String totalToPay = finalTotalAmount.getText();
        String cleanedPrice = totalToPay.replaceAll("[$,]", "");
        return Double.parseDouble(cleanedPrice);
    }
}
