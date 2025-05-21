package com.cydeo.simple_tests;

import com.cydeo.pages.SeleniumPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumCalendarTest {
    private final SeleniumPage PAGE = new SeleniumPage();

    @BeforeEach
    public void startMethod(){
        //1- Go to the url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
        Driver.getDriver().get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        Utils.titleContains("Selenium Practise");
    }
    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
        Utils.assertAll();
    }
    @Test
    public void taskPerformance() {
        //2- Click on Date input area
        PAGE.dateInput.click();
        Utils.waitVisible(PAGE.calendar);
        //3- Get all elements(td) of calendar table using findElements method
        List<WebElement> calendarElements = PAGE.calendarCells;
        List<WebElement> calendarHeaders = PAGE.calendarHeaders;
        //4- Get the text of all elements(td) of calendar table
        System.out.println("==========================");
        for(WebElement header : calendarHeaders){
            System.out.printf("%-4s", header.getText());
        }
        System.out.println();
        int count = 0;
        for(WebElement element : calendarElements){
            String day = element.getText();
            if(day.isEmpty()){
                System.out.print("   ");
            } else {
                System.out.printf("%-4s", day);
            }
            count++;
            if(count % 7 == 0){
                System.out.println();
            }
        }
        System.out.println("==========================");
        //5- Click 12. day of month
        for(WebElement cell : PAGE.calendarCells){
            if(cell.getText().contains("12")){
                cell.click();
            }
        }
        //6- Verify date of "05/12/2024" has been entered in input area.
        String selectedDate = PAGE.dateInput.getDomProperty("value");
        Utils.isTrue(selectedDate.equals("05/12/2025"));
    }
}
