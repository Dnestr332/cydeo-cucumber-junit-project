package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearch;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class BingSearchDefs {
    private final BingSearch bingPage = new BingSearch();
    private String expectedTitle;

    @Given("user is on the {string} page")
    public void userIsOnThePage(String expectedTitle) {
        Driver.getDriver().get("https://www.bing.com/");
        Utils.waitTitle(expectedTitle);
        Utils.verifyTitle(expectedTitle);
    }

    @When("user enters {string} into Bing search field")
    public void userEntersIntoBingSearchField(String arg0) {
        bingPage.searchField
                .sendKeys(arg0 + Keys.ENTER);
    }

    @Then("user is able to see the Bing {string} result page")
    public void userIsAbleToSeeTheBingSearchResultPage(String expectedTitle) {
        Utils.waitTitle(expectedTitle);
        Utils.verifyTitle(expectedTitle);
    }
}
