Feature: Exercise 2

#  Scenario Outline: User Table Page test
  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I login as a user Roman Iovlev
    When I click on Service button in header
    And I click on 'User Table' in Service dropdown
#    Then 'User Table' page should be opened
#    And 6 Number Type Dropdown should be displayed on Users Table on User Table Page
#    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
#    And 6 Description texts under images should be displayed on Users Table on User Table Page
#    And 6 checkboxes should be displayed on Users Table on User Table Page
#    And User table should contain following values
#
#    Examples:
#    |Number  |User              |Description                      |
#    |1       |Roman             |Wolverine                        |
#    |2       |Sergey Ivan       |Spider Man                       |
#    |3       |Vladzimir         |Punisher                         |
#    |4       |Helen Bennet      |Captain America some description |
#    |5       |Yoshi Tannamuri   |Cyclope some description         |
#    |6       |Giovanni Rovelli  |Hulksome description             |
#
#    And droplist should contain values in column Type for user Roman
#    Examples:
#    |Dropdown values|
#    |Admin          |
#    |User           |
#    |Manager        |