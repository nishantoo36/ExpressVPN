Feature: De

  Background:
    Given User open order page with "de" Language

  Scenario: Verify the planDetails
    Then User should see "12 Monate" plan selected
    And User should see list of plan
    And User should see details of "1 Monat" plan
    And User should see details of "6 Monate" plan
    And User should see details of "12 Monate" plan

  Scenario: Verify the selection of plan
    When user select "1 Monat" plan
    Then User should see "1 Monat" plan selected
    And User should able to see plan best Suggestion dialog
    When user select "6 Monate" plan
    Then User should see "6 Monate" plan selected
    And User should able to see plan best Suggestion dialog
    When user select "12 Monate" plan
    Then User should see "12 Monate" plan selected
    And User should not able to see plan best Suggestion dialog

  Scenario: Verify no fill Validation message for Credit card
    When User scroll down the page to "Kreditkarte" payment type
    When User select "Kreditkarte" payment type
    Then it should open credit card detail fill up form
    When User click on "Jetzt anmelden" button
    Then User should able to see no fill error for email
    And User should able to see no fill error for credit card form all details

  Scenario: Verify no fill Validation message for PayPal
    When User scroll down the page to "PayPal" payment type
    When User select "PayPal" payment type
    Then User should able to see "Weiter zu PayPal" button
    When User click on "Weiter zu PayPal" button
    Then User should able to see no fill error for email

  Scenario: Verify no fill Validation message for Bitcoin
    When User scroll down the page to "Bitcoin" payment type
    When User select "Bitcoin" payment type
    Then User should able to see "Weiter zu BitPay" button
    When User click on "Weiter zu BitPay" button
    Then User should able to see no fill error for email

  Scenario: Verify no fill Validation message for Other
    When User scroll down the page to "Oder bezahlen Sie mit" payment type
    When User select "Oder bezahlen Sie mit" payment type
    Then User should able to see "Weiter zu Paymentwall" button
    When User click on "Weiter zu Paymentwall" button
    Then User should able to see no fill error for email

  Scenario: Verify Validation message for invalid values
    When User enter email address as "test"
    Then User should able to error for invalid email address
    When User scroll down the page to "Kreditkarte" payment type
    When User select "Kreditkarte" payment type
    When User enter credit card number as "12"
    When User enter cvv as "12"
    Then User should able to error for invalid card number
    And User should able to error for invalid cvv












