package org.DariaRyabinina;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ReviewPage {

    public SelenideElement nameReview = $(byXpath("//@id[.='header-container']/following::h1[1]"));
    public SelenideElement webColumnMoney = $(byXpath("//span[@class='amount-holder']/span[@class='amount']"));
    public SelenideElement financialfreedom = $(byXpath("//@id[.='can-spend'][1]/following::span[1]"));
}
