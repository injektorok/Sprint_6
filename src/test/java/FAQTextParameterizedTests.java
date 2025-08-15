import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.FAQPage;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

// с параметризацией

public class FAQTextParameterizedTests extends BaseTest {

    // общий локатор для блока вопрос-ответ
    String commonQuestionLocator = "accordion__heading-" + "x";
    String commonAnswerLocator = ".//*[@id = 'accordion__panel-x']/p";
    private By commonQuestion = By.id(commonQuestionLocator);
    private By commonAnswer = By.xpath(commonAnswerLocator);

    // общие методы для работы с текстовым блоком
    public void scrollAndClickCommonQuestion(String index) {
        // присвоение общему локатору конкретного индекса
        this.commonQuestionLocator = commonQuestionLocator.replaceAll("x", index);
        this.commonQuestion = By.id(commonQuestionLocator);

        WebElement element = driver.findElement(commonQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(commonQuestion));
    }

    public String getCommonAnswer(String index) {
        // присвоение общему локатору конкретного индекса
        this.commonAnswerLocator = commonAnswerLocator.replaceAll("x", index);
        this.commonAnswer = By.id(commonAnswerLocator);

        return driver.findElement(commonAnswer).getText();
    }

    // текстовки для проверки
    String[] expectedTexts  = new String[] {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. \" +\n" +
                    "                \"Если хотите покататься с друзьями, можете просто сделать несколько заказов — \" +\n" +
                    "                \"один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. \" +\n" +
                    "                \"Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат \" +\n" +
                    "                \"8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в \" +\n" +
                    "                \"поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на \" +\n" +
                    "                \"восемь суток — даже если будете кататься без передышек и во сне. \" +\n" +
                    "                \"Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, \" +\n" +
                    "                \"объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    @ParameterizedTest
    @CsvSource({
            "expectedTexts[0], 0",
            "expectedTexts[1], 1",
            "expectedTexts[2], 2",
            "expectedTexts[3], 3",
            "expectedTexts[4], 4",
            "expectedTexts[5], 5",
            "expectedTexts[6], 6",
            "expectedTexts[7], 7"
    })
    public void testForCheckingAllTexts(String expected, String index) {
        scrollAndClickCommonQuestion(index);
        String actual = getCommonAnswer(index);
        assertEquals(expected, actual, "Текст под спойлером "+ index +" некорректен!");
    }
}