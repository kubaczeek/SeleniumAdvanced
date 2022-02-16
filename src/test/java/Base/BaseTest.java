package Base;

import common.Config;
import common.DriverFactory;
import common.UserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import shop.Basket;
import shop.Product;

import java.io.FileNotFoundException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected UserFactory userFactory = new UserFactory();
    protected Config config = new Config();
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() throws FileNotFoundException {
        DriverFactory driverFactory = new DriverFactory();
        config.loadConfig();
        driver = driverFactory.getDriver(config.getBrowser());
        driver.get(config.getBASE_URL());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void goToPreviousPage() {
        driver.navigate().back();
    }

    protected String countTextProductInBasket(Basket basket) {
        int count = countItemsInBasket(basket);
        if (count == 1) {
            return config.getPrefixOneProductInBasket() + " "
                    + count + " " + config.getSuffixOneProductInBasket();
        } else {
            return config.getPrefixProductsInBasket() + " "
                    + count + " " + config.getSuffixProductsInBasket();
        }
    }

    private int countItemsInBasket(Basket basket) {
        int count = 0;
        for (Product productFromBasket : basket.getProductsInBasket()) {
            count += productFromBasket.getQuantity();
        }
        return count;
    }

    protected void addProductToBasket(Product product, Basket basket) {
        for (Product productFromBasket : basket.getProductsInBasket()) {
            if (productFromBasket.getName().equals(product.getName()) && productFromBasket.getPrice() == product.getPrice()) {
                productFromBasket.setQuantity(productFromBasket.getQuantity() + product.getQuantity());
                return;
            }
        }
        basket.addProduct(product);
    }
}
