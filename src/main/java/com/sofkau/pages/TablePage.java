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

    private final Empleado empleado;


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

    //button[@id='submit']

    public TablePage(WebDriver driver, Empleado empleado) {
        super(driver);
        this.empleado = empleado;
        PageFactory.initElements(driver, this);

    }

    public void clickInicio() throws InterruptedException {
        click(form);
        Thread.sleep(2000);
        click(practiceForm);
        Thread.sleep(2000);
        click(webTabla);

    }


    public void insertDatos() throws InterruptedException {
        click(botonAdd);
        clearText(firstName);
        typeInto(firstName, empleado.getNombre());

        clearText(lastName);
        typeInto(lastName, empleado.getApellido());

        clearText(userEmail);
        typeInto(userEmail, empleado.getEmail());

        clearText(age);
        typeInto(age, empleado.getEdad());

        clearText(salary);
        typeInto(salary, empleado.getSalario());

        clearText(department);
        typeInto(department, empleado.getDepartamento());

        click(botonSutmit);
        click(botonSutmit);

    }


    public List<String> estaRegistrado() {
        List<String> resultado = new ArrayList<>();
        resultado.add(getText((By) firstName).trim());
        resultado.add(getText((By) lastName).trim());
        resultado.add(getText((By) userEmail).trim());

        return resultado;
    }


}
