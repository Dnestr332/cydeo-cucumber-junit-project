package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
    public GoogleSearch(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    public WebElement searchField;
}
