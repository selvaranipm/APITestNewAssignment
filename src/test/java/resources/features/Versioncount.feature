@tag
Feature: Verify Get method for versionscount
  

  @tag1
  Scenario: Version count
    Given the versioncount URl 
    When I send a countget request
    Then verify the count
    And status code should be success 