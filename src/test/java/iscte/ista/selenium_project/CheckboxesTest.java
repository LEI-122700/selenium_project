package iscte.ista.selenium_project;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Importa a condição "checked" para verificares se está marcado
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.open;

public class CheckboxesTest {
    CheckboxesPage page = new CheckboxesPage();

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1280x800";
        // URL direto do exercício de checkboxes
        open("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void interactWithCheckboxes() {
        // 1. Testar a Checkbox 1 (que começa desmarcada)
        page.checkbox1.shouldNotBe(checked); // Garante que está vazia
        page.checkbox1.click();              // Clica
        page.checkbox1.shouldBe(checked);    // Garante que ficou marcada

        // 2. Testar a Checkbox 2 (que começa marcada)
        page.checkbox2.shouldBe(checked);    // Garante que já está marcada
        page.checkbox2.click();              // Clica para desmarcar
        page.checkbox2.shouldNotBe(checked); // Garante que ficou vazia
    }
}