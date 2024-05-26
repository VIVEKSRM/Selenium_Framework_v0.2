package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.BaseClass;

public class login extends BaseClass {
    @FindBy(id="txtUsername")
    WebElement username;

    @FindBy(id="txtPassword")
    WebElement password;

    @FindBy(id="btnLogin")
    WebElement loginBtn;

    public login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
