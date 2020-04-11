package org.DariaRyabinina;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static Logger LOGG = LoggerFactory.getLogger(LoginPage.class);

    public SelenideElement loginFiled = $(byName("username"));
    public SelenideElement passFiled = $(byName("password"));
    public SelenideElement enterButtonLogin = $(byId("login-button"));

    public CodePage login(String login, String password) {
        loginFiled.clear();
        loginFiled.setValue(login);
        passFiled.clear();
        passFiled.setValue(password);
        LOGG.info(enterButtonLogin.getText());
        enterButtonLogin.click();

        return new CodePage();
    }

    public void test() {
        loginFiled.clear();
        loginFiled.setValue("demo");
        passFiled.clear();
        passFiled.setValue("demo");
    }
}

