package com.npacs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"username\"]") WebElement Username;
    @FindBy(xpath="//*[@id=\"password\"]") WebElement Password;
    @FindBy(xpath="//*[@id=\"kc-login\"]") WebElement Submit;

    public void loginApplication(String username,String password){
        Username.sendKeys(username);
        Password.sendKeys(password);
        Submit.click();
    }

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
