import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;

import java.time.Duration;


public class LoginPageTest {
    public WebDriver driver;
    Login login;



    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kella\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        login = new Login(driver);
    }


    @Test
    public void loginWithValidCredentials() {

        login.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }



    @Test(priority = 2)
    public void loginWithInvalidCredentials() {

        login.loginToApplication("rahul", "rahul2021");
        // Wait for the Error message to be loaded
        String errorMessage = login.getErrorMessage();

        Assert.assertEquals(errorMessage, "*username and password didn't match");


    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
