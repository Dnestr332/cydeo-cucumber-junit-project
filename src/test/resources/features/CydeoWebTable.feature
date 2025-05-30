@CydeoTable
Feature: Cydeo WebTable page functionality.
  Agile story: as a user I should be able to enter valid credentials
  on the login page and should be able to access the main page after.

  @Login
  Scenario: Login page functionality
    Then  user should see "order" in page URL

  @Login
  Scenario: Verify products
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | FamilyBea  |
      | Screenable |

  @Login
  Scenario: Verify cards
    When user is on the Order page
    Then user sees below radio buttons enabled for
      | Visa             |
      | MasterCard       |
      | American Express |

  @OrderOutline @Login
  Scenario Outline: Order placement
    When user is on the Order page
    Then user enters product info as "<product>" and "<quantity>"
    And user enters "<name>", "<street>", "<city>", "<state>", "<zip>"
    And user chooses "<card type>", enters "<card No>", "<expires>"
    And user clicks to Process Order
    Then user should see new order with "<name>" in the table on View all orders page

    Examples: All the values and fields
      | product    | quantity | name           | street           | city        | state | zip   | card type        | card No      | expires |
      | MoneyCog   | 1        | Alexandra Gray | 7, Miller Street | Newcastle   | AZ    | 21444 | Visa             | 321456789012 | 02/24   |
      | Familybea  | 2        | Bart Fisher    | 12, Cherry Ave   | Los Angeles | CA    | 22043 | MasterCard       | 980077987700 | 03/27   |
      | Screenable | 3        | Ned Stark      | 35, Stone st.    | Brooklyn    | NY    | 11237 | American Express | 774555444555 | 05/30   |


  @LoginOutline
  Scenario Outline: For all the scenarios
    Given user is on the page with "<url>"
    When user enters "<login>" and "<password>"
    And user clicks login button
    Then  user should see "<keyword>" in page URL

    Examples: all the values:
      | url                                 | login | password | keyword |
      | https://web-table-2.cydeo.com/login | Test  | Tester   | orders  |