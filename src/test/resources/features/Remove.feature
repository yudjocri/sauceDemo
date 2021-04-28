@Remove

  Feature: Successfully remove selected items

    Scenario Outline: Remove selected items

      Given user logs in to application with user "<UserName>"
      When  user adds to cart selected items
        | ItemName                 |
        | Sauce Labs Backpack      |
        | Sauce Labs Bike Light    |
        | Sauce Labs Bolt T-Shirt  |
        | Sauce Labs Fleece Jacket |
      And   user removes selected items from product page
        | ItemName                 |
        | Sauce Labs Fleece Jacket |
      And   user removes selected items from checkout page
        | ItemName                 |
        | Sauce Labs Backpack      |
      Then  user verifies items removed successfully
        | ItemName                 |
        | Sauce Labs Backpack      |
        | Sauce Labs Fleece Jacket |
      And   user checks out items from cart with details "<FirstName>", "<LastName>", "<PostalCode>"
      Then  user verifies item total and total value
      And   user successfully finish check out

      Examples:
        | UserName      | FirstName | LastName  | PostalCode |
        | standard_user | VERO      | CASSANOVA | 19044      |