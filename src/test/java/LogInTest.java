import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MyAccountPage;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void InitPage() {
        driver.get(LOG_IN_URL);
        loginPage = new LogInPage(driver);

//        loginPage = PageFactory.initElements(driver, LogInPage.class);
    }

    @Test
    public void LogInPageLoaded() {
        Assert.assertTrue(loginPage.pageLoaded());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, LOG_IN_URL);
    }

    @Test
    public void LoginUserAlreadyRegistered() {
        loginPage.loginUser(userFactory.getAlreadyRegisteredUser());
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), MY_ACCOUNT_URL);
    }

    @Test
    void SignOutUserFromMyAccountPage() {
        driver.get(MY_ACCOUNT_URL);
        myAccountPage.signOutButtonClick();
        Assert.assertTrue(loginPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), LOG_IN_URL);
    }
}
