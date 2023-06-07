package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private static final String LOGIN_CHECKOUT_PAGE_TITLE = "Login - Coolblue checkout";
    private static final String CONTINUE_BUTTON = "//button[contains(text(),'Continue')]";
    private static final String PASSWORD_FORM_TITLE = "//h2[text()='Welcome back!']";
    private static final String CHECKOUT_DELIVERY_PAGE_TITLE = "//strong[contains(text(),'Delivery')]";
    private static final String CHECKOUT_OVERVIEW_PAGE_TITLE = "//strong[contains(text(),'Overview')]";
    private static final String PAYMENT_METHOD = "//div[@class='selectable-card selectable-card--compact']//span[contains(text(),'%s')]";
    private static final String COMPLETE_ORDER_BUTTON = "//button[contains(text(),'Complete order')]";
    private static final String CHECKOUT_COMPLETE_ORDER_PAGE_TITLE = "//h1[contains(text(),'Order completed')]";
    private static final String PRODUCT_TITLE = "//h3[@class='h5']//a";
    private static final String ORDER_EMAIL = "//h2[contains(text(),'Contact information')]/following::span[contains(text(),'@')]";
    private static final String ORDER_CUSTOMER = "//h2[contains(text(),'Invoice address')]/following::span";
    private static final String INFORMATION_CHECKOUT_PAGE_TITLE = "//strong[contains(text(),'information')]";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    // This method waits for the login checkout page to load
    public void waitForLoadLoginCheckoutPage() {
        wait.until(ExpectedConditions.titleContains(LOGIN_CHECKOUT_PAGE_TITLE));
    }

    // This method clicks the continue button in the checkouts forsm
    public void clickContinueButton(int numberOfButton) {
        driver.findElements(By.xpath(CONTINUE_BUTTON)).get(numberOfButton).click();
    }

    // This method waits for the password form load in the checkout page
    public void waitForLoadPasswordForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_FORM_TITLE)));
    }


    // This method waits for the delivery section load in the checkout page
    public void waitForLoadDeliveryCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_DELIVERY_PAGE_TITLE)));
    }

    // This method waits for the overview section load in the checkout page
    public void waitForLoadOverviewCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_OVERVIEW_PAGE_TITLE)));
    }
    // This method allows you to choose the type of payment
    public void selectPaymentMethod(String paymentMethod) {
        driver.findElement(By.xpath(String.format(PAYMENT_METHOD, paymentMethod))).click();
    }

    // This method clicks the complete order button in the checkouts form
    public void clickCompleteOrderButton() {
        driver.findElements(By.xpath(COMPLETE_ORDER_BUTTON)).get(4).click();
    }


    // This method waits for the complete order page load
    public void waitForLoadCompleteOrderCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECKOUT_COMPLETE_ORDER_PAGE_TITLE)));
    }

    // This method takes the title of the product in the complete order page
    public String getProductOrderTitle() {
        return driver.findElement(By.xpath(PRODUCT_TITLE)).getText();
    }

    // This method takes the customer email in the complete order page
    public String getOrderEmail() {
        return driver.findElement(By.xpath(ORDER_EMAIL)).getText();
    }

    // This method takes the customer information in the complete order page
    public String getOrderCustomer() {
        return driver.findElement(By.xpath(ORDER_CUSTOMER)).getText();
    }


    // This method waits for the information section load in the checkout page
    public void waitForLoadInformationCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INFORMATION_CHECKOUT_PAGE_TITLE)));
    }
}
