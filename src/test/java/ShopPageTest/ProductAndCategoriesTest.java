package ShopPageTest;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class ProductAndCategoriesTest extends BaseTest {

    @BeforeClass
    public void OpenMainPage() {
        driver.get(config.getBASE_URL());
        mainPage = new MainPage(driver);
    }

    @Test
    public void IterateCategoriesCheckName() {
        mainPage = new MainPage(driver);
        ArrayList<WebElement> categories = mainPage.getCategories();
        for (WebElement webElement : categories) {
            mainPage = new MainPage(driver);
            webElement.click();
            categoryPage = new CategoryPage(driver);
            Assert.assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText());
            List<WebElement> listSubcategories = categoryPage.getSubcategories();
            for (int i = 0; i < listSubcategories.size(); i++) {
                listSubcategories.get(i).click();
                i++;
                categoryPage = new CategoryPage(driver);
                Assert.assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText());
                goToPreviousPage();
            }
            goToPreviousPage();
        }
    }

}
