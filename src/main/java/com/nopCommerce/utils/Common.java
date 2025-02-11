package com.nopCommerce.utils;

import com.nopCommerce.pages.RegisterNopCommercePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Common {

    private static final Logger logger = LoggerFactory.getLogger(RegisterNopCommercePage.class);

    /**
     * Clicks on the first element from a list of WebElements.
     *
     * @param webElements The list of WebElements to interact with.
     * @param page The name of the page where the action is performed (used for logging).
     */
    public static void clickFirst(List<WebElement> webElements, String page) {
        if (!webElements.isEmpty()) {
            webElements.getFirst().click();
        } else {
            throw new RuntimeException("No found elements with this selector");
        }
        logger.info("--- Click on the First Element in the {}", page + " page.");
    }

    /**
     * Selects an option from a dropdown (Select element) based on its visible text.
     *
     * @param webElement The dropdown WebElement to interact with.
     * @param option The visible text of the option to select.
     */
    public static void selectByVisibleText(WebElement webElement, String option) {
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }
}
