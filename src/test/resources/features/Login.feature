@Login

  Feature: Login Scenarios

    Scenario Outline: Login with different usernames

      Given user logs in to application with user "<UserName>"
      Then  user verifies login "<Expected>"

      Examples:
      | UserName        | Expected |
      | standard_user   | SUCCESS  |
      | locked_out_user | ERROR    |
