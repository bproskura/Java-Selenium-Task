package Tests;

import Pages.*;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutProcessTests extends BaseTest {

    private static final String SEARCH_INPUT = "search";
    private static final int FIRST_INPUT = 0;
    private static final String PRODUCT_NAME = "PlayStation 5";
    private static final int FIRST_PRODUCT_BUTTON = 2;
    private static final String EMAIL_INPUT = "email";
    private static final String EMAIL_VALUE = "yzhodan@mailto.plus";
    private static final String PASSSWORD_INPUT = "password";
    private static final String PASSWORD_VALUE = "testShopPassword";
    private static final String BANK_TRANSFER_METHOD = "Bank transfer";
    private static final int FIRST_PRODUCT = 0;
    private static final String CUSTOMER_VALUE = "Bohdan Proskura";
    private static final int SECOND_INPUT = 1;
    private static final int FIRST_CONTINUE_BUTTON = 0;
    private static final int SECOND_CONTINUE_BUTTON = 1;
    private static final int THIRD_CONTINUE_BUTTON = 2;

    @Test
    public void checkoutProcessTest(){

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
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
        productPage.clickViewShoppingCartButton();
        cartPage.waitForCartPage();
        cartPage.clickConfirmOrderButton();
        checkoutPage.waitForLoadLoginCheckoutPage();
        checkoutPage.setInput(EMAIL_INPUT, SECOND_INPUT, EMAIL_VALUE);
        checkoutPage.clickContinueButton(FIRST_CONTINUE_BUTTON);
        checkoutPage.waitForLoadPasswordForm();
        checkoutPage.setInput(PASSSWORD_INPUT, SECOND_INPUT, PASSWORD_VALUE);
        checkoutPage.clickContinueButton(SECOND_CONTINUE_BUTTON);
        checkoutPage.waitForLoadInformationCheckoutPage();
        checkoutPage.clickContinueButton(SECOND_CONTINUE_BUTTON);
        checkoutPage.waitForLoadDeliveryCheckoutPage();
        checkoutPage.clickContinueButton(THIRD_CONTINUE_BUTTON);
        checkoutPage.waitForLoadOverviewCheckoutPage();
        checkoutPage.selectPaymentMethod(BANK_TRANSFER_METHOD);
        checkoutPage.clickCompleteOrderButton();
        checkoutPage.waitForLoadCompleteOrderCheckoutPage();
        String productTitleInOrder = checkoutPage.getProductOrderTitle();
        String emailInOrder = checkoutPage.getOrderEmail();
        String customerInOrder = checkoutPage.getOrderCustomer();

        // Verify that the order contains the correct product
        assertThat(productTitleInOrder).isEqualTo(productTitle);

        // Verify that the email on the order is correct
        assertThat(emailInOrder).isEqualTo(EMAIL_VALUE);

        // Verify that the correct customer is on the order
        assertThat(customerInOrder).isEqualTo(CUSTOMER_VALUE);

    }
}
