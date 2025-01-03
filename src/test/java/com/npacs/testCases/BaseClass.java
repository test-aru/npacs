package com.npacs.testCases;

import com.npacs.utilities.BrowserFactory;
import com.npacs.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseClass   {

    public WebDriver driver;
    public ReadConfig config = new ReadConfig();

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getApplicationURL());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        BrowserFactory.quitBrowser(driver);
    }


}
