package br.ce.mpsilva.appium.page.seuBarriga;

import br.ce.mpsilva.appium.core.BasePage;
import br.ce.mpsilva.appium.core.GeradorPdfUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.mpsilva.appium.core.DriverFactory.getDriver;

public class SBNContasPage extends BasePage {

    protected String passo;
    protected GeradorPdfUtils geradorPdf;
    protected AppiumDriver<MobileElement> driver;
    protected WebDriver webDriver;
    private Integer timeOut;
    private WebDriverWait wait;
    public Boolean isPresent;

    public void inserirConta(String value) {
        try {
            passo = "teste passo";
            escrever(By.xpath("//*[@text='Conta']"), value);

            clicarPorTexto("SALVAR");
            evidenciaElemento();
        } catch (Exception e) {

        }

    }

    protected void evidenciaElemento() {
        geradorPdf.print(passo, getDriver());
    }

    public String obterMensagemExclusao() {
        try {
            return obterTexto(By.xpath("//*[@text='Conta excluída com sucesso']"));
        } catch (Exception e) {

            return null;
        }
    }

    public String obterMensagemSuccess() {
        try {
            return obterTexto(By.xpath("//*[@text='Conta adicionada com sucesso']"));
        } catch (Exception e) {

            return null;
        }
    }

    public void selecionarConta(String value) {
        try {
            cliqueLongo(By.xpath("//*[@text='" + value + "']"));
        } catch (Exception e) {

        }
    }

    public void clicarSalvarExcluir(String value) {
        try {
            clicarPorTexto(value);
        } catch (Exception e) {

        }
    }


}
