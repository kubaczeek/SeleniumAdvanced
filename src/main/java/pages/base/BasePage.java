package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BasePage {

    public WebDriverWait wait;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static int randomIntInBound(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public void waitToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitToBeDisplayed(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void click(WebElement webElement) {
        waitToBeClickable(webElement);
        webElement.click();
    }

    public void selectByValue(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

}
