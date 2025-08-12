import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.ArendaPage;
import org.pages.ForWhomSamokatPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullFlowTest {

    private WebDriver driver;

    @BeforeEach
    public void startUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void orderPositiveFlowButtonUp() {
        ForWhomSamokatPage objForWhomSamokatPage = new ForWhomSamokatPage(driver);
        // заполнение карточки клиента
        objForWhomSamokatPage.forWhomSamokatFilledUp("Пётр", "Алексеев",
                "Москва", "5","+79289472811");
        // заполнение полей "про аренду"
        ArendaPage objArendaPage = new ArendaPage(driver);
        objArendaPage.arendaPageFilled("003", "двое суток", "black", "Тест");

        String actual = objArendaPage.getSuccessMessage();
        assertTrue(actual.contains("Заказ оформлен"));
    }

    @Test
    public void orderPositiveSecondFlowButtonLow() {
        ForWhomSamokatPage objForWhomSamokatPage = new ForWhomSamokatPage(driver);
        // заполнение карточки клиента
        objForWhomSamokatPage.forWhomSamokatFilledLow("Антипа", "Михайлович",
                "Курская", "4", "+79289765456");
        // заполнение полей "про аренду"
        ArendaPage objArendaPage = new ArendaPage(driver);
        objArendaPage.arendaPageFilled("006", "пятеро суток", "grey", "Коммент");

        String actual = objArendaPage.getSuccessMessage();
        assertTrue(actual.contains("Заказ оформлен"));
    }

    @AfterEach
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}