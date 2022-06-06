@regression
Feature: User checks account feature functionalities

  Background:
    Given user is already logged in

    @space
    Scenario Outline: User creates Space
      When user clicks New Space tab
      When user enters "<name>" to the Space
      When user clicks Create button
      Then user should land on the "<name>" of new Space
      When user clicks New Project button and selects New RStudio Project
      Then user should land on RStudio IDE page

  Examples:
        | name             |
        | Rashad Jafarzade |



