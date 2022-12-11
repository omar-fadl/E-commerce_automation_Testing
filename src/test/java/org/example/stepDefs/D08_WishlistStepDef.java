package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage wishList=new P03_homePage();
@When("user click on wishlist")
    public void clickOnWishList(){
    wishList.clickOnAddToWishListBtn();
}

@Then("the message is displayed with green backgroung")
    public void validateMessageIsDisplayed(){
    wishList.validateAddToWishList();
}

@And("the message is displayed and wait until the message is disappeared")
public void disappeared_Msg() throws InterruptedException {
    wishList.disappeardMsg();
}
@Then("verify the quantity  greater than zero")
    public void verifyQty(){
wishList.verifyQuatity();
}
}