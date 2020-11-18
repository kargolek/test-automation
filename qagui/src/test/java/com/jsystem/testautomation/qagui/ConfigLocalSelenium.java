package com.jsystem.testautomation.qagui;

import com.jsystem.testautomation.qagui.classic.FrontendTest;
import com.jsystem.testautomation.qagui.config.GuiConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigLocalSelenium {

    public WebDriver driver;

    @BeforeAll
    public static void setupBeforeAll() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", Paths.get(FrontendTest.class.getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath());
    }

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setPlatform(Platform.LINUX);
        desiredCapabilities.setVersion("");

        driver = new RemoteWebDriver(new URL("http://172.20.224.1:4444/wd/hub/"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }



}
