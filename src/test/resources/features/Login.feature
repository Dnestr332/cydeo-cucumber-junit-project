@LoginTest
Feature: Login page functionality

  Agile story: As a user I should be able to login with correct credentials
  to different accounts. And dashboard should be displayed.

  #Student scenario
  Scenario: Login page works as expected for student
    Given student is on the login page
    When student enters valid credentials
    Then user is able to see the student dashboard
    #Librarian scenario
  Scenario: Login page works as expected for librarian
    Given librarian is on the login page
    When librarian enters valid credentials
    Then user is able to see the librarian dashboard
    #Admin scenario
  Scenario: Login page doesn't work as expected for admin
    Given admin is on the login page
    When admin enters invalid credentials
    Then user is unable to see the admin dashboard