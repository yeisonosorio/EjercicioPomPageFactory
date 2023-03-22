package com.sofkau.stepdefinitions;

import com.sofkau.models.Empleado;
import com.sofkau.pages.TablePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class TableStepDefinition extends WebUI {


    public static Logger LOGGER = Logger.getLogger(TableStepDefinition.class);

    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetup();
        LOGGER.info("inicio de la automatizacion");
    }

    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        TablePage tablePage = new TablePage(super.driver);
        tablePage.clickInicio();
    }

    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String email, String salario, String departamento) throws InterruptedException {
        TablePage tablePage = new TablePage(super.driver);
        //tiempo muerto
        tablePage.insertDatos(nombre, apellido, edad, email, salario, departamento);
    }

    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() throws InterruptedException {
        try {
            Assertions.assertEquals(TablePage.datosRegistrados, TablePage.datosTabla);
        } catch (Exception e) {
            LOGGER.warn(ASSERTION_EXCEPTION_MESSAGE, e);
        } finally {
            quiteDriver();
        }

    }


}
