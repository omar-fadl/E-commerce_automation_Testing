package org.example.pages;

import org.example.stepDefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P07_makeOrder {
    public WebElement getagreeOnTermsCheck(){

        return Hooks.driver.findElement(By.id("termsofservice"));
    }
    public WebElement getcheckoutBtn(){

        return Hooks.driver.findElement(By.id("checkout"));
    }

    public WebElement getaddressDrp(){

        return Hooks.driver.findElement(By.id("billing-address-select"));
    }

    public WebElement getcountryDrp(){

        return Hooks.driver.findElement(By.id("BillingNewAddress_CountryId"));
    }
    public WebElement getcityInput(){

        return Hooks.driver.findElement(By.id("BillingNewAddress_City"));
    }
    public WebElement getaddressInput(){

        return Hooks.driver.findElement(By.id("BillingNewAddress_Address1"));
    }
    public WebElement getpostalCode(){

        return Hooks.driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    }
    public WebElement getphone(){

        return Hooks.driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    }
    public WebElement getcontinueBtn1(){
        return Hooks.driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
    }
    public WebElement getcontinueBtn2(){

        return Hooks.driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/button"));
    }

    public WebElement getshippingMethodContinueBtn(){
        return Hooks.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
    }
    public WebElement getpaymenMethodContinueBtn(){
        return Hooks.driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
    }
    public WebElement getpaymenInfoContinueBtn(){
        return Hooks.driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
    }
    public WebElement get_ConfirmBtn(){
        return Hooks.driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
    }

    public WebElement getorderDone(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong"));
    }

    public void clickOnCheckOut(){
        getagreeOnTermsCheck().click();
        getcheckoutBtn().click();
    }
    public void fillBillingAddressSection(){

        Boolean found = Hooks.driver.findElements(By.id("billing-address-select")).size() > 0;

        if(found){

            Select dropAddressOptions= new Select(getaddressDrp());
            String selectedOption=dropAddressOptions.getFirstSelectedOption().getText();
            if(selectedOption.contains("New Address")){
                Select dropCountry= new Select(getcountryDrp());
                dropCountry.selectByValue("123");
                getcityInput().sendKeys("Giza");
                getaddressInput().sendKeys("Omrania");
                getpostalCode().sendKeys("12551");
                getphone().sendKeys("01151851295");
                getcontinueBtn1().click();
            }
            else{
                Hooks.driver.findElement(By.id("ShipToSameAddress")).click();
                getcontinueBtn1().click();
            }
        }
        else{

            Select drpCountry= new Select(getcountryDrp());
            drpCountry.selectByValue("123");
            getcityInput().sendKeys("Giza");
            getaddressInput().sendKeys("Omrania");
            getpostalCode().sendKeys("12551");
            getphone().sendKeys("01151851295");
            getcontinueBtn1().click();
        }

    }
    public void shippingAddressSection() throws InterruptedException {
        Thread.sleep(4000);

        boolean found=Hooks.driver.findElements(By.xpath("//*[@id=\"shipping-buttons-container\"]/button")).size() > 0;
        if(found==true){
            getcontinueBtn2().click();
        }
    }
    public void shippingMethodSection() throws InterruptedException {
        Thread.sleep(3000);
        getshippingMethodContinueBtn().click();
    }
    public void paymentMethodSection() throws InterruptedException{
        Thread.sleep(2000);
        getpaymenMethodContinueBtn().click();
    }

    public void paymentInfoSection() throws InterruptedException{
        Thread.sleep(2000);
        getpaymenInfoContinueBtn().click();
    }
    public void placeOrder(){
        get_ConfirmBtn().click();
    }
    public void validateOrderDone(){
        Assert.assertTrue(getorderDone().getText().contains("Your order has been successfully processed!"));
    }


}
