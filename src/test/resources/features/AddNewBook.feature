Feature: Library web application
  Verify if user is able to add new book and find it from the list.

  @add_new_book
  Scenario: Add new book to the library data base
    Given I open library webApp
    And I navigate to create new book page
    Then I can see input field to create book
    And I input book name
    And I select author
    And I input summary
    And I input ISBN
    And I check genre as fiction
    When I press submit
    Then I can see book is saved
