Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation is successful with valid username and password
    Given command new is selected
    When user "tero" with password "sala1nen" is created
    Then system will respond with "new user registered"

  Scenario: creation fails with already taken username and valid password
    Given command new is selected
    When user "pekka" with password "salainen1" is created
    Then system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid password
    Given command new is selected
    When user "ee" with password "salainen1" is created
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and too short password
    Given command new is selected
    When user "eero" with password "salai1" is created
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and password long enough but consisting of only letters
    Given command new is selected
    When user "eero" with password "salainenn" is created
    Then system will respond with "new user not registered"

  Scenario: can login with successfully generated account
    Given user "teero" with password "salainen12" is created first
    And   command login is selected
    When username "teero" and password "salainen12" are entered
    Then system will respond with "logged in"