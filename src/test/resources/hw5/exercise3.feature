Feature: Exercise 3

  Scenario:
    Given I open JDI GitHub site
    And I login as a user 'Roman Iovlev'
    And I click on 'SERVICE' button in header
    And I click on 'USER TABLE' in Service dropdown
    When I select 'Vip' checkbox for 'Sergey Ivan'
    Then 1 log row has "Vip: condition changed to true" text in log section