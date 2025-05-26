package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoTables;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupMethod() {
        Driver.getDriver();
    }
    @Before("@Login")
    public void loginDefaultUser() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        CydeoTables loginPage = new CydeoTables();
        loginPage.login("Test", "Tester");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Utils.assertAll();
        Driver.closeDriver();
    }
}
