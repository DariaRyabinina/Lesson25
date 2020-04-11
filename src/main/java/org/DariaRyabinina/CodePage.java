package org.DariaRyabinina;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CodePage {
    SelenideElement addCode = $(byId("otp-code"));

    SelenideElement enterButtonCode = $(byId("login-otp-button"));

    @Step("Введение кода")
    public CodePage enterCode(String code) {
        addCode.sendKeys("0000");
        return this;
    }

    @Step("Нажатие кнопки Вход")
    public TabMenu clickEntrButton() {
        enterButtonCode.click();
        return new TabMenu(getWebDriver());
    }
}
