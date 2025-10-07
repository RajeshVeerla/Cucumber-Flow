Feature: Login and Add to Cart

  Scenario: Successful login and add product to cart
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be redirected to the homepage
    And the user adds the product to the cart
    And the cart should show the product