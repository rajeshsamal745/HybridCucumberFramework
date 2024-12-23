@LogIn
Feature: Login Page Feature
	
	@Smoke
  Scenario: Verify the login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Shop"
	
	@Sanity
  Scenario: Forgot password link
    Given user is on login page
    Then Forgot your password link should be displayed
    
	@Regression @Skip
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "rajeshsamal745@gmail.com"
    And user enters password "Bhubaneswar@24"
    And user clicks on SignIn Button
    Then user gets the title of the page
    And page title should be "My account - My Shop"
