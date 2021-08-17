package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.AlertPage;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage page = new AlertPage();

    @Before
    public void setup() {
        menu.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta() {
        //acessar menu alerta


        //CLICAR alert
        page.clicarAlertConfirm();

        //verificar resposta
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
        //sair alert
        page.sair();
    }


    @Test
    public void deveClicarForaAlerta() {
        page.clicarAlertaSimples();
        esperar(1000);
        page.clicarForaCaixa();
        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

    }
}
