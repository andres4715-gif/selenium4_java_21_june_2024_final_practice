package com.nopCommerce.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;
    private static final String BASE_URL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}