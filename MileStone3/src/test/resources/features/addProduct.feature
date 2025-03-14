Feature: Add product to cart and proceed to checkout

  Scenario: Add product and navigate to checkout
    Given User is logged in
    When User navigates to Computer and then Desktop section
    And User selects the second desktop
    And User selects RAM and HDD options and adds to cart
    And User proceeds to shopping cart and agrees to terms
    Then User should be on the checkout page
