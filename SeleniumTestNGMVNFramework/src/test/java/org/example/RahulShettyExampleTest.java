package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.object.viewPages.loginPage;
import utilityPackage.BaseClass;

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
    @Test(priority=-9)
    public void test1()
    {
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test()
    public void test2()
    {
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test(priority=4)
    public void test3()
    {
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test(priority=0)
    public void test5()
    {
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test()
    public void test4()
    {
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test(priority=0)
    public void test6()
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
