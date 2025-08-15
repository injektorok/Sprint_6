import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.pages.ArendaPage;
import org.pages.ForWhomSamokatPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

// с параметризацией

public class FullFlowParameterizedTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "up, Пётр, Алексеев, Москва, 5, +79289472811, 003, двое суток, black, Тест",
            "low, Артур, Король, Курская, 4, +79289765456, 006, пятеро суток, grey, Коммент"
    })
    public void orderPositiveTwoScenarios(String buttonType, String name, String surname, String address, String station, String phoneNumber,
                                          String day, String period, String color, String commentary) {
        ForWhomSamokatPage objForWhomSamokatPage = new ForWhomSamokatPage(driver);

        // заполнение карточки клиента
        if (buttonType.equals("up")) {
            // через верхнюю кнопку
            objForWhomSamokatPage.forWhomSamokatFilledUp (name, surname, address, station, phoneNumber);
        }
        else {
            // через нижнюю кнопку
            objForWhomSamokatPage.forWhomSamokatFilledLow (name, surname, address, station, phoneNumber);
        }

        // заполнение полей страницы "про аренду"
        ArendaPage objArendaPage = new ArendaPage(driver);
        objArendaPage.arendaPageFilled(day, period, color, commentary);

        // проверка успешного оформления заказа
        String finalMessage = objArendaPage.getSuccessMessage();
        assertTrue(finalMessage.contains("Заказ оформлен"));
    }
}