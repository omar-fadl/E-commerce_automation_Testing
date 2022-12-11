package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D07_followUsStepDef {
    P03_homePage followUS=new P03_homePage();
@When("user opens facebook link")
    public void openFacebook(){
followUS.clickOnFacebook();
}
    @When("user opens twitter link")
    public void openTwitter(){
followUS.clickOnTwitter();
    }
    @When("user opens rss link")
    public void openRss(){
followUS.clickOnRss();
    }
    @When("user opens youtube link")
    public void openYoutube(){
followUS.clickOnYoutube();
    }

@Then("^\"(.*)\" is opened in new tab$")
    public void validateLink(String link){
followUS.validateURL(link);
}
}
