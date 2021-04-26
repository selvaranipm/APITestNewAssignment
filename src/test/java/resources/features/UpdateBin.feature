
@tag
Feature: Verify Put method for update bin
  

  @tag1
  Scenario: Updating a Bin
    Given the updateBin URl 
    When I send a updateput request
    Then verify the updateBin is updated
    And status code should be success 

  