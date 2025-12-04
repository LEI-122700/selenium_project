package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InputsPage {
    // Input field
    public SelenideElement inputField = $("input[type='number']"); // ajusta selector conforme HTML

    // Método para digitar valor
    public void enterValue(String value) {
        inputField.clear();  // limpa campo antes
        inputField.setValue(value);
    }

    // Método para ler valor atual
    public String getValue() {
        return inputField.getValue();
    }
}
