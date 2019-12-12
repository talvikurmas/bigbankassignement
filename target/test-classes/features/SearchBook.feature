Feature: Verify created book is found
  Verify if added book is found in library list

  @search_book
  Scenario: Find created book from the list
    Given I open library webApp
    And I navigate to all books page
    Then I can find created book