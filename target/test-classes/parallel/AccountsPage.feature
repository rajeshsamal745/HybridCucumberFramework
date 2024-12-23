Feature: Account Page Feature

  Background: 
    Given user has already logged in to application
      | username                 | password       |
      | rajeshsamal745@gmail.com | Bhubaneswar@24 |

  Scenario: Accounts apge title
    Given user is on the Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Shop"

  Scenario: Accounts section count
    Given user is on the Accounts page
    Then user gets accounts section
      | ADD MY FIRST ADDRESS      |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
    And accounts section count should be 5
