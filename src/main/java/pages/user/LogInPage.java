package pages.user;

import common.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='form-control']")
    WebElement emailInput;

    @FindBy(css = ".js-visible-password")
    WebElement passwordInput;

    @FindBy(css = "#submit-login")
    WebElement signSubmitInButton;

    @FindBy(css = ".page-header")
    WebElement elementLogInPage;


    public LogInPage sendKeysToElement(WebElement webElement, String keys) {
        webElement.sendKeys(keys);
        return this;
    }

    public void loginUser(User user){
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        signSubmitInButton.click();
    }

    public boolean pageLoaded() {
        return elementLogInPage.isDisplayed();
    }
}
