@downloadInvoice
  Feature: Purchase then download invoice

  Background:
    Given User navigates to application

  Scenario: Test Case 24: Download Invoice after Purchase Order
    When User selects products and proceeds to checkout
    Then User is redirected to register or login page
    Given User enters details username and email
    And User enters password and other details
    And User enters personal information
    And User enters address information
    And User enters mobile number
    Then User creates account
    When User is logged in
    Then User logs out and logs in again
    Then User proceeds to checkout
    And User places order and leaves a comment
    Then User proceeds to payment
    Then User downloads invoice
    Then User deletes account


#    And User is required to create an account
#    When User successfully created an acc
#    Then User proceeds to view cart and checks out
#    And User places order and proceeds to payment
#    And User deletes their account