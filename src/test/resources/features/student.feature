Feature: To test the crud operations of a Student

  Scenario Outline: Test to verify the saving operation of a student
    Given I have proper connection to DB
    When I make a post request with a student name "<studentName>" and age <age>
    Then I should be able to save the user
    Examples:
    | studentName | age |
    | arun        | 14  |
    | raj         | 42  |
    | kelvin      | 85  |

  Scenario: Test the retrieval of all students present in DB
    Given I have proper connection to DB
    When I make a get request to the students api
    Then I should get atleast one student back as response

  Scenario Outline: Test the student update operation
    Given I have proper connection to DB
    When I make a put request to update a student with id <studentId> ,name "<studentName>" and age <age>
    Then I should be able to update the student successfully
    Examples:
    | studentId | studentName | age |
    | 1         | arun1       | 89  |
    | 2         | raj1        | 74  |

  Scenario Outline: Test the student delete operation
    Given I have proper connection to DB
    When I make a delete request with a id <studentId>
    Then I should be able to delete the student
    Examples:
    | studentId |
    | 1         |
    | 2         |
    | 3         |