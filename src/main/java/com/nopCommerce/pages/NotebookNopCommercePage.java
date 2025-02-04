package com.nopCommerce.pages;

import com.nopCommerce.locators.NotebookNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotebookNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(NotebookNopCommercePage.class);

    public NotebookNopCommercePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public String verifyCategoryNameTitle() {
        WebElement categoryNameTitle = driver.findElement(NotebookNopCommerceLocators.CATEGORY_NAME_TITLE);
        String categoryNameTitleText = waitForElementToBeVisible(categoryNameTitle).getText();
        logger.info("--- Obtained category title text is: {}", categoryNameTitleText);
        return categoryNameTitleText.toLowerCase();
    }

    public void clickOnSecondProductOption(String option) {
        WebElement addProductToCart = driver.findElement(NotebookNopCommerceLocators.addToCartButtonLocator(option));
        addProductToCart.click();
        logger.info("--- The user can see the {} ", option + " Option to add this product within the cart");
    }

    public String verifySuccessAdditionToShoppingCartMessage() {
        WebElement successMessage = driver.findElement(NotebookNopCommerceLocators.SUCCESS_ADDED_PRODUCT_MESSAGE);
        String addToCartMessage = waitForElementToBeVisible(successMessage).getText();
        logger.info("--- Obtained message: {}", addToCartMessage);
        return addToCartMessage;
    }
}
