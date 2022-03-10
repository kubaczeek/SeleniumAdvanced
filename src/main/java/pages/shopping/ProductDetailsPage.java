package pages.shopping;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = ".add-to-cart")
    WebElement addToCartBtn;

    @FindBy(css = ".btn-secondary")
    WebElement continueShoppingBtn;

    @FindBy(css = "p.cart-products-count")
    WebElement elementCountProductInBasket;

    @FindBy(css = ".h1")
    WebElement name;

    @FindBy(xpath = "//*[@class=\"current-price\"]/span[1]")
    WebElement price;

    @FindBy(css = "#quantity_wanted")
    WebElement quantity;

    @FindBy(css = ".cart-content-btn .btn-primary")
    WebElement proceedToCheckoutBtn;

    @FindBy(css = "#group_1 *")
    List<WebElement> sizes;

    @FindBy(css = ".input-color")
    List<WebElement> colors;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void randomFillProduct() {
        quantity.clear();
        quantity.sendKeys(String.valueOf(randomIntInBound(5) + 1));
    }

    public Product getProductToObject() {
        return new Product.ProductBuilder()
                .name(name.getText())
                .price(Float.parseFloat(price.getAttribute("content")))
                .quantity(Integer.parseInt(quantity.getAttribute("value")))
                .build();
    }

    public ProductDetailsPage clickAddToCartButton() {
        addToCartBtn.click();
        waitUntilPopUpLoaded();
        return this;
    }

    public void clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingBtn);
    }

    public String textCountProductInBasket() {
        return elementCountProductInBasket.getText();
    }

    public void waitUntilPopUpLoaded() {
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
    }
}
