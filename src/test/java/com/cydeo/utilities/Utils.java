package com.cydeo.utilities;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final SoftAssertions SOFTLY = new SoftAssertions();
    private static final WebDriverWait WAIT = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    //Explicit and Hard waits:
    public static void sleep(int sec){
        try{
            Thread.sleep(sec * 1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void waitTitle(String partialTitle){
        final WebDriverWait WAIT = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WAIT.until(ExpectedConditions.titleContains(partialTitle));
    }
    public static void waitVisible(WebElement target){
        final WebDriverWait WAIT = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WAIT.until(ExpectedConditions.visibilityOf(target));
    }
    public static void waitClickable(WebElement target){
        final WebDriverWait WAIT = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WAIT.until(ExpectedConditions.elementToBeClickable(target));
    }

    //Verifications/Assertions:
    public static void verifyTitle(String expectedTitle) {
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertThat(Driver.getDriver().getTitle())
                .as("Verify page title")
                .isEqualTo(expectedTitle);
    }

    public static void titleContains(String expectedTitle){
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertThat(Driver.getDriver().getTitle())
                .as("Check if title contains: %s", expectedTitle)
                .contains(expectedTitle);
    }
    public static void urlContains(String keyword){
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertThat(Driver.getDriver().getCurrentUrl())
                .as("Check if url contains: %s", keyword)
                .contains(keyword);
    }
    public static void textContains(WebElement target, String expectedText){
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertThat(target.getText())
                .as("Check if element text contains: %s")
                .contains(expectedText);
    }
    public static void assertAll(){
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertAll();
    }
    public static void isDisplayed(WebElement target){
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertThat(target.isDisplayed())
                .as("Check if the element is displayed: %s")
                .isTrue();
    }
    public static void isTrue(Boolean condition){
        final SoftAssertions SOFTLY = new SoftAssertions();
        SOFTLY.assertThat(condition)
                .as("Check if condition is true: ")
                .isTrue();
    }

    //Window handles:
    public static void switchWindowAndVerify(String url, String title){
        for(String handle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            waitTitle(title);
            if(Driver.getDriver().getCurrentUrl().contains(url)){
                break;
            }
        }
        titleContains(title);
    }

    //Dropdowns:
    public static List<String> getStringList(WebElement target){
        Select select = new Select(target);
        List<String> result = new ArrayList<>();
        for(WebElement element : select.getOptions()){
            result.add(element.getText());
        }
        return result;
    }
}
