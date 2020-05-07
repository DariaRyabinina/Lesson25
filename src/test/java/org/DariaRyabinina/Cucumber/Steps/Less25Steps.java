package org.DariaRyabinina.Cucumber.Steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Less25Steps {
    private static final String formatManey = "\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.";

    @Дано("Пользователь авторизуется в bspb")
    public void openBspb() {
        open("https://idemo.bspb.ru/");
    }


    @Дано("Входит на поле очищает и вставляет Логин/Пароль {string}")
    public void enterLoginPassword(String value) {
        SelenideElement loginFiled = $(byName("username"));
        loginFiled.clear();
        loginFiled.setValue(value);
    }

    @Когда("нажимает кнопку Войти")
    public void pushButtonEnter() {
        $(byId("login-button")).click();
    }

    @Тогда("впереход на ЭФ Ввод кода")
    public void goToEnterCode() {
        SelenideElement addCode = $(byId("otp-code"));
        addCode.isDisplayed();
    }

    @Дано("Введение кода")
    public void enterCode() {
        $(byId("otp-code")).setValue("0000");
    }

    @Когда("Нажать на кнопку Войти")
    public void pushButtonEnterCode() {
        $(byId("login-otp-button")).click();
    }

    @Тогда("Переход на ЭФ Welcome")
    public void goToWelcome() {
        $(byId("bank-overview")).isDisplayed();

    }

    @Когда("Нажать на кнопку Oбзор")
    public void pushButtonReview() {
        $(byId("bank-overview")).click();
    }

    @Тогда("Переход на ЭФ Обзор")
    public void goToReview() {
        Selenide.title().equals("Обзор -  Интернет банк - Банк Санкт-Петербург");

    }

    @Тогда("Название соответствует Обзор")
    public void comparRewiew() {
        String namePage = $(byXpath("//@id[.='header-container']/following::h1[1]")).getText();
        namePage = namePage.replaceAll("[^(а-яёА-ЯЁ)]", "");
        namePage.equals("Обзор");
    }

    @Тогда("Название блока Финансовая свобода")
    public void comparFinFreedom() {
        $(byXpath("//@id[.='can-spend'][1]/following::span[1]")).shouldHave(text("Финансовая свобода"));
    }

    @Тогда("Проверка, сумма соответствует формату")
    public void comparFormatSumFinFreedom() {
        String sumMoney = $(byXpath("//span[@class='amount-holder']/span[@class='amount']")).getText().trim();
        boolean mach = sumMoney.matches(formatManey);
        Assert.assertTrue(mach, "Формат не соответствует");
    }

    @Когда("Перейти мышкой на поле Суммы")
    public void goToSum() {
        Actions action = new Actions(getWebDriver());
        action.moveToElement($(byXpath("//span[@class='amount-holder']/span[@class='amount']"))).build().perform();
    }

    @Тогда("Проверка, наличия поля Моих средств")
    public void comparMySum() {
        String myMoney = $(By.xpath("//small[@class='my-assets']")).getText();
        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        Assert.assertEquals(myMoney, "Моих средств", "Название поля не \"Моих средств\"");
    }

    @Тогда("Проверка, сумма моих средств соответствует формату")
    public void comparFormatMySum() {
        String mySumMoney = $(By.xpath("//small[@class='my-assets']")).getText();
        mySumMoney = mySumMoney.replaceAll("Моих средств", "").trim();

        boolean mach = mySumMoney.matches(formatManey);
        Assert.assertTrue(mach, "Формат не соответствует");
    }

}
