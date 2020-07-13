package com.banistmo.reto.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaTarifario extends PageObject {

	public static final Target LISTA_NOMRES_PRODUCTOS_COMPRADOS = Target
			.the("campo CON EL NOMBRE DE LOS PRODUCTOS EN EL CARRO ").locatedBy("td");

}
