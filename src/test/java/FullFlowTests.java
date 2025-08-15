import org.junit.jupiter.api.Test;
import org.pages.ArendaPage;
import org.pages.ForWhomSamokatPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

// без параметризации

public class FullFlowTests extends BaseTest {

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

}