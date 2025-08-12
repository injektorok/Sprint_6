import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.FAQPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FAQTextTests {

    private WebDriver driver;

    @BeforeEach
    public void startUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void testFirstAnswer() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickFirstQuestion();
        String actual = objFAQPage.getFirstAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testSecondAnswer() {
        String expected = "Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, можете просто сделать несколько заказов — " +
                "один за другим.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickSecondQuestion();
        String actual = objFAQPage.getSecondAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testThirdAnswer() {
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат " +
                "8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickThirdQuestion();
        String actual = objFAQPage.getThirdAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testFourthAnswer() {
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickFourthQuestion();
        String actual = objFAQPage.getFourthAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testFifthAnswer() {
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
                "поддержку по красивому номеру 1010.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickFifthQuestion();
        String actual = objFAQPage.getFifthAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testSixthAnswer() {
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на " +
                "восемь суток — даже если будете кататься без передышек и во сне. " +
                "Зарядка не понадобится.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickSixthQuestion();
        String actual = objFAQPage.getSixthAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testSeventhAnswer() {
        String expected = "Да, пока самокат не привезли. Штрафа не будет, " +
                "объяснительной записки тоже не попросим. Все же свои.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickSeventhQuestion();
        String actual = objFAQPage.getSeventhAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @Test
    public void testEighthAnswer() {
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        FAQPage objFAQPage = new FAQPage(driver);
        objFAQPage.scrollAndClickEighthQuestion();
        String actual = objFAQPage.getEighthAnswer();
        assertEquals(expected, actual, "Текст под спойлером некорректен!");
    }

    @AfterEach
    public void teardown() {
        // Закрываем браузер
        driver.quit();
    }
}