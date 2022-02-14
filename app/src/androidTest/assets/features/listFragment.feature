Feature: Restaurants list UI Tests

  Scenario: Show Progress when loading
    Given the Restaurant List Fragment with unload restaurants list
    When restaurant list is not loaded yet
    Then the progress is shown

