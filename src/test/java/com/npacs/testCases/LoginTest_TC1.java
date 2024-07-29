package com.npacs.testCases;

import com.npacs.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_TC1 extends BaseClass{

    @Test
    public void loginTest(){
        driver.get(baseURL);
        LoginPage lp=new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
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
