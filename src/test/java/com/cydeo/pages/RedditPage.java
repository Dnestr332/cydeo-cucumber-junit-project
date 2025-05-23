package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RedditPage {
    public RedditPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getSearchBar(){
        return Driver.getDriver()
                .findElement(By.tagName("reddit-search-large"))
                .getShadowRoot()
                .findElement(By.cssSelector("faceplate-search-input[name='q']"))
                .getShadowRoot()
                .findElement(By.cssSelector("input[name='q']"));
    }
}
