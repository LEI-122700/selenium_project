package iscte.ista.selenium_project;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileUploadPage {
    private final String url = "https://the-internet.herokuapp.com/upload";

    // Elementos principais
    private SelenideElement fileInput = $("#file-upload");       // input type="file"
    private SelenideElement uploadButton = $("#file-submit");    // botão Upload
    private SelenideElement dragDropArea = $("#drag-drop-upload"); // zona tracejada (drag & drop)
    private SelenideElement uploadedFiles = $("#uploaded-files"); // nome do ficheiro depois do upload
    private SelenideElement header = $("h3");                    // título "File Uploaded!"

    public void openPage() {
        open(url);
    }

    // Upload via input normal
    public void upFile(File file) {
        fileInput.uploadFile(file);   // Selenide trata do “Escolher ficheiro”
        uploadButton.click();
    }

    public String getUploadedFileName() {
        return uploadedFiles.getText().trim();
    }

    public String getHeaderText() {
        return header.getText().trim();
    }
}
