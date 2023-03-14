package com.sofkau.pages;

import com.sofkau.models.Empleado;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


}
