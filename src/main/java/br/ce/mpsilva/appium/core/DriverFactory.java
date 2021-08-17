package br.ce.mpsilva.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                "C:/Users/Administrador/Desktop/Automacoes/at-mobile-padrao-v1/src/main/resources/app-debug.apk");
        try {
            URL remoteUrl = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public static void KillDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}
