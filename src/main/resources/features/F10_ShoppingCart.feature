@smoke
Feature: Logged user shall add product to shopping cart/wishlist/comparelist
  Scenario:  Logged User shall add different products to shopping cart
    Given user go to login page
    And user login with "omarfadl000@gmail.com" and "omar123"
    And user press on login button
    Then user login to the system successfully

    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to cart button
    Then product "First Prize Pies" shall be added to cart
    #second product
    When user enter "Flower Girl Bracelet" in search box
    And user click on product "Flower Girl Bracelet"
    And user click on add to cart button
    Then product "Flower Girl Bracelet" shall be added to cart
