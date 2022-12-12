@smoke
Feature: F04_Search Logged user search for product by name
  Background:
    Given user go to login page
  And user login with "omarfadl000@gmail.com" and "omar123"
  And user press on login button

  Scenario:  Logged User could search for any product by name
  When user enter "nike" in search box
  And click on search button
 Then all search results should appear contain search "nike"

  Scenario:  Logged User could search for any product by SKU
    When user enter "SCI_FAITH" in search box
    And click on search button
    And click on search result
    Then search results should appear contain search "SCI_FAITH"
