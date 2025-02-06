package com.nopCommerce.pages;

import com.nopCommerce.locators.HomeNopCommerceLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeNopCommercePage extends BasePage implements TitleInterface {
    private static final Logger logger = LoggerFactory.getLogger(HomeNopCommercePage.class);

    public HomeNopCommercePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnRegisterButton() {
        logger.info("--- Click on register button");
        waitForElementToBeClickable(
                driver.findElement(HomeNopCommerceLocators.REGISTER_BUTTON)).click();
    }

    public void addAnyProductInTheSearchBox(String product) {
        waitForElementToBeVisible(
                driver.findElement(HomeNopCommerceLocators.SEARCH_BOX)).sendKeys(product);
    }

    public void clickSubmit() {
        logger.info("--- Click on Search Button");
        WebElement searchButton = driver.findElement(HomeNopCommerceLocators.SEARCH_BUTTON);
        waitForElementToBeClickable(searchButton).click();
    }

    public void clickComputerMenu(String option) {
        logger.info("Click on {}", option + " Menu");
        WebElement menuComputers = driver.findElement(HomeNopCommerceLocators.getMenuOption(option));
        waitForElementToBeClickable(menuComputers).click();
    }

    public void clickAddToCartButton() {
        WebElement addToCartButton = driver.findElement(HomeNopCommerceLocators.ADD_PRODUCT_TO_CART);
        waitForElementToBeClickable(addToCartButton).click();
        logger.info("--- Click on first product available on the home page");
    }

    public void chooseRam() {
        WebElement selectRam = driver.findElement(HomeNopCommerceLocators.RAM_DROPDOWN);
        waitForElementToBeClickable(selectRam);
        Select memoryRam = new Select(selectRam);
        memoryRam.selectByVisibleText("4GB [+$20.00]");
    }

    public void chooseHdd() {
        driver.findElement(HomeNopCommerceLocators.HDD_RADIO_BUTTON).click();
    }

    public void clickAddToCart() {
        driver.findElement(HomeNopCommerceLocators.ADD_TO_CART).click();
    }

    public void chooseCustomerServiceOption(String selectedOption) {
        List<String> finalCustomerOptions = new ArrayList<>();
        List<WebElement> customerOptions = driver.findElements(HomeNopCommerceLocators.CUSTOMER_SERVICE_OPTION);

        for (WebElement option : customerOptions) {
            finalCustomerOptions.add(option.getText());
        }
        logger.info("--- Obtained list of customer services options {}", finalCustomerOptions);
        String data = finalCustomerOptions.stream()
                .filter(x -> x.contains(selectedOption))
                .collect(Collectors.joining(", "));

        String refactorData = data.toLowerCase().trim().replace(" ", "");
        String customSelector = "//*[@href='/" + refactorData + "']";
        logger.info("--- New element to select: {} ", customSelector);
        WebElement option = driver.findElement(By.xpath(customSelector));
        option.click();
    }

    public boolean selectPollOption(String title, String option) {
        choosePollOption(option);
        return verifyCommunityPollTitle(title);
    }

    private boolean verifyCommunityPollTitle(String title) {
        WebElement communityTitle = driver.findElement(HomeNopCommerceLocators.COMMUNITY_POLL_TITLE);
        String communityTitleText = communityTitle.getText();
        logger.info("--- The obtained poll title is: {}", communityTitleText);
        return communityTitleText.equals(title);
    }

    private void choosePollOption(String option) {
        WebElement optionPoll = driver.findElement(HomeNopCommerceLocators.pollOption(option));
        logger.info("--- Selected option is: {}", optionPoll.getText());
        optionPoll.click();
    }

    //TODO IT IS NOT WORKING
    public boolean checkOptionIsSelected(String option) {
        WebElement optionPoll = driver.findElement(HomeNopCommerceLocators.pollOptionRadioButton(option));
        return optionPoll.isEnabled();
    }

    public void clickCommunity() {
        driver.findElement(HomeNopCommerceLocators.SUBMIT_POLL_BUTTON).click();
    }
}
