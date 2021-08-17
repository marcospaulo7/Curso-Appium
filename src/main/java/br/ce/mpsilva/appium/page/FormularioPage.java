package br.ce.mpsilva.appium.page;

import br.ce.mpsilva.appium.core.BasePage;
import br.ce.mpsilva.appium.core.DriverFactory;
import br.ce.mpsilva.appium.core.GeradorPdfUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class FormularioPage extends BasePage {

    protected String passo;
    protected GeradorPdfUtils geradorPdf;
    protected WebDriver webDriver;
    private Integer timeOut;
    private WebDriverWait wait;
    public Boolean isPresent;


    protected void evidenciaElemento(By elemento) {
        geradorPdf.print(passo, getDriver());
    }

    public void escreverNome(String nome) {
               passo = "inserir conta";
        evidenciaElemento(MobileBy.AccessibilityId("nome"));
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }


    public String obterNome() {
        return obterTexto(MobileBy.AccessibilityId("nome"));

    }

    public void selecionarCombo(String valor) {

        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
        Assert.assertEquals("PS4", obterTexto(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")));

    }

    public String obterValorCombo() {
        return obterTexto(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"));

    }

    public void clicarSwitch() {
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public void clicarCheck() {
        clicar(By.className("android.widget.CheckBox"));
    }

    public boolean isCheckMarcado() {
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado() {
        return isCheckMarcado(By.className("android.widget.Switch"));
    }

    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public String obterNomeCadastro() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
    }

    public String obterConsoleCadastro() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));
    }

    public String obterCheckCadastro() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
    }

    public String obterSwithCadastro() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
    }

    public void clicarSeekBar(double posicao) {
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int delta = 55;

        int y = seek.getLocation().y + (seek.getSize().height / 2);

        int xinicial = (seek.getLocation().x + delta);
        int x = (int) (seek.getLocation().x + ((seek.getSize().width - 2 * delta) * posicao));
        tap(x, y);
    }
}

