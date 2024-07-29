package com.npacs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "uid") WebElement txtusername;
    @FindBy(name="password") WebElement txtpassword;
    @FindBy(name="btnLogin") WebElement submit;

    public void setUsername(String uname){
        txtusername.sendKeys(uname);
    }
    public void setPassword(String pwd){
        txtpassword.sendKeys(pwd);
    }
    public void clickSubmit(){
        submit.click();
    }

}
