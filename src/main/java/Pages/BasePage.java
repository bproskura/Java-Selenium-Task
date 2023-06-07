package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final String INPUT_PATH = "//input[@type='%s']";
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    // This method allows you to set a value in an input field depending on its type and location on the page
    public void setInput(String inputType, int numberOfInput, String setValue) {
        driver.findElements(By.xpath(String.format(INPUT_PATH, inputType))).get(numberOfInput).sendKeys(setValue);
    }

    // This method takes the current browser URL
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
