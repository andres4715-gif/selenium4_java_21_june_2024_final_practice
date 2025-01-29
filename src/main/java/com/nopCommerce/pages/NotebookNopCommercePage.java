package com.nopCommerce.pages;

import com.nopCommerce.locators.ComputersNopCommerceLocators;
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
}
