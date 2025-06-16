package com.npacs.utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Screenshot {

   public static void takeScreenshot(WebDriver driver) throws InterruptedException, IOException {
       Thread.sleep(3000);
       try {
           System.out.println("Test Passed");
       }
       catch (Exception e) {
          System.out.println("Test Failed : "+e.getMessage()) ;
       } finally{
           // Check if the driver is not null and supports taking screenshots
           if (driver != null && driver instanceof TakesScreenshot screenshotDriver) {

               // Capture the screenshot and save it as a file
               File scrShot = screenshotDriver.getScreenshotAs(OutputType.FILE);

               // Generate a timestamp to make the filename unique
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
               String timestamp = dateFormat.format(new Date());

               // Create a unique filename by appending the timestamp to the original filename
               String filename = "screenshot_" + timestamp + ".png";

               // Now, you can handle the scrShot File using the unique filename
               // For example:
               System.out.println("screenshot initiated");
               FileUtils.copyFile(scrShot, new File("./Screenshots/" + filename));
               System.out.println("screenshot Taken");
           } else {
               System.out.println("WebDriver is null or does not support taking screenshots.");
           }
       }

   }


}
