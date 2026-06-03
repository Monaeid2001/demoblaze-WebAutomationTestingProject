package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public By productName(String productName){
        return By.xpath("//a[contains(text(),'"+productName+"')]");
    }
    public By productDesc(String productName){
        return By.xpath("//div[h4/a[contains(text(),'"+productName+"')]]/p");
    }
    public By productPrice(String productName){
        return By.xpath("//div[h4/a[contains(text(),'"+productName+"')]]/h5");
    }


    public ProductPage clickOnProduct(String productName){
//        driver.findElement(productName(productName)).click();
//        return new ProductPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(productName(productName)));
        driver.findElement(productName(productName)).click();
        return new ProductPage(driver);
    }
    public String getProductDesc(String productName){

        return driver.findElement(productDesc(productName)).getText();
    }
    public void waitForProductsToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("tbodyid")
                ));
    }
    public String getProductPrice(String productName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      return wait
              .until(ExpectedConditions.visibilityOfElementLocated(productPrice(productName)))
              .getText();
    }
}
