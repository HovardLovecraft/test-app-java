Feature: Go to google.com and do search

  @googleTest
  Scenario: Google search
    Given I open Google search page
    And  I enter value "test" to search field
    Then Link to site "www.speedtest.net" exists