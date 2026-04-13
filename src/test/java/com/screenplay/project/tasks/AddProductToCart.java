package com.screenplay.project.tasks;

import com.screenplay.project.userinterface.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductToCart implements Task {

    private final String productName;

    public AddProductToCart(String productName) {
        this.productName = productName;
    }

    public static AddProductToCart named(String productName) {
        return new AddProductToCart(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.ADD_TO_CART_BUTTON_FOR.of(productName))
        );
    }
}