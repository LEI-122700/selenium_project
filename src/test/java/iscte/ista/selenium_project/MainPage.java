package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    public SelenideElement findYourToolsButton = $$x("//a[@href='/products/']").findBy(visible);
    public SelenideElement toolsMenu = $("[data-test='main-menu-item-action']");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement cookiesButton = $(".ch2-allow-all-btn");
    public SelenideElement seeDeveloperToolsButton = $("body");

}
