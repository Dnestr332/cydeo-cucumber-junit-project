package com.cydeo.step_definitions;

import com.cydeo.pages.Wikipedia;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikiStepDefs {
    private final Wikipedia wiki = new Wikipedia();

    //Background
    @Given("user is on the {string} home page")
    public void userIsOnTheHomePage(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("wiki"));
        Utils.waitTitle(arg0);
        Utils.verifyTitle(arg0);
    }
    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String arg0) {
        Utils.waitClickable(wiki.searchBox);
        wiki.searchBox.sendKeys(arg0);
    }
    @And("User clicks wiki search button")
    public void userClicksWikiSearchButton() {
        Utils.waitClickable(wiki.searchButton);
        wiki.searchButton.click();
    }

    //Title Scenario
    @Then("User sees {string} is in the {string} title")
    public void userSeesIsInTheTitle(String arg0, String arg1) {
        Utils.waitTitle(arg0);
        Utils.verifyTitle(arg0 + " - " + arg1);
    }
    //Header Scenario
    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String arg0) {
        Utils.waitVisible(wiki.mainHeader);
        Utils.isTrue(wiki.mainHeader.getText().equals(arg0));
    }
    //Image Header Scenario
    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String arg0) {
        Utils.waitVisible(wiki.mainImageHeader);
        Utils.isTrue(wiki.mainImageHeader.getText().equals(arg0));
    }
}
