package utilityPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public static Properties props;

    public static void properties() {
        props = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("/config.properties");
            props.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void browserFactory() {
        try {
            String browserName = props.getProperty("browser");
            String browserVersion = props.getProperty("browserVersion");
            System.out.println("Browser Selected is : " + browserName);

            if (props.isEmpty()) {

                if (driver != null) {
                    driver.quit();
                }

                if (browserName.equalsIgnoreCase("chrome")) {

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


                } else if (browserName.equalsIgnoreCase("firefox")) {

                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                } else if (browserName.equalsIgnoreCase("edge")) {

                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                } else if (browserName.equalsIgnoreCase("ie")) {

                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                } else {
                    System.out.println("Sorry We don't support " + browserName + " Supported Names : chrome,firefox, edge,ie");
                    Assert.fail("Sorry We don't support " + browserName + " Supported Names : chrome,firefox, edge,ie");
                }
                driver.manage().window().maximize();

            } else {
                if (driver != null) {
                    driver.quit();
                }

                if (browserName.equalsIgnoreCase("chrome")) {

                    WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
                    driver = new ChromeDriver();
                } else if (browserName.equalsIgnoreCase("firefox")) {

                    WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();
                    driver = new FirefoxDriver();
                } else if (browserName.equalsIgnoreCase("edge")) {

                    WebDriverManager.edgedriver().browserVersion(browserVersion).setup();
                    driver = new EdgeDriver();
                } else if (browserName.equalsIgnoreCase("ie")) {

                    WebDriverManager.iedriver().browserVersion(browserVersion).setup();
                    driver = new InternetExplorerDriver();
                } else {
                    System.out.println("Sorry We don't support " + browserName + " Supported Names : chrome,firefox, edge,ie");

                }
            }
        }catch(Exception e){
            System.out.println("Exception captured at browserFactory method");
        }
    }

    public void tearDown() {

        if (driver != null) {
            driver.quit();
            System.out.println("Tear Down completed");
        }
    }

    public void getDriver(){
        driver.get(props.getProperty("URL"));
    }

    public void navigateTO(String url){
        driver.navigate().to(url);
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void navigateForward(){
        driver.navigate().forward();
    }

    public void pageRefresh(){
        driver.navigate().refresh();
    }
}

