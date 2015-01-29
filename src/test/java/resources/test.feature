Feature: Find and Watch Page test

  @run
  Scenario: Search for a sitcom on home page using the find and search bar
    Given I am on the sky home page
    And I have selected the find and search bar
    When I search for "Arrow"
    Then I should see "Arrow" series

  Scenario: Select the searched series
    Given I have searched for "Arrow" series
    And I am on the Find and Search page results of "Arrow"
    When I click on "Find Out More"
    Then I should see Highlights of Arrow

  Scenario: Open Episodes of the searched series
    Given I have searched for "Arrow" series
    And I am on the Find and Search page results of "Arrow"
    When I click on "Episodes"
    Then I should see Episodes of Arrow