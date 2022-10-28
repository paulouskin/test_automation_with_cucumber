@ui
Feature: Verify basic searching functionality scenario outline

  Scenario Outline: Successful search with properly formatted query
    Given "Jack The Occasional Shopper" is on the Etsy landing page
    And he accept default privacy policy
    When he search for "<query>"
    Then the "<result>" result page have been displayed
    Examples:
      | query                                                  | result  |
      | leather bag                                            | success |
      | jkflsdfhs;'gsdghjdf;'89dg;                             | error   |
      | very very long query which is required to be processed | error   |
      | $#@%#$%5345345gdsgdfgdfgdfetrrtert                     | error   |
