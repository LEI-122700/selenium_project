package sampler.data_input;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sampler.data_input.pages.TextFieldPage;

import static com.codeborne.selenide.Condition.*;

public class TextFieldTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    public void shouldUpdateCounterWhenTyping() {
        TextFieldPage page = TextFieldPage.openPage();

        String input = "Olá Elliot";
        page.typeText(input);

        page.getTextFieldElement()
                .shouldBe(visible)
                .shouldHave(value(input));

        page.getCharCounterElement()
                .shouldBe(visible)
                .shouldHave(text("10/10"));
    }
}

