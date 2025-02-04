package com.nopCommerce.pages;

import com.nopCommerce.locators.DescriptionProductNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescriptionProductNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(DescriptionProductNopCommercePage.class);

    public DescriptionProductNopCommercePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public void inputRecipientName() {
        WebElement recipientName = driver.findElement(DescriptionProductNopCommerceLocators.RECIPIENT_NAME);
        WebElement yourName = driver.findElement(DescriptionProductNopCommerceLocators.YOUR_NAME);
        recipientName.sendKeys("Recipient Product information");
        yourName.sendKeys("Your name Product information");
        logger.info("--- Adding product information");
    }

    public void clickOnAddToCartButton() {
        WebElement addToCartButton = driver.findElement(DescriptionProductNopCommerceLocators.ADD_TO_CART);
        addToCartButton.click();
        logger.info("Clicking on Add to Cart Button");
    }
}
