package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.AbasPage;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTest extends BaseTest {

    MenuPage menu = new MenuPage();
    AbasPage page = new AbasPage();

    @Test
    public void deveInteragirComAbas() {
        menu.acessarAbas();
        Assert.assertTrue(page.isAba1());

        page.selecionarAba2();
        Assert.assertTrue(page.isAba2());


    }
}
