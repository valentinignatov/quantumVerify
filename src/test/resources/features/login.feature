Feature: User Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter the username "practice"
    And I enter the password "SuperSecretPassword!"
    Then I should see a success message "You logged into a secure area!"
