package com.herokuapp.step_definitions;

import com.herokuapp.pages.LoginPage;
import com.herokuapp.utilities.BrowserUtils;
import com.herokuapp.utilities.ConfigurationReader;
import com.herokuapp.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("I navigate to login page")
    public void i_navigate_to_login_page() {
        BrowserUtils.waitForClickabilility(loginPage.FormAuthentication, 10);
        loginPage.FormAuthentication.click();
    }

    @Then("I verify that I am on the login page")
    public void i_verify_that_i_am_on_the_login_page() {
        Assert.assertTrue(Driver.get().getCurrentUrl().endsWith("/login"));
        Assert.assertEquals("Login Page", loginPage.textTitle.getText());
    }

    @When("I type username and password")
    public void i_type_username_and_password() {
        BrowserUtils.waitForClickabilility(loginPage.loginButton, 5);
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @When("I click login button")
    public void i_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("I see the error message for username")
    public void i_see_the_error_message_for_username() {
        String expectedMessage = "Your username is invalid!";
        String actualMessage = loginPage.flashMessage.getText();

        Assert.assertTrue(actualMessage.startsWith(expectedMessage));
    }

    @Then("I verify I logged in")
    public void i_verify_i_logged_in() {
        Assert.assertTrue(Driver.get().getCurrentUrl().endsWith("/secure"));

        BrowserUtils.waitForVisibility(loginPage.flashMessage, 5);
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = loginPage.flashMessage.getText();

        Assert.assertTrue(actualMessage.startsWith(expectedMessage));
    }

    @When("I type {string} and {string}")
    public void i_type_and(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @Then("I see the error message for password")
    public void i_see_the_error_message_for_password() {
        String expectedMessage = "Your password is invalid!";
        String actualMessage = loginPage.flashMessage.getText();

        Assert.assertTrue(actualMessage.startsWith(expectedMessage));
    }

    @Then("I verify title of the text is {string}")
    public void i_verify_title_of_the_text_is(String expectedTitle) {
        String actualTitle = loginPage.textTitle.getText();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("I verify text is {string}")
    public void i_verify_text_is(String expectedText) {
        String actualText = loginPage.text.getText();

        Assert.assertEquals(expectedText, actualText);
    }

}
