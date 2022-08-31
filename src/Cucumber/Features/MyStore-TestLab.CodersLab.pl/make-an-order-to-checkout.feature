Feature: Make an order and proceed to checkout

  Scenario: Registered user with at least one added address  makes an order and proceed to checkout

    Given User opened browser with "https://mystore-testlab.coderslab.pl"
    When User clicks a button 'Sign in'
    And User enters correct login data
    And User clicks a light blue 'SIGN IN' button
    And User goes to HomePage by clicking 'My Store' logo
    And User chooses product "Hummingbird printed sweater"
    And User selects size "M"
    And User sets quantity to 5
    And User adds products to cart
    And User clicks 'Proceed to checkout'
    And User presses another 'Proceed to checkout' button
    And User confirms address
    And User chooses product delivery option 'PrestaShop - pick up in store'
    And User confirms delivery method
    And User selects 'Pay by Check' payment option
    And User agrees terms of service and clicks 'Order with an obligation to pay'
    And User takes screenshot of order confirmation
