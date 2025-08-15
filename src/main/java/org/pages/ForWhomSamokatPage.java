package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForWhomSamokatPage {

    private WebDriver driver;
    // кнопка для принятия использования куки-файлов
    private By cookiesButton = By.id("rcc-confirm-button");
    // кнопка "Заказать" верхняя и нижняя
    private By upperOrderButton = By.xpath(".//*[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button')]");
    private By lowerOrderButton = By.xpath(".//*[contains(@class, 'Home_FinishButton')]/button[contains(@class, 'Button_Middle')]");
    // блок "Для кого самокат"
    private By nameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private By surnameField = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private By addressField = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    private By stationField = By.xpath(".//input[contains(@placeholder, 'Станция')]");
    private By phoneField = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    private By nextButton = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");

    public ForWhomSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookiesButton() {
        driver.findElement(cookiesButton).click();
    }

    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    public void clickLowerOrderButton() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(lowerOrderButton));
        element.click();
    }

    // заполнение полей формы

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setStationField(String station) {
        driver.findElement(stationField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='select-search__select']")));

        String xpath = String.format(".//div[@class='select-search__select']/ul/li[@data-index='%s']/button", station);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // метод заполнения через верхнюю кнопку
    public void forWhomSamokatFilledUp(String name, String surname, String address, String station, String phoneNumber){
        clickCookiesButton();
        clickUpperOrderButton();
        setName(name);
        setSurname(surname);
        setAddress(address);
        setStationField(station);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }

    // метод заполнения через нижнюю кнопку
    public void forWhomSamokatFilledLow(String name, String surname, String address, String station, String phoneNumber){
        clickCookiesButton();
        clickLowerOrderButton();
        setName(name);
        setSurname(surname);
        setAddress(address);
        setStationField(station);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }
}