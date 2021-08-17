package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.FormularioPage;
import br.ce.mpsilva.appium.page.MenuPage;
import br.ce.mpsilva.appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){

        menu.acessarSplash();
        page.isTelaSplashVisivel();
        page.aguardarSplashSumir();
        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
    }


}
