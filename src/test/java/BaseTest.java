import common.Config;
import common.DriverFactory;
import common.UserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.io.FileNotFoundException;

public class BaseTest {
    WebDriver driver;
    UserFactory userFactory = new UserFactory();
    Config config = new Config();

    MainPage mainPage;
    LogInPage loginPage;
    MyAccountPage myAccountPage;
    CreateAccountPage createAccountPage;
    PersonalInformationPage personalInformationPage;
    BasketPage basketPage;

    @BeforeClass
    public void setup() throws FileNotFoundException {
        config.loadConfig();
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(config.getBrowser());
        driver.get(config.getBASE_URL());
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
