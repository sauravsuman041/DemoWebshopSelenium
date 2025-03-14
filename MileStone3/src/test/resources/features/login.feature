Feature: User Login

  Scenario: Login with valid credentials
    Given User is on the Demo Webshop home page
    When User logs in with valid credentials
    Then User should be logged in successfully
