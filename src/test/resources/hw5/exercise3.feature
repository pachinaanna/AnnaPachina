Feature:

  Scenario:
    Given I open JDI GitHub site
    And I login as a user 'Roman Iovlev'
    And I click on 'Service' button in header
    And I click on 'User Table' in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has "Vip: condition changed to true" text in log section