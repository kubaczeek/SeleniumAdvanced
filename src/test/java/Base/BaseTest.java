package Base;

import common.Config;
import common.DriverFactory;
import common.UserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.io.FileNotFoundException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected UserFactory userFactory = new UserFactory();
    protected Config config = new Config();
    protected WebDriverWait wait;

    public MainPage mainPage; // czy dzięki temu kod nie jest bardziej przejrzysty?. Jezeli tego nie zrobie pozniej musze tworzyc nowy main page kilka razy MainPage mainPage = new MainPage(driver);
    // jezeli zostawie tak to tylko mainPage = new MainPage(driver)
    protected LogInPage loginPage;
    protected MyAccountPage myAccountPage;
    protected CreateAccountPage createAccountPage;
    protected PersonalInformationPage personalInformationPage;
    protected BasketPage basketPage;
    protected CategoryPage categoryPage;

    @BeforeClass
    public void setup() throws FileNotFoundException {
        DriverFactory driverFactory = new DriverFactory();
        config.loadConfig();
        driver = driverFactory.getDriver(config.getBrowser());
        driver.get(config.getBASE_URL());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
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

    public void goToPreviousPage(){
        driver.navigate().back();
    }
}
