package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class OpcaoEscondidaTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida() {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Iniciando...");
        menu.scrool(0.9, 0.1);

        menu.clicarPorTexto("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());

        menu.clicarPorTexto("OK");
    }
}
