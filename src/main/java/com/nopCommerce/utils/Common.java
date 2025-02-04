package com.nopCommerce.utils;

import com.nopCommerce.pages.RegisterNopCommercePage;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Common {
    private static final Logger logger = LoggerFactory.getLogger(RegisterNopCommercePage.class);

    public static void clickFirst(List<WebElement> webElements, String page) {
        List<WebElement> elements = webElements;
        if (!elements.isEmpty()) {
            elements.getFirst().click();
        } else {
            throw new RuntimeException("No found elements with this selector");
        }
        logger.info("--- Click on the First Element in the {}", page + " page.");
    }
}
