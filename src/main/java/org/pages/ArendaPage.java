package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArendaPage {

    private WebDriver driver;

    // поля страницы "Про Аренду"
    private By calendarField = By.cssSelector(".react-datepicker__input-container");
    private By arendaPeriodField = By.cssSelector(".Dropdown-placeholder");
    private By commentaryField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private By finalOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Заказать']");
    private By confirmOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Да']");

    // сообщение об успешно принятом заказе (только для FireFox!)
    private By successMessage = By.xpath(".//*[text()='Заказ оформлен']");

    public ArendaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCalendarField(String day) {
        driver.findElement(calendarField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-datepicker-ignore-onclickoutside")));
        String cssSelector = String.format(".react-datepicker__day--%s", day);
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public void setArendaPeriodField(String period) {
        driver.findElement(arendaPeriodField).click();
        String xpath2 = String.format(".//div[@class='Dropdown-menu']/div[contains(text(), '%s')]", period);
        driver.findElement(By.xpath(xpath2)).click();
    }

    public void setSamokatColor(String color) {
        String id = String.format("%s", color);
        driver.findElement(By.id(id)).click();
    }

    public void setCommentaryField(String commentary) {
        driver.findElement(commentaryField).sendKeys(commentary);
    }

    public void clickFinalOrderButton() {

        var button = driver.findElement(finalOrderButton);
        button.click();
    }

    public void clickConfirmationOrderButton() {
        var button = driver.findElement(confirmOrderButton);
        button.click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void arendaPageFilled(String day, String period, String color, String commentary){
        setCalendarField(day);
        setArendaPeriodField(period);
        setSamokatColor(color);
        setCommentaryField(commentary);
        clickFinalOrderButton();
        clickConfirmationOrderButton();
    }
}