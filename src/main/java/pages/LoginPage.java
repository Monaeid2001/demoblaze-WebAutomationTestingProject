package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By loginUserName = By.id("loginusername");
    private final By loginPassword = By.id("loginpassword");
    private final By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By closeButton = By.xpath("//button[contains(text(),'Close')]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String username, String password) {
        driver.findElement(loginUserName).sendKeys(username);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(d -> d.switchTo().alert())
                .getText();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public void waitUntilLoginModalDisappears() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
    }

}
