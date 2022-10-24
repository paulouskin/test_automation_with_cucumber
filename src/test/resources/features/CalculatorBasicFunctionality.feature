Feature: Verify basic calculator operations

  As a John from 5th grade
  I want to verify if calculator basic functions - add, subtract, divide, multiply - works correctly
  So that I can feel confident on my math classes

  #This is our comment
  Scenario: John should be able to add 2 numbers
    * John has a calculator
    * he add 2 and 5
    * result will be 7

  Scenario: John should be able to subtract 2 numbers
    Given John has a calculator
    When he subtract 8 from 12
    Then result will be 4

  Scenario: John should be able to multiply 2 numbers
    Given John has a calculator
    When he multiply 4 by 5
    Then result will be 20

  Scenario: John should be able to divide 2 numbers
    Given John has a calculator
    When he divide 20 by 5
    Then result will be 4

