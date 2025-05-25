package com.cydeo.step_definitions;

import com.cydeo.pages.EbaySearch;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class EbaySearchDefs {
    private String expectedTitle;
    private final EbaySearch PAGE = new EbaySearch();

    @Given("user is on {string} page")
    public void userIsOnPage(String url) {
        Driver.getDriver().get(url);
    }

    @Then("user sees title is as expected.")
    public void user_sees_title_is_as_expected() {
        expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        Utils.waitTitle("eBay");
        Utils.verifyTitle(expectedTitle);
    }

    @When("user types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        PAGE.searchBar.sendKeys("Wooden Spoon" + Keys.ENTER);
    }

    @When("user clicks search button")
    public void user_clicks_search_button() {
        PAGE.searchButton.click();
    }

    @Then("user sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        expectedTitle = "Wooden Spoon for sale | eBay";
        Utils.waitTitle("Wooden");
        Utils.verifyTitle(expectedTitle);
    }

    @When("user types {string} in the search box")
    public void user_types_in_the_search_box(String searchValue) {
        PAGE.searchBar.sendKeys(searchValue + Keys.ENTER);
    }

    @Then("user sees {string} is in the title")
    public void user_sees_is_in_the_title(String title) {
        Utils.waitTitle(title);
        Utils.verifyTitle(title);
    }
}
