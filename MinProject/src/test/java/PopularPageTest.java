import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    Login login;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kella\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        login = new Login(driver);
        login.loginToApplication("rahul", "rahul@2021");
    }

    @Test
    public void popularPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popularEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/nav/div[1]/ul/li[2]/a")));
        popularEle.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"Urls didn't match");

    }
}
