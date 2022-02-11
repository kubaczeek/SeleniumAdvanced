package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class PageHelpers {
    public WebDriverWait wait;

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

    public void click(WebElement webElement){
        waitToBeClickable(webElement);
        webElement.click();
    }

}
