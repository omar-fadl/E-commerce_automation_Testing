@smoke
Feature: Logged User shall select different tags
  Scenario: Logged user shall select different tags successfully
    Given user go to login page
    And user login with "omarfadl000@gmail.com" and "omar123"
    And user press on login button
    And user enter "First Prize Pies" in search box
    And click on search button
    When user selects tag "awesome"
    Then user shall be directed to this tag "awesome" page
    And user selects tag "nice"
    Then user shall be directed to this tag "nice" page
