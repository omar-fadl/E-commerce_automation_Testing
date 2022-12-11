
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
  Given user go to login page
  And user login with "omarfadl000@gmail.com" and "omar123"
  And user press on login button
  Then user login to the system successfully

  Scenario: user could login with invalid email and password
 Given user go to login page
  And user login with "wrong@example.com" and "P@ssw0rd"
  And user press on login button
  Then user could not login to the system

