Feature: Compra exitosa de un producto
  Como usuario de SauceDemo
  Quiero comprar un producto desde el inventario
  Para completar una orden exitosamente

  Background:
    Given que el usuario inicia sesión con credenciales válidas

  @compra_exitosa @e2e @smoke
  Scenario: Finalizar una compra con 1 producto
    When agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito
    And inicia el proceso de checkout
    And completa los datos del comprador:
      | firstName | lastName | postalCode |
      | Sheila    | Tapia    | 051      |
    Then visualiza el resumen de compra con el producto "Sauce Labs Backpack"
    When finaliza la compra
    Then ve el mensaje de confirmación de orden
    And el carrito queda vacío