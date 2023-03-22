package com.sofkau.pages;

import com.sofkau.models.Empleado;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends CommonActionOnPages {


    /**
     * Localizadores
     */

    @CacheLookup
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[2]")
    private WebElement form;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[1]")
    private WebElement practiceForm;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Web Tables']")
    private WebElement webTabla;

    /**
     * localizadores con id
     */
    @CacheLookup
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement botonAdd;


    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement userEmail;


    @CacheLookup
    @FindBy(id = "age")
    private WebElement age;


    @CacheLookup
    @FindBy(id = "salary")
    private WebElement salary;

    @CacheLookup
    @FindBy(id = "department")
    private WebElement department;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement botonSutmit;

    @CacheLookup
    @FindBy(xpath = "(//div[@role='row'])[5]")
    private WebElement fila5;

    private By celdas = By.xpath(".//div[@role='gridcell']");

    public static List<String> datosRegistrados = new ArrayList<>();
    public static List<String> datosTabla = new ArrayList<>();

    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void clickInicio() throws InterruptedException {
        click(form);
        Thread.sleep(2000);
        click(practiceForm);
        Thread.sleep(2000);
        click(webTabla);

    }


    public void insertDatos(String nombre, String apellido, String edad, String correo, String salario, String departamento) throws InterruptedException {
        datosRegistrados.clear();
        datosTabla.clear();
        click(botonAdd);
        clearText(firstName);
        typeInto(firstName, nombre);

        clearText(lastName);
        typeInto(lastName, apellido);

        clearText(age);
        typeInto(age, edad);

        clearText(userEmail);
        typeInto(userEmail, correo);


        clearText(salary);
        typeInto(salary, salario);

        clearText(department);
        typeInto(department, departamento);
        click(botonSutmit);

        //ingresar los datos
        datosRegistrados.add(nombre);
        datosRegistrados.add(apellido);
        datosRegistrados.add(edad);
        datosRegistrados.add(correo);
        datosRegistrados.add(salario);
        datosRegistrados.add(departamento);


        //verificar los datos
        datosTabla.add(getText(By.xpath("//div/descendant::*[338]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[339]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[340]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[341]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[342]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[343]")));


    }


    public void datosTabla() {
        datosTabla.add(getText(By.xpath("//div/descendant::*[338]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[339]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[340]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[341]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[342]")));
        datosTabla.add(getText(By.xpath("//div/descendant::*[343]")));
    }


}
