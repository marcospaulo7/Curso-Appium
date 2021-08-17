package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.MenuPage;
import br.ce.mpsilva.appium.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    @After
    public void tearDown() {
        page.sairContextoWeb();
        gerarScreenShort();
    }

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin() {
        menu.acessarSBHibrido();
        esperar(3000);
        page.entrarContextoWeb();
        page.setEmail("marcos.sbfj01d@gmail.com");
        page.setSenha("123456");
        page.entrar();
        Assert.assertEquals(page.getMensagem(),"Bem vindo, Marcos Paulo Soares Silva!" );

    }


}
