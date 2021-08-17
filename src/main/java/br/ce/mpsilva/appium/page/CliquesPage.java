package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo() {

        AndroidTouchAction touch = new AndroidTouchAction(getDriver());
        touch.longPress(LongPressOptions.longPressOptions().withElement(
                ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))))
                .perform();

    }

    public String obterTextoCampo() {
        return getDriver().findElement(By.xpath("//(android.widget.TextView)[3]")).getText();
    }


}
