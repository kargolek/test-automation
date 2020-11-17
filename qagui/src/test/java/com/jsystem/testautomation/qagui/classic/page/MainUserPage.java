package com.jsystem.testautomation.qagui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainUserPage extends BasePage{

    public MainUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "gravatar")
    public WebElement avatarButton;
    @FindBy(xpath = "//h1[@class='formatted-header__title wp-brand-font']")
    public WebElement title;
}
