import common.UserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.util.Random;

public class BaseTest {
    WebDriver driver;
    UserFactory userFactory = new UserFactory();

    String BASE_URL = "http://146.59.32.4/index.php"; // TODO Class Configuration properties
    String LOG_IN_URL = "http://146.59.32.4/index.php?controller=authentication&back=my-account"; // TODO Class Configuration properties
    String MY_ACCOUNT_URL = "http://146.59.32.4/index.php?controller=my-account"; // TODO Class Configuration properties
    String CREATE_ACCOUNT_URL = "http://146.59.32.4/index.php?controller=authentication&create_account=1"; // TODO Class Configuration properties
    String PERSONAL_INFORMATION_URL = "http://146.59.32.4/index.php?controller=identity"; // TODO Class Configuration properties
    String SIGN_OUT_URL = "http://146.59.32.4/index.php?controller=authentication&back=identity"; // TODO Class Configuration properties
    String BASKET_URL = "http://146.59.32.4/index.php?controller=cart&action=show"; // TODO Class Configuration properties

    MainPage mainPage;
    LogInPage loginPage;
    MyAccountPage myAccountPage;
    CreateAccountPage createAccountPage;
    PersonalInformationPage personalInformationPage;
    ProductDetailsPage productDetailsPage;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String textToAlert) {
        driver.switchTo().alert().sendKeys(textToAlert);
    }
}
