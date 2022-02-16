package UserTest;

import Base.BaseTest;
import common.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.user.CreateAccountPage;
import pages.user.LogInPage;
import pages.user.MyAccountPage;
import pages.user.PersonalInformationPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserRegistrationTest extends BaseTest {

    @BeforeClass
    public void InitPage() {
        driver.get(config.getCREATE_ACCOUNT_URL());
        Assert.assertEquals(driver.getCurrentUrl(), config.getCREATE_ACCOUNT_URL());
    }

    @Test
    public void RegisterUserAndCheckPersonalInfo() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        User user = userFactory.getRandomUser();
        createAccountPage.registerUser(user);
        driver.get(config.getPERSONAL_INFORMATION_URL());
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        Assert.assertEquals(personalInformationPage.getFirstName(), user.getFirstName());
        Assert.assertEquals(personalInformationPage.getLastName(), user.getLastName());
        Assert.assertEquals(personalInformationPage.getEmail(), user.getEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Assert.assertEquals(LocalDate.parse(personalInformationPage.getDateOfBirthday(), formatter), LocalDate.parse(user.getDateOfBirth(), formatter));

        personalInformationPage.logout();
        LogInPage logInPage = new LogInPage(driver);
        Assert.assertTrue(logInPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getSIGN_OUT_URL());

        logInPage.loginUser(user);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getPERSONAL_INFORMATION_URL());
    }
}
