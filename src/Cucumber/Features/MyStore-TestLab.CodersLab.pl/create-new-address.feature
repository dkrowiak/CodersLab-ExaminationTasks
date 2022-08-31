Feature: Create new address

  Scenario Outline: registered user with at least one added address can add another new address

    Given an opened browser with "https://mystore-testlab.coderslab.pl"
    When button 'Sign in' is clicked
    And correct login data is entered
    And light blue 'SIGN IN' button is clicked
    And 'Addresses' button is pressed
    And 'Create new address' is clicked
    And 'New address' form is filled with correct "<alias>", "<address>", "<city>", "<zip>", "<country>" and "<phone>"
    And 'SAVE' button is pressed
    Then the entered address has been added


    Examples:
    |alias  |address    |city       |zip    |country        |phone      |
    |Mr.    |Abbey Road |London     |N5V    |United Kingdom |1112223333 |
#    |Ms.    |Baker Road |Manchester |03101  |United Kingdom |4445556666 |