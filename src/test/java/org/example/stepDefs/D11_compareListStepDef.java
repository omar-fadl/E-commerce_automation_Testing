package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pages.P06_compareList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class D11_compareListStepDef {
    P06_compareList compare=new P06_compareList();
    @When("user click on add to compareList button")
    public void clickOnAddToComparelist() throws InterruptedException {
        compare.clickOnAddToComparelist();
        Thread.sleep(3000);
    }

    @And("^product \"(.*)\" shall be added to compareList$")
    public void validateProductAddedToComparelist(String Name) throws InterruptedException {
      compare.validateProductAddedToComparelist(Name);
    }
}
