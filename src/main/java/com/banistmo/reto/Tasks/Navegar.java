package com.banistmo.reto.Tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.banistmo.reto.userinterface.OpcionPagina;


public class Navegar implements Task {

    private final OpcionPagina opcionPagina;

    public Navegar(OpcionPagina opcionPagina) {
        this.opcionPagina = opcionPagina;
    }

    @Override
    @Step("{0} navigate to the option #option")
    public <T extends Actor> void performAs(T actor) {
        actor. attemptsTo(
                Open.url(opcionPagina.url())
        );
    }

    public static Performable en(OpcionPagina opcionPagina) {
        return instrumented(Navegar.class, opcionPagina);
    }
}
