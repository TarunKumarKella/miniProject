import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kella\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        WebElement usernameEl = driver.findElement(By.id("usernameInput"));
        usernameEl.sendKeys("rahul");
        WebElement passwordEl = driver.findElement(By.id("passwordInput"));
        passwordEl.sendKeys("rahul@2021");
        WebElement loginEl = driver.findElement(By.className("login-button"));
        loginEl.click();
    }
    @Test
    public void HeadingCheck(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moviesHeadingText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movies-list-heading")));
        System.out.println(moviesHeadingText.getText());
    }
    @Test
    public void playButtonCheck(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement playbuttonEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
    }

    @Test
    public void contactUsSec(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactUsEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("footer-container")));
    }

    @Test
    public void moviesContainer(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement MoviesContaineEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-details-container")));
    }

    @Test
    public  void  websiteLogoCheck(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement websiteLogoEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
