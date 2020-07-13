package com.banistmo.reto.interactions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ClickCon extends PageObject implements Interaction {
    private Target target;
    private WebElementFacade elemento;

    public ClickCon(Target target) {
        this.target = target;
    }

    public ClickCon(WebElementFacade elemento) {
        this.elemento = elemento;
    }

    public static Performable Js(Target target) {
        return instrumented(ClickCon.class, target);
    }

    public static Performable Js(WebElementFacade elemento) {
        return instrumented(ClickCon.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (target != null) {
            try {
                actor.attemptsTo(WaitUntil.the(target, isPresent()));
            } catch (Exception e) {
                System.out.println("Error en el wait ");
            }
            elemento = target.resolveAllFor(actor).get(0);
        }

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("arguments[0].click();",
                elemento);
    }
}
