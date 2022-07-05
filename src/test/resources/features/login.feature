@login
Feature: User should be able to login

  @positive
  Scenario: Positive
    Given I am on the home page
    When I navigate to login page
    Then I verify that I am on the login page
    When I type username and password
    And I click login button
    Then I verify I logged in

  @negativeUsername
  Scenario Outline: User should not be able to login with incorrect username
    Given I am on the home page
    When I navigate to login page
    Then I verify that I am on the login page
    When I type "<username>" and "<password>"
    And I click login button
    Then I verify that I am on the login page
    And I see the error message for username
    Examples:
      | username        | password             |
      |                 | SuperSecretPassword! |
      | invalidUsername |                      |
      | invalidUsername | SuperSecretPassword! |
      | >£#$½{[]}       | SuperSecretPassword! |
      |                 |                      |

  @negativePassword
  Scenario Outline: User should not be able to login with incorrect password
    Given I am on the home page
    When I navigate to login page
    Then I verify that I am on the login page
    When I type "<username>" and "<password>"
    And I click login button
    Then I verify that I am on the login page
    And I see the error message for password
    Examples:
      | username | password        |
      | tomsmith |                 |
      | tomsmith | invalidPassword |
      | tomsmith | >£#$½{[]}       |

  @text
  Scenario: verify title and text is correct
    Given I am on the home page
    When I navigate to login page
    Then I verify that I am on the login page
    And I verify title of the text is "Login Page"
    And I verify text is "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages."

  @failed
  Scenario: intentionally failed scenario
    Given I am on the home page
    When I navigate to login page
    Then I verify that I am on the login page
    And I verify title of the text is "Login Page"
    And I verify text is "failed"