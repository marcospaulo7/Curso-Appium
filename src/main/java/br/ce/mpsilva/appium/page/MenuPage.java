package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {


    public void acessarFormulario() {
        clicarPorTexto("Formulário");
        System.out.println("Acessou o formulário");

    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
        System.out.println("Acessou o Splash");

    }

    public void acessarAlertas() {
        clicarPorTexto("Alertas");
        System.out.println("Acessou o Alertas");

    }

    public void acessarAbas() {
        clicarPorTexto("Abas");
        System.out.println("Acessou o Abas");

    }

    public void acessarAccordion() {
        clicarPorTexto("Accordion");
        System.out.println("Acessou o Accordion");

    }

    public void acessarCliques() {
        clicarPorTexto("Cliques");
        System.out.println("Acessou o Cliques");

    }

    public void acessarSwipe() {
        clicarPorTexto("Swipe");
        System.out.println("Acessou o Swipe");

    }

    public void acessarSBHibrido() {
        clicarPorTexto("SeuBarriga Híbrido")  ;
        System.out.println("Acessou o SeuBarriga Híbrido");

    }
    public void acessarSBNativo() {
        clicarPorTexto("SeuBarriga Nativo")  ;
        System.out.println("Acessou o SeuBarriga Nativo");

    }

    public void acessarSwipeList() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scroolDown();

        clicarPorTexto("Swipe List");
        System.out.println("Acessou o Swipe List");

    }

    public void acessarDradNDrop() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scroolDown();

        clicarPorTexto("Drag and drop");
        System.out.println("Acessou o Drag and drop");

    }
}
