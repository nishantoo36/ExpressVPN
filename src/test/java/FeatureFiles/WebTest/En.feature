Feature: En

  Background:
    Given User open order page with "en" Language

  Scenario: Verify the planDetails
    Then User should see "12 Months" plan selected
    And User should see list of plan
    And User should see details of "1 Month" plan
    And User should see details of "6 Months" plan
    And User should see details of "12 Months" plan

  Scenario: Verify the selection of plan
    When user select "1 Month" plan
    Then User should see "1 Month" plan selected
    And User should able to see plan best Suggestion dialog
    When user select "6 Month" plan
    Then User should see "6 Months" plan selected
    And User should able to see plan best Suggestion dialog
    When user select "12 Months" plan
    Then User should see "12 Months" plan selected
    And User should not able to see plan best Suggestion dialog

  Scenario: Verify no fill Validation message for Credit card
    When User scroll down the page to "Credit Card" payment type
    When User select "Credit Card" payment type
    Then it should open credit card detail fill up form
    When User click on "Join Now" button
    Then User should able to see no fill error for email
    And User should able to see no fill error for credit card form all details

  Scenario: Verify no fill Validation message for PayPal
    When User scroll down the page to "PayPal" payment type
    When User select "PayPal" payment type
    Then User should able to see "Continue to PayPal" button
    When User click on "Continue to PayPal" button
    Then User should able to see no fill error for email

  Scenario: Verify no fill Validation message for Bitcoin
    When User scroll down the page to "Bitcoin" payment type
    When User select "Bitcoin" payment type
    Then User should able to see "Continue to BitPay" button
    When User click on "Continue to BitPay" button
    Then User should able to see no fill error for email

  Scenario: Verify no fill Validation message for Other
    When User scroll down the page to "Other" payment type
    When User select "Other" payment type
    Then User should able to see "Continue to Paymentwall" button
    When User click on "Continue to Paymentwall" button
    Then User should able to see no fill error for email

  Scenario: Verify Validation message for invalid values
    When User enter email address as "test"
    Then User should able to error for invalid email address
    When User scroll down the page to "Credit Card" payment type
    When User select "Credit Card" payment type
    When User enter credit card number as "12"
    When User enter cvv as "12"
    Then User should able to error for invalid card number
    And User should able to error for invalid cvv












