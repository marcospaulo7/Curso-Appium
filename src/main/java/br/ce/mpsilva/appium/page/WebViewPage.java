package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb() {
        Set<String> contextHandles = getDriver().getContextHandles();
        for (String valor : contextHandles) {
            System.out.println(valor);
        }
        getDriver().context((String) contextHandles.toArray()[1]);
    }

    public void sairContextoWeb() {
            getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }


    public void setEmail(String valor) {
        getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void setSenha(String valor) {
        getDriver().findElement(By.id("senha")).sendKeys(valor);
    }

    public void entrar() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }
    public String getMensagem() {
      return  obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
