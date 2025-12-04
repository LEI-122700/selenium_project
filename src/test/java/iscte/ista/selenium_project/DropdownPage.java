package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class DropdownPage {
    public SelenideElement dropdown = $("#dropdown"); // id do select

    public void selectByVisibleText(String text) {
        new Select(dropdown).selectByVisibleText(text);
    }

    public String getSelectedOption() {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
}
