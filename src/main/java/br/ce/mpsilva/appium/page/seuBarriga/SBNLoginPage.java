package br.ce.mpsilva.appium.page.seuBarriga;

import br.ce.mpsilva.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class SBNLoginPage extends BasePage {

    public void setEmail(String value){
        escrever(By.xpath("//*[@text='Nome']"), value);
    }

    public void setSenha(String value) {
        escrever(By.xpath("//*[@text='Senha']"), value);
    }

    public void entrar() {
        clicar(By.xpath("//*[@text='ENTRAR']"));
    }
}
