package sampler5;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SamplerPage {
    // URL confirmado da ficha
    public String url = "https://demo.vaadin.com/sampler/";

    // Vamos procurar no menu lateral um componente de tipo Interação.
    // "Notifications" é um exemplo perfeito.
    // Usamos o byText para encontrar o link que diz exatamente "Notifications"
    public SelenideElement interactionLink = $(byText("Notification"));

    public SelenideElement showButton = $x("//div[contains(@class, 'v-button') and .//span[contains(text(), 'Show notification')]]");

}
