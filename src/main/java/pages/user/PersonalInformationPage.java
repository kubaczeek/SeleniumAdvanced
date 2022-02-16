package pages.user;

import common.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalInformationPage {

    public PersonalInformationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-header")
    WebElement elementPersonalInformationPage;

    @FindBy(css = ".logout")
    WebElement logoutButton;

    @FindBy(css = "[name~=\"firstname\"]")
    WebElement firstNameInput;

    @FindBy(css = "[name~=\"lastname\"]")
    WebElement lastNameInput;

    @FindBy(css = "[type~=\"email\"]")
    WebElement emailInput;

    @FindBy(css = "[name~=\"birthday\"]")
    WebElement birthdayInput;

    @FindBy(css = "[type~=\"checkbox\"]")
    List<WebElement> allCheckboxesToRegister;

    @FindBy(css = ".custom-radio")
    List<WebElement> socialTitleRadioButtons;

    public boolean pageLoaded() {
        return elementPersonalInformationPage.isDisplayed();
    }

    public boolean firstNameValid(User user){
        return firstNameInput.getText().equals(user.getFirstName());
    }

    public boolean lastNameValid(User user){
        return lastNameInput.getText().equals(user.getLastName());
    }

    public String getFirstName() {
        return firstNameInput.getAttribute("value");
    }

    public String getLastName() {
        return lastNameInput.getAttribute("value");
    }

    public String getEmail() {
        return emailInput.getAttribute("value");
    }

    public String getDateOfBirthday() {
        return birthdayInput.getAttribute("value");
    }

    public void logout(){
        logoutButton.click();
    }
}
