package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage slider=new P03_homePage();
    @When("user click on Nokia Lumia 1020")
    public void clickOnNokiaSlider(){
       slider.clickOnNokiaSlider();
    }
    @When("user click on iphone slider")
    public void clickOnIphoneSlider(){
      slider.clickOnIphoneSlider();
    }
    @Then("^\"(.*)\" is opened in the same tab$")
   public void validateUrl(String url){
       slider.validateUrl(url);
    }
}
