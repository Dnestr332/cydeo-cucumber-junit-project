@Wiki
Feature: Wikipedia Search Functionality

  Agile story: As a user I should be able to enter text into search bar on the main page
  and by clicking the search button I should be able to see the search result.

  Background: For all the scenarios on the Wikipedia main page.
    Given user is on the "Wikipedia" home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button

  #Title Verification
  Scenario: Page has the title as expected
    Then User sees "Steve Jobs" is in the "Wikipedia" title
  #Header Verification
  Scenario: Page has the header as expected
    Then User sees "Steve Jobs" is in the main header
  #Image Header Verification
  Scenario: Page has an image header as expected
    Then User sees "Steve Jobs" is in the image header