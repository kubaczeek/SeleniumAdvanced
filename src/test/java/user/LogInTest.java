package user;

import base.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends Pages {

    @BeforeMethod
    public void InitPage() {
        driver.get(config.getLOG_IN_URL());
    }

    @Test
    public void LogInPageLoaded() {
        Assert.assertTrue(logInPage.pageLoaded());
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, config.getLOG_IN_URL());
    }

    @Test
    public void LoginUserAlreadyRegistered() {
        logInPage.loginUser(userFactory.getAlreadyRegisteredUser());
        Assert.assertTrue(myAccountPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getMY_ACCOUNT_URL());
    }

    @Test
    void SignOutUserFromMyAccountPage() {
        driver.get(config.getMY_ACCOUNT_URL());
        myAccountPage.signOutButtonClick();
        Assert.assertTrue(logInPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getLOG_IN_URL());
    }
}
