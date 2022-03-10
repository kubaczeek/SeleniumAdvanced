package pages.order;

import common.Config;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderDetailsPage extends BasePage {

    @FindBy(css = "td.text-xs-right:nth-child(3)")
    WebElement price;

    @FindBy(css = "td strong")
    WebElement name;

    @FindBy(css = ".text-sm-center .btn")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "#order-products > tbody > tr > td:nth-child(2)")
    WebElement quantity;

    @FindBy(xpath = "//*[@class='box']/ul/li[2]")
    WebElement paymentMethod;

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getPaymentMethodText() {
        return paymentMethod.getText();
    }

    public String getPaymentMethodTextFromConfig(String paymentType, Config config) {
        if (paymentType.equals("Pay by Check"))
            return config.getPaymentMethodByCheck();
        return config.getPaymentMethodByBank();
    }

    public Product getProductToObjectFromPage() {
        return new Product.ProductBuilder()
                .name(name.getText())
                .price(Float.parseFloat(price.getText().substring(1)))
                .quantity(Integer.parseInt(quantity.getText()))
                .build();
    }
}
