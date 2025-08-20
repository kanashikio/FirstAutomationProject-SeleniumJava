@signup
Feature: Signup Feature

Background:
  Given User navigates to application

  Scenario: Successful User Registration
    Given User navigates to login
    Given User enters details username and email
    And User enters password and other details
    And User enters personal information
    And User enters address information
    And User enters mobile number
    Then User creates account
    When User is logged in
    Then User deletes account



