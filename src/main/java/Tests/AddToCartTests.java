package Tests;

import Pages.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddToCartTests extends BaseTest {

    private static final String SEARCH_INPUT = "search";
    private static final int FIRST_INPUT = 0;
    private static final String PRODUCT_NAME = "iPhone 14";
    private static final int FIRST_PRODUCT = 0;
    private static final String ONE_PRODUCT_IN_CART = "1";
    private static final int FIRST_PRODUCT_BUTTON = 2;

    /*
    This test checks if an item was successfully added to cart
    and if the item is displayed correctly in the cart
     */

    @Test
    public void addToCartTest(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.setInput(SEARCH_INPUT, FIRST_INPUT, PRODUCT_NAME);
        homePage.clickSearchButton();
        productPage.waitForLoadPageAfterSearch(PRODUCT_NAME);
        String productTitle = productPage.getListOfAllProducts().get(FIRST_PRODUCT);
        productPage.clickAddToCartButton(FIRST_PRODUCT_BUTTON);
        productPage.waitForLoadConfirmPage();
        String numberInCartIcon = productPage.getProductNumberInCartIcon();

        // Verify if an item has been added to cart
        assertThat(numberInCartIcon).isEqualTo(ONE_PRODUCT_IN_CART);
        productPage.clickViewShoppingCartButton();
        cartPage.waitForCartPage();

        // Verify if the product is added to the cart correctly
        assertThat(cartPage.getProductTitle()).isEqualTo(productTitle);

    }
}
