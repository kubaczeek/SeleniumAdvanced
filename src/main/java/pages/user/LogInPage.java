package pages.user;

import common.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//*[@class='form-control']")
    WebElement emailInput;

    @FindBy(css = ".js-visible-password")
    WebElement passwordInput;

    @FindBy(css = "#submit-login")
    WebElement signSubmitInButton;

    @FindBy(css = ".page-header")
    WebElement elementLogInPage;

    public LogInPage(WebDriver driver) {
        super(driver);
    }


    public LogInPage sendKeysToElement(WebElement webElement, String keys) {
        webElement.sendKeys(keys);
        return this;
    }

    public void loginUser(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        signSubmitInButton.click();
    }

    public boolean pageLoaded() {
        return elementLogInPage.isDisplayed();
    }
}
