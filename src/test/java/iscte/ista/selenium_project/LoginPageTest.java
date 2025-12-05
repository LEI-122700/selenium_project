package iscte.ista.selenium_project;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {
    LoginPage page = new LoginPage();

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1280x800";
        open("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginSuccessfully() {
        // 1. Preencher Credenciais (fornecidas na própria página do exercício)
        page.usernameInput.setValue("tomsmith");
        page.passwordInput.setValue("SuperSecretPassword!");

        // 2. Clicar no botão
        page.loginButton.click();

        // 3. Validações
        // Verificar se a mensagem verde apareceu
        page.successMessage.shouldBe(visible);

        // Verificar se o texto da mensagem diz que entrámos
        page.successMessage.shouldHave(text("You logged into a secure area!"));
    }
}
