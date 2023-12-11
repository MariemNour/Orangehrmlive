Feature: Verify that admin user can Add candidate to candidate API

  Scenario: POST to candidate API
    Given admin user is logged in
    When post call api with valid data
    Then api response is 200OK