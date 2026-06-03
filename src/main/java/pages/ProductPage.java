package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
    private final By productName = By.xpath("//h2[contains(text(),'Nokia')]");
    private final By productDesc = By.xpath("//div[@id='more-information']/p");
    private final By addToCartButton = By.xpath("//a[text()='Add to cart']");
    private final By productPrice = By.className("price-container");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(
                    d -> d.findElement(productName)
            ).getText();
           }
    public String getProductDesc(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                d -> d.findElement(productDesc)
        ).getText();
    }
    public ProductPage clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                d -> d.findElement(addToCartButton)
        ).click();
        return this;
    }
    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(d -> d.switchTo().alert())
                .getText();
    }
    public void acceptAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.switchTo().alert()).accept();
    }
    public boolean isAddToCartButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      return  wait.until(d -> d.findElement(addToCartButton).isDisplayed());
    }
    public String getProductPrice () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(d -> d.findElement(productPrice)).getText().split(" ")[0];
    }


}
