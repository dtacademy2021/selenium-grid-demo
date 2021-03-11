Feature: Search






  Scenario: Verify Google Search Page
    Given I am on Google Search homepage
    When I search  for a "Microphone"
    Then The title of the page should contain the term
   

    
     
   	