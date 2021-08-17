package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import br.ce.mpsilva.appium.core.DriverFactory;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class AccordionPage extends BasePage {


    public String obterOpcao1() {
        return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }


}
