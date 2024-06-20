package com.pages_old_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpeningNewWindowsPage {
    WebDriver driver;

    By openingNewWindowsPage = By.xpath("//*[text() = 'Opening a new window']");
    By clickHere = By.xpath("//*[text() = 'Click Here']");
    By newWindowsText = By.xpath("//h3[text() = 'New Window']");

    public OpeningNewWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkOpeningNewWindowsLabel() {
        boolean checkingOpeningMesssage = driver.findElement(openingNewWindowsPage).isDisplayed();
        System.out.println("--- The element in the new page is displayed? -> " +  checkingOpeningMesssage);
        return checkingOpeningMesssage;
    }

    public void clickHereAction() {
        driver.findElement(clickHere).click();
    }

    public String getNewWindowsText() {
        String gettingTextLabelNewPage = driver.findElement(newWindowsText).getText();
        System.out.println("--- The obtained text is: " + gettingTextLabelNewPage);
        return gettingTextLabelNewPage;
    }
}
