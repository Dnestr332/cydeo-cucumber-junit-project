@BingTest
Feature: Bing search page functionality

  Agile story: As a user I should be able to enter text in the search field
  and by pressing "Enter" it should show me the search result.

  Scenario: Bing search page works as expected
    Given user is on the Bing search page
    When user enters valid text into Bing search field
    Then user is able to see the Bing search result page
