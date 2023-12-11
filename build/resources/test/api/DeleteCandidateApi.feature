
Feature: Verify that admin user can delete candidate through candidate API

  Background:
    Given admin user is logged in properly
    And new candidate is created

  Scenario: DELETE to candidate API
    When delete call api with valid id
    Then api response is 200