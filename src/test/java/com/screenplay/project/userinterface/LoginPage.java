package com.screenplay.project.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final String URL = "https://www.saucedemo.com/";

    public static final Target USERNAME_INPUT =
            Target.the("campo usuario").located(By.id("user-name"));

    public static final Target PASSWORD_INPUT =
            Target.the("campo contraseña").located(By.id("password"));

    public static final Target LOGIN_BUTTON =
            Target.the("botón ingresar").located(By.id("login-button"));
}