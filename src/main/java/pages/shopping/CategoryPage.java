package pages.shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static pages.PageHelpers.randomIntInBound;

public class CategoryPage {

    public CategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "article")
    List<WebElement> articlesInCategory;

    @FindBy(css = ".category-sub-menu li a")
    List<WebElement> subcategories;

    @FindBy(css = ".total-products p")
    WebElement totalProductsTextOnPage;

    @FindBy(css = ".h1")
    WebElement categoryHeader;

    public String totalProductsOnPageText(){
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

    public String getHeaderText(){
        return categoryHeader.getText();
    }

    public List<WebElement> getSubcategories() {
        return subcategories;
    }

    public WebElement getRandomSubcategory() {
        return subcategories.get(randomIntInBound(subcategories.size()));
    }

    public WebElement getRandomProduct() {
        return articlesInCategory.get(randomIntInBound(articlesInCategory.size()));
    }
}
