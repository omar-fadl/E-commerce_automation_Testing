package org.example.pages;

import org.example.stepDefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class P01_register {
    SoftAssert soft=new SoftAssert();
    public WebElement getregisterLink(){
      return Hooks.driver.findElement(By.className("ico-register"));
    }
    public void openRegisterPage(){

        getregisterLink().click();
    }

    public WebElement getGender(){
        return Hooks.driver.findElement(By.id("gender-male"));
    }
    public void selectGender(){
        getGender().click();
    }

    public WebElement enterFristName(){

        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement enterLastName(){

        return Hooks.driver.findElement(By.id("LastName"));
    }
    public void enter_fristName_lastName(String fName,String lName){
        enterFristName().sendKeys(fName);
        enterLastName().sendKeys(lName);
    }
    public WebElement getDayOfBirth(){

        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement getMonthOfBirth(){

        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement getYearOfBirth(){

        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }
    public void select_DateOfBirth(String day,String month,String year){
        Select dropDay= new Select(getDayOfBirth());
        Select dropMonth= new Select(getMonthOfBirth());
        Select dropYear= new Select(getYearOfBirth());

        dropDay.selectByVisibleText(day);
        dropMonth.selectByVisibleText(month);
        dropYear.selectByVisibleText(year);
    }
    public WebElement getEmail(){
        return Hooks.driver.findElement(By.id("Email"));
    }
    public void enter_Email(String email){
        getEmail().sendKeys(email);
    }
    public WebElement getPassword(){
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement getConfirmPassword(){
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public void enter_Password(String password,String confirmPassword){
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
    }

    public WebElement getRegisterBtn(){
        return Hooks.driver.findElement(By.id("register-button"));
    }
    public void clickRegisterBtn(){
        getRegisterBtn().click();
    }
    public String getUrlOfSuccessRegister(){
        return Hooks.driver.getCurrentUrl();
    }
    public WebElement getSuccessMsg(){
        return Hooks.driver.findElement(By.className("result"));
    }


    public void resultOfRegisteration(){

         String acualUrl="https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
         String expectedUrl=getUrlOfSuccessRegister();
         soft.assertEquals(expectedUrl,acualUrl);

       String acualMsg="Your registration completed";
       String expectedMsg=getSuccessMsg().getText();
       soft.assertTrue(acualMsg.contains(expectedMsg));
     String acualcolorMsg="#4cb17c";
     String colorMsg=getSuccessMsg().getCssValue("color");
        String expectedcolorMsg= Color.fromString(colorMsg).asHex();
     soft.assertEquals(expectedcolorMsg,acualcolorMsg);
     soft.assertAll();
    }
}
