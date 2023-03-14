package com.sofkau.stepdefinitions;

import com.sofkau.models.Empleado;
import com.sofkau.pages.TablePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Logger;

public class TableStepDefinition extends WebUI {


    private Empleado empleado;
    private TablePage tablePage;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(TableStepDefinition.class));


    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetup();
        LOGGER.info("inicio de la automatizacion");
    }

    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        TablePage tablePage = new TablePage(super.driver, empleado);
        tablePage.clickInicio();
    }

    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String email, String salario, String departamento) {
        System.out.println(nombre);
    }

    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() {

    }

}
