package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    //конструктор класса с вызовом метода родительского класса
    public MainPage(WebDriver driver){
        super(driver);
    }

    // Кнопка согласия с куками
    private final By confirmButton = By.id("rcc-confirm-button");
    // локатор кнопки Заказать в хедере
    private final By orderButtonTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // локатор кнопки Заказать в центре страницы
    private final By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //локатор пункта с вопросом
    private final String questionPoint = "accordion__heading-%d";
    //локатор панели аккордеона
    private final String answerInDropdownPanel = "accordion__panel-%d";

    public String getPanelText(int panelIndex) {
        //ожидание загрузки в течение 5 сек
        waitForVisibilityOfElement(driver,confirmButton,5);
        //согласиться с использованием кук, так как панель закрывает аккордеон
        clickCookieConfirmButton();
        // Открываем вопрос, чтобы увидеть ответ
        driver.findElement(By.id(String.format(questionPoint,panelIndex))).click();
        //ожидаем отображения текста в панели аккордеона
        waitForVisibilityOfElement(driver,By.id(String.format(answerInDropdownPanel,panelIndex)),5);
        // Получаем текст ответа, который является следующим элементом после вопроса
        return driver.findElement(By.id(String.format(answerInDropdownPanel,panelIndex))).getText();
    }

    public void clickTopOrderButton() {
        driver.findElement(orderButtonTop).click();
    }
    public void clickMiddleOrderButton() {
        driver.findElement(orderButtonMiddle).click();
    }
    public void clickCookieConfirmButton(){
        driver.findElement(confirmButton).click();
    }
}