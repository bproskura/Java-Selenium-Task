package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    private static final String SHOPPING_CART_TITLE = "//h1[contains(text(),'Shopping cart')]";
    private static final String PRODUCT_TITLE = "//h2[@class='shopping-cart-item__title mb--0 h4']//a[contains(@href,'product')]";
    private static final String CONFIRM_ORDER_BUTTON = "//button[@name='checkout']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // This method waits for the cart page to load
    public void waitForCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SHOPPING_CART_TITLE)));
    }


    // This method takes the title of the product in the cart
    public String getProductTitle() {
        return driver.findElement(By.xpath(PRODUCT_TITLE)).getText();
    }

    // This method clicks the confirm order button in the cart
    public void clickConfirmOrderButton() {
        driver.findElements(By.xpath(CONFIRM_ORDER_BUTTON)).get(1).click();
    }

}
