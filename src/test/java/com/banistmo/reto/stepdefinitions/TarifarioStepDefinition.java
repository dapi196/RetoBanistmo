package com.banistmo.reto.stepdefinitions;


import com.banistmo.reto.Tasks.FromtheDropList;
import com.banistmo.reto.Tasks.Navegar;
import com.banistmo.reto.interactions.ClickCon;
import com.banistmo.reto.userinterface.OpcionPagina;
import com.banistmo.reto.userinterface.PaginaPrincipal;
import com.banistmo.reto.userinterface.PaginaTarifario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.openqa.selenium.WebDriver;


public class TarifarioStepDefinition {
	
	@Managed(uniqueSession = true)
    private WebDriver driver;

        @Given("^el usuario ingresa a la pagina web$")
        public void elUsuarioIngresaALaPaginaWeb() {
        	OnStage.setTheStage(new OnlineCast());

            OnStage.aNewActor().can(BrowseTheWeb.with(driver));
        	theActorInTheSpotlight().wasAbleTo(Navegar.en(OpcionPagina.WEB));
        }


        @Given("^quiero ingresar al link (.*)$")
        public void quieroIngresarAlLinkTarifario(String opcion) {
        	theActorInTheSpotlight().attemptsTo(FromtheDropList.selectTheItem(opcion, PaginaPrincipal.LISTA_LINKS_FOOTER));
        }

        @When("^selecciono el pdf a abrir (.*)$")
        public void seleccionoElPdfAAbrir(String Opcion) throws InterruptedException {
        	Thread.sleep(2000);
        	theActorInTheSpotlight().attemptsTo(ClickCon.Js(PaginaTarifario.LISTA_PDF));
        	Thread.sleep(2000);
        }

        @Then("^verifica que se abre el pdf$")
        public void verificaQueSeAbreElPdf() {
           System.out.println("numero de ventanas "+driver.getWindowHandles().size());
        }

      
        
        
    }
