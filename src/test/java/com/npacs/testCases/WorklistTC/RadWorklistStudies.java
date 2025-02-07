package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.ModularReportingElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadWorklistStudies extends BaseClass {


    @Test (priority = 0)
    public void openRadWorklist() throws InterruptedException {
        LoginPageElements lp=new LoginPageElements(driver);
        lp.radVijayLogin();
        DashboardElements db=new DashboardElements(driver);
        db.clickOnWorklistArchive();
        RadWorklistElements rw=new RadWorklistElements(driver);
        //rw.openWorklistMenu();
        //rw.validateReportingMenu();
        //rw.clickOnThisMonth();
        rw.clickOnLast15Days();
        rw.searchPatient("681132");
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
        ModularReportingElements Re = new ModularReportingElements(driver);
        Re.verifyPatientTab();
        Re.selectTemplate();
        Thread.sleep(2000);
        Re.saveReport();
        Re.DraftReport();
        Re.PrintPreview();
        Re.SignReport();
        Re.PrintPreview();

    }

//    public void NavigateReportingAndVerifyPatient() throws InterruptedException {
//        RadWorklistElements rw=new RadWorklistElements(driver);
//        rw.checkStatusAndNavigate();
//        Thread.sleep(2000);
//        ModularReportingElements Re = new ModularReportingElements(driver);
//        Re.verifyPatientTab();
//    }













}




