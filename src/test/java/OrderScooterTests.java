import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_object.MainPage;
import page_object.OrderPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterTests extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String station;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String comment;

    // Конструктор для параметризованного теста
    public OrderScooterTests(String firstName, String lastName, String address, String station, String phoneNumber, String date, String rentPeriod, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phone = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentPeriod;
        this.comment = comment;
    }

    // Параметры для теста
    @Parameterized.Parameters
    public static List<Object[]> getTextData() {
        return List.of(
                new Object[]{"Покой", "Неукротимый", "Санкт-Петербург", "Площадь Революции", "+79089651313", "13.06.2024", "сутки", ""},
                new Object[]{"Свиток", "Призматический", "Северный проспект 89", "Щукинская", "89992011019", "20.06.2024", "четверо суток", "Комментарий к комментарию"}
        );
    }

    @Test
    public void checkOrderButtonTop() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConfirmButton();
        objMainPage.clickTopOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //заполнение первого шага
        objOrderPage.setFirstStep(firstName, lastName, address, station, phone);
        //заполнение второго шага
        objOrderPage.setSecondStep(date, rentalPeriod, comment);
        //проверка появления экрана с успешным заказом
        assertTrue(objOrderPage.isOrderSuccess());
    }

    @Test
    public void checkOrderButtonMiddle() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConfirmButton();
        objMainPage.clickMiddleOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //заполнение первого шага
        objOrderPage.setFirstStep(firstName, lastName, address, station, phone);
        //заполнение второго шага
        objOrderPage.setSecondStep(date, rentalPeriod, comment);
        //проверка появления экрана с успешным заказом
        assertTrue(objOrderPage.isOrderSuccess());
    }

    @Test
    public void checkOrderButtonMiddleWithChoosingColor() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConfirmButton();
        objMainPage.clickMiddleOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        //заполнение первого шага
        objOrderPage.setFirstStep(firstName, lastName, address, station, phone);
        //заполнение второго шага
        objOrderPage.setSecondStepWithChoosingColor(date, rentalPeriod, comment);
        //проверка появления экрана с успешным заказом
        assertTrue(objOrderPage.isOrderSuccess());
    }
}