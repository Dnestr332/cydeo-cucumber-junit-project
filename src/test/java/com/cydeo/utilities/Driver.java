package com.cydeo.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    driver = new ChromeDriver();
                    driver.manage().window().setPosition(new Point(4, 4));
                    driver.manage().window().setSize(new Dimension(1400, 720));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().setPosition(new Point(4, 4));
                    driver.manage().window().setSize(new Dimension(1400, 720));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
