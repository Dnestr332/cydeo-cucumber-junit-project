package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoLibrary {
    public CydeoLibrary(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailField;

    @FindBy(id = "inputPassword")
    public WebElement passField;

    @FindBy(xpath = "//button")
    public WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(), 'Test')]")
    public WebElement userAvatar;
}
