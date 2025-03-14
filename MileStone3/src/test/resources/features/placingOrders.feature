Feature: Complete Order

  Scenario: Complete checkout and confirm order
    Given User is on the checkout page
    When User completes checkout with Cash on Delivery
    Then Order confirmation should display "order has been placed successfully"
    And User logs out successfully

