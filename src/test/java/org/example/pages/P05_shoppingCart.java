package org.example.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.stepDefs.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_shoppingCart {



    public WebElement get_ProductByName(String productName){

        return Hooks.driver.findElement(By.linkText(productName));
    }

    public WebElement get_addToCartBtn(){

        return Hooks.driver.findElement(By.xpath("//div[@class=\"add-to-cart\"]//button[@type=\"button\"]"));
    }
public List<WebElement>rowElements(){
        return Hooks.driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr"));
}
public List<WebElement>colElements(){
        return Hooks.driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td"));
}
public WebElement getAddToCartLabelBtn(){
        return  Hooks.driver.findElement(By.className("cart-label"));
}
    public void validateProductAddedToCart(String Name) throws InterruptedException {
        Assert.assertTrue(Hooks.driver.findElement(By.className("content")).getText().contains("The product has been added to your "));
        Thread.sleep(3000);
        getAddToCartLabelBtn().click();
        int rowsCount = rowElements().size();
        int colCount = colElements().size();

        for (int i=1;i<=rowsCount;i++){
            for (int j=1;j<=colCount;j++){
                String productName = Hooks.driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                if (productName.contains(Name)) {
                    Assert.assertTrue(productName.contains(Name));
                    System.out.println("yes the product is found "+Name);
                }
            }
        }

    }
    public void clickOnProductName(String prodName){
        get_ProductByName(prodName).click();
    }
    public void clickOnAddToCartBtn(){
        get_addToCartBtn().click();
    }
}
