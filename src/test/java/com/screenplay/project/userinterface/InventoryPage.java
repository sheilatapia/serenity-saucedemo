package com.screenplay.project.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    public static final Target ADD_TO_CART_BUTTON_FOR =
            Target.the("botón agregar al carrito para '{0}'")
                  .locatedBy("//button[@id='add-to-cart-sauce-labs-backpack']");

    public static final Target CART_ICON =
            Target.the("ícono del carrito").located(By.className("shopping_cart_link"));

    public static final Target CART_BADGE =
            Target.the("badge del carrito").located(By.className("shopping_cart_badge"));
}