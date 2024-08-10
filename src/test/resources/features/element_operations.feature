Feature: Element Add and Remove Operations

  Scenario: Successfully add multiple elements
    Given I am on the Add Remove page
    When I add 100 elements
    Then the number of displayed elements should be 100

  Scenario: Successfully remove all elements
    Given I have added 100 elements
    When I remove all 100 elements
    Then no elements should be displayed
