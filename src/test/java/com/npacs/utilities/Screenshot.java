package com.npacs.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.npacs.testCases.BaseClass.driver;

public class Screenshot {

    public String captureScreenshot(String scrname){
        String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = "./Screenshots/" + scrname + "_" + timeStamp + ".png";
        File dest = new File(screenShotPath);

        try{
            FileUtils.copyFile(sourceFile, dest);
            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
            return dest.getAbsolutePath();
        }catch(Exception e){
            System.out.println("Screenshot error: "+ e.getMessage());
            return  null;
        }
    }

}
