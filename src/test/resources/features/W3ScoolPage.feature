@W3
Feature: Window switch page functionality
  Agile story: user is able to enter text in the console,
  click links, switch windows, verify logos.

  Scenario: W3School page works as expected
    Given user is on the W3School page
    When user writes to the console
    And click on the Visit W3Schools.com! link
    Then total window handle number is 2
    When user switches to the second window
    Then  upper left side logo is displayed
    When user goes back to the first window
    Then run Button contains Run ❯ text