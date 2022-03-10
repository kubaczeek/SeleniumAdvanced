package pages.order;

import common.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;
import java.util.Random;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//input[@name='address1']")
    WebElement address;

    @FindBy(xpath = "//input[@name='city']")
    WebElement city;

    @FindBy(xpath = "//input[@name='postcode']")
    WebElement zipcode;

    @FindBy(css = ".js-country")
    WebElement countrySelect;

    @FindBy(css = "#delivery_message")
    WebElement deliveryMessageInput;

    @FindBy(css = ".custom-radio .ps-shown-by-js")
    List<WebElement> paymentOptions;

    @FindBy(css = ".custom-checkbox")
    WebElement agreeTermsButton;

    @FindBy(css = ".form-footer .continue")
    WebElement continueAddressButton;

    @FindBy(css = ".delivery-options-list .continue")
    WebElement continueShipButton;

    @FindBy(css = ".ps-shown-by-js .btn")
    WebElement placeOrderButton;

    @FindBy(css = ".cart-total .value")
    WebElement totalPriceOrder;

    @FindBy(css = ".account")
    WebElement accountButton;

    @FindBy(css = "#payment-option-1-container")
    WebElement paymentOption1Container;

    @FindBy(css = "#payment-option-2-container")
    WebElement paymentOption2Container;

    @FindBy(css = "#payment-option-1")
    WebElement paymentOption1Button;

    @FindBy(css = "#payment-option-2")
    WebElement paymentOption2Button;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage fillAddressForm(User user) {
        address.sendKeys(user.getAddress());
        city.sendKeys(user.getCity());
        zipcode.sendKeys(user.getZipCode());
        String country = "";
        if (user.getCountry().equals("Poland"))
            country = "14";
        else if (user.getCountry().equals("United States"))
            country = "21";
        selectByValue(countrySelect, country);
        return this;
    }

    public OrderPage acceptTerms() {
        click(agreeTermsButton);
        return this;
    }

    public void clickContinueAddressBtn() {
        continueAddressButton.click();
    }

    public void clickContinueShipBtn() {
        click(continueShipButton);
    }

    public String clickRandomPaymentAndReturnText() {
        if (new Random().nextBoolean()) {
            paymentOption1Button.click();
            return paymentOption1Container.getText();
        } else {
            paymentOption2Button.click();
            return paymentOption2Container.getText();
        }
    }

    public void placeOrder() {
        click(placeOrderButton);
    }
}
