Feature: Login

  Scenario: Successful login with valid credentials
    Given User open URL
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser


  Scenario Outline: Login Data Driven
    Given User open URL
    And User enter Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

    Examples:
    | email | password |
    | admin@yourstore.com  | admin    |
    | admin2@yourstore.com | admin123 |