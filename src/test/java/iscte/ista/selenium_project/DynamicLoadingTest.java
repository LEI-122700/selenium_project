package iscte.ista.selenium_project;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.time.Duration; // <--- Importante para definir o tempo

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DynamicLoadingTest {
    DynamicLoadingPage page = new DynamicLoadingPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    public void testDynamicLoadingHiddenElement() {
        // 1. Clicar no botão Start
        page.startButton.shouldBe(visible).click();

        // 2. Verificar que o loading apareceu (opcional)
        page.loadingBar.shouldBe(visible);

        // 3. Validar que o texto final aparece.
        // CORREÇÃO: Adicionamos 'Duration.ofSeconds(10)' para esperar até 10s.
        // O site demora ~5s, por isso o default de 4s falhava.
        page.finishText.shouldBe(visible, Duration.ofSeconds(10)).shouldHave(text("Hello World!"));
    }
}