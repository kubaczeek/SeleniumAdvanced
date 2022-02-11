package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends PageHelpers{

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "a>span.hidden-sm-down")
    WebElement signInButton;

    @FindBy (css = ".logout")
    WebElement logOutButton;

    @FindBy (css = ".h2")
    WebElement elementMainPage;

    @FindBy(css = ".product")
    List<WebElement> popularProducts;

    public boolean pageLoaded(){
        return elementMainPage.isDisplayed();
    }

    public String elementMainPageText(){
        return elementMainPage.getText();
    }

    public void openRandomProduct(){
        popularProducts.get(randomIntInBound(popularProducts.size())).click();
    }

}
