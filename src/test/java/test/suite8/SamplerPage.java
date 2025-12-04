package test.suite8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SamplerPage {
    // URL do Vaadin Sampler
    private static final String URL = "https://demo.vaadin.com/sampler/";

    // Mapeamento dos elementos (Seletores)
    // O menu lateral tem vários itens, queremos o "Basic features"
    private final SelenideElement basicFeaturesLink = $(byText("Basic features"));

    // O título da página ou um elemento que confirma que carregou
    private final SelenideElement pageHeader = $("h1");

    // Métodos de interação (Ações)

    // 1. Abrir a página
    public void open() {
        Selenide.open(URL);
    }

    // 2. Clicar na categoria "Basic features"
    public void clickBasicFeatures() {
        basicFeaturesLink.click();
    }

    // 3. Verificar se o título ou elemento esperado está visível (para asserções)
    public boolean isPageOpened() {
        return $("div.v-app-loading").exists() == false; // Exemplo simples
    }
}
