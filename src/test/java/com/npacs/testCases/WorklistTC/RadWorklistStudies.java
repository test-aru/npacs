package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.ModularReportingElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.Test;

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
        rw.searchPatient("584511");
        Thread.sleep(1000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(1000);
        ModularReportingElements Re = new ModularReportingElements(driver);
        Re.verifyPatientTab();
        Re.selectTemplate();
        Re.saveReport();

    }

//    @Test (priority = 1)
//    public void searchPatients()  {
//        RadWorklistElements rw=new RadWorklistElements(driver);
//
//    }












}




