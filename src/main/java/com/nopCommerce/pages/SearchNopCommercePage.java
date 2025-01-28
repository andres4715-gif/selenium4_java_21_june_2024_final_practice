package com.nopCommerce.pages;

import com.nopCommerce.locators.SearchNopCommerceLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(RegisterNopCommercePage.class);

    public SearchNopCommercePage(WebDriver driver) {
        super(driver);
    }

    public String getSearchTitleName() {
        String gettingTextLabelNewPage = driver.findElement(SearchNopCommerceLocators.NAME_TITLE_PAGE).getText();
        logger.info("--- Getting the search title name: {}", gettingTextLabelNewPage);
        return gettingTextLabelNewPage;
    }

    public boolean verifyListOfProductName(String searchProductName) {
        List<WebElement> productTitles = driver.findElements(SearchNopCommerceLocators.LIST_NAME_PRODUCTS);
        List<String> finalProductList = new ArrayList<>();
        logger.info("--- Total Result searching {} ", searchProductName + ": " + productTitles.size());

        boolean hasLaptop = false;
        for (WebElement title : productTitles) {
            if (title.getText().toLowerCase().contains("laptop")) {
                finalProductList.add(title.getText());
                hasLaptop = true;
            }
        }

        logger.info("--- Any response with {}", searchProductName + "?: " + hasLaptop);
        logger.info("--- Final list witch contain {} ", searchProductName + ": " + finalProductList);
        return hasLaptop;
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }
}
