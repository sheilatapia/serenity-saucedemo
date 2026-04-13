package com.screenplay.project.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CHECKOUT_BUTTON =
            Target.the("botón checkout").located(By.id("checkout"));

    public static final Target CART_ITEM_NAME =
            Target.the("nombre del producto en el carrito")
                  .located(By.className("inventory_item_name"));

    public static final Target CART_BADGE =
            Target.the("badge del carrito").located(By.className("shopping_cart_badge"));
}