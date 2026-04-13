package com.screenplay.project.questions;

import com.screenplay.project.userinterface.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartIsEmpty implements Question<Boolean> {

    public static CartIsEmpty now() {
        return new CartIsEmpty();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // El badge del carrito desaparece cuando no hay productos
        return !CartPage.CART_BADGE.resolveFor(actor).isVisible();
    }
}