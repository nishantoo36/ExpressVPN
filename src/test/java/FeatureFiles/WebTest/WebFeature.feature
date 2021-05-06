Feature: ValidationTestForLogin

  Background:
    Given User should be on Home Page

  @WebScenarios
  Scenario: Test Drag and Drop
      When user click on "Dropable" link
      When user do drag and drop

  @WebScenarios
  Scenario: Test Select
    When user click on "Selectable" link
    When user select ["Item 1","Item 3","Item 7"]


  @WebScenarios
  Scenario: Test Control group
    When user click on "Controlgroup" link
    When user switch to iframe
    When user select "SUV" in horizontal car-type selection
    When user select Automatic transmission in horizontal car-type selection
    When user select Insurance checkbox in horizontal car-type selection
    When user enter "1" value in number of car input box
    When user select "Truck" in vertical car-type selection
    When user select Standard transmission in vertical car-type selection
    When user select Insurance checkbox in vertical car-type selection
    When user enter "3" value in number of car vertical box









