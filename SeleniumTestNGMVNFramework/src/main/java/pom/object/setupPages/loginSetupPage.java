package pom.object.setupPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.BaseClass;

import java.util.Map;

import static utilityPackage.WaitUtils.waitForElement;

public class loginSetupPage extends BaseClass {

    public loginSetupPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean loginToApp(Map<String, Object> feildElementMap) {
        waitForElement(driver, (WebElement) feildElementMap.get("userEmail"),5).sendKeys("anshika@gmail.com");
        waitForElement(driver, (WebElement) feildElementMap.get("userPassword"),5).sendKeys("Iamking@000");
        waitForElement(driver, (WebElement) feildElementMap.get("loginButton"),5).click();
        return true;
    }
}