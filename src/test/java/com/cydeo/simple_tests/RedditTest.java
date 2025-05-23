package com.cydeo.simple_tests;

import com.cydeo.pages.RedditPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RedditTest {
    private final RedditPage PAGE = new RedditPage();

    @BeforeEach
    public void setupMethod(){
        Driver.getDriver().get("https://www.reddit.com/");
        Utils.waitTitle("Reddit");
        Utils.verifyTitle("Reddit - The heart of the internet");
        System.out.println("Original title: " + Driver.getDriver().getTitle());
    }
    @Test
    public void testSearch(){
        WebElement searchBar = PAGE.getSearchBar();
        searchBar.click();
        searchBar.sendKeys("warhammer" + Keys.ENTER);
        Utils.waitTitle("warhammer");
        Utils.verifyTitle("warhammer - Reddit Search!");
        System.out.println("The title after search: " + Driver.getDriver().getTitle());
    }
}
