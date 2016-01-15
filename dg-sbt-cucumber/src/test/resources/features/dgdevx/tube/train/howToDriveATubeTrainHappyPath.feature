Feature: How drive a tube train

  As a tube driver,
  I would like to drive a tube train,
  So that I commute people across London

  Scenario: Close the door
    Given I have take control of the train
    When I push the close the door button
    Then the train make a beep
    And the door are closed

  Scenario: Start the train
    Given I have take control of the train
    And the door are closed
    When I push the close the door button
    Then the train make a beep
    And the door are closed
