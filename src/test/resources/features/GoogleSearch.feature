@GoogleTest
Feature: Google search page functionality

  Agile story: As a user I should be able to enter text in the search field
  and by pressing "Enter" it should show me the search result.

  Scenario: Google search page works as expected
    Given user is on the Google search page
    When user enters valid text into Google search field
    Then user is able to see the Google search result page