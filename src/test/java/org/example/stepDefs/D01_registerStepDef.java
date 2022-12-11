package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D01_registerStepDef {
    P01_register register=new P01_register();
    @Given("user go to register page")
    public void goRegisterPage(){
        register.openRegisterPage();
    }

    @When("user select gender type")
    public void slect_gender(){
        register.selectGender();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enter_userName_lastName(String userName,String lastName){
    register.enter_fristName_lastName(userName,lastName);
    }

    @And("^user enter date of birth day \"(.*)\" and month \"(.*)\" and year \"(.*)\"$")
    public void select_dateOfBirth(String day,String month,String year){

        register.select_DateOfBirth(day,month,year);
    }

    @And("^user enter email \"(.*)\" field$")
    public void enter_email(String email){
        register.enter_Email(email);


    }

    @And("^user fills Password fields \"(.*)\" and \"(.*)\"$")
    public void enter_password(String password,String confirmPassword){
   register.enter_Password(password,confirmPassword);

    }

    @And("user clicks on register button")
    public void click_registerBtn(){
        register.clickRegisterBtn();
    }

    @Then("success message is displayed")
    public void success_msg(){
     register.resultOfRegisteration();
    }
}
