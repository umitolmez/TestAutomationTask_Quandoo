package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BasePage{

    @FindBy(xpath = "//i[@class='icon-2x icon-signout']")
    WebElement logoutButton;

}
