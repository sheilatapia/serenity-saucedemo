package com.screenplay.project.questions;

import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductInSummary implements Question<String> {

    public static ProductInSummary name() {
        return new ProductInSummary();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutPage.ITEM_NAME_IN_SUMMARY
                .resolveFor(actor)
                .waitUntilVisible()
                .getText();
    }
}