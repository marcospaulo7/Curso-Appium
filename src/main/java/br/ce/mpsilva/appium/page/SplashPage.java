package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import br.ce.mpsilva.appium.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class SplashPage extends BasePage {

    public boolean isTelaSplashVisivel() {
        return existeElementoPorTexto("Splash!");

    }

    public void aguardarSplashSumir() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));

    }
}
