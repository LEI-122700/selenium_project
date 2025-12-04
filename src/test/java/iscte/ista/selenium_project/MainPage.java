package iscte.ista.selenium_project;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public SelenideElement findYourToolsButton = $$x("//a[@href='/products/']").findBy(visible);
  public SelenideElement toolsMenu = $("[data-test='main-menu-item-action']");
  public SelenideElement searchButton = $("[data-test='site-header-search-action']");
  public SelenideElement acceptCookiesButton = $(".ch2-allow-all-btn");
}
