package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginbuttonLocator = By.className("login-button");
    By errorMessageLocator = By.className("error-message");

    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);

    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);

    }
    public void clickOnLoginButton(){
        driver.findElement(loginbuttonLocator).click();

    }

    public  void loginToApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

    }
    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        WebElement errorMessgeEl = driver.findElement(errorMessageLocator);
        return errorMessgeEl.getText();

    }
}
