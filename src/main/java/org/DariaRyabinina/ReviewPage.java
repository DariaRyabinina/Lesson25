package org.DariaRyabinina;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ReviewPage {

    public WebElement nameReview = $(byXpath("//@id[.='header-container']/following::h1[1]"));
    public WebElement webColumnMoney = $(byXpath("//span[@class='amount-holder']/span[@class='amount']"));
    public WebElement financialfreedom = $(byXpath("//@id[.='can-spend'][1]/following::span[1]"));
}
