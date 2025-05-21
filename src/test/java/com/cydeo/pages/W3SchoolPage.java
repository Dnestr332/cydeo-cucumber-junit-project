package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3SchoolPage {
    public W3SchoolPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='runbtn']")
    public WebElement runButton;

    @FindBy(linkText = "Visit W3Schools.com!")
    public WebElement linkVisit;

    @FindBy(xpath = "//i[@class='fa fa-logo ws-hover-text-green']")
    public WebElement greenLogo;
}
