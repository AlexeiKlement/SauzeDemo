package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By error_button = By.cssSelector("h3");
    private final By TITLE = By.cssSelector("[class=title]");

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getErrorText() {
        return driver.findElement(error_button).getText();
    }
}
