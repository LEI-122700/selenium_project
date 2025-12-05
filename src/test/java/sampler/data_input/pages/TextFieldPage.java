package sampler.data_input.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TextFieldPage {
    private static final String URL =
            "https://demo.vaadin.com/sampler/#ui/data-input/text-input/text-field";


    @FindBy(css = "input.v-textfield.v-widget[placeholder='Write something']")
    private SelenideElement textField;


//    @FindBy(xpath = "//span[@class='v-captiontext' and contains(text(), '/10 characters')]")
//    private SelenideElement charCounter;


    public static TextFieldPage openPage() {
        return open(URL, TextFieldPage.class);
    }

    public TextFieldPage typeText(String text) {
        textField.setValue(text);
        return this;
    }

    public String getTextValue() {
        return textField.getValue();
    }



    public SelenideElement getTextFieldElement() {
        return textField;
    }

    public SelenideElement getCharCounterElement() {
        return $$("span.v-captiontext").findBy(visible);
    }

    public String getCounterText() {
        return getCharCounterElement().getText().trim();
    }
}
