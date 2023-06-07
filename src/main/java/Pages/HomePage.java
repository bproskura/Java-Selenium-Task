package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.coolblue.nl/en";
    private static final String COOKIES_POPUP = "//div[@class='modal-box__container']";
    private static final String OKAY_BUTTON_IN_COOKIES_POPUP = "//button[@aria-label='Accept our cookies']";
    private static final String SIGN_IN_NAVIGATION = "//span[contains(text(),'Sign in')]";
    private static final String LOG_IN_MENU = "//div[@class='p--4 section--4']";
    private static final String LOG_IN_BUTTON = "//button[contains(@class, 'login-form')]";
    private static final String LOG_IN_FORM = "//div[contains(@class, 'js-generic-login-form')]";
    private static final String LOG_IN_BUTTON_IN_FORM = "//div[@class='section--5']//button";
    private static final String CONFIRM_PAGE = "//*[@id='root-instructions']";
    private static final String EMAIL_VALIDATION_MESSAGE = "//*[@aria-live='assertive']";
    private static final String SEARCH_BUTTON = "//button[@aria-label='Search']";
    private static final String START_HERE_BUTTON = "//a[contains(text(),'Start here')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // This method opens the main site
    public void open() {
        driver.get(HOME_PAGE_URL);
    }

    // This method waits for the pop-up to load with cookie confirmation
    public void waitForCookiesPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COOKIES_POPUP)));
    }

    // This method clicks the Okay button in the cookie popup
    public void clickOkayButton() {
        driver.findElement(By.xpath(OKAY_BUTTON_IN_COOKIES_POPUP)).click();
    }


    // This method expects to close the popup cookie
    public void waitForCloseCookiesPopUp() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(COOKIES_POPUP)));
    }

    // This method clicks on Sign in in the site's header
    public void clickSignIn() {
        driver.findElement(By.xpath(SIGN_IN_NAVIGATION)).click();
    }

    // This method expects the Sign In drop-down menu to open
    public void waitForOpenLogInMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOG_IN_MENU)));
    }

    // This method clicks the Log in button in the Sign in drop-down menu
    public void clickLogInButton() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(LOG_IN_BUTTON)));
    }
    // This method waits for the login form to open
    public void waitForOpenLogInForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOG_IN_FORM)));
    }

    // This method waits for the confirm page to open, after a successful login
    public void waitForLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM_PAGE)));
    }

    // This method clicks the Log in button in the Login form
    public void clickLogInButtonInForm() {
        driver.findElement(By.xpath(LOG_IN_BUTTON_IN_FORM)).click();
    }


    // This method takes a validation error in the login form for the email field
    public String getEmailValidationMessage() {
        return driver.findElement(By.xpath(EMAIL_VALIDATION_MESSAGE)).getText();
    }

    // This method clicks the search button in the search bar
    public void clickSearchButton() {
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }


    // This method clicks the Start here button in the Sign in drop-down menu
    public void clickStartHereButton() {
        driver.findElements(By.xpath(START_HERE_BUTTON)).get(2).click();
    }
}
