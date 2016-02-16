Feature: How drive a tube train happy path

  As a tube driver,
  I would like to drive a tube train,
  So I can commute people across London

  @wip
  Scenario: Close the door
    Given "Marco" is the driver
    When "Marco" closes the doors
    Then the train makes a beep
    And the train closes its doors

  @wip
  Scenario: Start the train
    Given "Marco" is the driver
    And the doors are closed
    When I push the dead man's handle at level 1
    Then the train starts

  @wip
  Scenario: Speed up the train
    Given "Marco" is the driver
    And the train moves at speed 1
    When I push the dead man's handle at level 3
    Then the train speed changes to speed 3

  @wip
  Scenario: Slow the train
    Given "Marco" is the driver
    And the train moves at speed 3
    When I push the dead man's handle at level 1
    Then the train speed changes to speed 1

  @wip
  Scenario: Stop the train
    Given "Marco" is the driver
    And the train moves at speed 1
    When I push the dead man's handle at level 0
    Then the train stops gently

  @wip
  Scenario: Open the train
    Given "Marco" is the driver
    And the train is not moving
    When I push the open door button
    Then the train opens its doors