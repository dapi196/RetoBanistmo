
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background: ejecucion de la aplicacion
    Given el usuario ingresa a la pagina web
  @tag1
  Scenario Outline: Ingresar al Link y Verificar Pdf
    Given quiero ingresar al link <link>
    When selecciono el pdf a abrir <pdf>  
    Then verifica que se abre el pdf 

    Examples: 
      | link      | pdf                               |
      | Tarifario |   Tarifas de Cuentas de Depósitos | 
      

      
