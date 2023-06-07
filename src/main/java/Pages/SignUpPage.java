package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage{
    private static final String SIGN_UP_PAGE_TITLE = "//h1[text()='Create account']";
    private static final String CHECKBOX_FIELD = "//div[@class='checkbox']";
    private static final String REGISTER_BUTTON = "//button[contains(text(),'Register')]";
    private static final String VALIDATION_CONTAINER = "//div[@class='js-errormessagecontainer']";
    private static final String VALIDATION_ERROR_MESSAGE = "//label[@class='errormessage']";
    private static final String INPUT_VALIDATION_ERROR_MESSAGE = "//div[@class='color--error']";

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // This method waits for the Sign Up page to load
    public void waitForLoadSignUpPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGN_UP_PAGE_TITLE)));
    }

    // This method activates the checkboxes on the Sign Up page
    public void selectCheckbox(int numberOfCheckbox) {
        driver.findElements(By.xpath(CHECKBOX_FIELD)).get(numberOfCheckbox).click();
    }

    // This method clicks the registration button
    public void clickRegisterButton() {
        driver.findElement(By.xpath(REGISTER_BUTTON)).click();
    }

    // This method waits for the validation block to appear
    public void waitForRobotValidationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VALIDATION_CONTAINER)));
    }

    // This method takes the validation error in the validation block
    public String getValidationErrorMessage() {
        return driver.findElement(By.xpath(VALIDATION_ERROR_MESSAGE)).getText();
    }

    // This method takes a validation error for the corresponding input field
    public String getInputValidationErrorMessage(int numberOfInput) {
        return driver.findElements(By.xpath(INPUT_VALIDATION_ERROR_MESSAGE)).get(numberOfInput).getText();
    }
}
