package com.nopCommerce.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static String baseUrl;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driverThreadLocal.set(driver);
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--remote-allow-origins=*");
        // driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = loadBaseUrl();
        }
        logger.info("Opening browser with URL: {}", baseUrl);
        return baseUrl;
    }

    private static String loadBaseUrl() {
        Properties prop = new Properties();
        try (InputStream input = Hooks.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            prop.load(input);
            return prop.getProperty("base.url");
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration", ex);
        }
    }
}
