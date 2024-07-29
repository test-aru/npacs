package com.npacs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"username\"]") WebElement Username;
    @FindBy(xpath="//*[@id=\"password\"]") WebElement Password;
    @FindBy(xpath="//*[@id=\"kc-login\"]") WebElement Submit;

//    @FindBy(name ="uid") WebElement txtusername;
//    @FindBy(name="password") WebElement txtpassword;
//    @FindBy(name="btnLogin") WebElement submit;

    public void setUsername(String username){
        this.Username.sendKeys(username);
    }

    public void setPassword(String password){
        this.Password.sendKeys(password);
    }

    public void clickSubmit(){
        Submit.click();
    }

}
