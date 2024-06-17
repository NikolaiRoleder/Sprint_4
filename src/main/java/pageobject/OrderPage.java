package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage extends BasePage {

    //конструктор класса с вызовом метода родительского класса
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //ПЕРВЫЙ ШАГ
    //локатор поля Имя
    private final By firstName = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    //локатор поля Фамилия
    private final By lastName = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    //локатор поля Адрес: куда привезти заказ
    private final By address = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    //локатор дропдауна Станция метро
    private final By metro = By.xpath(".//input[contains(@placeholder, 'метро')]");
    //список станций метро
    private final By metroList = By.xpath(".//div[@class='select-search__select']//div[starts-with(@class,'Order_Text')]");
    //локатор поля Телефон: на него позвонит курьер
    private final By phone = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    //локатор кнопки Далее
    private final By nextStepButton = By.xpath(".//button[text()='Далее']");

    //ВТОРОЙ ШАГ
    // поле для ввода даты
    private final By date = By.xpath(".//div[starts-with(@class, 'react-datepicker__input-container')]//input");
    //выбранная дата
    private final By dateSelected = By.className("react-datepicker__day--selected");
    //локатор дропдауна Срок аренды
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    //список сроков аренды
    private final By rentalPeriodList = By.className("Dropdown-option");
    //локатор черного цвета самоката
    private final By blackColorCheckbox = By.id("black");
    //локатор поля Комментарий для курьера
    private final By comment = By.xpath(".//input[contains(@placeholder, 'Комментарий')]");
    //локатор кнопки Заказать
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //локатор кнопки подтверждения заказа
    private final By orderConfirmButton = By.xpath(".//button[text()='Да']");
    //текст успешного оформления заказа
    private final By successOrder = By.xpath(".//div[text()='Заказ оформлен']");

    //метод для выбора элемента выпадающего списка
    private void chooseElementFromDropdown(By listOfElements, String elementToChoose) {
        List<WebElement> elementsFiltered = this.driver.findElements(listOfElements);
        for (WebElement element : elementsFiltered) {
            if (element.getText().equals(elementToChoose)) {
                element.click();
                break;
            }
        }
    }

    //заполнение первого шага формы
    public void setFirstStep(String firstName, String lastName, String address, String station, String phone) {
        waitForVisibilityOfElement(driver, this.firstName, 5);
        setValue(this.firstName, firstName);
        setValue(this.lastName, lastName);
        setValue(this.address, address);
        setValue(this.metro, station);
        chooseElementFromDropdown(metroList, station);
        setValue(this.phone, phone);
        clickElement(nextStepButton);
    }

    //заполнение второго шага формы
    public void setSecondStep(String date, String rentalPeriod, String comment) {
        waitForVisibilityOfElement(driver, this.date, 5);
        setValue(this.date, date);
        clickElement(dateSelected);
        clickElement(this.rentalPeriod);
        chooseElementFromDropdown(rentalPeriodList, rentalPeriod);
        setValue(this.comment, comment);
        clickElement(orderButton);
        waitForVisibilityOfElement(driver, orderConfirmButton, 5);
        clickElement(orderConfirmButton);
    }

    //заполнение второго шага формы c выбором цвета самоката
    public void setSecondStepWithChoosingColor(String date, String rentalPeriod, String comment) {
        waitForVisibilityOfElement(driver, this.date, 5);
        setValue(this.date, date);
        clickElement(dateSelected);
        clickElement(this.rentalPeriod);
        chooseElementFromDropdown(rentalPeriodList, rentalPeriod);
        clickElement(blackColorCheckbox);
        setValue(this.comment, comment);
        clickElement(orderButton);
        waitForVisibilityOfElement(driver, orderConfirmButton, 5);
        clickElement(orderConfirmButton);
    }

    //отображение успешного экрана
    public boolean isOrderSuccess() {
        return driver.findElement(successOrder).isDisplayed();
    }
}