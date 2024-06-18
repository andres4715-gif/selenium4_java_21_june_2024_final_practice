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

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test(priority = 3, enabled = true, description = "Checking the success log in")
    public void successLogin() {
        LoginOrangePage loginOrangePage = new LoginOrangePage(driver);
        DashboardOrangePage dashboardOrangePage = new DashboardOrangePage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginOrangePage.addingUserName();
        loginOrangePage.addingPassword();
        loginOrangePage.clickOnLoginButton();
        String dataToCheck = dashboardOrangePage.gettingTitle();
        System.out.println("--- The obtained Title is: " + dataToCheck);
        Assert.assertEquals(dataToCheck, "Dashboard");
        headerPage.clickAvatar();
        headerPage.clickLogOut();
    }

    @Test(priority = 1, enabled = true, description = "Filling data and submit it")
    public void fillFormPersonalData() {
        LoginOrangePage loginOrangePage = new LoginOrangePage(driver);
        LeftPanelOrangePage leftPanelOrangePage = new LeftPanelOrangePage(driver);
        ViewSystemUserPage viewSystemUserPage = new ViewSystemUserPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginOrangePage.addingUserName();
        loginOrangePage.addingPassword();
        loginOrangePage.clickOnLoginButton();
        leftPanelOrangePage.flowToCheckDropdown();
        viewSystemUserPage.fillUserName();
        headerPage.clickAvatar();
        headerPage.clickLogOut();
    }

    @Test(priority = 1, enabled = true, description = "Checking Dropdown")
    public void dropdownPractice() {
        HomeNopCommercePage homeNopCommercePage = new HomeNopCommercePage(driver);
        driver.get("https://demo.nopcommerce.com/");
        homeNopCommercePage.chooseCurrencyOption();
    }

    @Test(priority = 1, enabled = true, description = "Checking Dropdown")
    public void radioButton() throws InterruptedException {
        HomeNopCommercePage homeNopCommercePage = new HomeNopCommercePage(driver);
        RegisterNopCommercePage registerNopCommercePage = new RegisterNopCommercePage(driver);

        driver.get("https://demo.nopcommerce.com/");
        homeNopCommercePage.clickOnRegisterButton();
        boolean maleRadioButtonInitialStatus = registerNopCommercePage.checkMaleRadioButtonStatus();
        Assert.assertFalse(maleRadioButtonInitialStatus);
        registerNopCommercePage.selectMaleRadioButtonToActive();
        boolean maleRadioButtonFinalStatus = registerNopCommercePage.checkMaleRadioButtonStatus();
        Assert.assertTrue(maleRadioButtonFinalStatus);
        Thread.sleep(2000);
    }

    @Test(priority = 2, enabled = true, description = "New activity window")
    public void executingNewPage() {
        HomePage homepage = new HomePage(driver);
        OpeningNewWindowsPage openingnewwindowspage = new OpeningNewWindowsPage(driver);

        ArrayList<String> newTb;
        driver.navigate().to("https://the-internet.herokuapp.com/");
        homepage.clickMultipleWindows();
        Assert.assertTrue(openingnewwindowspage.checkOpeningNewWindowsLabel());
        openingnewwindowspage.clickHereAction();
        newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        Assert.assertEquals(openingnewwindowspage.getNewWindowsText(), "New Window");
    }
}
