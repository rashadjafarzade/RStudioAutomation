@regression
Feature: User validations for Login functionality

  Background:
    Given user navigates to RStudio Cloud Login Page

  @Login
  Scenario Outline: Login validations for positive and negative scenarios
    When user enters "<usernameData>" username and "<passwordData>" password
    Then user clicks on login button
    And user should verify "<errorMessageData>" error message when switch is "<Switch>"
    And user should be successfully land on RStudio Cloud User Account Dashboard when switch is "<Switch>"
    Examples:
      |usernameData                 |passwordData    |errorMessageData                                                           | Switch |
      | invalidUsername@email.com   | invalidPassword|Login failed - please verify that your email and password are correct.     | on     |
      | jafarzaderashad@gmail.com   | Rstudio22@!    |                                                                           | off    |

