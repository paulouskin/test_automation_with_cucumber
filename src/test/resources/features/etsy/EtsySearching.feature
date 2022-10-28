@on-hold
Feature: Verify basic searching functionality

  Scenario: Successful search with properly formatted query
    Given "Jack The Occasional Shopper" is on the Etsy landing page
    And he accept default privacy policy
    When he search for "leather bag"
    Then the "success" result page have been displayed

  Scenario: Invalid result for searching of non-existing item
    Given "Jack The Occasional Shopper" is on the Etsy landing page
    And she accept default privacy policy
    When he search for "jkflsdfhs;'gsdghjdf;'89dg;"
    Then the "error" result page have been displayed

  Scenario: Successful search with properly formatted query
    Given "Jack The Occasional Shopper" is on the Etsy landing page
    And he accept default privacy policy
    When he search for "very very long query which is required to be processed"
    Then the "success" result page have been displayed

  Scenario: Invalid result for searching of non-existing item
    Given "Jack The Occasional Shopper" is on the Etsy landing page
    And she accept default privacy policy
    When he search for "$#@%#$%5345345gdsgdfgdfgdfetrrtert"
    Then the "error" result page have been displayed