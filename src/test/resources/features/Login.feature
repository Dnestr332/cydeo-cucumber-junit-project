@LoginTest
Feature: Login page functionality

  Agile story: As a user I should be able to login with correct credentials
  to different accounts. And dashboard should be displayed.
  Background: For all the scenarios on the login page of the library application.
    Given user is on the login page

  #Student scenario
  Scenario: Login page works as expected for student
    When student enters valid credentials
    Then user is able to see the student dashboard
    #Librarian scenario
  Scenario: Login page works as expected for librarian
    When librarian enters valid credentials
    Then user is able to see the librarian dashboard
    #Admin scenario
  Scenario: Login page doesn't work as expected for admin
    When admin enters invalid credentials
    Then user is unable to see the admin dashboard