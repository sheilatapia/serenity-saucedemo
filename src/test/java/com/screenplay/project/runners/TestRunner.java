package com.screenplay.project.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(
                key = Constants.GLUE_PROPERTY_NAME,
                value = "com.screenplay.project.stepdefinitions"
        ),
        @ConfigurationParameter(
                key = Constants.PLUGIN_PROPERTY_NAME,
                value = "pretty, json:target/cucumber-reports/cucumber.json, io.cucumber.core.plugin.SerenityReporterParallel"
        ),
        @ConfigurationParameter(
                key = Constants.FILTER_TAGS_PROPERTY_NAME,
                value = "@compra_exitosa"
        )
})
public class TestRunner {
}