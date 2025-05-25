@CydeoTable
Feature: Cydeo WebTable page functionality.
  Agile story: as a user I should be able to enter valid credentials
  on the login page and should be able to access the main page after.

  Background: for all the tests
    Given user is on the page with "https://web-table-2.cydeo.com/login"
    When user enters "Test" and "Tester"
    And user clicks login button

  Scenario: Login page functionality
    Then  user should see "order" in page URL

  Scenario: Verify products
    When user is on the Order page
    Then user sees below options under “product” dropdown
      | MoneyCog   |
      | FamilyBea  |
      | Screenable |

  Scenario: Verify cards
    When user is on the Order page
    Then user sees below radio buttons enabled for
      | Visa             |
      | MasterCard       |
      | American Express |

  Scenario: Order placement
    When user is on the “Order” page
    Then user enters appropriate test data
      | Product                                     |  |
      | Quantity                                    | 5 |
      | Customer name                               |  John Doe|
      | Street                                      |  555 Main st|
      | City                                        |  Brooklyn|
      | State                                       |  NY|
      | Zip                                         |  11258|
      | Card type: Visa/MasterCard/American Express |  |
      | Card No                                     |  |
      | Expire date                                 |  |
    And user clicks to “Process Order”
    Then user should see new order in the table on “View all orders” page


  @CydeoOutline
  Scenario Outline: For all the scenarios
    Given user is on the page with "<url>"
    When user enters "<login>" and "<password>"
    And user clicks login button
    Then  user should see "<keyword>" in page URL

    Examples: all the values:
      | url                                 | login | password | keyword |
      | https://web-table-2.cydeo.com/login | Test  | Tester   | orders  |