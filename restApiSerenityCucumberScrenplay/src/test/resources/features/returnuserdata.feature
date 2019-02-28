Feature: Return User Data

  Scenario: Get Single User
    Given the service was up
    When i search for the user with id "3"
    Then the id obtained should be "3"
    And the first_name should be "Emma"
    And the last_name should be "Wong"


  Scenario: Get All Users
    Given the service was up
    When i search for all the users
    Then i should get all the users