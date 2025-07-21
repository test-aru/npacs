package com.npacs.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginAssertions {

    WebDriver driver;
    public LoginAssertions(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    public void AssertLoginScreen(){
        String expectedTitle = "Sign in to ris-pacs";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Successfully navigated to the Login screen. Current title: " + actualTitle);
            Assert.assertTrue(true);
        } else {
            System.out.println("Failed to navigate to the Login screen. Current title: " + actualTitle);
            Assert.assertTrue(false);
        }
    }


    public void AssertDashboardScreen(){
        String expectedTitle = "RIS | Front Office";
       String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Successfully navigated to the Dashboard screen. Current title: " + actualTitle);
             Assert.assertTrue(true);
        } else {
            System.out.println("Failed to navigate to the Dashboard screen. Current title: " + actualTitle);
            Assert.assertTrue(false);
        }

    }


}
