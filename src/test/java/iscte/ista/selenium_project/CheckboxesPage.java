package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CheckboxesPage {
    // A página tem duas checkboxes.
    // O seletor "form#checkboxes input" procura os inputs dentro do formulário.

    // Checkbox 1 (normalmente começa desmarcada)
    // Usamos :first-of-type ou nth-of-type(1) para pegar a primeira
    public SelenideElement checkbox1 = $("#checkboxes input:first-of-type");

    // Checkbox 2 (normalmente começa marcada)
    // Usamos :last-of-type ou nth-of-type(2) para pegar a segunda
    public SelenideElement checkbox2 = $("#checkboxes input:last-of-type");
}
