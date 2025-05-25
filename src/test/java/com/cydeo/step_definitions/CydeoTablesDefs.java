package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoTables;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CydeoTablesDefs {
    private String keyWord;
    private final CydeoTables PAGE = new CydeoTables();

    @Given("user is on the page with {string}")
    public void userIsOnThePageWith(String url) {
        Driver.getDriver().get(url);
        keyWord = "Cydeo Web Table App";
        Utils.verifyTitle(keyWord);
    }

    @When("user enters {string} and {string}")
    public void userEntersAnd(String login, String password) {
        PAGE.userBar.sendKeys(login);
        PAGE.passBar.sendKeys(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        PAGE.loginButton.click();
    }

    @Then("user should see {string} in page URL")
    public void userShouldSeeInPageURL(String keyword) {
        Utils.urlContains(keyword);
    }

    //Order scenario
    @When("user is on the Order page")
    public void userIsOnTheOrderPage() {
        PAGE.orderButton.click();
        keyWord = "create-order";
        Utils.urlContains(keyWord);
    }
    @Then("user sees below options under “product” dropdown")
    public void userSeesBelowOptionsUnderProductDropdown(List<String> expectedProducts) {
        List<String> actualProducts = Utils.getStringList(PAGE.productDropDown);
        Utils.isTrue(actualProducts.equals(expectedProducts));
    }

    @Then("user sees below radio buttons enabled for")
    public void userSeesBelowRadioButtonsEnabledFor(List<String> radioButtons) {
        for(String cardValue : radioButtons) {
            WebElement cardButton = PAGE.getCard(cardValue);
            cardButton.click();
            Utils.isTrue(cardButton.isSelected());
        }
    }
}
