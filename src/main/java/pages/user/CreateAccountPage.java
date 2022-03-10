package pages.user;

import common.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CreateAccountPage extends BasePage {

    @FindBy(css = ".form-control[name~=\"firstname\"]")
    WebElement firstNameInput;

    @FindBy(css = ".form-control[name~=\"lastname\"]")
    WebElement lastNameInput;

    @FindBy(css = ".form-control[type~=\"email\"]")
    WebElement emailInput;

    @FindBy(css = ".form-control[type~=\"password\"]")
    WebElement passwordInput;

    @FindBy(css = ".form-control[name~=\"birthday\"]")
    WebElement birthdayInput;

    @FindBy(css = "[type~=\"checkbox\"]")
    List<WebElement> allCheckboxesToRegister;

    @FindBy(css = ".custom-radio")
    List<WebElement> socialTitleRadioButtons;

    @FindBy(css = ".page-header")
    WebElement elementCreateAccountPage;

    @FindBy(css = ".form-control-submit")
    WebElement saveButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser(User user) {
        if (user.getSocialTitle().equals("Mr"))
            socialTitleRadioButtons.get(0).click();
        if (user.getSocialTitle().equals("Mrs"))
            socialTitleRadioButtons.get(1).click();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        birthdayInput.sendKeys(user.getDateOfBirth());
        for (WebElement webElement : allCheckboxesToRegister) {
            webElement.click();
        }
        saveButton.click();
    }

    public boolean pageLoaded() {
        return elementCreateAccountPage.isDisplayed();
    }
}
