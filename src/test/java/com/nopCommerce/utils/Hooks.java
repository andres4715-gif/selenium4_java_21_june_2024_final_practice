package com.nopCommerce.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static String baseUrl;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // GITHUB Action execution
        String seleniumRemoteUrl = System.getenv("SELENIUM_REMOTE_URL");
        if (seleniumRemoteUrl != null && !seleniumRemoteUrl.isEmpty()) {
            try {
                URL remoteUrl = new URL(seleniumRemoteUrl);
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-software-rasterizer");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-setuid-sandbox");
                options.addArguments("--disable-background-networking");
                options.addArguments("--disable-background-timer-throttling");
                options.addArguments("--disable-client-side-phishing-detection");
                options.addArguments("--disable-default-apps");
                options.addArguments("--disable-hang-monitor");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-prompt-on-repost");
                options.addArguments("--disable-sync");
                options.addArguments("--disable-translate");
                options.addArguments("--metrics-recording-only");
                options.addArguments("--no-first-run");
                options.addArguments("--safebrowsing-disable-auto-update");
                options.addArguments("--enable-automation");
                options.addArguments("--disable-blink-features=AutomationControlled");
                WebDriver driver = new RemoteWebDriver(remoteUrl, options);
                driverThreadLocal.set(driver);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Error creating RemoteWebDriver with URL: " + seleniumRemoteUrl, e);
            }
        } else {
            // Local Execution
            WebDriver driver = new ChromeDriver(options);
            driverThreadLocal.set(driver);
            // driver.manage().window().maximize();
        }
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
