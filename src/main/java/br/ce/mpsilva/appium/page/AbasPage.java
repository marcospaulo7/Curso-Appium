package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;

public class AbasPage extends BasePage {

    public boolean isAba1() {
        return  existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public boolean isAba2() {
       return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public void selecionarAba2() {
        clicarPorTexto("ABA 2");
    }

}
