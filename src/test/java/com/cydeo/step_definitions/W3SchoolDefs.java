package com.cydeo.step_definitions;

import com.cydeo.pages.W3SchoolPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class W3SchoolDefs {
    private final W3SchoolPage PAGE = new W3SchoolPage();
    private final JavascriptExecutor JS = (JavascriptExecutor) Driver.getDriver();
    private String firstHandle;
    private String expectedTitle;

    @Given("user is on the W{int}School page")
    public void userIsOnTheWSchoolPage(int arg0) {
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        expectedTitle = "W3Schools Tryit Editor";
        Utils.verifyTitle(expectedTitle);
    }

    @When("user writes to the console")
    public void userWritesToTheConsole() {
        firstHandle = Driver.getDriver().getWindowHandle();
        JS.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue('firstHandle');");
    }

    @And("click on the Visit W{int}Schools.com! link")
    public void clickOnTheVisitWSchoolsComLink(int arg0) {
        Driver.getDriver().switchTo().frame("iframeResult");
        PAGE.linkVisit.click();
    }

    @Then("total window handle number is {int}")
    public void totalWindowHandleNumberIs(int arg0) {
        int numOfWindows = Driver.getDriver()
                .getWindowHandles()
                .size();
        Utils.isTrue(numOfWindows == 2);
    }

    @When("user switches to the second window")
    public void userSwitchesToTheSecondWindow() {
        expectedTitle = "W3Schools Online Web Tutorials";
        for(String handle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
        }
        Utils.verifyTitle(expectedTitle);
    }

    @Then("upper left side logo is displayed")
    public void upperLeftSideLogoIsDisplayed() {
        Utils.isDisplayed(PAGE.greenLogo);
    }

    @When("user goes back to the first window")
    public void userGoesBackToTheFirstWindow() {
        Driver.getDriver().switchTo().window(firstHandle);
        expectedTitle = "W3Schools Tryit Editor";
        Utils.verifyTitle(expectedTitle);
    }

    @Then("run Button contains Run ❯ text")
    public void runButtonContainsRunText() {
        Utils.textContains(PAGE.runButton, "Run");
    }
}
