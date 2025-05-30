package com.cydeo.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private static final InheritableThreadLocal<WebDriver> POOL = new InheritableThreadLocal<>();
    private Driver(){
    }

    public static WebDriver getDriver(){
        if (POOL.get() == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new", "--disable-gpu");
                    POOL.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    POOL.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            POOL.get().manage().window().setPosition(new Point(4, 4));
            POOL.get().manage().window().setSize(new Dimension(1400, 720));
            POOL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return POOL.get();
    }

    public static void closeDriver() {
        if (POOL.get() != null) {
            try {
                POOL.get().quit();  // Close all tabs and end the session
            } catch (Exception ignored) {
                // optional: log or suppress expected shutdown issues
            }
            POOL.remove();
        }
    }
}
