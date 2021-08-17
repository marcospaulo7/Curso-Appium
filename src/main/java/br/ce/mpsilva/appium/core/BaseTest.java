package br.ce.mpsilva.appium.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import cucumber.api.Scenario;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest {


    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizarClasses() {
        DriverFactory.KillDriver();
    }

    @After
    public void tearDown() {
       gerarScreenShort();
        DriverFactory.getDriver().resetApp();
    }

    public void esperar(int i) {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

    }

    public void gerarScreenShort() {
        try {
            File img = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(img, new File("target/screenshots/" + testName.getMethodName() + ""));
            System.out.println("gerado Evidencia: " + testName.getMethodName() + "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
