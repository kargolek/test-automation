package com.jsystem.testautomation.qagui.classic;

import com.jsystem.testautomation.qagui.ConfigSelenium;
import com.jsystem.testautomation.qagui.classic.page.LoginPage;
import com.jsystem.testautomation.qagui.classic.page.MainUserPage;
import com.jsystem.testautomation.qagui.classic.page.MainWordPressPage;
import com.jsystem.testautomation.qagui.classic.page.UserProfilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

@Tag("Frontend")
@DisplayName("Frontend Test")
public class FrontendTest extends ConfigSelenium {

    public MainWordPressPage mainWordPressPage;
    public LoginPage loginPage;
    public MainUserPage mainUserPage;
    public UserProfilePage userProfilePage;

    @BeforeEach
    public void setupFrontendTest() throws URISyntaxException {
        mainWordPressPage = new MainWordPressPage(driver);
        loginPage = new LoginPage(driver);
        mainUserPage = new MainUserPage(driver);
        userProfilePage = new UserProfilePage(driver);
        driver.get("http://wordpress.com");

        mainWordPressPage.loginButton.click();
        loginPage.username.clear();
        loginPage.username.click();
        loginPage.username.sendKeys("karol.orlowicz@gmail.com");
        loginPage.buttonPrimary.click();
        loginPage.password.clear();
        loginPage.password.click();
        loginPage.password.sendKeys("zaq12WSX");
        loginPage.buttonPrimary.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(mainUserPage.title));
    }


    @DisplayName("Login Test")
    @Test
    public void loginTest() {
        String result = mainUserPage.title.getText();
        assertThat(result).contains("Moja strona");
    }

    @DisplayName("Check if user is login in")
    @Test
    public void shouldUserLogIn() {
        mainUserPage.avatarButton.click();
        String result = userProfilePage.profileName.getText();
        assertThat(result).isEqualTo("kargolek");
    }

    @DisplayName("Check if user is logout")
    @Test
    public void shouldUserLogOut() throws InterruptedException {
        mainUserPage.avatarButton.click();
        userProfilePage.logoutButton.click();
        assertThat(mainWordPressPage.loginButton.isDisplayed()).isTrue();
    }


}
