package com.npacs.pageObjects;

import com.npacs.assertions.LoginAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPageElements{

    WebDriver driver;

    public LoginPageElements(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"username\"]") WebElement Username;
    @FindBy(xpath="//*[@id=\"password\"]") WebElement Password;
    @FindBy(xpath="//*[@id=\"kc-login\"]") WebElement Submit;
    @FindBy(xpath="//*[@class=\"mat-focus-indicator top-avatar width-auto mr-10 ml-5 mat-icon-button mat-button-base\"]") WebElement ProfileIcon;
    @FindBy(xpath="//*[@class=\"d-ib p-r mt-5 d-ib full-width fs-12 font-bold grey-clr mb-30\"]") WebElement LoginUser;

    public void loginApplication(String username,String password) {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        Username.sendKeys(username);
        Password.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        Submit.click();
    }

    public void adminLogin() throws InterruptedException {
        loginApplication("raster","raster");
    }

    public void radVijayLogin() throws InterruptedException {
        loginApplication("user.0","user@0");
    }

    public void gatekeeperLogin() throws InterruptedException {
        loginApplication("user.201","user201");
    }

    public void technicianLogin() throws InterruptedException {
        loginApplication("user.301","user301");
    }

    public void verifyLoginUser(){
        ProfileIcon.click();
        System.out.println("Profile icon clicked.");
        LoginUser.getText();
        System.out.println("Logged in user is: " + LoginUser.getText());

    }
}
