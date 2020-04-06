package org.DariaRyabinina;

import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class less22_1 {

    private WebDriver webDriver;
    public static final Logger LOGG = LoggerFactory.getLogger(less22_1.class);

    @BeforeClass
    public void downloadDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void Test1() {

        Selenide.open("https://idemo.bspb.ru/");

       // webDriver.get("https://idemo.bspb.ru/");
       // webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage
                .longin("demo", "demo")
                .enterCode("0000")
                .clickEntrButton()
                .clickButtonId();

        ReviewPage reviewPage = new ReviewPage(webDriver);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60);
        webDriverWait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(reviewPage.nameReview));

        String nameReview1 = reviewPage.nameReview.getText();
        nameReview1 = nameReview1.replaceAll("[^(а-яёА-ЯЁ)]", "");
        Assert.assertEquals(nameReview1, "Обзор");
        $(reviewPage.financialfreedom).shouldHave(text("Финансовая свобода"))  ;
        //Assert.assertEquals(reviewPage.financialfreedom.getText(), "Финансовая свобода");

      //  webDriverWait.until(ExpectedConditions.visibilityOf(reviewPage.webColumnMoney));


        String sumMoney = reviewPage.webColumnMoney.getText().trim();
        LOGG.info(sumMoney);
        boolean mach = sumMoney.matches("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.");
        Assert.assertTrue(mach);

        Actions action = new Actions(webDriver);
        action.moveToElement(reviewPage.webColumnMoney).build().perform();

      //  webDriverWait.until(ExpectedConditions.visibilityOf(reviewPage.webColumnMyMoney));

        String myMoney=$(By.xpath("//small[@class='my-assets']")).getText();
        String mySumMoney=myMoney;

      //  String myMoney = reviewPage.webColumnMyMoney.getText();
        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        LOGG.info(myMoney);
        Assert.assertEquals(myMoney, "Моих средств");
        mySumMoney=$(mySumMoney).getText().replaceAll("Моих средств", "").trim();

       // String mySumMoney = reviewPage.webColumnMyMoney.getText().replaceAll("Моих средств", "").trim();
        LOGG.info(mySumMoney);
        mach = mySumMoney.matches("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.");
        Assert.assertTrue(mach);


    }
}
