Feature: How drive a tube train happy path

  As a tube driver,
  I would like to drive a tube train,
  So I can commute people across London

  @wip
  Scenario: Close the door
    Given "Marco" is the driver
    When "Marco" closes the doors
    Then the train makes a beep
    And the train's doors are closed

  @wip
  Scenario: Start the train
    Given "Marco" is the driver
    And "Marco" closes the doors
    When "Marco" push the dead man's handle at level 1
    Then the train is moving at speed 1

  @wip
  Scenario: Speed up the train
    Given "Marco" is the driver
    And "Marco" push the dead man's handle at level 1
    When "Marco" push the dead man's handle at level 3
    Then the train is moving at speed 3

  @wip
  Scenario: Slow the train
    Given "Marco" is the driver
    And "Marco" push the dead man's handle at level 3
    When "Marco" push the dead man's handle at level 1
    Then the train is moving at speed 1

  @wip
  Scenario: Stop the train
    Given "Marco" is the driver
    And "Marco" push the dead man's handle at level 1
    When "Marco" push the dead man's handle at level 0
    Then the train stops gently

  @wip
  Scenario: Open the train when train stopped
    Given "Marco" is the driver
    And "Marco" push the dead man's handle at level 0
    When "Marco" opens the doors
    Then the train's doors are opened