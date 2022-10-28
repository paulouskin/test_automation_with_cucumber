@api
Feature: Basic endpoint work verification for the User service

  As a test automation engineer
  I want to automate basic User service checklist
  So that my developer colleagues can sleep well after code push

  Background: Check if service is up and running
    Given user service is up and running

  Scenario: Service should return list of users
    When we fetch all users from the page 2
    Then user list contains 6 users

  Scenario: Service should return a user
    When we fetch the user with id 7
    Then user has an email address "michael.lawson@reqres.in"

  Scenario: Service should create a user
    When we create new user with the following parameters:
      | name     | job                      |
      | John Doe | Test Automation Engineer |
    Then user id is returned

  Scenario: Service should update user data
    When we update the user with id 10 with following information:
      | name     | job                  |
      | Jane Doe | Test Automation Lead |
    Then user will have new job "Test Automation Lead"

  Scenario: Service should delete user from system
    When we delete the user with id "2"
    Then deleted user email "janet.weaver@reqres.in" have been returned