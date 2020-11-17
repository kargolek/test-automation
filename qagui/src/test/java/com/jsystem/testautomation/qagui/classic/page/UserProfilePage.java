package com.jsystem.testautomation.qagui.classic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends BasePage {

    public UserProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "profile-gravatar__user-display-name")
    public WebElement profileName;
    @FindBy(xpath = "//button[@class='button sidebar__me-signout-button is-compact']")
    public WebElement logoutButton;


}
