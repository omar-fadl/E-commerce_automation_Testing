@smoke
Feature: Logged User shall make order
  Scenario: Logged User shall make successful order
    Given user go to login page
    And user login with "omarfadl000@gmail.com" and "omar123"
    And user press on login button
    Then user login to the system successfully

    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to cart button
    Then product "First Prize Pies" shall be added to cart

    When click on agree on terms and checkout buttons
    And logged user should fill Billing address field
    And logged user should fill shipping method field
    And logged user should fill payment method field
    And logged user should fill payment Info field
    And logged user should place order
    Then order should be completed
