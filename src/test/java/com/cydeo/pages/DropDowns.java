package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DropDowns {
    public DropDowns(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getDropDown(String id){
        return Driver.getDriver().findElement(By.id(id));
    }
}
