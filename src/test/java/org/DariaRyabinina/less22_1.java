package org.DariaRyabinina;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class less22_1 {
    public static final Logger LOGG = LoggerFactory.getLogger(less22_1.class);
    private static final String formatManey = "\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.";

    @BeforeMethod
    public void initDriver() {
        open("https://idemo.bspb.ru/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Test
    public void Test1SpbBank() {

        LoginPage loginPage = new LoginPage();
        loginPage
                .login("demo", "demo")
                .enterCode("0000")
                .clickEntrButton()
                .clickButtonId();

        ReviewPage reviewPage = new ReviewPage();
        String nameReview1 = reviewPage.nameReview.getText();
        nameReview1 = nameReview1.replaceAll("[^(а-яёА-ЯЁ)]", "");
        Assert.assertEquals(nameReview1, "Обзор", "Название вкладки не \"Обзор\"");
        $(reviewPage.financialfreedom).shouldHave(text("Финансовая свобода"));

        String sumMoney = reviewPage.webColumnMoney.getText().trim();
        LOGG.info("Сумма равна " + sumMoney);
        boolean mach = sumMoney.matches(formatManey);
        Assert.assertTrue(mach, "Формат не соответствует");

        Actions action = new Actions(getWebDriver());
        action.moveToElement(reviewPage.webColumnMoney).build().perform();


        String myMoney = $(By.xpath("//small[@class='my-assets']")).getText();
        String mySumMoney = myMoney;


        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        LOGG.info("Сумма моих средств " + myMoney);
        Assert.assertEquals(myMoney, "Моих средств", "Название поля не \"Моих средств\"");
        mySumMoney = mySumMoney.replaceAll("Моих средств", "").trim();


        LOGG.info("Моих средств " + mySumMoney);
        mach = mySumMoney.matches(formatManey);
        Assert.assertTrue(mach, "Формат не соответствует");
    }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.test();
    }

}
