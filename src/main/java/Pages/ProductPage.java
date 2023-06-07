package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class ProductPage extends BasePage {

    private static final String ALL_PRODUCTS_TITLE_WEBELEMENTS = "//div[@class='product-card__title']//div//a";
    private static final String ADD_TO_CART_BUTTON = "//a[contains(@href,'shopping-cart')]";
    private static final String CONFIRM_PAGE = "Almost yours";
    private static final String COUNTER_IN_CART_ICON = "//span[@class='badge']";
    private static final String VIEW_SHOPPING_CART_BUTTON = "//a[contains(text(),'View my shopping cart')]";


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    // This method waits for the search results page to load
    public void waitForLoadPageAfterSearch(String pageTitle) {
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }


    // This method takes the titles of all products on the search results page
    public List<String> getListOfAllProducts() {
        List<WebElement> listOfElements = driver.findElements(By.xpath(ALL_PRODUCTS_TITLE_WEBELEMENTS));
        List<String> listOfProductsTitle = new ArrayList<>();
        for (WebElement listofElement: listOfElements){
            listOfProductsTitle.add(listofElement.getText());}
        return listOfProductsTitle;
    }


    // This method clicks the add to cart button in the product card
    public void clickAddToCartButton(int numberOfProduct) {
        driver.findElements(By.xpath(ADD_TO_CART_BUTTON)).get(numberOfProduct).click();
    }

    // This method waits for the confirmation page to load after clicking on the add to cart button
    public void waitForLoadConfirmPage() {
        wait.until(ExpectedConditions.titleContains(CONFIRM_PAGE));
    }

    // This method takes the numerical value of the items in the cart icon
    public String getProductNumberInCartIcon() {
        return driver.findElement(By.xpath(COUNTER_IN_CART_ICON)).getText();
    }

    // This method clicks the button to go to the cart, to the confirmation page of adding an item
    public void clickViewShoppingCartButton() {
        driver.findElement(By.xpath(VIEW_SHOPPING_CART_BUTTON)).click();
    }
}
