package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p04_SelectTag;
import org.junit.Assert;
import org.openqa.selenium.By;

public class D09_SelectTagStepDef {
    p04_SelectTag select=new p04_SelectTag();
    @When("^user selects tag \"(.*)\"$")
    public void selectTag(String tagName) throws InterruptedException {
        Thread.sleep(4500);
        select.clickOnTag(tagName);
    }
    @Then("^user shall be directed to this tag \"(.*)\" page$")
    public void validateRedirectionToTagPage(String tagName) throws InterruptedException {
        Thread.sleep(4500);
        Assert.assertTrue(Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1")).getText().contains(tagName));

    }
}
