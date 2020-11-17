package com.jsystem.testautomation.qagui;

import com.jsystem.testautomation.qagui.classic.FrontendTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigSelenium {

    public WebDriver driver;

    @BeforeAll
    public static void setupBeforeAll() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", Paths.get(FrontendTest.class.getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath());
    }

    @BeforeEach
    public void setup() throws URISyntaxException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void  tearDown(){
        driver.close();
    }



}
