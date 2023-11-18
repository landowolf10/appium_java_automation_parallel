Feature: Successful login
  Scenario: As a valid user, I want to validate that I can log in successfully
    Given user opens the app
    When entering email lando.wolg@gmail.com and password lando1234
    And press login button
    Then verify user successfully logged in