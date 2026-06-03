package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private final By  nameInput = By.id("name");
    private final By  countryInput = By.id("country");
    private final By cityInput = By.id("city");
    private final By cardInput = By.id("card");
    private final By monthInput = By.id("month");
    private final By yearInput = By.id("year");
    private final By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
    private final By totalPrice = By.id("totalm");
    private final By successMessage = By.xpath("//h2[contains(text(),'Thank')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillCheckoutForm(String name, String country, String city, String card, String month, String year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(countryInput).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(cardInput).sendKeys(card);
        driver.findElement(monthInput).sendKeys(month);
        driver.findElement(yearInput).sendKeys(year);
        driver.findElement(purchaseButton).click();
    }
    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText().split(" ")[1];
    }
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
