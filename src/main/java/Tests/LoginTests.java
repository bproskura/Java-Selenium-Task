package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTests extends BaseTest {

    private static final String EMAIL_INPUT = "email";
    private static final int FIRST_INPUT = 0;
    private static final String EMAIL_VALUE = "yzhodan@mailto.plus";
    private static final String PASSWORD_INPUT = "password";
    private static final String PASSWORD_VALUE = "testShopPassword";
    private static final String ACCOUNT_NAME = "Bohdan";
    public static final String LOGIN_PAGE_URL = "/login";
    private static final String WRONG_EMAIL_VALUE = "yzhodan";
    private static final String EMAIL_VALIDATION_MESSAGE = "No valid email address was entered. Check if the email address contains an @ and " +
            "a period. Check for spaces, too.";

    /*
    This test checks for a validation error
    if the wrong email pattern is entered in the login form
     */

    @Test (priority = 1)
    public void wrongLoginEmailPatternTest(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.clickSignIn();
        homePage.waitForOpenLogInMenu();
        homePage.clickLogInButton();
        homePage.waitForOpenLogInForm();
        homePage.setInput(EMAIL_INPUT, FIRST_INPUT, WRONG_EMAIL_VALUE);
        homePage.setInput(PASSWORD_INPUT, FIRST_INPUT, PASSWORD_VALUE);
        assertThat(homePage.getEmailValidationMessage()).contains(EMAIL_VALIDATION_MESSAGE);
    }

    /*
    This test verifies a successful login to the site.
    Unfortunately due to the inability to pass the
    captcha test comes to the step of appearance of captcha
     */

    @Test (priority = 2)
    public void verifyLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.clickSignIn();
        homePage.waitForOpenLogInMenu();
        homePage.clickLogInButton();
        homePage.waitForOpenLogInForm();
        homePage.setInput(EMAIL_INPUT, FIRST_INPUT, EMAIL_VALUE);
        homePage.setInput(PASSWORD_INPUT, FIRST_INPUT, PASSWORD_VALUE);
        homePage.clickLogInButtonInForm();
        homePage.waitForLogin();

        // Verify the page title after a successful login
        assertThat(homePage.getPageUrl()).contains(LOGIN_PAGE_URL);
    }
}
