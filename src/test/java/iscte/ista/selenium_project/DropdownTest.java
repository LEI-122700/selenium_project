package iscte.ista.selenium_project;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import iscte.ista.selenium_project.DropdownPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {
    DropdownPage dropdownPage;

    @BeforeEach
    public void setup() {
        dropdownPage = new DropdownPage();
        open("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void testSelectOption() {
        dropdownPage.selectByVisibleText("Option 2");
        assertEquals("Option 2", dropdownPage.getSelectedOption());
    }
}
