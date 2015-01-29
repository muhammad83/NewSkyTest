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

  Scenario: Open Episodes of the searched series
    Given I am on the episodes page of Arrow
    When I click on season "1"
    Then I should see 23 episodes of season 1

  Scenario: Open Episodes of the searched series
    Given I am on the episodes page of Arrow
    When I click on season "1"
    Then I should see the following episodes
      | Sacrifice                    |
      | Darkness on the Edge of Town |
      | The Undertaking              |
      | Home Invasion                |
      | Unfinished Business          |
      | Salvation                    |
      | The Huntress Returns         |
      | Dead to Rights               |
      | Dodger                       |
      | The Odyssey                  |
      | Betrayal                     |
      | Vertigo                      |
      | Trust but Verify             |
      | Burned                       |
      | Year's End                   |
      | Vendetta                     |
      | Muse of Fire                 |
      | Legacies                     |
      | Damaged                      |
      | An Innocent Man              |
      | Lone Gunman                  |
      | Honour Thy Father            |
      | Pilot                        |
