@CheckOutSauceDemo

  Feature: checkout
    as a user I want to checkout one product successfully

  Scenario: user already succesfully login and add two item then remove one item and do checkout

    Given User open the app sauce demo
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then User already on dashboard page
    When User sort product by "Price (low to high)"
    And User add to click button add to cart item "Sauce Labs Onesie"
    And User add to click button add to cart item "Sauce Labs Bike Light"
    And User click icon badge to cart for checkout
    Then User will redirected to page checkout list
    And User click remove one item "Sauce Labs Bike Light"
    And User click button checkout
    Then User will redirected to information buyer page
    And User input "Widi" as FirstName and "Pamungkas" as LastName and "46156" as zipCode
    Then User click button continue
    And User will redirected to checkout overview page
    Then User Validate total value
    Then User click finish button
    And User will redirected to checkout complete page