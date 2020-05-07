package org.DariaRyabinina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TabMenu {


    @FindBy(id = "bank-overview")
    WebElement code;

    public void clickButtonId() {
        code.click();
    }
}
