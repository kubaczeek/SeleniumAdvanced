package shopping;

import base.Pages;
import models.Basket;

public class BasketBaseTest extends Pages {

    protected String countTextProductInBasket(Basket basket) {
        int count = basket.getItemsQuantity();
        if (basket.getItemsQuantity() == 1) {
            return config.getPrefixOneProductInBasket() + " "
                    + count + " " + config.getSuffixOneProductInBasket();
        }
        return config.getPrefixProductsInBasket() + " "
                + count + " " + config.getSuffixProductsInBasket();
    }
}
