package com.npacs.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "NPACS-Test-Report-"+ timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".//reports//"+ repName);

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Server", "Testing Server (112)");
        extent.setSystemInfo("Tester", "Arunkarthick");
        extent.setSystemInfo("Browser", "Chrome_Version_136");
        extent.setSystemInfo("Machine", "Linux");

        System.out.println("Test Execution is Started..............");

    }


    public void onTestStart(ITestResult result) {
        System.out.println("-----------------------------Test Started----------------------------------");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed..............");
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is : " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed..............");
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is : " + result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is : " + result.getThrowable());
        test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped..............");
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is : " + result.getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

}

