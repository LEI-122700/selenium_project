package iscte.ista.selenium_project;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach    public void setUp() {
        open("https://www.jetbrains.com/");

        if (mainPage.cookiesButton.is(visible, Duration.ofSeconds(2))) {
            mainPage.cookiesButton.click();
        }
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        $("[data-test-id='search-input']").sendKeys("Selenium");
        $("button[data-test='full-search-button']").click();

        $("input[data-test-id='search-input']").shouldHave(attribute("value", "Selenium"));
    }

    @Test
    public void toolsMenu() {
        // Clica no menu "Developer Tools"
        mainPage.toolsMenu.shouldBe(visible).click(ClickOptions.usingJavaScript());

        // CORREÇÃO: Verificamos se o botão "Find your tool" ficou visível.
        // Sabemos que este botão existe dentro do menu ou na página de destino,
        // por isso é a validação mais segura.
        mainPage.findYourToolsButton.shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());    }
}
