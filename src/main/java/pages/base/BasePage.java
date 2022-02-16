package pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    public void selectByValue(WebElement webElement, String value){
        new Select(webElement).selectByValue(value);
    }
}
