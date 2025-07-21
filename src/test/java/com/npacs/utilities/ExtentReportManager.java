package com.npacs.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.activation.FileDataSource;
import javax.management.relation.RelationSupport;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;
    public WebDriver driver;
    public Map<String, ExtentTest> classTestMap = new HashMap<>(); // 🔑 Class name -> ExtentTest (parent)

    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "NPACS-Test-Report-"+ timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".//reports//"+ repName);

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "NPACS");
        extent.setSystemInfo("Module", "Reporting");
        extent.setSystemInfo("Server", "Testing Server (112)");
        extent.setSystemInfo("Browser", "Chrome_Version_136");
        extent.setSystemInfo("Machine", "Linux");
        extent.setSystemInfo("Tester", "Arunkarthick");

        //get os and browser value dynamically from the xml file
//        String os = context.getCurrentXmlTest().getParameter("os");
//        extent.setSystemInfo("Operating System", os);
//        String browser  = context.getCurrentXmlTest().getParameter("browser");
//        extent.setSystemInfo("Browser", browser);

        //get testng group from the xml file and attach it to report
        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()){
            extent.setSystemInfo("Groups", includedGroups.toString());
        }

    }


    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        // Create parent class node if not present
        if(!classTestMap.containsKey(className)){
            ExtentTest parentTest = extent.createTest(className);
            classTestMap.put(className, parentTest);
        }
        test = classTestMap.get(className).createNode(methodName);

        System.out.println("------------ Test Started: " + methodName + " ------------");
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test case PASSED is : " + result.getName());
        test.assignCategory(result.getMethod().getGroups());

    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test case FAILED is : " + result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test case FAILED cause is : " + result.getThrowable());

        try{
            String imgPath = new Screenshot().captureScreenshot(result.getName());
            if(imgPath != null) {
                test.fail("Screenshot of failure:", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test case SKIPPED is : " + result.getName());
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        extent.flush();

        //To Automatically open the Report in Desktop
        String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName;
        File reportFile = new File(reportPath);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(reportFile.toURI());
            } catch (IOException e) {
                System.err.println("Failed to open Extent Report: " + e.getMessage());
            }
        } else {
            System.err.println("Desktop operations are not supported on this environment.");
        }


        //To create mail and send
//try{
//    //URL url = new URL("file://"+".//reports//"+repName);
//    File file = new File("reports/" + repName);
//    HtmlEmail email = new HtmlEmail();
//    email.setHostName("smtp.googlemail.com");
//    email.setSmtpPort(465);
//    email.setAuthenticator(new DefaultAuthenticator("arunkarthick.r@raster.in","Dec5@1998"));
//    email.setSSLOnConnect(true);
//    email.setFrom("arunkarthick.r@raster.in");
//    email.setSubject("Automation Test Result");
//    email.setHtmlMsg("<html><body><p>Please find Attached Report........</p></body></html>");
//    email.setTextMsg("Please view the report in an HTML-compatible email client.");
//    email.addTo("vigneswaran.p@raster.in");
//    email.attach(new FileDataSource(file), repName, "Extent Automation report");
//    email.send();
//} catch (Exception e) {
//    throw new RuntimeException(e);
//}


    }
}

