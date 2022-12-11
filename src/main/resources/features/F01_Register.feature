
  Feature: F01_Register
    Scenario: guest user could register with valid data successfully
      Given user go to register page
    When user select gender type
    And user enter first name "omar" and last name "fadl"
    And user enter date of birth day "15" and month "October" and year "1995"
    And user enter email "omarfadl000@gmail.com" field
    And user fills Password fields "omar123" and "omar123"
      And user clicks on register button
      Then  success message is displayed