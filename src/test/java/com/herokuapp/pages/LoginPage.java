package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(css = ".radius")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='example']/h2")
    public WebElement textTitle;

    @FindBy(className = "subheader")
    public WebElement text;

    @FindBy(id="flash")
    public WebElement flashMessage;
}
