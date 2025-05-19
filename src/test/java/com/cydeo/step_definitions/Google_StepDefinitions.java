package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Google_StepDefinitions {

    @When("user is on the Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://google.com/");
        System.out.println("User is on the page.");
    }

    @Then("user should see the title is google")
    public void user_should_see_the_title_is_google() {
        System.out.println("Test 1: title verification.");
        String expectedTitle = "Google";
        Utils.verifyTitle(expectedTitle);
    }
}
