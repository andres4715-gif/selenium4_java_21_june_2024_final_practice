package com.pages_old_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    WebDriver driver;

    By avatar = By.cssSelector("[class='oxd-userdropdown-img']");
    By logOut = By.xpath("//*[text() = 'Logout']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAvatar() {
        driver.findElement(avatar).click();
    }

    public void clickLogOut() {
        driver.findElement(logOut).click();
    }
}
