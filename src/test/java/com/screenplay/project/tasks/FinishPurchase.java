package com.screenplay.project.tasks;

import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class FinishPurchase implements Task {

    public static FinishPurchase order() {
        return new FinishPurchase();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}