package com.npacs.assertions;

import com.npacs.pageObjects.LoginPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginAssertions {

    WebDriver driver;
    public LoginAssertions(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    public boolean navigatedToLoginScreen(){
        String expectedTitle = "Sign in to ris-pacs";
        String actualTitle = driver.getTitle();
        boolean isLoginScreen = actualTitle.contains(expectedTitle);
        if (isLoginScreen) {
            System.out.println("Successfully navigated to the Login screen. Current title: " + actualTitle);
        } else {
            System.out.println("Failed to navigate to the Login screen. Current title: " + actualTitle);
        }
        return isLoginScreen;
    }

    public boolean navigatedToDashboardScreen(){
        String expectedTitle = "RIS | Front Office";
        String actualTitle = driver.getTitle();
        boolean isLoginScreen = actualTitle.contains(expectedTitle);
        if (isLoginScreen) {
            System.out.println("Successfully navigated to the Dashboard screen. Current title: " + actualTitle);
        } else {
            System.out.println("Failed to navigate to the Dashboard screen. Current title: " + actualTitle);
        }
        return isLoginScreen;
    }


}
