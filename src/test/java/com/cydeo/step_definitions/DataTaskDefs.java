package com.cydeo.step_definitions;

import com.cydeo.pages.DropDowns;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.datafaker.providers.entertainment.NewGirl;

import java.util.List;

public class DataTaskDefs {
    private final DropDowns PAGE = new DropDowns();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        String expectedTitle = "Dropdowns";
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
        Utils.waitTitle(expectedTitle);
        Utils.verifyTitle(expectedTitle);
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> monthsInFeature) {
        String id = "month";
        List<String> monthsInPage = Utils.getStringList(PAGE.getDropDown(id));
        Utils.isDisplayed(PAGE.getDropDown(id));
        Utils.isTrue(monthsInFeature.equals(monthsInPage));
    }
}
