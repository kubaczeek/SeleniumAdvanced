package pages.shopping;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class BasketPage extends BasePage {

    @FindBy(css = "span.price")
    List<WebElement> prices;

    @FindBy(css = ".cart-total .value")
    WebElement totalPrice;

    @FindBy(css = "a.label")
    List<WebElement> names;

    @FindBy(css = ".text-sm-center .btn")
    WebElement proceedToCheckoutButton;

    @FindBy(css = ".js-cart-line-product-quantity")
    List<WebElement> quantities;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
    }

    public Product getProductToObjectByIndexFromList(int i) {
        return new Product.ProductBuilder()
                .name(names.get(i).getText())
                .price(Float.parseFloat(prices.get(i).getText().substring(1)))
                .quantity(Integer.parseInt(quantities.get(i).getAttribute("value")))
                .build();
    }

    public float getTotalPrice() {
        return Float.parseFloat(totalPrice.getText().substring(1));
    }
}
