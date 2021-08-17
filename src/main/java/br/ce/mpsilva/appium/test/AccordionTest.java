package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.AccordionPage;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;

public class AccordionTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    public void deveInteragirComAccordion() {
        menu.acessarAccordion();

        page.obterOpcao1();
        esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", page.obterOpcao1());
    }
}
