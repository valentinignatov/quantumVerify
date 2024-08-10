Feature: Web Inputs Interaction

  Scenario: Successfully insert and verify various inputs on WebInput page
    Given I am on the WebInput page
    When I insert number "10"
    And I increment number by 20
    And I decrement number by 10
    And I insert text "Valentin Ignatov Test"
    And I insert password "superPas"
    And I insert today's date
    And I display the output
    Then the number displayed should be "20"
    And the text displayed should be "Valentin Ignatov Test"
    And the password displayed should be "superPas"
    And the date displayed should match today's date

