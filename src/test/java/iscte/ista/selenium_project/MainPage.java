package iscte.ista.selenium_project;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.jetbrains.com/
public class MainPage {
    //public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
    public SelenideElement findYourToolsButton = $$x("//a[@href='/products/']").findBy(visible);
    //public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-action']");
    public SelenideElement toolsMenu = $("[data-test='main-menu-item-action']");
    public SelenideElement cookiesButton = $(".ch2-allow-all-btn");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
}