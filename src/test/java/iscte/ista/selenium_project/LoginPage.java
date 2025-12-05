package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // URL: https://the-internet.herokuapp.com/login

    // 1. Campo de Username (tem id="username")
    public SelenideElement usernameInput = $("#username");

    // 2. Campo de Password (tem id="password")
    public SelenideElement passwordInput = $("#password");

    // 3. Botão de Login (procuramos pelo tipo ou classe)
    // A classe ".radius" é usada no botão de login neste site específico
    public SelenideElement loginButton = $("button.radius");

    // 4. Mensagem de Sucesso (aparece depois de entrar)
    // Tem id="flash" e classe="success"
    public SelenideElement successMessage = $("#flash");
}
