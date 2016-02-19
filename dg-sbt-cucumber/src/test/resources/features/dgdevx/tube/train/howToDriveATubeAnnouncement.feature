Feature: Underground tube train announcement

  As a tube driver,
  I would like to talk to passengers,
  So they could know why my train is late

  @wip
  Scenario: Can inform passenger about Signal Failure
    Given "Marco" is the driver
    When I say to the microphone "Line suspended because Signal Failure"
    Then the passengers hear "Line suspended because Signal Failure"

