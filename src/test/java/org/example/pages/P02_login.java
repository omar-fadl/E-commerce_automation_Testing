package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class P02_login {
    SoftAssert soft=new SoftAssert();
    public WebElement getloginLink(){

        return Hooks.driver.findElement(By.className("ico-login"));
    }
    public void openLoginPage(){
        getloginLink().click();
    }

    public WebElement getusername(){

        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement getpassword(){

        return Hooks.driver.findElement(By.id("Password"));
    }
    public void set_userName_Password(String username,String password){
        getusername().sendKeys(username);
        getpassword().sendKeys(password);
    }
    public WebElement getLoginBtn(){
        return Hooks.driver.findElement(By.className("login-button"));
    }
    public void clickaloginBtn(){
        getLoginBtn().click();
    }
    public String getloginUrl(){

        return Hooks.driver.getCurrentUrl();
    }
    public String getPageTitle(){
        return Hooks.driver.getTitle();
    }
    public void resultSuccessLogin() throws InterruptedException {
        String actualUrl="https://demo.nopcommerce.com/";
        String expectedUrl=getloginUrl();
        soft.assertEquals(expectedUrl,actualUrl);

        String acualTitle="nopCommerce demo store";
        String expectedTitle=getPageTitle();
        soft.assertTrue(acualTitle.contains(expectedTitle));
        soft.assertAll();
        Thread.sleep(5000);
    }

    public WebElement getErrorMsg(){
        return Hooks.driver.findElement(By.className("message-error"));
    }

    public void resultErrorLogin(){


        String acualMsg="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String expectedMsg=getErrorMsg().getText();
        soft.assertTrue(acualMsg.contains(expectedMsg));

        String acualcolorMsg="#e4434b";
        String colorMsg=getErrorMsg().getCssValue("color");
        String expectedcolorMsg= Color.fromString(colorMsg).asHex();

    soft.assertEquals(expectedcolorMsg,acualcolorMsg);
        soft.assertAll();
    }
    public WebElement getclickFogetPassword(){
        return Hooks.driver.findElement(By.linkText("Forgot password?"));
    }
    public void clickFogetPassword(){
        getclickFogetPassword().click();
    }
    public WebElement getEmailInput(){
        return Hooks.driver.findElement(By.cssSelector("input[class=\"email\"]"));
    }
    public void setEmailtoReset(String email){
        getEmailInput().sendKeys(email);
    }
public WebElement getNotificationRestPassword(){
        return Hooks.driver.findElement(By.xpath("//p[@class=\"content\"]"));
}

    public void validateResetPassword(){
        String expectetedNotification="Email with instructions has been sent to you.";
        String acualNotification=getNotificationRestPassword().getText();
        soft.assertTrue(acualNotification.contains(expectetedNotification));
    }
    public WebElement getRecoverBtn(){
        return Hooks.driver.findElement(By.name("send-email"));
    }
    public void clickRecoverBtn(){
        getRecoverBtn().click();
    }
}
