package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final By username = By.id("sign-username");
    private final By password = By.id("sign-password");
    private final By registerButton = By.xpath("//button[contains(text(),'Sign up')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void register(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(registerButton).click();
    }
    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(d -> d.switchTo().alert())
                .getText();
    }



}
