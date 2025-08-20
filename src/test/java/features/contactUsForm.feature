@contactUs
  Feature: Contact Us Form

  Background:
    Given User navigates to application

    Scenario: Successfully Filling Out Contact Us Form
      Given User navigates to contact us form page
      Given User inputs personal details and a message
      And User uploads file
      Then User submits form
      And User returns home