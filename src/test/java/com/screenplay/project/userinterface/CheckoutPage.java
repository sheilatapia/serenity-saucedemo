package com.screenplay.project.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    // Step One - Información del comprador
    public static final Target FIRST_NAME_INPUT =
            Target.the("campo nombre").located(By.id("first-name"));

    public static final Target LAST_NAME_INPUT =
            Target.the("campo apellido").located(By.id("last-name"));

    public static final Target POSTAL_CODE_INPUT =
            Target.the("campo código postal").located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON =
            Target.the("botón continuar").located(By.id("continue"));

    // Step Two - Resumen de la orden
    public static final Target ITEM_NAME_IN_SUMMARY =
            Target.the("nombre del producto en el resumen")
                .located(By.cssSelector("[data-test='inventory-item-name']"));

    public static final Target FINISH_BUTTON =
            Target.the("botón finalizar compra").located(By.id("finish"));

    // Confirmation
    public static final Target CONFIRMATION_HEADER =
            Target.the("encabezado de confirmación")
                  .located(By.xpath("//h2[contains(@class,'complete-header')]"));
}