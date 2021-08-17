package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.core.GeradorPdfUtils;
import br.ce.mpsilva.appium.page.FormularioPage;
import br.ce.mpsilva.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class FormularioTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();



    @Before
    public void inicializarAppium() {
        menu.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() {
        page.escreverNome("Marcos Paulo");
        Assert.assertEquals("Marcos Paulo", page.obterNome());

    }

    @Test
    public void deveInteragirComCombo() {
        page.selecionarCombo("PS4");
        Assert.assertEquals("PS4", page.obterValorCombo());
    }

    @Test
    public void deveInteragirComCheckSwitch() {

        Assert.assertTrue(page.isSwitchMarcado());
        System.out.println("switch está ativado");
        Assert.assertFalse(page.isCheckMarcado());
        System.out.println("check está ativado");

        page.clicarCheck();
        page.clicarSwitch();

        Assert.assertFalse(page.isSwitchMarcado());
        System.out.println("check está desativado");
        Assert.assertTrue(page.isCheckMarcado());
        System.out.println("switch está desativado");
    }

    @Test
    public void desafioCadastro() {
        page.escreverNome("Marcos Paulo");
        page.clicarCheck();
        page.clicarSwitch();
        page.selecionarCombo("PS4");
        page.salvar();
        System.out.println("SAlVAR CLICOU");

        Assert.assertEquals("Nome: Marcos Paulo", page.obterNomeCadastro());
        Assert.assertEquals("Console: ps4", page.obterConsoleCadastro());
        Assert.assertTrue(page.obterCheckCadastro().endsWith("Marcado"));
        Assert.assertTrue(page.obterSwithCadastro().endsWith("Off"));
    }

    @Test
    public void deveIteragirComDataPick() {
        page.clicarPorTexto("01/08/2000");
        page.clicarPorTexto("02");
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("02/8/2000"));

    }


    @Test
    public void deveAlterarHora() {
        page.clicarPorTexto("06:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");
        Assert.assertTrue(page.existeElementoPorTexto("10:40"));

    }

    @Test
    public void deveInteragirComSeekBar() {
        page.clicarSeekBar(0.65);
    }
}
