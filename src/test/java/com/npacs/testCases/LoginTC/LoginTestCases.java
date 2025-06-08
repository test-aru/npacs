package com.npacs.testCases.LoginTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.testCases.BaseClass;
import com.npacs.utilities.BrowserFactory;
import com.npacs.utilities.Screenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.npacs.utilities.ReadExcel;

import java.io.IOException;


public class LoginTestCases extends BaseClass {


    @Test(priority=8)
    public void loginWithValidUsernameAndPassword() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        LoginPageElements lp=new LoginPageElements(driver);
        la.navigatedToLoginScreen();
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(1);
        String username = crdentials[0];
        String password = crdentials[1];
       // String username = "raster";
       // String password = "raster";
        lp.loginApplication(username,password);
        //Screenshot.takeScreenshot(driver);
        la.navigatedToDashboardScreen();
        //db.RefreshPage();
    }

    @Test (priority=1)
    public void loginWithInValidUsernameAndValidPassword() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(2);
        String username = crdentials[0];
        String password = crdentials[1];
       // String username = "raster0";
      //  String password = "raster";
        lp.loginApplication(username,password);
        Screenshot.takeScreenshot(driver);
        la.navigatedToDashboardScreen();
        db.RefreshPage();
    }

    @Test (priority=2)
    public void loginWithValidUsernameAndInValidPassword() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(3);
        String username = crdentials[0];
        String password = crdentials[1];
       // String username = "raster";
       // String password = "raster0";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
        db.RefreshPage();

    }

    @Test (priority=3)
    public void loginWithInValidUsernameAndInValidPassword() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(4);
        String username = crdentials[0];
        String password = crdentials[1];
       // String username = "raster0";
       // String password = "raster0";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
        db.RefreshPage();
    }

    @Test (priority=4)
    public void loginWithUsernameAndPasswordInUpperCase() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(5);
        String username = crdentials[0];
        String password = crdentials[1];
      //  String username = "RASTER";
      //  String password = "RASTER";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
        db.RefreshPage();
    }

    @Test (priority=5)
    public void loginWithUsernameAndPasswordInSpecialChar() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
       LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(6);
        String username = crdentials[0];
        String password = crdentials[1];
     //   String username = "RAS%^&#";
     //   String password = "RAS@!$%";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
        db.RefreshPage();
    }

    @Test (priority=6)
    public void loginWithUsernameAndPasswordIsEmpty() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(7);
        String username = crdentials[0];
        String password = crdentials[1];
      //  String username = "    ";
      //  String password = "    ";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
        db.RefreshPage();
    }

    @Test (priority=7)
    public void loginWithUsernameAndEmptyPassword() throws InterruptedException, IOException {
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        ReadExcel obj = new ReadExcel();
        String[] crdentials = obj.getUsernamePasswordFromExcel(8);
        String username = crdentials[0];
        String password = crdentials[1];
      //  String username = "raster";
      //  String password = "    ";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
        db.RefreshPage();
    }


}
