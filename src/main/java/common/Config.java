package common;

import enums.Browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String BASE_URL;
    private String LOG_IN_URL;
    private String MY_ACCOUNT_URL;
    private String CREATE_ACCOUNT_URL;
    private String PERSONAL_INFORMATION_URL;
    private String SIGN_OUT_URL;
    private String BASKET_URL;
    private String ORDER_HISTORY_URL;
    private Browser browser;
    private String prefixOneProductInBasket;
    private String suffixOneProductInBasket;
    private String prefixProductsInBasket;
    private String suffixProductsInBasket;
    private String paymentMethodByCheck;
    private String paymentMethodByBank;

    public void loadConfig() throws FileNotFoundException {
        InputStream input = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();

        try {
            prop.load(input);
            this.setBASE_URL(prop.getProperty("BASE_URL"));
            this.setLOG_IN_URL(prop.getProperty("LOG_IN_URL"));
            this.setMY_ACCOUNT_URL(prop.getProperty("MY_ACCOUNT_URL"));
            this.setCREATE_ACCOUNT_URL(prop.getProperty("CREATE_ACCOUNT_URL"));
            this.setPERSONAL_INFORMATION_URL(prop.getProperty("PERSONAL_INFORMATION_URL"));
            this.setSIGN_OUT_URL(prop.getProperty("SIGN_OUT_URL"));
            this.setBASKET_URL(prop.getProperty("BASKET_URL"));
            this.setORDER_HISTORY_URL(prop.getProperty("ORDER_HISTORY_URL"));
            this.setBrowser(prop.getProperty("browser"));
            this.setPrefixOneProductInBasket(prop.getProperty("prefixOneProductInBasket"));
            this.setPrefixProductsInBasket(prop.getProperty("prefixProductsInBasket"));
            this.setSuffixOneProductInBasket(prop.getProperty("suffixOneProductInBasket"));
            this.setSuffixProductsInBasket(prop.getProperty("suffixProductsInBasket"));
            this.setPaymentMethodByBank(prop.getProperty("paymentMethodByBank"));
            this.setPaymentMethodByCheck(prop.getProperty("paymentMethodByCheck"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getORDER_HISTORY_URL() {
        return ORDER_HISTORY_URL;
    }

    public void setORDER_HISTORY_URL(String ORDER_HISTORY_URL) {
        this.ORDER_HISTORY_URL = ORDER_HISTORY_URL;
    }

    public String getPrefixOneProductInBasket() {
        return prefixOneProductInBasket;
    }

    public void setPrefixOneProductInBasket(String prefixOneProductInBasket) {
        this.prefixOneProductInBasket = prefixOneProductInBasket;
    }

    public String getSuffixOneProductInBasket() {
        return suffixOneProductInBasket;
    }

    public void setSuffixOneProductInBasket(String suffixOneProductInBasket) {
        this.suffixOneProductInBasket = suffixOneProductInBasket;
    }

    public String getPrefixProductsInBasket() {
        return prefixProductsInBasket;
    }

    public void setPrefixProductsInBasket(String prefixProductsInBasket) {
        this.prefixProductsInBasket = prefixProductsInBasket;
    }

    public String getSuffixProductsInBasket() {
        return suffixProductsInBasket;
    }

    public void setSuffixProductsInBasket(String suffixProductsInBasket) {
        this.suffixProductsInBasket = suffixProductsInBasket;
    }

    public String getPaymentMethodByCheck() {
        return paymentMethodByCheck;
    }

    public void setPaymentMethodByCheck(String paymentMethodByCheck) {
        this.paymentMethodByCheck = paymentMethodByCheck;
    }

    public String getPaymentMethodByBank() {
        return paymentMethodByBank;
    }

    public void setPaymentMethodByBank(String paymentMethodByBank) {
        this.paymentMethodByBank = paymentMethodByBank;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = Browser.valueOf(browser);
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public String getLOG_IN_URL() {
        return LOG_IN_URL;
    }

    public void setLOG_IN_URL(String LOG_IN_URL) {
        this.LOG_IN_URL = LOG_IN_URL;
    }

    public String getMY_ACCOUNT_URL() {
        return MY_ACCOUNT_URL;
    }

    public void setMY_ACCOUNT_URL(String MY_ACCOUNT_URL) {
        this.MY_ACCOUNT_URL = MY_ACCOUNT_URL;
    }

    public String getCREATE_ACCOUNT_URL() {
        return CREATE_ACCOUNT_URL;
    }

    public void setCREATE_ACCOUNT_URL(String CREATE_ACCOUNT_URL) {
        this.CREATE_ACCOUNT_URL = CREATE_ACCOUNT_URL;
    }

    public String getPERSONAL_INFORMATION_URL() {
        return PERSONAL_INFORMATION_URL;
    }

    public void setPERSONAL_INFORMATION_URL(String PERSONAL_INFORMATION_URL) {
        this.PERSONAL_INFORMATION_URL = PERSONAL_INFORMATION_URL;
    }

    public String getSIGN_OUT_URL() {
        return SIGN_OUT_URL;
    }

    public void setSIGN_OUT_URL(String SIGN_OUT_URL) {
        this.SIGN_OUT_URL = SIGN_OUT_URL;
    }

    public String getBASKET_URL() {
        return BASKET_URL;
    }

    public void setBASKET_URL(String BASKET_URL) {
        this.BASKET_URL = BASKET_URL;
    }


}
