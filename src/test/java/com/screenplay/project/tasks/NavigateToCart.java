package com.screenplay.project.tasks;

import com.screenplay.project.userinterface.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class NavigateToCart implements Task {

    public static NavigateToCart page() {
        return new NavigateToCart();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.CART_ICON)
        );
    }
}