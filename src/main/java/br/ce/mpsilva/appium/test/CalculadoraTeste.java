package br.ce.mpsilva.appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTeste {


    @Test
    public void deveSomarDoisValores() throws MalformedURLException {

        AndroidDriver<MobileElement> driver = inicializarAppium();

        MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/op_add");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        Assert.assertEquals( "4",el7.getText());
        driver.quit();

    }

    private AndroidDriver<MobileElement> inicializarAppium() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("MobileCapabilityTypeApp", "F:/arquivos-programacao/cursoAppium/src/main/resources/CTAppium_1_2.apk");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        return driver;
    }
}