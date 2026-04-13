package com.screenplay.project.tasks;

import com.screenplay.project.models.BuyerData;
import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
                Enter.theValue(buyerData.getPostalCode()).into(CheckoutPage.POSTAL_CODE_INPUT)
        );

        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        WebElement continueBtn = Serenity.getDriver().findElement(By.id("continue"));
        ((JavascriptExecutor) Serenity.getDriver()).executeScript("arguments[0].click();", continueBtn);

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
    }
}