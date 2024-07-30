package com.npacs.testCases;

import com.npacs.utilities.BrowserFactory;
import com.npacs.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseClass   {

    public WebDriver driver;
    public ReadConfig config = new ReadConfig();

    @BeforeClass
    public void setup(){
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getApplicationURL());
    }

    @AfterClass
    public void tearDown() throws InterruptedException{
        BrowserFactory.quitBrowser(driver);
    }


}
