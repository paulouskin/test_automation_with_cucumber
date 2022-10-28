@on-hold
@to_implement
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

  Scenario: Search result filtering should be available
    #Verify filter menu presence

  Scenario: Search result sorting should be available
    #Verify sorting menu presence

  Scenario: Search result page item have price
    #Verify item price element presence

  Scenario: Search result page item have rating
    #Verify rating element presence

  Scenario: Search result have the seller name/title
    #Verify seller name element text presence and log 1st item in a list seller name/title

  Scenario: Search result page item has short description
    #Verify short description presence and log it

  Scenario: Search result page item has preview image
    #Verify item image preview element presence and it's source link

  Scenario: Search result page item can be added to favourites
    #Verify add to favorite button presence after hover over an item