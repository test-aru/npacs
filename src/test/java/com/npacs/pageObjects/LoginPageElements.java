package com.npacs.pageObjects;

import com.npacs.assertions.LoginAssertions;
import com.npacs.testCases.BaseClass;
import com.npacs.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPageElements extends BaseClass {

    WebDriver driver;

    public LoginPageElements(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"username\"]") WebElement Username;
    @FindBy(xpath="//*[@id=\"password\"]") WebElement Password;
    @FindBy(xpath="//*[@id=\"kc-login\"]") WebElement Submit;
    @FindBy(xpath="//div/button[5]/span[@class=\"mat-button-focus-overlay\"]") WebElement ProfileIcon;
    @FindBy(xpath="/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/mat-toolbar/div[2]/div[1]/div[2]") WebElement LoginUser;

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


    public void verifyLoginUser() throws InterruptedException {
        Thread.sleep(3000);
        ProfileIcon.click();
        System.out.println("Profile icon clicked.");
        LoginUser.getText();
        System.out.println("Logged in user is: " + LoginUser.getText());

    }
}
