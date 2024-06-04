package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;
import pom.object.loginPage;
import utilityPackage.BaseClass;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import static java.lang.System.*;

public class ExtendReportExampleTest extends BaseClass {
    ExtentReports extent;
    @BeforeTest()
    public void extendReport()
    {
        String path= getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Vivek Ranjan");
    }
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
        extent.createTest("test1");
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test()
    public void test2()
    {
        extent.createTest("test2");
        getDriver();
        loginPage login=new loginPage(driver);
        login.loginToApp();
    }
    @Test(priority=4)
    public void test3()
    {
       ExtentTest test= extent.createTest("test3");
        getDriver();
        test.log(Status.PASS,"Application Opened in Browser");
        loginPage login=new loginPage(driver);
        login.loginToApp();
        test.log(Status.PASS,"Login Completed");
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
        extent.flush();
    }

}
