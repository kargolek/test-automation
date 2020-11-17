package com.jsystem.testautomation.qagui.classic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "usernameOrEmail")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = ".button.is-primary")
    public WebElement buttonPrimary;

}
