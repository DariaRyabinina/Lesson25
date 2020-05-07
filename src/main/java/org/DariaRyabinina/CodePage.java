package org.DariaRyabinina;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CodePage {
    SelenideElement addCode = $(byId("otp-code"));

    SelenideElement enterButtonCode = $(byId("login-otp-button"));

    @Step("Введение кода")
    protected CodePage enterCode(String code) {
        addCode.sendKeys(code);
        return this;
    }

    @Step("Нажатие кнопки Вход")
    protected TabMenu clickEntrButton() {
        enterButtonCode.click();
        return new TabMenu();
    }
}
