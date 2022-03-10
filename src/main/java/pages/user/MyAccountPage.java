package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class MyAccountPage extends BasePage {

    @FindBy(css = ".page-header")
    WebElement elementMyAccountPage;

    @FindBy(css = ".logout")
    WebElement logoutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public boolean pageLoaded() {
        return elementMyAccountPage.isDisplayed();
    }

    public void signOutButtonClick() {
        logoutButton.click();
    }
}
