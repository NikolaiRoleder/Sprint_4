import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderScooterTests extends BaseTest {

    @Test
    public void checkOrderButtonTop() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        //нажатие на кнопку согласия с куками
        objMainPage.clickCookieConfirmButton();
        objMainPage.clickTopOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //заполнение первого шага
        objOrderPage.setFirstStep("Покой", "Неукротимый", "Санкт-Петербург", "Площадь Революции", "+79089651313");
        //заполнение второго шага
        objOrderPage.setSecondStep( "13.06.2024", "сутки", "");
        //проверка появления экрана с успешным заказом
        assertTrue(objOrderPage.isOrderSuccess());
    }

    @Test
    public void checkOrderButtonMiddleWithChoosingColor() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        //нажатие на кнопку согласия с куками
        objMainPage.clickCookieConfirmButton();
        objMainPage.clickMiddleOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //заполнение первого шага
        objOrderPage.setFirstStep("Свиток", "Призматический", "Северный проспект 89", "Щукинская", "89992011019");
        //заполнение второго шага
        objOrderPage.setSecondStepWithChoosingColor("20.06.2024", "четверо суток", "Комментарий к комментарию");
        //проверка появления экрана с успешным заказом
        assertTrue(objOrderPage.isOrderSuccess());
    }
}