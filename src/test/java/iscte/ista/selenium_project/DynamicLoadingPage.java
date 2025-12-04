package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// URL: https://the-internet.herokuapp.com/dynamic_loading/1
public class DynamicLoadingPage {

    // O botão "Start"
    public SelenideElement startButton = $x("//div[@id='start']/button");

    // O texto "Hello World!" que aparece depois do carregamento
    // Nota: Inicialmente está oculto (display: none), depois fica visível
    public SelenideElement finishText = $x("//div[@id='finish']/h4");

    // O indicador de carregamento (barra de progresso)
    public SelenideElement loadingBar = $x("//div[@id='loading']");
}