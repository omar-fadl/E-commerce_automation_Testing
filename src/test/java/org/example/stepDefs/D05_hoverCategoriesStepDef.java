package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D05_hoverCategoriesStepDef {
    P03_homePage hover=new P03_homePage();
@When("user hover on main category")
public void hoverMainCategory() throws InterruptedException {
    hover.hoverRandomCategory();
}

@Then("user hover and select random sub category check that subcategory contain desktops")
    public void validateSubcategory() throws InterruptedException {
    hover.findelements();
    }
}
