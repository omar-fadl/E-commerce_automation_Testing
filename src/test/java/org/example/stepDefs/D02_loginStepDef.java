package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;

public class D02_loginStepDef {
    P02_login login=new P02_login();
    @Given("user go to login page")
    public void goLoginPage(){
        login.openLoginPage();
    }

    @When("^user login with \"(.*)\" and \"(.*)\"$")
    public void loginWith_validData(String email,String password){
    login.set_userName_Password(email,password);
    }
    @And("user press on login button")
    public void pressLoginBtn(){
        login.clickaloginBtn();
    }
    @Then("user login to the system successfully")
    public void successMsg() throws InterruptedException {
     login.resultSuccessLogin();
    }
    @Then("user could not login to the system")
    public void errorMsg(){
        login.resultErrorLogin();

    }
    @And("click forget password button")
    public void clickOnFogetPasswordBtn(){
       login.clickFogetPassword();
    }
    @And("^enter his/her \"(.*)\" to reset password$")
    public void emailOfResetPassword(String email){
        login.setEmailtoReset(email);
    }
    @Then("user click on recover button")
    public void clickRecoverBtn(){
        login.clickRecoverBtn();
    }
    @And("user could reset his password")
    public void validateResetPassword(){
         login.validateResetPassword();
    }
}
