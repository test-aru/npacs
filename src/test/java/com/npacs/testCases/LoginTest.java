package com.npacs.testCases;

import com.npacs.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{

    @Test
    public void adminLogin(){
        LoginPage lp=new LoginPage(driver);
        String username = "raster";
        String password = "raster";
        lp.loginApplication(username,password);
    }


}
