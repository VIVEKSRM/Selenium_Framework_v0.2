package pom.object.setupPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.BaseClass;

import java.util.Map;

public class loginSetupPage extends BaseClass {

    public loginSetupPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean loginToApp(Map<String, Object> feildElementMap) {

       WebElement username= (WebElement) feildElementMap.get("userEmail");
       username.sendKeys("anshika@gmail.com");
       WebElement userPassword= (WebElement) feildElementMap.get("userPassword");
       userPassword.sendKeys("Iamking@000");
       WebElement loginButton= (WebElement) feildElementMap.get("loginButton");
       loginButton.click();
       return true;
    }
}