Feature: Exercise 1
#  In order to assert browser title
#  As a user
#  I want to open site by url

  Background:
    Given I open JDI GitHub site

  Scenario: opening site test
    Then site should be opened

  Scenario: browser title test
    Then 'Home Page' page should be opened

  Scenario: login test
    When I login as a user Roman Iovlev
    Then user should be logged

  Scenario: assert that user name in the right-top side screen that user is logged
    When I login as a user Roman Iovlev
    Then user name should be equal to 'ROMAN IOVLEV'

  Scenario: go to Different Element Page
    Given I login as a user Roman Iovlev
    When I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    Then 'Different Elements' page should be opened

  Scenario: select checkbox Water and Wind
    Given I login as a user Roman Iovlev
    And I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    When I check checkbox 'Water'
    And I check checkbox 'Wind'
    Then element 'Water' should be checked
    And element 'Wind' should be checked    

  Scenario: select radio button
    Given I login as a user Roman Iovlev
    And I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    When I activate radio button 'Selen'
    Then radio button 'Selen' should be checked

  Scenario: select color in dropdown
    Given I login as a user Roman Iovlev
    And I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    When I select 'Yellow' in dropdown
    Then color 'Yellow' should be selected

  Scenario: assert that for each checkbox there are individual log row and value is corresponded to the status of item
    Given I login as a user Roman Iovlev
    And I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    When I check all checkboxes
    Then log row for checked checkboxes should match the status
    When I uncheck all checkboxes
    Then log row for unchecked checkboxes should match the status

  Scenario: assert that for each radio button there are individual log row and value is corresponded to the status of item
    Given I login as a user Roman Iovlev
    And I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    When I activate every radio button
    Then log row for each radio button should match the status

  Scenario: assert that for each color in dropdown there are individual log row and value is corresponded to the status of item
    Given I login as a user Roman Iovlev
    And I click on Service button in header
    And I click on 'DIFFERENT ELEMENTS' in Service dropdown
    When I select every color in dropdown
    Then log row for each color should match the status