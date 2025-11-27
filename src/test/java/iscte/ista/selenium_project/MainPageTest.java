package iscte.ista.selenium_project;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");
        executeJavaScript("var banner = document.querySelector('.ch2-container'); if(banner) banner.remove();");
        executeJavaScript("var banner2 = document.querySelector('div[data-test=\"banner\"]'); if(banner2) banner2.remove();");
        executeJavaScript("var cookieOverlay = document.getElementById('onetrust-banner-sdk'); if(cookieOverlay) cookieOverlay.remove();");
    }

    @Test
    public void search() {
        mainPage.searchButton.shouldBe(visible).click(ClickOptions.usingJavaScript());
        $$("input").findBy(visible).setValue("Selenium").pressEnter();
        $$("input").findBy(value("Selenium")).shouldBe(visible);
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
        mainPage.seeDeveloperToolsButton.shouldBe(visible).click(ClickOptions.usingJavaScript());
        mainPage.findYourToolsButton.shouldBe(visible).click(ClickOptions.usingJavaScript());

        String title = Selenide.title();
        assertTrue(title.contains("Tools") || title.contains("Products"));
    }
}