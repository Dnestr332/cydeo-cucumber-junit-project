Feature: Login page functionality
  Agile story: As a user I should ne able to login with correct credentials
  to different accounts. And dashboard should be displayed.

  Scenario: Login page works as expected for student
    Given student is on the login page
    When student enters valid credentials
    Then user is able to see the student dashboard

  Scenario: Login page works as expected for librarian
    Given librarian is on the login page
    When librarian enters valid credentials
    Then user is able to see the librarian dashboard

  Scenario: Login page works as expected for admin
    Given admin is on the login page
    When admin enters valid credentials
    Then user is able to see the student admin