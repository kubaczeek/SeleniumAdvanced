package products;

import base.Pages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ProductAndCategoriesTest extends Pages {

    @BeforeClass
    public void OpenMainPage() {
        driver.get(config.getBASE_URL());
    }

    @Test
    public void IterateCategoriesCheckName() {
        String categoryNameBefore, subcategoryNameBefore;
        ArrayList<WebElement> categories = mainPage.getCategories();

        for (WebElement webElement : categories) {
            categoryNameBefore = webElement.getText();
            categoryPage.clickWebElement(webElement);
            assertThat(categoryPage.getHeaderText())
                    .isEqualToIgnoringCase(categoryNameBefore);
            Assert.assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText());
            List<WebElement> listSubcategories = categoryPage.getSubcategories();

            for (int i = 0; i < listSubcategories.size(); i++) {
                subcategoryNameBefore = listSubcategories.get(i).getText();
                categoryPage.click(listSubcategories.get(i));
                i++;
                assertThat(categoryPage.getHeaderText())
                        .isEqualToIgnoringCase(subcategoryNameBefore);
                Assert.assertEquals(categoryPage.totalProductsText(), categoryPage.totalProductsOnPageText());
                goToPreviousPage();
            }
            goToPreviousPage();
        }
    }
}
