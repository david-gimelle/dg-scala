Feature: Underground tube train safety

  As a tube driver,
  I would like to drive a safe tube train,
  So that I commute people across London safely

  Scenario: Can not start a train with open door
    Given I have take control of the train
    And the door are open
    When I start the train
    Then the train doesn't move

  Scenario: Start the train
    Given I have take control of the train
    And the door are closed
    When I push the close the door button
    Then the train make a beep
    And the door are closed
