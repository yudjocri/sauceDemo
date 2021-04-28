@Checkout

  Feature: Successfully checkout items from cart

    Scenario Outline: Checkout items from cart

      Given user logs in to application with user "<UserName>"
      When  user adds to cart selected items
        | ItemName              |
        | Sauce Labs Backpack   |
        | Sauce Labs Bike Light |
      And   user checks out items from cart with details "<FirstName>", "<LastName>", "<PostalCode>"
      Then  user verifies item total and total value
      And   user successfully finish check out

      Examples:
      | UserName      | FirstName | LastName  | PostalCode |
      | standard_user | VERO      | CASSANOVA | 19044      |
