package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.MenuPage;
import br.ce.mpsilva.appium.page.seuBarriga.SBNContasPage;
import br.ce.mpsilva.appium.page.seuBarriga.SBNLoginPage;
import br.ce.mpsilva.appium.page.seuBarriga.SBNMenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBNtest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBNLoginPage login = new SBNLoginPage();
    private SBNMenuPage menu2 = new SBNMenuPage();
    private SBNContasPage conta = new SBNContasPage();

    @Before
    public void setup() {
        menu.acessarSBNativo();
        login.setEmail("zz@zz");
        login.setSenha("1234");
        login.entrar();
    }

    @Test
    public void deveInserirContas() {
        menu2.acessarContas();
        conta.inserirConta("Conta 1234");
        Assert.assertTrue(conta.existeElementoPorTexto("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirConta() {
        menu2.acessarContas();
        conta.selecionarConta("testando");
        esperar(1000);
        conta.clicarSalvarExcluir("EXCLUIR");
        Assert.assertTrue(conta.existeElementoPorTexto("Conta excluída com sucesso"));

    }
}
