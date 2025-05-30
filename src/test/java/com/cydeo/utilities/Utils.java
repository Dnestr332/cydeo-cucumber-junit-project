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

    // Shared SoftAssertions per thread
    private static final ThreadLocal<SoftAssertions> softly = ThreadLocal.withInitial(SoftAssertions::new);
    //Helper methods
    private static SoftAssertions getSoftly(){
        return new SoftAssertions();
    }
    private static WebDriverWait getWait(){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    //Explicit and Hard waits:
    public static void sleep(int sec){
        try{
            Thread.sleep(sec * 1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void waitTitle(String partialTitle){
        getWait().until(ExpectedConditions.titleContains(partialTitle));
    }
    public static void waitVisible(WebElement target){
        getWait().until(ExpectedConditions.visibilityOf(target));
    }
    public static void waitClickable(WebElement target){
        getWait().until(ExpectedConditions.elementToBeClickable(target));
    }

    //Verifications/Assertions:
    public static void verifyTitle(String expectedTitle) {
        getSoftly().assertThat(Driver.getDriver().getTitle())
                .as("Verify page title")
                .isEqualTo(expectedTitle);
    }
    public static void titleContains(String expectedTitle){
        getSoftly().assertThat(Driver.getDriver().getTitle())
                .as("Check if title contains: %s", expectedTitle)
                .contains(expectedTitle);
    }
    public static void urlContains(String keyword){
        getSoftly().assertThat(Driver.getDriver().getCurrentUrl())
                .as("Check if url contains: %s", keyword)
                .contains(keyword);
    }
    public static void textContains(WebElement target, String expectedText){
        getSoftly().assertThat(target.getText())
                .as("Check if element text contains: %s")
                .contains(expectedText);
    }
    public static void assertAll() {
        try {
            getSoftly().assertAll();
        } finally {
            // Clean up to avoid memory leaks between scenarios
            softly.remove();
        }
    }
    public static void isDisplayed(WebElement target){
        getSoftly().assertThat(target.isDisplayed())
                .as("Check if the element is displayed: %s")
                .isTrue();
    }
    public static void isTrue(Boolean condition){
        getSoftly().assertThat(condition)
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

    //Web Tables
    public static List<String> getStringRows(List<WebElement> target){
        List<String> result = new ArrayList<>();
        for(WebElement row : target){
            result.add(row.getText());
        }
        return result;
    }
}
