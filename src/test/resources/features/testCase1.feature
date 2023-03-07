Feature: Test case 1

  Scenario: Register user

    Given user is on the main page
    When user clicks on Signup/Login button
    And user enters name and email
    And user clicks Signup button
    And user verifies that the enter account information message is visible
    And user enters their details
    And user clicks on the Sign up for our newsletter checkbox
    And user clicks on the Receive special offers from our partners checkbox
    And user enters the other details
    And user clicks the Create Account button
    And user verifies that the account was created
    And user clicks the continue button
    And user verifies that the logged in as username is visible
    And user clicks the Delete account button
    Then user sees the Account deleted message and should be able to click the continue button