package br.ce.mpsilva.appium.core;

import br.ce.mpsilva.appium.page.FormularioPage;
import br.ce.mpsilva.appium.page.MenuPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class BasePage {


    public void escrever(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);


    }



    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicar(String id) {
        clicar(By.id(id));
    }

    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='" + texto + "']"));

    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto) {
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elementos.size() > 0;
    }

    public void tap(int x, int y) {
        new TouchAction(getDriver()).press(PointOption.point(x, y)).perform();

    }

    public void cliqueLongo(By by) {

        AndroidTouchAction touch = new AndroidTouchAction(getDriver());
        touch.longPress(LongPressOptions.longPressOptions().withElement(
                ElementOption.element(getDriver().findElement(by))))
                .perform();

    }

    public void scroolDown() {
        scrool(0.9, 0.1);
    }

    public void scroolUp() {
        scrool(0.1, 0.9);
    }

    public void scrool(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);


        new TouchAction(getDriver())
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();

    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);


        new TouchAction(getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y))
                .release()
                .perform();

    }


    public void swipeElement(MobileElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);


        new TouchAction(getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y))
                .release()
                .perform();

    }

    public String obterTituloAlerta() {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return obterTexto(By.id("android:id/message"));
    }

}
