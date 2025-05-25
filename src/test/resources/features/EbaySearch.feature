@Ebay
Feature: Ebay search functionality
  Agile story: As a user I should be able to enter text into search bar
  and by clicking search button I should see the search result.

  Scenario: Page has the title as expected
    Given  user is on "https://www.ebay.com/" page
    Then user sees title is as expected.

  Scenario: Search functionality works as expected
    Given  user is on "https://www.ebay.com/" page
    When user types Wooden Spoon in the search box
    And user clicks search button
    Then user sees Wooden Spoon is in the title

  Scenario: Search functionality works as expected with parameters
    Given  user is on "https://www.ebay.com/" page
    When user types "Wooden Spoon" in the search box
    And user clicks search button
    Then user sees "Wooden Spoon" is in the title