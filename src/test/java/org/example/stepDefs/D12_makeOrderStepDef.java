package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P07_makeOrder;

public class D12_makeOrderStepDef {
P07_makeOrder makeOrder=new P07_makeOrder();
    @When("click on agree on terms and checkout buttons")
    public void clickOnAgreeAndCheckout(){
        makeOrder.clickOnCheckOut();

    }

    @And("logged user should fill Billing address field")
    public void fillBillingAddressSection() throws InterruptedException {

        makeOrder.fillBillingAddressSection();
        Thread.sleep(3000);

    }
    @And("logged user should fill shipping address field")
    public void fillShippingAddress() throws InterruptedException {
        Thread.sleep(4000);
        makeOrder.shippingAddressSection();
    }
    @And ("logged user should fill shipping method field")
    public void fillShippingMethod() throws InterruptedException {
        makeOrder.shippingMethodSection();
        Thread.sleep(3000);
    }
    @And("logged user should fill payment method field")
    public void fillPaymentMethod() throws InterruptedException {
        makeOrder.paymentMethodSection();
    }

    @And("logged user should fill payment Info field")
    public void fillPaymentInfo() throws InterruptedException {
        makeOrder.paymentInfoSection();
    }
    @And("logged user should place order")
    public void placeOrder() throws InterruptedException {
        Thread.sleep(3000);
        makeOrder.placeOrder();
    }
    @Then("order should be completed")
    public void validateOrderCompletion() throws InterruptedException {
        Thread.sleep(3000);
        makeOrder.validateOrderDone();
    }
}
