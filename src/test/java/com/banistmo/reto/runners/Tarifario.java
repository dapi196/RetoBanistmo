package com.banistmo.reto.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ingresar_link.feature",
        glue = {"com/banistmo/reto/stepdefinitions"},
        snippets = SnippetType.CAMELCASE,
        plugin = {"rerun:target/rerun.txt"}
)
public class Tarifario {
}
