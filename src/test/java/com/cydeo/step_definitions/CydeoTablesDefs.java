package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoTables;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CydeoTablesDefs {
    private String keyWord;
    private final CydeoTables PAGE = new CydeoTables();

    //LoginOutline
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

    //Order Scenario Outline
    @Then("user enters product info as {string} and {string}")
    public void userEntersProductInfoAsAnd(String product, String quantity) {
        Select products = new Select(PAGE.productDropDown);
        products.selectByVisibleText(product);
        PAGE.quantity.sendKeys(quantity);
    }

    @And("user enters {string}, {string}, {string}, {string}, {string}")
    public void userEnters(String name, String street, String city, String state, String zip) {
        PAGE.customerName.sendKeys(name);
        PAGE.street.sendKeys(street);
        PAGE.city.sendKeys(city);
        PAGE.state.sendKeys(state);
        PAGE.zipCode.sendKeys(zip);
    }

    @And("user chooses {string}, enters {string}, {string}")
    public void userChoosesEnters(String cardType, String cardNo, String expires) {
        PAGE.getCard(cardType).click();
        PAGE.cardNumber.sendKeys(cardNo);
        PAGE.expireDate.sendKeys(expires);
    }

    @And("user clicks to “Process Order”")
    public void userClicksToProcessOrder() {
        PAGE.processOrderButton.click();
    }

    @Then("user should see new order with {string} in the table on “View all orders” page")
    public void userShouldSeeNewOrderWithInTheTableOnViewAllOrdersPage(String customer) {
        keyWord = "orders";
        Utils.urlContains(keyWord);
        List<String> orders = Utils.getStringRows(PAGE.orderRows);
        Utils.isTrue(orders.contains(customer));
    }
}
