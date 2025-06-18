package com.npacs.testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.*;
import com.npacs.utilities.BrowserFactory;
import com.npacs.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseClass   {

    public static WebDriver driver;
    public ReadConfig config = new ReadConfig();

    protected ArchivedStudiesElements Ae;
    protected DashboardElements db;
    protected RadWorklistElements rw;
    protected LoginPageElements lp;
    protected ModularReportingElements Re;


    @BeforeClass
    public void setup() throws InterruptedException {
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getApplicationURL());
        Ae = new ArchivedStudiesElements(driver);
        db = new DashboardElements(driver);
        rw = new RadWorklistElements(driver);
        lp = new LoginPageElements(driver);
        Re = new ModularReportingElements(driver);
    }

//    @AfterClass
//    public void tearDown() throws InterruptedException{
//        BrowserFactory.quitBrowser(driver);
//    }




}
