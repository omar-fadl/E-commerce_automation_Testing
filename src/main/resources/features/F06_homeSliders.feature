
Feature: F06_homeSlider | users could switch between sliders
  Scenario: user switch between sliders and url change in tabs
    When user click on Nokia Lumia 1020
    Then "https://demo.nopcommerce.com/nokia-lumia-1020" is opened in the same tab
  Scenario: user switch between sliders and url change in tabs
    When user click on iphone slider
    Then "https://demo.nopcommerce.com/iphone-6" is opened in the same tab