package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTableDefs {

    @Then("user should see the below list")
    public void user_should_see_the_below_list(List<String> fruits) {
        System.out.println(fruits);
    }

    @Then("officer is able to read any data")
    public void officer_is_able_to_read_any_data(Map<String,String> data) {
        System.out.println(data);

    }
}
