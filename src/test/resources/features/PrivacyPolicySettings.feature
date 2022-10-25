@ui
Feature: Verify privacy policy setting option

  As a Jane The Shopper
  I want to configure privacy policy settings
  So that I can setup my further shopping experience

  Background:
    Given "Jane The Shopper" is on the Etsy landing page

  Scenario: Buyer should proceed with shopping with default privacy policy settings
    When she accept default privacy policy
    Then she can proceed with the shopping

  Scenario: Buyer should update default privacy policy settings
    When she goes to the privacy policy settings
    Then different privacy policy update options are available

  Scenario: Initial information for privacy policy settings should be visible
    Then initial privacy policy information is visible

  Scenario: Cookie handling policy details should be available
    Then cookie handling policy details is available

  Scenario: Site customization settings should be available
    When she goes to the privacy policy settings
    Then site customization option is available

  Scenario: Personal advertising settings should be available
    When she goes to the privacy policy settings
    Then personal advertising option is available

  Scenario: Buyer should proceed with shopping after privacy policy update
    When she goes to the privacy policy settings
    And she enables site customization option in privacy policy settings
    And she enables personal advertising option in privacy policy settings
    And she accepts privacy policy updates
    Then she can proceed with the shopping