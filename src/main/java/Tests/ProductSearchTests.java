package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductSearchTests extends BaseTest {

    private static final String SEARCH_INPUT = "search";
    private static final int FIRST_INPUT = 0;
    private static final String PRODUCT_NAME = "PlayStation 5";

    /*
    This test verifies the results of the
    correct output of an item after a search.
    */

    @Test
    public void searchProductTest(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.setInput(SEARCH_INPUT, FIRST_INPUT, PRODUCT_NAME);
        homePage.clickSearchButton();
        productPage.waitForLoadPageAfterSearch(PRODUCT_NAME);
        List<String> allProductsTitle = productPage.getListOfAllProducts();
        for (String allProductTitle:allProductsTitle){

            // Verify that all products in the output match the query
            assertThat(allProductTitle).contains(PRODUCT_NAME);
        }

    }
}
