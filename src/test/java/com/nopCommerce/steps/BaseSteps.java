package com.nopCommerce.steps;

import com.nopCommerce.utils.Hooks;
import org.openqa.selenium.WebDriver;
import com.nopCommerce.pages.HomeNopCommercePage;
import com.nopCommerce.pages.RegisterNopCommercePage;
import com.nopCommerce.pages.SearchNopCommercePage;

public class BaseSteps {
    protected WebDriver driver;
    protected HomeNopCommercePage homeNopCommercePage;
    protected RegisterNopCommercePage registerNopCommercePage;
    protected SearchNopCommercePage searchNopCommercePage;

    public BaseSteps() {
        this.driver = Hooks.getDriver();
        this.homeNopCommercePage = new HomeNopCommercePage(driver);
        this.registerNopCommercePage = new RegisterNopCommercePage(driver);
        this.searchNopCommercePage = new SearchNopCommercePage(driver);
    }
}
