package org.DariaRyabinina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabMenu {
    public TabMenu(WebDriver webDriver) {
    }

    @FindBy(id = "bank-overview")
    WebElement code;

    public void clickButtonId() {
        code.click();
    }
}
