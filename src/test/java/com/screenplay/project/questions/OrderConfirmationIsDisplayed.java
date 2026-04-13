package com.screenplay.project.questions;

import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrderConfirmationIsDisplayed implements Question<Boolean> {

    public static OrderConfirmationIsDisplayed onScreen() {
        return new OrderConfirmationIsDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CheckoutPage.CONFIRMATION_HEADER.resolveFor(actor).isVisible();
    }
}