package base;

import common.Config;
import common.DriverFactory;
import common.UserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;

public class TestBase {
    protected WebDriver driver;
    protected UserFactory userFactory = new UserFactory();
    protected Config config = new Config();

    @BeforeClass
    public void setup() throws FileNotFoundException {
        DriverFactory driverFactory = new DriverFactory();
        config.loadConfig();
        driver = driverFactory.getDriver(config.getBrowser());
        driver.get(config.getBASE_URL());
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void goToPreviousPage() {
        driver.navigate().back();
    }
}
