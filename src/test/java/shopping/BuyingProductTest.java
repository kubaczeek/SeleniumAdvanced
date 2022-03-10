package shopping;

import common.User;
import models.Basket;
import models.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;

public class BuyingProductTest extends BasketBaseTest {
    User user;
    Basket basket;

    @BeforeClass
    public void OpenMainPage() {
        user = userFactory.getRandomUser();
        basket = new Basket();
        driver.get(config.getCREATE_ACCOUNT_URL());
    }

    @Test
    public void BuyingProductTests() {
        createAccountPage.registerUser(user);

        String categoryNameBefore = mainPage.openRandomCategory();
        assertThat(categoryPage.getHeaderText()).isEqualToIgnoringCase(categoryNameBefore);
        assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText());

        String subcategoryNameBefore = categoryPage.openRandomSubcategory();
        assertThat(categoryPage.getHeaderText()).isEqualToIgnoringCase(subcategoryNameBefore);
        assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText());

        categoryPage.openRandomProduct();

        productDetailsPage.randomFillProduct();

        Product product = productDetailsPage.getProductToObject();

        basket.addProductToBasket(product);
        productDetailsPage.clickAddToCartButton();
        assertEquals(productDetailsPage.textCountProductInBasket(), countTextProductInBasket(basket));

        productDetailsPage.clickProceedToCheckoutBtn();

        Product productOnPage = basketPage.getProductToObjectByIndexFromList(0);
        verifyProduct(product, productOnPage);


        basketPage.clickProceedToCheckoutButton();

        orderPage.fillAddressForm(user)
                .clickContinueAddressBtn();

        orderPage.clickContinueShipBtn();

        String chosePaymentMethod = orderPage.clickRandomPaymentAndReturnText();

        orderPage.acceptTerms()
                .placeOrder();

        driver.get(config.getORDER_HISTORY_URL());

        orderHistoryPage.clickDetailsButton();

        Product productFromOrderDetails = orderDetailsPage.getProductToObjectFromPage();
        productFromOrderDetails.setName(productFromOrderDetails.getName().substring(0, product.getName().length()));
        assertThat(productFromOrderDetails).usingRecursiveComparison()
                .isEqualTo(product);
        assertEquals(orderDetailsPage.getPaymentMethodTextFromConfig(chosePaymentMethod, config), orderDetailsPage.getPaymentMethodText());
    }

    private void verifyProduct(Product product, Product productOnPage) {
        assertThat(productOnPage).usingRecursiveComparison().isEqualTo(product);
        assertThat(productOnPage.getTotalPrice()).isEqualTo(product.getTotalPrice());
        assertThat(productOnPage.getTotalPrice()).isEqualTo(basketPage.getTotalPrice());
    }
}

