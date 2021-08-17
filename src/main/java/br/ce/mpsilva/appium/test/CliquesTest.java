package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.CliquesPage;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTest extends BaseTest {


    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void inicializarAppium() {
        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo() {

        page.cliqueLongo();

        Assert.assertEquals("Clique Longo", page.obterTextoCampo());
    }

    @Test
    public void deveRelizarCliqueDuplo(){
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");

        Assert.assertEquals("Clique Duplo", page.obterTextoCampo());

    }
}
