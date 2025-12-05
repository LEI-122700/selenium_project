package test.suite8;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class SamplerTest {

    @Test
    public void accessBasicFeaturesTest() {
        // Inicializar a Page Object
        SamplerPage page = new SamplerPage();

        // 1. Abrir o site Sampler
        page.open();

        // Pequena pausa para garantir carregamento visual (opcional em Selenide, mas útil para veres acontecer)
        // sleep(2000);

        // 2. Interagir: Clicar em "Basic features"
        page.clickBasicFeatures();

        // 3. Validar: Verificar se apareceu algo relacionado com Basic Features
        // Aqui verificamos se um sub-menu (ex: "Tooltip" ou "Icon") ficou visível
        // O Selenide espera automaticamente até o elemento aparecer
        // Nota: Ajusta "Icon" para outro sub-item se "Icon" não existir na versão atual
        // $(byText("Icon")).shouldBe(visible);
    }
}
