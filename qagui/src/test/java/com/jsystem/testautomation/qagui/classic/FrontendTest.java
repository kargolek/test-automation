package com.jsystem.testautomation.qagui.classic;

import com.jsystem.testautomation.qagui.ConfigLocalSelenium;
import com.jsystem.testautomation.qagui.classic.page.LoginPage;
import com.jsystem.testautomation.qagui.classic.page.MainUserPage;
import com.jsystem.testautomation.qagui.classic.page.MainWordPressPage;
import com.jsystem.testautomation.qagui.classic.page.UserProfilePage;
import com.jsystem.testautomation.qagui.config.GuiConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URISyntaxException;

import static com.google.common.truth.Truth.assertThat;

@Tag("frontend")
@DisplayName("Frontend Test")
public class FrontendTest extends ConfigLocalSelenium {

    public MainWordPressPage mainWordPressPage;
    public LoginPage loginPage;
    public MainUserPage mainUserPage;
    public UserProfilePage userProfilePage;

    @BeforeEach
    public void setupFrontendTest() {
        mainWordPressPage = new MainWordPressPage(driver);
        loginPage = new LoginPage(driver);
        mainUserPage = new MainUserPage(driver);
        userProfilePage = new UserProfilePage(driver);

        driver.get(GuiConfig.BASE_URL);
        mainWordPressPage.loginButton.click();
        loginPage.username.clear();
        loginPage.username.click();
        loginPage.username.sendKeys(GuiConfig.LOGIN);
        loginPage.buttonPrimary.click();
        loginPage.password.clear();
        loginPage.password.click();
        loginPage.password.sendKeys(GuiConfig.PASSWORD);
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
