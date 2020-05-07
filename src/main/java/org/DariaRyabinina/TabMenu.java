package org.DariaRyabinina;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class TabMenu {

  SelenideElement code=$(byId("bank-overview"));

    public void clickButtonId() {
        code.click();
    }
}
