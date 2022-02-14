package common;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public WebDriver getDriver(Browser browser) {
        WebDriver driver = null;
        switch (browser) {
            case CHROME:
                driver = getChromeDriver();
                break;
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
            case EDGE:
                driver = getEdgeDriver();
                break;
            case IE:
                driver = getIEDriver();
                break;
        }
        return driver;
    }

    private WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    private WebDriver getEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
    private WebDriver getIEDriver(){
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
