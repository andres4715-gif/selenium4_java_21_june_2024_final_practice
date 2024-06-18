package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardOrangePage {
    WebDriver driver;

    By dashboardLabel = By.cssSelector("[class='oxd-topbar-header-breadcrumb']");

    public DashboardOrangePage(WebDriver driver) {
        this.driver = driver;
    }

    public String gettingTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLabel));
        return driver.findElement(dashboardLabel).getText();
    }
}
