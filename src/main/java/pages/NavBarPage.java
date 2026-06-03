package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBarPage {
    private final WebDriver driver;
    private final By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private final By contactLink = By.xpath("//a[contains(text(),'Contact')]");
    private final By aboutUsLink = By.xpath("//a[contains(text(),'About us')]");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By loginLink = By.xpath("//a[contains(text(),'Log in')]");
    private final By signUpLink = By.xpath("//a[contains(text(),'Sign up')]");
    private final By loggedinUser = By.id("nameofuser");


    public NavBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickSignUp() {
        driver.findElement(signUpLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        return new RegisterPage(driver);
    }

    public LoginPage clickLogin() {
        driver.findElement(loginLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        return new LoginPage(driver);
    }
    public CartPage clickCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
        public String getLoggedInUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until( ExpectedConditions.visibilityOfElementLocated(loggedinUser)).getText();
        }

}
