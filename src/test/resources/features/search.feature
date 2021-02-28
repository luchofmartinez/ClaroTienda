Feature: Search products in Claro Tienda

  Background:
    Given The user enter the web https://tienda.claro.com.ar

    Scenario Outline: The user perform a search
      When The user perform a search <brand>
      Then All product contains the <brand> name
      Examples:
        | brand    |
        | Samsung  |
        | Motorola |
        | LG       |
        | Nokia    |