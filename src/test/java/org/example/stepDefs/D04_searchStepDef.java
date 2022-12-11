package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class D04_searchStepDef {
    P03_homePage search= new  P03_homePage();
    @When("^user enter \"(.*)\" in search box$")
    public void enterSearchWord(String word){
        search.setSearchWord(word);
    }
    @And("click on search button")
    public void clickSearchButton(){
        search.clickSearch();
    }
    @And("click on search result")
    public void clickSearchResult(){
        search.clickImageLink();
    }
    @Then("^all search results should appear contain search \"(.*)\"$")
    public void validateSearchResult( String word) throws InterruptedException {
        Thread.sleep(3000);
        search.resultSearch(word);
    }
    @Then("^search results should appear contain search \"(.*)\"$")
    public void validateSearchResultSku(String word) throws InterruptedException {
        Thread.sleep(3000);
        search.checkResultSku(word);
    }
}
