package com.screenplay.project.utils;

public class EnvironmentReader {

    private static final String DEFAULT_USERNAME = "standard_user";
    private static final String DEFAULT_PASSWORD = "secret_sauce";

    public static String getUsername() {
        return System.getProperty("app.username", DEFAULT_USERNAME);
    }

    public static String getPassword() {
        return System.getProperty("app.password", DEFAULT_PASSWORD);
    }
}