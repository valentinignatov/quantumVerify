Feature: Sequence Circle Drag and Drop to Target Area

  Scenario: Successfully perform multiple drag and drop operations
    Given I am on the Drag and Drop Circles page
    When I drag the circles in sequence "red, green, blue" to the target area
    Then the circles should be successfully dropped on the target in the order "red, green, blue"
    And I refresh the page
    When I drag the circles in sequence "green, blue, red" to the target area
    Then the circles should be successfully dropped on the target in the order "green, blue, red"
    And I refresh the page
    When I drag the circles in sequence "blue, red, green" to the target area
    Then the circles should be successfully dropped on the target in the order "blue, red, green"
