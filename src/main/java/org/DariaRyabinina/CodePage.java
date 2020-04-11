package org.DariaRyabinina;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CodePage {
    SelenideElement addCode = $(byId("otp-code"));

    SelenideElement enterButtonCode = $(byId("login-otp-button"));

    public CodePage enterCode(String code) {
        addCode.sendKeys("0000");
        return this;
    }

    public TabMenu clickEntrButton() {
        enterButtonCode.click();
        return new TabMenu(getWebDriver());
    }
}
