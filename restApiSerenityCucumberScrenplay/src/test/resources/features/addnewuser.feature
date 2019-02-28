Feature: Add new User
  @current
  Scenario: Add a new User
    Given the service was up
    When i try to add a new user with name "Javier" and last name "Alvarez"
    Then i should see that the new user was added succesfully