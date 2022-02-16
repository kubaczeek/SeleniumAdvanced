package ShoppingTest;

import Base.BaseTest;
import common.User;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.order.OrderDetailsPage;
import pages.order.OrderHistoryPage;
import pages.order.OrderPage;
import pages.shopping.BasketPage;
import pages.shopping.CategoryPage;
import pages.shopping.ProductDetailsPage;
import pages.user.CreateAccountPage;
import shop.Basket;
import shop.Product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BuyingProductTest extends BaseTest {
    @BeforeClass
    public void OpenMainPage() {
        driver.get(config.getBASE_URL());
    }

    @Test
    public void BuyingProductTests() {
        Product product;
        Basket basket = new Basket();
        String categoryNameBefore, subcategoryNameBefore;

        User user = userFactory.getRandomUser(); // get random user
        driver.get(config.getCREATE_ACCOUNT_URL());
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.registerUser(user); // register random user

        MainPage mainPage = new MainPage(driver);
        WebElement randomCategory = mainPage.getRandomCategory(); // get random category
        categoryNameBefore = randomCategory.getText(); // store in variable name category
        randomCategory.click(); // go into category

        CategoryPage categoryPage = new CategoryPage(driver);
        assertThat(categoryPage.getHeaderText()) // assert that name is chose category is equals with actual on page
                .isEqualToIgnoringCase(categoryNameBefore);
        Assert.assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText()); // assert that text with count product is equal with number of products on page
        WebElement randomSubcategory = categoryPage.getRandomSubcategory(); // get random subcategory
        subcategoryNameBefore = randomSubcategory.getText(); // store in variable name subcategory
        randomSubcategory.click(); // go into subcategory

        categoryPage = new CategoryPage(driver);
        assertThat(categoryPage.getHeaderText()) // assert that name is chose subcategory is equals with actual on page
                .isEqualToIgnoringCase(subcategoryNameBefore);
        Assert.assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText()); // assert that text with count product is equal with number of products on page
        WebElement randomProduct = categoryPage.getRandomProduct(); // get random product
        randomProduct.click(); // go into product

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.randomFillProduct(); // random choose quantity
        product = productDetailsPage.getProductToObject(); // get product to Object from details page
        addProductToBasket(product, basket); // add product to Basket with validation. If product is on basket only increase quantity
        productDetailsPage.clickAddToCartButton(); // add do cart //TODO 1. if product is unavailable add another to basket 2. customizable product
        productDetailsPage.waitUntilPopUpLoaded(driver); // wait until Popup is visible
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.textCountProductInBasket(), countTextProductInBasket(basket)); // assert that text in popup is equals to quantity products in your basket
        productDetailsPage.clickProceedToCheckoutBtn(); // click add to cart btn

        BasketPage basketPage = new BasketPage(driver);
        Product productOnPage = basketPage.getProductToObjectByIndexFromList(0); // get first and only (in that case) product
        Assertions.assertThat(productOnPage).usingRecursiveComparison()// assert equals product stored in variable, and product from page
                .isEqualTo(product);
        Assertions.assertThat(productOnPage.getQuantity() * productOnPage.getPrice()) // assert price product on page and product in variable
                .isEqualTo(product.getQuantity() * product.getPrice());
        Assertions.assertThat(productOnPage.getQuantity() * productOnPage.getPrice())
                .isEqualTo(basketPage.getTotalPriceFloat(), Assertions.offset((float) 0.01));
        basketPage.clickProceedToCheckoutButton(); // click add to cart button

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillAddressForm(user) // fill address form (to make this more simple, I've added to User class address information)
                .clickContinueAddressBtn(); // click continue button

        orderPage = new OrderPage(driver);
        orderPage.clickContinueShipBtn(); //click continue button

        orderPage = new OrderPage(driver);
        String chosePaymentMethod = orderPage.clickRandomPaymentAndReturnText(); //click random payment button
        orderPage.acceptTerms() //click accept terms button
                .placeOrder(); // click place order button
        driver.get(config.getORDER_HISTORY_URL()); // go to order history page

        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.clickDetailsButton(); // go to order's details

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        Product productFromOrderDetails = orderDetailsPage.getProductToObjectFromPage();
        productFromOrderDetails.setName(productFromOrderDetails.getName().substring(0, product.getName().length())); // change product's from page name because it contains size and color sometimes
        Assertions.assertThat(productFromOrderDetails).usingRecursiveComparison() // assert product stored in variable is equal to product form page
                .isEqualTo(product);
        Assert.assertEquals(orderDetailsPage.getPaymentMethodTextFromConfig(chosePaymentMethod, config), orderDetailsPage.getPaymentMethodText()); //assert payment method is okay
    }
}

