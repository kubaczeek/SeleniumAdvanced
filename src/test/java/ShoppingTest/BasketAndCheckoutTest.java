package ShoppingTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.shopping.BasketPage;
import pages.MainPage;
import pages.shopping.ProductDetailsPage;
import shop.Basket;
import shop.Product;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketAndCheckoutTest extends BaseTest {

    @Test
    public void BasketAndCheckoutTests() {
        Product product;
        Basket basket = new Basket();
        int i = 0;
        while (i < 5) {
            driver.get(config.getBASE_URL());
            MainPage mainPage = new MainPage(driver);
            mainPage.openRandomProduct();
            ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
            productDetailsPage.randomFillProduct();
            product = productDetailsPage.getProductToObject();
            addProductToBasket(product, basket);
            productDetailsPage.clickAddToCartButton();
            productDetailsPage.waitUntilPopUpLoaded(driver);
            productDetailsPage = new ProductDetailsPage(driver);
            Assert.assertEquals(productDetailsPage.textCountProductInBasket(), countTextProductInBasket(basket));
            i++;
        }

        driver.get(config.getBASKET_URL());

        BasketPage basketPage = new BasketPage(driver);
        ArrayList<Product> productsInBasketOnPage = new ArrayList<>();
        for (int j = 0; j < basket.getProductsInBasket().size(); j++) {
            productsInBasketOnPage.add(basketPage.getProductToObjectByIndexFromList(j));
        }

        for (int index = 0; index < basket.getProductsInBasket().size(); index++) {
            assertThat(productsInBasketOnPage.get(index)).usingRecursiveComparison()
                    .isEqualTo(basket.getProductByIndex(index));
        }
    }
}
