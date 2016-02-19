Feature: Underground tube train safety

  As a tube driver,
  I would like to drive a safe tube train,
  So I can commute people across London safely

  @wip
  Scenario: Can not start a train with open doors
    Given "Marco" is the driver
    And "Marco" opens the doors
    When "Marco" push the dead man's handle at level 1
    Then the train is moving at speed 0

  @wip
  Scenario: Can not open the doors of a moving train
    Given "Marco" is the driver
    And "Marco" closes the doors
    And "Marco" push the dead man's handle at level 2
    When "Marco" opens the doors
    Then the train's doors are closed

  @wip
  Scenario: Train can stop automatically if the driver dies
    Given "Marco" is the driver
    And "Marco" closes the doors
    And "Marco" push the dead man's handle at level 2
    When I stop to push the dead man's handle
    Then the train stops immediately

  @wip
  Scenario: Brake the train
    Given "Marco" is the driver
    And "Marco" push the dead man's handle at level 2
    When I push the brake
    Then the train stops immediately

  @wip
  Scenario: Can not use dead man handle if I am not the driver
    Given "Marco" is the driver
    And "Marco" push the dead man's handle at level 1
    When "Loco" push the dead man's handle at level 3
    Then the train is moving at speed 1

