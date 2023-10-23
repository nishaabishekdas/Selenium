
@tag
Feature: View Store Details
  As a user I should get the all the details of stores

  @tag1
  Scenario: Get all store details
    Given store API is available
    When I invoke stores API with get Method
    Then the response code should be 200

    Scenario: Get specific store using store id
    Given store API is available
    When I invoke "stores/{id}" api with get Method
    Then the response code should be 200