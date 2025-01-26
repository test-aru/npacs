package com.npacs.testCases.LoginTC;

import com.npacs.pageObjects.LoginPageElements;
import com.npacs.testCases.BaseClass;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.annotations.Test;

public class RolesLoginTest extends BaseClass {

    @Test
    public void adminLoginTest() throws InterruptedException {
        LoginPageElements lp=new LoginPageElements(driver);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        String username = "raster";
        String password = "raster";
        lp.loginApplication(username,password);

    }

    @Test
    public void drVijayLoginTest(){
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "user.0";
        String password = "user@0";
        lp.loginApplication(username,password);

    }

    @Test
    public void gatekeeperLoginTest(){
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "user.201";
        String password = "user201";
        lp.loginApplication(username,password);

    }

    @Test
    public void technicianLoginTest(){
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "user.301";
        String password = "user301";
        lp.loginApplication(username,password);

    }

}
