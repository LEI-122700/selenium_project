package iscte.ista.selenium_project;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadPageTest {
    FileUploadPage fileUploadPage = new FileUploadPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    public void uploadFileSuccessfully() {
        // 1. abrir a página
        fileUploadPage.openPage();

        // 2. apontar para o ficheiro de teste
        File file = Paths
                .get("src", "test", "resources", "test-file.txt")
                .toFile();


        fileUploadPage.upFile(file);


        $("h3").shouldBe(visible).shouldHave(text("File Uploaded"));


        assertEquals("test-file.txt", fileUploadPage.getUploadedFileName());
    }
}
