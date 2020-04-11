package org.DariaRyabinina;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Вход в систему {login} / {password}")
    public CodePage login(String login, String password) {
        loginFiled.clear();
        loginFiled.setValue(login);
        passFiled.clear();
        passFiled.setValue(password);
        enterButtonLogin.click();

        return new CodePage();
    }

    @Step
    public void test() {
        loginFiled.clear();
        loginFiled.setValue("demo");
        passFiled.clear();
        passFiled.setValue("demo");
    }
}

