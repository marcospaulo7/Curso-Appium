package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void clicarAlertConfirm() {
        clicarPorTexto("ALERTA CONFIRM");
    }


    public void clicarConfirmar() {
        clicarPorTexto("CONFIRMAR");
    }


    public void sair() {
        clicarPorTexto("SAIR");
    }

    public void clicarAlertaSimples() {
        clicarPorTexto("ALERTA SIMPLES");

    }

    public void clicarForaCaixa() {
        tap(100, 150);
    }
}

