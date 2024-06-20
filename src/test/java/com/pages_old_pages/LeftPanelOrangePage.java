package com.pages_old_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LeftPanelOrangePage {
    WebDriver driver;

    By adminOption = By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");


    public LeftPanelOrangePage(WebDriver driver) {
        this.driver = driver;
    }

    public void optionGetText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminOption));
        String obtainedData = driver.findElement(adminOption).getText();
        System.out.println("--- The option to use is: " + obtainedData);
        Assert.assertEquals(obtainedData, "Admin");
    }

    public void clickOnTheAdminOption() {
        driver.findElement(adminOption).click();
    }

    public void flowToCheckDropdown() {
        optionGetText();
        clickOnTheAdminOption();
    }
}
