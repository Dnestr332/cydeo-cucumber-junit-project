Feature: Google Search functionality
  Agile story: As a user, when I'm on the Google search page
  I should be able to search anything and see the relevant results

  Scenario: Search page default title verification
    When  user is on the Google search page
    Then  user should see the title is google