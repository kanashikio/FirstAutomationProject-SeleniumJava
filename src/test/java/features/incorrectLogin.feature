@incorrectLogin
  Feature: Incorrect Login Credentials

  Background:
    Given User navigates to application

  Scenario: Failed Login due to Invalid Credentials
    Given User navigates to login
    When User enters invalid credentials
    Then User gets error message
