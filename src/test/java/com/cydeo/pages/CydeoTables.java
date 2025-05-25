package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoTables {
    public CydeoTables(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userBar;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passBar;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[.='Order']")
    public WebElement orderButton;

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropDown;

    public WebElement getCard(String value){
        return Driver.getDriver().findElement(By.xpath("//input[@value='" + value + "']"));
    }
}
