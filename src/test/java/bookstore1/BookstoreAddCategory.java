package bookstore1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.Keys;

public class BookstoreAddCategory {

    // ---------- LOGIN ----------
    private final SelenideElement usernameInput = $("input[name='username']");
    private final SelenideElement passwordInput = $("vaadin-password-field input");
    private final SelenideElement loginButton = $("vaadin-button[part='vaadin-login-submit']");

    public void login() {
        usernameInput.shouldBe(Condition.visible).sendKeys("admin");
        passwordInput.shouldBe(Condition.visible).sendKeys("admin");
        loginButton.shouldBe(Condition.enabled).click();
    }

    // ---------- ADMIN & CATEGORY ELEMENTS ----------

    // Botão Admin (corrigido anteriormente)
    private final SelenideElement adminButton = $x("//a[contains(@class, 'menu-link') and contains(., 'Admin')]");

    // Cabeçalho da página (usado para espera)
    private final SelenideElement editCategoriesHeader = $x("//*[text()='Edit Categories']");

    // NOVO: Botão (vaadin-button) "Add New Category"
    // Usamos o texto visível do botão para o seletor.
    private final SelenideElement addNewCategoryButton = $x("//vaadin-button[contains(text(), 'Add New Category')]");

    // Campo de texto (o input que recebe a categoria)
    // Seletor baseado no input que está visível (que se assume ser o único)
    private final SelenideElement newCategoryInput = $$("vaadin-text-field:not([hidden])").last().$("input[part='value']");

    // ---------- ADMIN ACTIONS ----------

    public void clickAdminButton() {
        adminButton.shouldBe(Condition.visible).click();
        editCategoriesHeader.shouldBe(Condition.visible);
    }

    public void clickAddNewCategoryButton() {
        addNewCategoryButton.shouldBe(Condition.visible).click();

        // **CORREÇÃO CRUCIAL:** Espera que o botão desapareça (Condição de Não-Existência ou Invisibilidade)
        addNewCategoryButton.should(Condition.disappear);

        // Confirma que o campo de input (que o substitui) está visível antes de prosseguir
        newCategoryInput.shouldBe(Condition.visible);
    }

    public void typeAndSubmitNewCategory(String categoryName) {
        newCategoryInput.sendKeys(categoryName);
        newCategoryInput.sendKeys(Keys.ENTER);

        newCategoryInput.shouldHave(Condition.value(""));
    }
}