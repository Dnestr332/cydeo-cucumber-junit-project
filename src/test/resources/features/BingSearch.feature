@BingTest
Feature: Bing search page functionality

  Agile story: As a user I should be able to enter text in the search field
  and by pressing "Enter" it should show me the search result.

  Scenario: Bing search page works as expected
    Given user is on the "Search - Microsoft Bing" page
    When user enters "orange" into Bing search field
    Then user is able to see the Bing "orange - Search" result page
