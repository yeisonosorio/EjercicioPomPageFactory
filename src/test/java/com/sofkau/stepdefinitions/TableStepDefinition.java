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
import java.util.logging.Logger;

public class TableStepDefinition extends WebUI {


    private Empleado empleado;

    private TablePage tablePage;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(TableStepDefinition.class));

    private static final String ASSERTION_EXCEPTION_MESSAGE = "No son los valores esperados";

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
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String email, String salario, String departamento) throws InterruptedException {
        try {
            tablePage = new TablePage(super.driver, empleado);
            tablePage.insertDatos();
            Assertions.assertEquals(
                    tablePage.estaRegistrado(), elementosRegistrados(),
                    String.format(ASSERTION_EXCEPTION_MESSAGE, resultado()));
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        } finally {
            quiteDriver();
        }

    }


    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() {

    }

    public void llenarDatos() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setApellido("Pérez");
        empleado.setEdad("22");
        empleado.setEmail("juanperez@example.com");
        empleado.setSalario("5000");
        empleado.setDepartamento("Informática");
    }


    public List<String> elementosRegistrados() {
        List<String> botonResultado = new ArrayList<>();
        botonResultado.add(empleado.getNombre().trim() + " " + empleado.getApellido().trim());
        botonResultado.add(empleado.getEmail().trim());
        return botonResultado;

    }

    private String resultado() {
        return "\n" + tablePage.estaRegistrado().toString() + "\n" + elementosRegistrados().toString();
    }

}
