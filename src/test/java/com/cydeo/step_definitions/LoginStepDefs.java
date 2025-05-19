package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoLibrary;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    private String email;
    private  String password;
    private String keyWord;
    private CydeoLibrary library;

    @Before
    public void setup(){
        password = "libraryUser";
        library = new CydeoLibrary();
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Given("student is on the login page")
    public void studentIsOnTheLoginPage() {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        Utils.verifyTitle("Login - Library");
    }

    @When("student enters valid credentials")
    public void studentEntersValidCredentials() {
        email = "student21@library";
        library.emailField.sendKeys(email);
        library.passField.sendKeys(password);
        library.signInButton.click();
    }

    @Then("user is able to see the student dashboard")
    public void userIsAbleToSeeTheStudentSDashboard() {
        keyWord = "Student";
        Utils.textContains(library.userAvatar, keyWord);
    }

    @Given("librarian is on the login page")
    public void librarianIsOnTheLoginPage() {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        Utils.verifyTitle("Login - Library");
    }

    @When("librarian enters valid credentials")
    public void librarianEntersValidCredentials() {
        email = "librarian21@library";
        library.emailField.sendKeys(email);
        library.passField.sendKeys(password);
        library.signInButton.click();
    }

    @Then("user is able to see the librarian dashboard")
    public void userIsAbleToSeeTheLibrarianSDashboard() {
        keyWord = "Librarian";
        Utils.textContains(library.userAvatar, keyWord);
    }

    @Given("admin is on the login page")
    public void adminIsOnTheLoginPage() {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
        Utils.verifyTitle("Login - Library");
    }

    @When("admin enters invalid credentials")
    public void adminEntersValidCredentials() {
        email = "admin@library";
        library.emailField.sendKeys(email);
        library.passField.sendKeys(password);
        library.signInButton.click();
    }

    @Then("user is unable to see the admin dashboard")
    public void userIsAbleToSeeTheStudentSAdmin() {
        Utils.waitVisible(library.errorMessage);
        Assert.assertTrue(library.errorMessage.isDisplayed());
    }
}
