import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductDetailsPage;
import shop.Basket;
import shop.Product;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketAndCheckoutTest extends BaseTest {

    @BeforeClass
    public void OpenMainPage() {
        driver.get(BASE_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    public void BasketAndCheckoutTest() {
        Product product;
        Basket basket = new Basket();
        int i = 0;
        while (i < 5) {
            driver.get(BASE_URL);
            mainPage = new MainPage(driver);
            mainPage.openRandomProduct();
            productDetailsPage = new ProductDetailsPage(driver);
            productDetailsPage.randomFillProduct();
            product = productDetailsPage.getProductToObject();
            addProductToBasket(product, basket);
            productDetailsPage.clickAddToCartButton();
            productDetailsPage.waitUntilPopUpLoaded(driver);
            productDetailsPage = new ProductDetailsPage(driver);
            Assert.assertEquals(productDetailsPage.textCountProductInBasket(), countTextProductInBasket(basket));
            i++;
        }

        driver.get(BASKET_URL);

        BasketPage basketPage = new BasketPage(driver);
        ArrayList<Product> productsInBasketOnPage = new ArrayList<>();
        for (int j = 0; j < basket.getProductsInBasket().size(); j++) {
            productsInBasketOnPage.add(basketPage.getProductToObjectByIndexFromList(j));
        }


        for (int index = 0; index < basket.getProductsInBasket().size(); index++) {
            assertThat(productsInBasketOnPage.get(index))
                    .isEqualToComparingFieldByField(basket.getProductByIndexFromBasket(index));
        }
        System.out.println("ASDASDASFGEAGHWFWE");
    }

    private String countTextProductInBasket(Basket basket) {
        int count = countItemsInBasket(basket);
        if (count == 1) {
            return "There is " + count + " item in your cart.";
        } else {
            return "There are " + count + " items in your cart.";
        }
    }

    private void addProductToBasket(Product product, Basket basket) {
        boolean isInBasket = false;
        for (Product productFromBasket : basket.getProductsInBasket()) {
            if (productFromBasket.getName().equals(product.getName()) && productFromBasket.getPrice() == product.getPrice()) {
                productFromBasket.setQuantity(productFromBasket.getQuantity() + product.getQuantity());
                isInBasket = true;
            }
        }
        if (!isInBasket)
            basket.addProduct(product);
    }

    private int countItemsInBasket(Basket basket) {
        int count = 0;
        for (Product productFromBasket : basket.getProductsInBasket()) {
            count += productFromBasket.getQuantity();
        }
        return count;
    }
}
