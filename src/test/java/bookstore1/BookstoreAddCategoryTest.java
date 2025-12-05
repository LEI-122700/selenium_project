package bookstore1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;

public class BookstoreAddCategoryTest {

    private BookstoreAddCategory page;

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Selenide.open("https://vaadin-bookstore-example.demo.vaadin.com/");

        page = new BookstoreAddCategory();
    }

    @Test
    void testAddCategory() {
        // Nome da categoria (não vamos validar unicidade)
        final String CATEGORY_NAME = "Nova Categoria Teste";

        // 1. Ações
        page.login();
        page.clickAdminButton();

        // NOVO FLUXO: Clicar no botão -> Escrever -> Submeter
        page.clickAddNewCategoryButton(); // Clicar no botão 'Add New Category'
        page.typeAndSubmitNewCategory(CATEGORY_NAME); // Escrever e dar ENTER

        // 2. Asserção
        // Verifica se a nova categoria aparece na lista de categorias no menu Admin.
        SelenideElement categoryItem = $x("//vaadin-item[text()='" + CATEGORY_NAME + "']");
        categoryItem.shouldBe(Condition.visible).shouldHave(Condition.text(CATEGORY_NAME));
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}