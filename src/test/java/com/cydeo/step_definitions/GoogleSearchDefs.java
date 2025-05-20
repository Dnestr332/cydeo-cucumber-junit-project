package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearch;
import com.cydeo.pages.GoogleSearch;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class GoogleSearchDefs {
    private final GoogleSearch googlePage = new GoogleSearch();
    private String expectedTitle;

    @Given("user is on the Google search page")
    public void userIsOnTheGoogleSearchPage() {
        Driver.getDriver().get("https://www.google.com/");
        expectedTitle = "Google";
        Utils.waitTitle(expectedTitle);
        Utils.verifyTitle(expectedTitle);
    }

    @When("user enters valid text into Google search field")
    public void userEntersValidTextIntoSearchField() {
        googlePage.searchField
                .sendKeys(ConfigReader.getProperty("google_item") + Keys.ENTER);
    }

    @Then("user is able to see the Google search result page")
    public void userIsAbleToSeeTheSearchResultPage() {
        expectedTitle = ConfigReader.getProperty("google_item") + " - Google Search";
        Utils.waitTitle(ConfigReader.getProperty("google_item"));
        Utils.verifyTitle(expectedTitle);
    }
}
