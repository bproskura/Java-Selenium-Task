package Tests;

import Pages.BaseTest;
import Pages.HomePage;
import Pages.SignUpPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTests extends BaseTest {

    private static final String EMAIL_INPUT = "email";
    private static final String PASSWORD_INPUT = "password";
    private static final int SECOND_INPUT = 1;
    private static final int CONFIRM_PASSWORD_INPUT = 2;
    private static final String EMAIL_VALUE = "test@gmail.com";
    private static final String PASSWORD_VALUE = "testPassword";
    private static final int FIRST_CHECBOX = 0;
    private static final int SECOND_CHECBOX = 1;
    private static final String VALIDATION_ERROR_MESSAGE = "You didn't indicate that you're not a robot.";
    private static final String SHORT_PASSWORD_VALUE = "test";
    private static final int FIRST_INPUT_ERROR = 0;
    private static final int SECOND_INPUT_ERROR = 1;
    private static final int THIRD_INPUT_ERROR = 2;
    private static final String SHORT_PASSWORD_VALLIDATION_MESSAGE = "The password you entered is too short.";
    private static final String SHORT_CONFIRM_PASSWORD_VALLIDATION_MESSAGE = "The confirmation password entered is too short.";
    private static final String BLANK_EMAIL_VALIDATION_MESSAGE = "No email address was entered.";
    private static final String BLANK_PASSWORD_VALIDATION_MESSAGE = "No password was entered.";
    private static final String BLANK_CONFIRM_PASSWORD_VALIDATION_MESSAGE = "No confirmation password was entered.";


    /*
    This test verifies that you are registered on the site.
    Captcha is very difficult to bypass, so is checked to
    the moment when the error is displayed that the captcha did not pass
    */

    @Test (priority = 1)
    public void verifyRobotValidationMessage(){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.clickSignIn();
        homePage.waitForOpenLogInMenu();
        homePage.clickStartHereButton();
        signUpPage.waitForLoadSignUpPage();
        signUpPage.setInput(EMAIL_INPUT, SECOND_INPUT, EMAIL_VALUE);
        signUpPage.setInput(PASSWORD_INPUT, SECOND_INPUT, PASSWORD_VALUE);
        signUpPage.setInput(PASSWORD_INPUT, CONFIRM_PASSWORD_INPUT, PASSWORD_VALUE);
        signUpPage.selectCheckbox(FIRST_CHECBOX);
        signUpPage.selectCheckbox(SECOND_CHECBOX);
        signUpPage.clickRegisterButton();
        signUpPage.waitForRobotValidationMessage();

        String validatonErrorMessage = signUpPage.getValidationErrorMessage();

        // Verify robot validation error message
        assertThat(validatonErrorMessage).contains(VALIDATION_ERROR_MESSAGE);
    }

    /*
    This test checks for validation errors when a too
    short password is entered in the registration form
    */


    @Test (priority = 2)
    public void verifyRegistrationErrorsWithShortPassword(){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.clickSignIn();
        homePage.waitForOpenLogInMenu();
        homePage.clickStartHereButton();
        signUpPage.waitForLoadSignUpPage();
        signUpPage.setInput(EMAIL_INPUT, SECOND_INPUT, EMAIL_VALUE);
        signUpPage.setInput(PASSWORD_INPUT, SECOND_INPUT, SHORT_PASSWORD_VALUE);
        signUpPage.setInput(PASSWORD_INPUT, CONFIRM_PASSWORD_INPUT, SHORT_PASSWORD_VALUE);
        signUpPage.selectCheckbox(FIRST_CHECBOX);
        String validatonPasswordErrorMessage = signUpPage.getInputValidationErrorMessage(FIRST_INPUT_ERROR);
        String validatonConfirmPasswordErrorMessage = signUpPage.getInputValidationErrorMessage(SECOND_INPUT_ERROR);

        // Verify short password validation error message
        assertThat(validatonPasswordErrorMessage).contains(SHORT_PASSWORD_VALLIDATION_MESSAGE);

        // Verify short confirm password validation error message
        assertThat(validatonConfirmPasswordErrorMessage).contains(SHORT_CONFIRM_PASSWORD_VALLIDATION_MESSAGE);
    }

     /*
    This test checks for validation errors when trying to
    register with blank input fields on the registration form
    */

    @Test (priority = 3)
    public void verifyRegistrationErrorsWithBlankFields(){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        homePage.open();
        homePage.waitForCookiesPopUp();
        homePage.clickOkayButton();
        homePage.waitForCloseCookiesPopUp();
        homePage.clickSignIn();
        homePage.waitForOpenLogInMenu();
        homePage.clickStartHereButton();
        signUpPage.waitForLoadSignUpPage();
        signUpPage.clickRegisterButton();
        String validationEmailErrorMessage = signUpPage.getInputValidationErrorMessage(FIRST_INPUT_ERROR);
        String validatonPasswordErrorMessage = signUpPage.getInputValidationErrorMessage(SECOND_INPUT_ERROR);
        String validatonConfirmPasswordErrorMessage = signUpPage.getInputValidationErrorMessage(THIRD_INPUT_ERROR);

        // Verify blank email input validation error message
        assertThat(validationEmailErrorMessage).contains(BLANK_EMAIL_VALIDATION_MESSAGE);

        // Verify blank password input validation error message
        assertThat(validatonPasswordErrorMessage).contains(BLANK_PASSWORD_VALIDATION_MESSAGE);

        // Verify blank confirm password input validation error message
        assertThat(validatonConfirmPasswordErrorMessage).contains(BLANK_CONFIRM_PASSWORD_VALIDATION_MESSAGE);
    }
}
