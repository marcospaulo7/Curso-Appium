package br.ce.mpsilva.appium.test;

import br.ce.mpsilva.appium.core.BaseTest;
import br.ce.mpsilva.appium.page.DragDropPage;
import br.ce.mpsilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragNDropTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragDropPage page = new DragDropPage();
    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};

    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] estadofinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void deveEfetuarDranNDrop() {
        menu.acessarDradNDrop();
        esperar(2000);
        Assert.assertArrayEquals(estadoInicial, page.obterLista());

        page.arrastar("Esta", "e arraste para");

        Assert.assertArrayEquals(estadoIntermediario, page.obterLista());

        page.arrastar("Faça um clique longo,", "é uma lista");

        Assert.assertArrayEquals(estadofinal, page.obterLista());

    }
}
