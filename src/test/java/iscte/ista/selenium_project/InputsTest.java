package iscte.ista.selenium_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import iscte.ista.selenium_project.InputsPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest {
    InputsPage inputsPage;

    @BeforeEach
    public void setup() {
        inputsPage = new InputsPage();
        open("https://the-internet.herokuapp.com/inputs"); // página de exemplo
    }

    @Test
    public void testEnterNumber() {
        inputsPage.enterValue("42");
        assertEquals("42", inputsPage.getValue());
    }

    @Test
    public void testIncrementValue() {
        inputsPage.enterValue("10");
        // podes usar setValue com outro valor ou enviar keys ↑↓ se quiseres simular incremento
        inputsPage.enterValue("15");
        assertEquals("15", inputsPage.getValue());
    }
}
