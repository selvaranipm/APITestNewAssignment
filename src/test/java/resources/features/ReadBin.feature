
@tag
Feature: Verify Get method for Read bin
  

  @tag1
  Scenario: Updating a Bin
    Given the ReadBin URl 
    When I send a readget request
    Then verify the Bin is read
    And ReadBin status code should be success 
 
