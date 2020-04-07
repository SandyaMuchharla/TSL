@login
Feature: Login to gmail

  @SmokeTest1
  Scenario: Find Broken links
    Given I am on "https://gmail.com"
    When I get href links
    Then status code should be 200