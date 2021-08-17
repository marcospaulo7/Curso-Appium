package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    @Test
    public void deveRealizarSwipe(){
        menu.acessarSwipe();

        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        menu.swipe(0.9,0.1);

        Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

        menu.clicarPorTexto(">");

        Assert.assertTrue(menu.existeElementoPorTexto("chegou até o fim"));

        menu.swipe(0.1,0.9);

        menu.clicarPorTexto("<");

        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

    }
}
