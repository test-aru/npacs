package com.npacs.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl)
    {

        if(browserName.equals("Chrome"))
        {
            //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_132");
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_138");
            ChromeOptions op = new ChromeOptions();
            //op.addArguments("--headless");
            op.addArguments("--remote-allow-origins=*");
            op.addArguments("--disable-application-cache");
            op.addArguments("--disk-cache-size=0");
            op.addArguments("--incognito"); // optional: incognito mode disables many forms of caching
            op.addArguments("--start-maximized");
            driver = new ChromeDriver(op);
        }
        else if(browserName.equals("Firefox"))
        {
            System.setProperty("webdriver.chrome.driver", "./drivers/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
           // options.addArguments("--headless");
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("IE"))
        {
            System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else
        {
            System.out.println("We do not support this browser ");
        }

        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitBrowser(WebDriver driver)
    {
        driver.quit();
    }
}
