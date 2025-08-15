import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    // адрес тестируемого приложения
    private static final String SITE_URL = "https://qa-scooter.praktikum-services.ru/";

    protected WebDriver driver;

    @BeforeEach
    public void startUp() {
        driver = new ChromeDriver();
        driver.get(SITE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}