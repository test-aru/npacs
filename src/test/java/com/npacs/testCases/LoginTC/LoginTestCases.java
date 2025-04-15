package com.npacs.testCases.LoginTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.testCases.BaseClass;
import org.apache.poi.ddf.EscherRecord;
import org.testng.annotations.Test;
import com.npacs.utilities.Screenshot;


public class LoginTestCases extends BaseClass {
    public void login() throws InterruptedException {
        LoginAssertions la=new LoginAssertions(driver);
        LoginPageElements lp=new LoginPageElements(driver);
        la.navigatedToLoginScreen();
//        String username = "raster";
//        String password = "raster";
        lp.loginApplication("raster","raster");
        //Screenshot.takeScreenshot(driver);
        la.navigatedToDashboardScreen();

    }

    @Test(priority=0)
    public void loginWithValidUsernameAndPassword() throws InterruptedException {
        LoginAssertions la=new LoginAssertions(driver);
        LoginPageElements lp=new LoginPageElements(driver);
        la.navigatedToLoginScreen();
        String username = "raster";
        String password = "raster";
        lp.loginApplication(username,password);
        //Screenshot.takeScreenshot(driver);
        la.navigatedToDashboardScreen();

    }

    @Test (priority=1)
    public void loginWithInValidUsernameAndValidPassword(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "raster0";
        String password = "raster";
        lp.loginApplication(username,password);
       // Screenshot.takeScreenshot(driver);
        la.navigatedToDashboardScreen();
    }
    @Test (priority=2)
    public void loginWithValidUsernameAndInValidPassword(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "raster";
        String password = "raster0";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
    }
    @Test (priority=3)
    public void loginWithInValidUsernameAndInValidPassword(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "raster0";
        String password = "raster0";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
    }
    @Test (priority=4)
    public void loginWithUsernameAndPasswordInUpperCase(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "RASTER";
        String password = "RASTER";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
    }
    @Test (priority=5)
    public void loginWithUsernameAndPasswordInSpecialChar(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "RAS%^&#";
        String password = "RAS@!$%";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
    }
    @Test (priority=6)
    public void loginWithUsernameAndPasswordIsEmpty(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "    ";
        String password = "    ";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
    }
    @Test (priority=7)
    public void loginWithUsernameAndEmptyPassword(){
        LoginAssertions la=new LoginAssertions(driver);
        la.navigatedToLoginScreen();
        LoginPageElements lp=new LoginPageElements(driver);
        String username = "raster";
        String password = "    ";
        lp.loginApplication(username,password);
        la.navigatedToDashboardScreen();
    }


}
