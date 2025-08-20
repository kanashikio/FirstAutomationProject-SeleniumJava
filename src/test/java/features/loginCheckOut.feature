@loginCheckOut
  Feature: Login before Checkout
  
  Background: 
    Given User navigates to application
  
  Scenario: Test Case 16: Login before Checkout
    Given User navigates to login
    Given User enters details username and email
    And User enters password and other details
    And User enters personal information
    And User enters address information
    And User enters mobile number
    Then User creates account
    When User is logged in
    Then User logs out and logs in again
    And User adds products to cart
    Then User proceeds to checkout
    And User places order and leaves a comment
    Then User proceeds to payment
    Then User deletes account