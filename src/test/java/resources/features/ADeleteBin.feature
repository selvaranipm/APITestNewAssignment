@tag
Feature: ADeleteBin
 
  @tag1
  Scenario: DeleteBin
    Given the DeleteBin endpoint URl 
    When I send a Delete request
    Then verify the Bin is Deleted
    And DeleteBin status code should be success 