package com.jsystem.testautomation.qagui.classic;

import com.jsystem.testautomation.qagui.ConfigSelenium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.google.common.truth.Truth.assertThat;

@Tag("Frontend")
@DisplayName("Frontend Test")
public class FrontendTest extends ConfigSelenium {

    @DisplayName("Login Test")
    @Test
    public void loginTest(){
        driver.get("http://wordpress.com");
        driver.findElement(By.xpath("//a[@title='Log In']")).click();
        driver.findElement(By.id("usernameOrEmail")).clear();
        driver.findElement(By.id("usernameOrEmail")).click();
        driver.findElement(By.id("usernameOrEmail")).sendKeys("karol.orlowicz@gmail.com");
        driver.findElement(By.cssSelector(".button.is-primary")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("zaq12WSX");
        driver.findElement(By.cssSelector(".button.is-primary")).click();

        String result = driver.findElement(By.xpath("//h1[@class='formatted-header__title wp-brand-font']")).getText();
        assertThat(result).contains("Moja strona");
    }

}
