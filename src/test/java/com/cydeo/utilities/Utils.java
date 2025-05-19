package com.cydeo.utilities;

import io.opentelemetry.api.trace.StatusCode;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    //Explicit and Hard waits:
    public static void sleep(int sec){
        try{
            Thread.sleep(sec * 1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void waitTitle(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(title));
    }
    public static void waitVisible(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(target));
    }

    //Window handles
    public static void switchWindowAndVerify(String url, String title){
        for(String handle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            waitTitle(title);
            if(Driver.getDriver().getCurrentUrl().contains(url)){
                break;
            }
        }
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title) );
    }

    //Verifications/Assertions
    public static void verifyTitle(String title){
        Assert.assertEquals(Driver.getDriver().getTitle(), title);
    }
    public static void titleContains(String title){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }
}
