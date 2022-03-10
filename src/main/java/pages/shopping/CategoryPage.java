package pages.shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(css = "article")
    List<WebElement> articlesInCategory;
    @FindBy(css = ".category-sub-menu li a")
    List<WebElement> subcategories;
    @FindBy(css = ".total-products p")
    WebElement totalProductsTextOnPage;
    @FindBy(css = ".h1")
    WebElement categoryHeader;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String totalProductsOnPageText() {
        return totalProductsTextOnPage.getText();
    }

    public String totalProductsText() {
        int count = articlesInCategory.size();
        if (count == 1) {
            return "There is " + count + " product.";
        } else {
            return "There are " + count + " products.";
        }
    }

    public String getHeaderText() {
        return categoryHeader.getText();
    }

    public List<WebElement> getSubcategories() {
        return subcategories;
    }

    public String openRandomSubcategory() {
        WebElement randomCategory = subcategories.get(randomIntInBound(subcategories.size()));
        String name = randomCategory.getText();
        randomCategory.click();
        return name;
    }

    public void openRandomProduct() {
        articlesInCategory.get(randomIntInBound(articlesInCategory.size())).click();
    }

    public void clickWebElement(WebElement webElement) {
        click(webElement);
    }
}
