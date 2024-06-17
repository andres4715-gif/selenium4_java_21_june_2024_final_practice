package com.webdriver.app;

import com.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class FirstTest {
    static WebDriver driver;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }

    @Test(priority = 1, enabled = true, description = "Open any page with a head chrome browser")
    public void openSecondTest() {
        driver.navigate().to("https://www.google.com.co/");
    }

    @Test(priority = 2, enabled = true, description = "Chcking new activitie")
    public void executingNewPage() {
        ArrayList<String> newTb;
        HomePage homepage = new HomePage(driver);
        OpeningNewWindowsPage openingnewwindowspage = new OpeningNewWindowsPage(driver);
        driver.navigate().to("https://the-internet.herokuapp.com/");
        homepage.clickMultipleWindows();
        Assert.assertTrue(openingnewwindowspage.checkOpeningNewWindowsLabe());
        openingnewwindowspage.clickHereAction();
        newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        Assert.assertEquals(openingnewwindowspage.getNewWindowsText(), "New Window");
    }
}
