@tag
Feature: Change Privacy Bin with put method

  @tag1
  Scenario: Change Privacy Bin
    Given the CPendpoint URl 
    When I send a chnageprivacyput request
    Then verify the changeprivacyBin is updated
    And verify CP status code should be success 