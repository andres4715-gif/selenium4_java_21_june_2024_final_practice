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

    @Test(priority = 1, enabled = true, description = "Checking the success log in")
    public void successLogin() {
        LoginOrangePage loginOrangePage = new LoginOrangePage(driver);
        DashboardOrangePage dashboardOrangePage = new DashboardOrangePage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginOrangePage.addingUserName();
        loginOrangePage.addingPassword();
        loginOrangePage.clickOnLoginButton();
        String dataToCheck = dashboardOrangePage.gettingTitle();
        System.out.println("--- The obtained Title is: " + dataToCheck);
        Assert.assertEquals(dataToCheck, "Dashboard");
    }

    @Test(priority = 2, enabled = true, description = "New activity window")
    public void executingNewPage() {
        HomePage homepage = new HomePage(driver);
        ArrayList<String> newTb;
        OpeningNewWindowsPage openingnewwindowspage = new OpeningNewWindowsPage(driver);
        driver.navigate().to("https://the-internet.herokuapp.com/");
        homepage.clickMultipleWindows();
        Assert.assertTrue(openingnewwindowspage.checkOpeningNewWindowsLabel());
        openingnewwindowspage.clickHereAction();
        newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        Assert.assertEquals(openingnewwindowspage.getNewWindowsText(), "New Window");
    }
}
