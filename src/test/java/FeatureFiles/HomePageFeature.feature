Feature: HomePageFeature

  @TestngScenario
  Scenario: Verify title and element on homepage
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    Then Verify that all elements available on Home screen

  @TestngScenario
  Scenario: Verify that after selecting "no, no" option for "ENbutton" user should be on home page
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on ENButton
    Then Verify that This will end the activity pop-up is open up
    When user click on No no button
    Then Verify page title is "selendroid-test-app"
    Then Verify that all elements available on Home screen

  @TestngScenario
  Scenario: Verify the elements after selecting chrome logo
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on Chrome logo
    Then Verify page title is "selendroid-test-app"
    Then Verify that text "Hello, can you please tell me your name?" is present in text view
    When user enter name as "Nishant Patel"
    When user select car as "Mercedes"
    Then Verify that car in drop down selected as "Mercedes"
    When user select send me your name button
    Then Verify that text "This is my way of saying hello" is present in text view
    Then Verify the entered name as "Nishant Patel"
    Then Verify car name as "mercedes"
    When user click on start again link
    Then Verify that car in drop down selected as "Volvo"

  @TestngScenario
  Scenario Outline: Verify the elements after selecting file logo
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on File logo
    Then Verify page title is "selendroid-test-app"
    Then Verify that text "Welcome to register a new User" is present in text view
    Then Verify that all elements available on registration screen
    Then Verify that "Mr. Burns" is prePopulated in name field
    Then Verify that "Ruby" is selected as programming language by default
    When user select username as "<username>"
    When user select email as "<email>"
    When user select password as "<password>"
    When user select name as "<name>"
    When user select programming language as "<programming language>"
    When user select I accept adds checkbox
    When user click Register user (verify)
    Then Verify that value of name is "<name>"
    Then Verify that value of username is "<username>"
    Then Verify that value of password is "<password>"
    Then Verify that value of email is "<email>"
    Then Verify that value of programming language is "<programming language>"
    Then Verify that bool status of I accepted adds is "true"
    When user click Register use
    Then Verify that all elements available on Home screen

    Examples:
      | username    | password |  | email                     | name          | programming language |
      | Nishanttest | asdf123  |  | pnishant90@mailinator.com | Nishant Patel | Java                 |

  @TestngScenario
  Scenario: Verify the elements after selecting show progress
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on show progress bar
    Then Verify page title is "selendroid-test-app"
    Then Verify that all elements available on registration screen

  @TestngScenario
  Scenario: Verify Toast message
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on Display Toast message
    Then Toast message should appear as "Hello selendroid toast!"

  @TestngScenario
  Scenario: Verify popup test
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on Display Popup Window button
    When user dismiss popup button


  @TestngScenario
  Scenario: Verify that app should not crash when tap on "Press to throw unhandled action exception"
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user click on Press to throw unhandled action exception
    Then Verify page title is "selendroid-test-app"

  @TestngScenario
  Scenario: Verify that app should not crash when tap on "Press to throw unhandled action exception"
    When user launch the app
    Then Verify page title is "selendroid-test-app"
    When user enter "test" in type to throw unhandled exception field
    Then Verify page title is "selendroid-test-app"