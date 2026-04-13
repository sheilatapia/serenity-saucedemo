package com.screenplay.project.stepdefinitions;
import com.screenplay.project.userinterface.CheckoutPage;

import com.screenplay.project.models.BuyerData;
import com.screenplay.project.questions.CartIsEmpty;
import com.screenplay.project.questions.OrderConfirmationIsDisplayed;
import com.screenplay.project.questions.ProductInSummary;
import com.screenplay.project.tasks.*;
import com.screenplay.project.userinterface.CheckoutPage;
import com.screenplay.project.userinterface.CheckoutPage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CompraStepDefinitions {

    private Actor actor;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");
    }

    @Given("que el usuario inicia sesión con credenciales válidas")
    public void elUsuarioIniciaSession() {
        actor.attemptsTo(
                Login.withCredentials("standard_user", "secret_sauce")
        );
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String productName) {
        actor.attemptsTo(
                AddProductToCart.named(productName)
        );
    }

    @And("navega al carrito")
    public void navegaAlCarrito() {
        actor.attemptsTo(
                NavigateToCart.page()
        );
    }

    @And("inicia el proceso de checkout")
    public void iniciaElProcesoDeCheckout() {
        actor.attemptsTo(
                StartCheckout.process()
        );
    }

    @And("completa los datos del comprador:")
    public void completaLosDatosDelComprador(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        Map<String, String> data = rows.get(0);

        BuyerData buyerData = BuyerData.builder()
                .firstName(data.get("firstName"))
                .lastName(data.get("lastName"))
                .postalCode(data.get("postalCode"))
                .build();

        actor.attemptsTo(
                FillBuyerInformation.with(buyerData)
        );
    }

    @Then("visualiza el resumen de compra con el producto {string}")
    public void visualizaElResumenDeCompra(String productName) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FINISH_BUTTON, isVisible()).forNoMoreThan(15).seconds()
        );
        actor.should(
                seeThat(ProductInSummary.name(), equalTo(productName))
        );
    }

    @When("finaliza la compra")
    public void finalizaLaCompra() {
        actor.attemptsTo(
                FinishPurchase.order()
        );
    }

    @Then("ve el mensaje de confirmación de orden")
    public void veElMensajeDeConfirmacion() {
        actor.should(
                seeThat(OrderConfirmationIsDisplayed.onScreen(), is(true))
        );
    }

    @Then("el carrito queda vacío")
    public void elCarritoQuedaVacio() {
        actor.should(
                seeThat(CartIsEmpty.now(), is(true))
        );
    }
}