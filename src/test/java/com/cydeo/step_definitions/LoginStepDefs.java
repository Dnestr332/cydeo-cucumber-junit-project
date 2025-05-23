package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoLibrary;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    private String email;
    private String keyWord;
    private CydeoLibrary library;
    private final String PASSWORD = "libraryUser";

    //Background
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        library = new CydeoLibrary();
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        Utils.verifyTitle("Login - Library");
    }
    //Student Scenario
    @When("student enters valid credentials")
    public void studentEntersValidCredentials() {
        email = "student21@library";
        library.emailField.sendKeys(email);
        library.passField.sendKeys(PASSWORD);
        library.signInButton.click();
    }
    @Then("user is able to see the student dashboard")
    public void userIsAbleToSeeTheStudentSDashboard() {
        keyWord = "Student";
        Utils.textContains(library.userAvatar, keyWord);
    }
    //Librarian Scenario
    @When("librarian enters valid credentials")
    public void librarianEntersValidCredentials() {
        email = "librarian21@library";
        library.emailField.sendKeys(email);
        library.passField.sendKeys(PASSWORD);
        library.signInButton.click();
    }
    @Then("user is able to see the librarian dashboard")
    public void userIsAbleToSeeTheLibrarianSDashboard() {
        keyWord = "Librarian";
        Utils.textContains(library.userAvatar, keyWord);
    }
    //Admin Scenario
    @When("admin enters invalid credentials")
    public void adminEntersValidCredentials() {
        email = "admin@library";
        library.emailField.sendKeys(email);
        library.passField.sendKeys(PASSWORD);
        library.signInButton.click();
    }
    @Then("user is unable to see the admin dashboard")
    public void userIsAbleToSeeTheStudentSAdmin() {
        Utils.waitVisible(library.errorMessage);
        Utils.isDisplayed(library.errorMessage);
    }
}
