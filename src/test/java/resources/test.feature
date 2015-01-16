Feature: Find and Watch Page test

  @run
  Scenario: Search for a sitcom on find and watch page
    Given I am on the search and find page
    When I search for "Arrow"
    #Then I should see Arrow series