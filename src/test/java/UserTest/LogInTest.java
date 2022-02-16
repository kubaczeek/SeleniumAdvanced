package UserTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.user.LogInPage;
import pages.user.MyAccountPage;

public class LogInTest extends BaseTest {

    @BeforeMethod
    public void InitPage() {
        driver.get(config.getLOG_IN_URL());
    }

    @Test
    public void LogInPageLoaded() {
        LogInPage loginPage = new LogInPage(driver);
        Assert.assertTrue(loginPage.pageLoaded());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, config.getLOG_IN_URL());
    }

    @Test
    public void LoginUserAlreadyRegistered() {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginUser(userFactory.getAlreadyRegisteredUser());
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getMY_ACCOUNT_URL());
    }

    @Test
    void SignOutUserFromMyAccountPage() {
        driver.get(config.getMY_ACCOUNT_URL());
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.signOutButtonClick();
        LogInPage logInPage = new LogInPage(driver);
        Assert.assertTrue(logInPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getLOG_IN_URL());
    }
}
