package com.npacs.testCases;

import com.npacs.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{



//    @Test
//    public void adminLogin(){
//        driver.get(baseURL);
//        LoginPage lp=new LoginPage(driver);
//        System.out.println("testttttttttttt");
//        lp.setUsername(adminUsername);
//        lp.setPassword(adminPassword);
//        lp.clickSubmit();
//        if(driver.getTitle().equals(" RIS | Front Office "))
//        {
//            Assert.assertTrue(true);
//        }
//        else{
//            Assert.assertFalse(false);
//        }
//    }

    @Test
    public void radVijayLogin(){
        driver.get(baseURL);
        LoginPage lp=new LoginPage(driver);
        lp.setUsername(radVijayUsername);
        lp.setPassword(radVijayPassword);
        lp.clickSubmit();
        if(driver.getTitle().equals(" RIS | Front Office "))
        {
            Assert.assertTrue(true);
        }
        else{
            Assert.assertFalse(false);
        }
    }

}
