@Wiki
Feature: Wikipedia Search Functionality

  Agile story: As a user I should be able to enter text into search bar on the main page
  and by clicking the search button I should be able to see the search result.

  #Title Verification
  Scenario: Page has the title as expected
    Given user is on the "Wikipedia" home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the "Wikipedia" title
  #Header Verification
  Scenario: Page has the header as expected
    Given user is on the "Wikipedia" home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header
  #Image Header Verification
  Scenario: Page has an image header as expected
    Given user is on the "Wikipedia" home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

  @ScenarioOutline
  Scenario Outline: For all the scenarios of this feature
    Given user is on the "Wikipedia" home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the "Wikipedia" title
    Then User sees "<expectedHeader>" is in the main header
    Then User sees "<expectedImageHeader>" is in the image header

    Examples: Search values we are going to be using
      | searchValue    | expectedTitle  | expectedHeader | expectedImageHeader |
      | Steve Jobs     | Steve Jobs     | Steve Jobs     | Steve Jobs          |
      | Mary Barra     | Mary Barra     | Mary Barra     | Mary Barra          |
      | Vladimir Putin | Vladimir Putin | Vladimir Putin | Vladimir Putin      |
      | Donald Trump   | Donald Trump   | Donald Trump   | Donald Trump        |