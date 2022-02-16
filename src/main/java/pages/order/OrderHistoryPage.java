package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    @FindBy(xpath = "//*[contains(text(), 'Details')]")
    WebElement detailsButton;

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDetailsButton() {
        detailsButton.click();
    }
}
