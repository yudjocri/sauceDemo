@Sort

  Feature: Sort Items

    Scenario Outline: Sort scenarios

      Given user logs in to application with user "<UserName>"
      When  user sort items in "<Order>"
      Then  user verifies items sorted in "<Order>"

      Examples:
      | UserName      | Order |
      | standard_user | az    |
      | standard_user | za    |
      | standard_user | hilo  |
      | standard_user | lohi  |
