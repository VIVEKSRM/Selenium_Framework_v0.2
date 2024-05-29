package pom.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.object.setupPages.loginSetupPage;
import utilityPackage.BaseClass;

import java.util.LinkedHashMap;

public class loginPage extends BaseClass {
    public loginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        ObjectFeildMap();
    }

    private static LinkedHashMap<String, Object> feildElementMap= new LinkedHashMap<>();

    @FindBy(xpath=("//*[@id='userEmail']"))
    private WebElement txtUserEmail;

    @FindBy(xpath=("//*[@id='userPassword']"))
    private WebElement txtUserPassword;

    @FindBy(xpath=("//*[@id='login']"))
    private WebElement loginButton;


    private void ObjectFeildMap(){
        feildElementMap.put("userEmail",txtUserEmail);
        feildElementMap.put("userPassword",txtUserPassword);
        feildElementMap.put("loginButton",loginButton);
    }
   public boolean loginToApp()
   {
       loginSetupPage loginSetup=new loginSetupPage(driver);
       return loginSetup.loginToApp(feildElementMap);
   }
}
