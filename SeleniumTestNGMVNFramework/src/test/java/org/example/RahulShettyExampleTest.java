package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.object.loginPage;
import utilityPackage.BaseClass;
import utilityPackage.WaitUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.id;
import static utilityPackage.WaitUtils.waitForElement;

public class RahulShettyExampleTest extends BaseClass {
    @BeforeMethod()
    public void beforeMethod()
    {
        browserFactory();
    }

    /* WebDriver driver;
     @Test()
     public void setup()
     {
         WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("start-maximized");
         options.addArguments("enable-automation");
         options.addArguments("--no-sandbox");
         options.addArguments("--disable-infobars");
         options.addArguments("--disable-dev-shm-usage");
         options.addArguments("--disable-browser-side-navigation");
         options.addArguments("--disable-gpu");
         options.addArguments("--ignore-ssl-errors=yes");
         options.addArguments("--ignore-certificate-errors");
         driver = new ChromeDriver(options);
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
         driver.get("https://www.rahulshettyacademy.com/client");

       //  LandingPage landingPage = new LandingPage(driver);
         String productName="ADIDAS ORIGINAL";
         driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
         driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
         driver.findElement(By.id("login")).click();
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
         List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

         WebElement prod =	products.stream().filter(product->
                 product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
         prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
         //ng-animating
         wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
         driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

         List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
         Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
         Assert.assertTrue(match);
         driver.findElement(By.cssSelector(".totalRow button")).click();

         Actions a = new Actions(driver);
         a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

         driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
         driver.findElement(By.cssSelector(".action__submit")).click();

         String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
         Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
         driver.close();

     }*/
    @Test()
    public void test1()
    {
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();


    }
    @AfterMethod()
    public void afterMethod()
    {
        tearDown();
    }

}
