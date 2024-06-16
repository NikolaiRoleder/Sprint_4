import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    WebDriver driver;

    @Before
    public void setUp() {
        //WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}