Feature: Verify that Admin Can Create then Delete User

  Scenario: Admin Can Create then Delete User
    Given admin user is logged in
    And admin navigate to system user page
    And admin capture the number of records
    When admin clicks on add new user
    And admin enter valid user data
    And admin clicks on save button
    Then admin number of records increased by one
    When admin searches with the username for the new user
    And admin delete the new user
    And admin reset filter
    Then number of records should be decreased by one