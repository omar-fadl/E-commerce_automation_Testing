Feature: registered user could reset his password
Scenario: user could reset password
Given user go to login page
And click forget password button
And enter his/her "omarfadl000@gmail.com" to reset password
Then user click on recover button
And user could reset his password