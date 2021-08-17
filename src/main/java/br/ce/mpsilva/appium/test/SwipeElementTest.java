package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.MenuPage;
import br.ce.mpsilva.appium.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeElementTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    private SwipeListPage page = new SwipeListPage();

    @Test
    public void deveResolverDesafio() {

        menu.acessarSwipeList();
        page.swipeParaEsquerda("Opção 1");
        page.clicarBotaoMais();
        Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

        page.swipeParaEsquerda("Opção 4");
        page.clicarPorTexto("(-)");

        Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));


        page.swipeParaDireita("Opção 5 (-)");

        Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));

    }

}
