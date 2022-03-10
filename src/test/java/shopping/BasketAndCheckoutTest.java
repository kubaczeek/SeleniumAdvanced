package shopping;

import models.Basket;
import models.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketAndCheckoutTest extends BasketBaseTest {
    @Test
    public void BasketAndCheckoutTests() {
        Basket basket = new Basket();
        int i = 0;

        while (i < 5) {
            driver.get(config.getBASE_URL());
            mainPage.openRandomProduct();
            productDetailsPage.randomFillProduct();

            basket.addProductToBasket(productDetailsPage.getProductToObject());
            productDetailsPage.clickAddToCartButton();
            Assert.assertEquals(productDetailsPage.textCountProductInBasket(), countTextProductInBasket(basket));
            i++;
        }

        driver.get(config.getBASKET_URL());

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
