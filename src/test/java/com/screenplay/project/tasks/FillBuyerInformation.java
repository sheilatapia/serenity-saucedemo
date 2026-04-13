package com.screenplay.project.tasks;

import com.screenplay.project.models.BuyerData;
import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class FillBuyerInformation implements Task {

    private final BuyerData buyerData;

    public FillBuyerInformation(BuyerData buyerData) {
        this.buyerData = buyerData;
    }

    public static FillBuyerInformation with(BuyerData buyerData) {
        return new FillBuyerInformation(buyerData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(buyerData.getFirstName()).into(CheckoutPage.FIRST_NAME_INPUT),
                Enter.theValue(buyerData.getLastName()).into(CheckoutPage.LAST_NAME_INPUT),
                Enter.theValue(buyerData.getPostalCode()).into(CheckoutPage.POSTAL_CODE_INPUT),
                Scroll.to(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}