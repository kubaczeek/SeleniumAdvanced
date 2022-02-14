import common.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.PersonalInformationPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserRegistrationTest extends BaseTest {

    @BeforeClass
    public void InitPage() {
        driver.get(config.getCREATE_ACCOUNT_URL());
        Assert.assertEquals(driver.getCurrentUrl(), config.getCREATE_ACCOUNT_URL());
        createAccountPage = new CreateAccountPage(driver);
    }

    @Test
    public void RegisterUserAndCheckPersonalInfo() {
        User user = userFactory.getRandomUser();
        createAccountPage.registerUser(user);
        driver.get(config.getPERSONAL_INFORMATION_URL());
        personalInformationPage = new PersonalInformationPage(driver);
        Assert.assertEquals(personalInformationPage.getFirstName(), user.getFirstName());
        Assert.assertEquals(personalInformationPage.getLastName(), user.getLastName());
        Assert.assertEquals(personalInformationPage.getEmail(), user.getEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Assert.assertEquals(LocalDate.parse(personalInformationPage.getDateOfBirthday(), formatter), LocalDate.parse(user.getDateOfBirth(), formatter));

        personalInformationPage.logout();
        loginPage = new LogInPage(driver);
        Assert.assertTrue(loginPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getSIGN_OUT_URL());

        loginPage.loginUser(user);
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.pageLoaded());
        Assert.assertEquals(driver.getCurrentUrl(), config.getPERSONAL_INFORMATION_URL());
    }
}
