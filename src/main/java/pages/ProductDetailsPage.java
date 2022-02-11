package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shop.Product;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage extends PageHelpers{

    public ProductDetailsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

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

    @FindBy(css = "#group_1 *")
    List<WebElement> sizes;

    @FindBy(css = ".input-color")
    List<WebElement> colors;

    public void randomFillProduct(){
        quantity.clear();
        quantity.sendKeys(String.valueOf(randomIntInBound(5)+1));
    }

    public Product getProductToObject(){
        Product product = new Product.ProductBuilder()
                .name(name.getText())
                .price(Float.parseFloat(price.getAttribute("content")))
                .quantity(Integer.parseInt(quantity.getAttribute("value")))
                .build();
        return product;
    }

    public void clickAddToCartButton() {
        addToCartBtn.click();
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingBtn);
    }

    public String textCountProductInBasket(){
        return elementCountProductInBasket.getText();
    }

    public void waitUntilPopUpLoaded(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(continueShoppingBtn));
    }
}
