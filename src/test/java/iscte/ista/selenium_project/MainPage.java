package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    // Botão da lupa
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");

    // Menu principal (Desktop)
    public SelenideElement toolsMenu = $(byText("Developer Tools"));

    // Botões de navegação
    public SelenideElement seeDeveloperToolsButton = $(byText("Developer Tools"));
    public SelenideElement findYourToolsButton = $("[data-test='suggestion-link']");
}