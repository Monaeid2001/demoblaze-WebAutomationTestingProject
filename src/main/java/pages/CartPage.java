package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final By checkoutButton = By.xpath("//button[contains(text(),'Place Order')]");
    private final By TotalPrice = By.id("totalp");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public By cartItem(String productName){
        return By.xpath("//td[contains(text(),'"+productName+"')]");
    }
    public By deleteButtonForProduct(String productName){
        return By.xpath("//td[contains(text(),'"+productName+"')]/following-sibling::td/a");
    }

    public boolean isProductInCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem(productName)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deleteProductFromCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonForProduct(productName)))
                .click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cartItem(productName)));
    }
    public CheckoutPage checkout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton))
                .click();
        return new CheckoutPage(driver);
    }
    public String getTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPrice)).getText();
    }
    public void waitForCartToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
    }
}
