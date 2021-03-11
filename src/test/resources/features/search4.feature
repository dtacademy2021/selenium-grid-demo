
Feature: Customer sign in

  Scenario: Verify Google Search Page
    Given I am on Google Search homepage
    When I search  for a "Laptop"
    Then The title of the page should contain the term
    
     
   	