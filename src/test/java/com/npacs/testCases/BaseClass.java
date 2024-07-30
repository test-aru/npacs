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

    /*ReadConfig readConfig = new ReadConfig();
    public String baseURL=readConfig.getApplicationURL();
    public String adminUsername=readConfig.adminUname();
    public String adminPassword=readConfig.adminPwd();
    public String radVijayUsername= readConfig.radVijayUname();
    public String radVijayPassword= readConfig.radVijayPwd();
    public static WebDriver driver;
*/
    // public String baseURL="https://demo.guru99.com/V3/index.php";
    //public String username="mngr583237";
    //public String password="YtEbUsY";
    //public static WebDriver driver;

    @BeforeClass
    public void setup(){
       // System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver_127");
        //
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getApplicationURL());
       // driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() throws InterruptedException{
        BrowserFactory.quitBrowser(driver);
    }


}
