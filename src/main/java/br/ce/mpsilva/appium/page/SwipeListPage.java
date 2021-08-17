package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import br.ce.mpsilva.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeParaDireita(String opcao) { //swipe por elemento
        swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
    }

    public void swipeParaEsquerda(String opcao) {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
    }

    public void clicarBotaoMais() {
        MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
        new TouchAction(getDriver())
                .tap(ElementOption.element(getDriver()
                        .findElement(By.xpath("//*[@text='(+)']/..")))).perform();
    }
}
