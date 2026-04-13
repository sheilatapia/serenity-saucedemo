package com.screenplay.project.tasks;

import com.screenplay.project.userinterface.CartPage;
import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class StartCheckout implements Task {

    public static StartCheckout process() {
        return new StartCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),
                WaitUntil.the(CheckoutPage.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}