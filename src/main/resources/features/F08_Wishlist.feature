@smoke
Feature: F08_WishList | users could add product to WishList
  Scenario: verify that the massege of add product to WishList is displayed
    When user click on wishlist
    Then the message is displayed with green backgroung

  Scenario: verify that the quantity greater than zero after click on add to wishlist
    When user click on wishlist
   And the message is displayed and wait until the message is disappeared
    Then verify the quantity  greater than zero
