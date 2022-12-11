package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_shoppingCart;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class D10_shoppingCartStepDef {
    P05_shoppingCart shopping=new P05_shoppingCart();
    @When("^user click on product \"(.*)\"$")
    public void clickOnProduct(String productName){

        shopping.clickOnProductName(productName);
    }
    @And("user click on add to cart button")
    public void clickOnAddToCartBtn() throws InterruptedException {
        shopping.clickOnAddToCartBtn();
        Thread.sleep(3000);
    }
    @Then("^product \"(.*)\" shall be added to cart$")
    public void validateProductAddToCart (String productName) throws InterruptedException {
        shopping.validateProductAddedToCart(productName);
    }

}
