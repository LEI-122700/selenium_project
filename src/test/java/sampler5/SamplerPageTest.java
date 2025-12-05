package sampler5;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

@Feature("Sampler - Interaction Tests")
public class SamplerPageTest {
    SamplerPage page = new SamplerPage();

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1280x800";
        open(page.url);
    }

    @Test
    @Owner("Diogo") // Substitui pelo teu nome se quiseres
    @Description("Aceder ao componente Notifications (Interação) no Vaadin Sampler")
    public void accessInteractionComponent() {
        // Clicar no link "Notifications" no menu lateral
        // scrollTo() ajuda caso o menu seja muito comprido
        page.interactionLink.scrollTo().click();

        page.showButton.shouldBe(visible).click();
    }

}
