@Data
Feature: Data Tables practice

  Scenario: List of fruits and vegetables
    Then user should see the below list
      | orange     |
      | apple      |
      | kiwi       |
      | tomato     |
      | strawberry |
      | peach      |

  Scenario: Officer reads drivers data
    Then officer is able to read any data
      | name     | Jane          |
      | lastName | Doe           |
      | age      | 34            |
      | address  | XYZ           |
      | state    | NY            |
      | zipcode  | 11235         |
      | phone    | 111-111-11111 |

