package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupMethod(){
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Utils.assertAll();
//        Driver.closeDriver();
    }
}
