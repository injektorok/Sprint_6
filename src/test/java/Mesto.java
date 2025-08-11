import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mesto {
    private WebDriver driver;

    @Test
    void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Найди поле "Email" и заполни его
        driver.findElement(By.id("email")).sendKeys("some_email");
        // Найди поле "Пароль" и заполни его
        driver.findElement(By.id("password")).sendKeys("some_password");
        // Найди кнопку "Войти" и кликни по ней
        driver.findElement(By.className("auth-form__button")).click();
    }

    @AfterEach
    void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
