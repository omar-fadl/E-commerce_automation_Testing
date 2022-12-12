@smoke
Feature: F03_Currencies--> logged user can change currency from us dollar to Euro
  Scenario: loged user check that all product price contain symbol "€" when select currency Euro
    Given user go to login page
    And user login with "omarfadl000@gmail.com" and "omar123"
    And user press on login button
    Then user login to the system successfully
    When user select currency "Euro"
    Then  user show all products price contain symbol "€"
