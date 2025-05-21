package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeleniumPage {
    public SeleniumPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='datepicker']")
    public WebElement dateInput;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
    public List<WebElement> calendarCells;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//th")
    public List<WebElement> calendarHeaders;


}
