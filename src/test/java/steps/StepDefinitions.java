package steps;

import io.cucumber.java.pt.Dado;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private WebDriver driver;


    public void tirarScreenshot(String nomeArquivo) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File screenshotsDir = new File("screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }
            FileUtils.copyFile(screenshot, new File("screenshots/" + nomeArquivo + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Dado("que acesso à página")
    public void que_acesso_à_página() {
        // Configura o WebDriverManager para gerenciar o ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Configura opções do Chrome
        ChromeOptions options = new ChromeOptions();
        
        // Verifica se está rodando em CI (GitHub Actions) ou localmente
        String ci = System.getenv("CI");
        if (ci != null && ci.equals("true")) {
            // Modo headless para CI (sem interface gráfica)
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        }
        options.addArguments("--window-size=1920,1080");
        
        driver = new ChromeDriver(options);
        driver.get("https://mediumseagreen-sheep-627446.hostingersite.com/");
        tirarScreenshot("acesso");

    }
    @Dado("informo um nome {string}")
    public void informo_um_nome(String nome) {
        driver.findElement(By.id("nome")).sendKeys(nome);
        // Assert para garantir que o valor foi inserido no campo
        String valorCampo = driver.findElement(By.id("nome")).getAttribute("value");
        assertEquals(nome, valorCampo, "O nome inserido não está correto");

        tirarScreenshot("nome");
    }

    @Dado("informo um sobre {string}")
    public void informo_um_sobre(String sobrenome) {
        driver.findElement(By.id("sobrenome")).sendKeys(sobrenome);
        String valorCampo = driver.findElement(By.id("sobrensssome")).getAttribute("value");
        assertEquals(sobrenome, valorCampo, "O sobrenome inserido não está correto");

        tirarScreenshot("sobrenome");
    }


}