package base;

import org.testng.annotations.BeforeMethod;
import pages.order.OrderDetailsPage;
import pages.order.OrderHistoryPage;
import pages.order.OrderPage;
import pages.shopping.BasketPage;
import pages.shopping.CategoryPage;
import pages.shopping.MainPage;
import pages.shopping.ProductDetailsPage;
import pages.user.CreateAccountPage;
import pages.user.LogInPage;
import pages.user.MyAccountPage;
import pages.user.PersonalInformationPage;

public class Pages extends TestBase {
    public MainPage mainPage;
    public ProductDetailsPage productDetailsPage;
    public BasketPage basketPage;

    public CategoryPage categoryPage;
    public OrderPage orderPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderDetailsPage orderDetailsPage;
    public CreateAccountPage createAccountPage;
    public LogInPage logInPage;
    public MyAccountPage myAccountPage;
    public PersonalInformationPage personalInformationPage;


    @BeforeMethod
    public void pagedSetup() {
        mainPage = new MainPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        basketPage = new BasketPage(driver);
        categoryPage = new CategoryPage(driver);
        orderPage = new OrderPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        logInPage = new LogInPage(driver);
        myAccountPage = new MyAccountPage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
    }
}
