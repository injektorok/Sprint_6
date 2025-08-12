import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.ArendaPage;
import org.pages.ForWhomSamokatPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullFlowTest {

    private WebDriver driver;
    String name;
    String surname;
    String address;
    String stationNumber;
    String phoneNumber;
    String day;
    String period;
    String color;
    String commentary;

 /*   public TestOrderPositiveFlow(String name, String surname, String address, String stationNumber, String phoneNumber, String day, String period, String color, String commentary) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stationNumber = stationNumber;
        this.phoneNumber = phoneNumber;
        this.day = day;
        this.period = period;
        this.color = color;
        this.commentary = commentary;
    }
*/
    public static List<Object[]> getTextData() {
        return Arrays.asList( new Object[][]{
                {"Алла", "Алексеев", "Москва", "2", "+79289472811", "003", "двое суток", "black", "Тест"},
                {"Кирилл", "Михайлович", "Курская", "5", "+79289765456", "006", "пятеро суток", "grey", "Коммент"},
        });
    }

    @BeforeEach
    public void startUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void orderPositiveFlow() {
        String expected = "Заказ оформлен";
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        ForWhomSamokatPage objForWhomSamokatPage = new ForWhomSamokatPage(driver);
        objForWhomSamokatPage.forWhomSamokatFilledUp("Шарип", "Алексеев",
                "Москва", "2","+79289472811");
        ArendaPage objArendaPage = new ArendaPage(driver);
        objArendaPage.arendaPagetFilled("003", "двое суток", "black", "Тест");
        String actual = objArendaPage.getSuccessMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    public void orderPositiveSecondFlow() {
        String expected = "Заказ оформлен";
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        ForWhomSamokatPage objForWhomSamokatPage = new ForWhomSamokatPage(driver);
        objForWhomSamokatPage.forWhomSamokatFilledLow("Антипа", "Михайлович",
                "Курская", "5", "+79289765456");
        ArendaPage objArendaPage = new ArendaPage(driver);
        objArendaPage.arendaPagetFilled("006", "пятеро суток", "grey", "Коммент");
        String actual = objArendaPage.getSuccessMessage();
        assertTrue(actual.contains(expected));
    }

    @AfterEach
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
