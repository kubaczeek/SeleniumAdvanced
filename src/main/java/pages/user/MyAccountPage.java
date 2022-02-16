package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-header")
    WebElement elementMyAccountPage;

    @FindBy(css = ".logout")
    WebElement logoutButton;

    public boolean pageLoaded() {
        return elementMyAccountPage.isDisplayed();
    }

    public void signOutButtonClick() {
        logoutButton.click();
    }
}
