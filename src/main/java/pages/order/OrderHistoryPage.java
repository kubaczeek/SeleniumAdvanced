package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderHistoryPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Details')]")
    WebElement detailsButton;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickDetailsButton() {
        detailsButton.click();
    }
}
