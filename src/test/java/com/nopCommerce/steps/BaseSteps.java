package com.nopCommerce.steps;

import com.nopCommerce.pages.*;
import com.nopCommerce.utils.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected WebDriver driver;
    protected HomeNopCommercePage homeNopCommercePage;
    protected RegisterNopCommercePage registerNopCommercePage;
    protected SearchNopCommercePage searchNopCommercePage;
    protected ComputerNopCommercePage computerNopCommercePage;
    protected NotebookNopCommercePage notebookNopCommercePage;

    public BaseSteps() {
        this.driver = Hooks.getDriver();
        this.homeNopCommercePage = new HomeNopCommercePage(driver);
        this.registerNopCommercePage = new RegisterNopCommercePage(driver);
        this.searchNopCommercePage = new SearchNopCommercePage(driver);
        this.computerNopCommercePage = new ComputerNopCommercePage(driver);
        this.notebookNopCommercePage = new NotebookNopCommercePage(driver);
    }
}
