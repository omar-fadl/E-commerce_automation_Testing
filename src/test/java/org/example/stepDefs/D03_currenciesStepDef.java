package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage home=new P03_homePage();

@When("^user select currency \"(.*)\"$")
    public void select_currencies(String currencyName) throws InterruptedException {
    home.selectCurrency(currencyName);
}
@Then("^user show all products price contain symbol \"(.*)\"$")
    public void show_all_product_contain_correct_symbol(String symbol) throws InterruptedException {

    home.check_products_price_symbol(symbol);
}
}


