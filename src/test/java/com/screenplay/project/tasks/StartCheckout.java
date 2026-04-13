package com.screenplay.project.tasks;

import com.screenplay.project.userinterface.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class StartCheckout implements Task {

    public static StartCheckout process() {
        return new StartCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }
}