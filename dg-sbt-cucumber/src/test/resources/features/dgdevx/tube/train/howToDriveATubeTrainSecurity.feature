Feature: Underground tube train safety

  As a tube driver,
  I would like to drive a safe tube train,
  So I can commute people across London safely

  @wip
  Scenario: Can not start a train with open doors
    Given "Marco" is the driver
    And the doors are open
    When I start the train
    Then the train doesn't move

  @wip
  Scenario: Can not open the doors of a moving train
    Given "Marco" is the driver
    And the train is moving
    When I push the open door button
    Then the train doesn't open its doors

  @wip
  Scenario: Train can stop automatically if the driver dies
    Given "Marco" is the driver
    And the doors are closed
    And the train is moving
    When I stop to push the dead man's handle
    Then the train stops immediately

  @wip
  Scenario: Break the train
    Given "Marco" is the driver
    When I push the break
    Then the train stops immediately

