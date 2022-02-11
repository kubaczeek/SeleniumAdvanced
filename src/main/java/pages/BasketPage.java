package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import shop.Product;

import java.util.List;

public class BasketPage {
    @FindBy(css = "span.price")
    List<WebElement> prices;

    @FindBy(css = "a.label")
    List<WebElement> names;

    @FindBy(css = ".js-cart-line-product-quantity")
    List<WebElement> quantities;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public Product getProductToObjectByIndexFromList(int i) {
        return new Product.ProductBuilder()
                .name(names.get(i).getText())
                .price(Float.parseFloat(prices.get(i).getText().substring(1)))
                .quantity(Integer.parseInt(quantities.get(i).getAttribute("value")))
                .build();
    }
}
