package com.npacs.testCases;

import com.npacs.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{

    @Test
    public void adminLoginTest(){
        LoginPage lp=new LoginPage(driver);
        String username = "raster";
        String password = "raster";
        lp.loginApplication(username,password);
    }

    @Test
    public void drVijayLoginTest(){
        LoginPage lp=new LoginPage(driver);
        String username = "user.0";
        String password = "user@0";
        lp.loginApplication(username,password);
    }

    @Test
    public void gatekeeperLoginTest(){
        LoginPage lp=new LoginPage(driver);
        String username = "user.201";
        String password = "user201";
        lp.loginApplication(username,password);
    }



}
