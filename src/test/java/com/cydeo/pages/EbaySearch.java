package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbaySearch {
    public EbaySearch(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    public WebElement searchButton;
}
