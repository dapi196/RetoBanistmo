package com.banistmo.reto.Tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

import java.util.Optional;


public class FromtheDropList implements Interaction {
    private String value;
    private Target target;

    public FromtheDropList(String value, Target target) {
        super();
        this.value = value;
        this.target = target;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        Optional<WebElementFacade> itemOptional = target.resolveAllFor(actor).stream().filter(
                item -> item.getText().toLowerCase().contains(value.toLowerCase())
        ).findFirst();

        WebElementFacade itemEncontrado = itemOptional.orElseThrow(()-> new RuntimeException(""));
        	itemEncontrado.click();
        

    }

    public static Performable selectTheItem(String value, Target target) {
        return instrumented(FromtheDropList.class, value, target);
    }
    public static Performable selectTheItem(String value, Target target,Boolean isButton) {
        return instrumented(FromtheDropList.class, value, target,isButton);
    }

}