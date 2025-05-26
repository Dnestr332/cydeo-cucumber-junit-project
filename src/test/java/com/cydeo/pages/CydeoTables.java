package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CydeoTables {
    public CydeoTables(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Login page
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userBar;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passBar;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public void login(String user, String pass){
        userBar.sendKeys(user);
        passBar.sendKeys(pass);
        loginButton.click();
    }

    //Order page
    @FindBy(xpath = "//button[.='Order']")
    public WebElement orderButton;
    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropDown;
    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement quantity;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement customerName;
    @FindBy(xpath = "//input[@name='street']")
    public WebElement street;
    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;
    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;
    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNumber;
    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement expireDate;

    public WebElement getCard(String value){
        return Driver.getDriver().findElement(By.xpath("//input[@value='" + value + "']"));
    }

    //View all orders page
    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement viewOrdersButton;
    @FindBy(xpath = "//table//tr")
    public List<WebElement> orderRows;
}
