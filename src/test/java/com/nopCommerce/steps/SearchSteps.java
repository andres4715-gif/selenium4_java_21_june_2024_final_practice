package com.nopCommerce.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SearchSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(SearchSteps.class);

    @Then("the user should see a list of products related to {string}")
    public void the_user_should_see_a_list_of_products_related_to(String product) {
        String titleName = searchNopCommercePage.getSearchTitleName();
        logger.info("--- The title name in the page is: {}", titleName);
        Assert.assertEquals(titleName, "Search", "The title name is not correct");
        boolean listWithResults = searchNopCommercePage.verifyListOfProductName(product);
        Assert.assertTrue(listWithResults, "No results contain the word: " + product);
    }

    @When("the user clicks over the first product listed on the product page")
    public void the_user_clicks_over_the_first_product_listed_on_the_product_page() {
        searchNopCommercePage.chooseFirstProduct();
    }
}
