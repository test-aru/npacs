package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.*;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadWorklistStudies extends BaseClass {

    String PatientID = "692014";

    @Test (priority = 0)
    public void ValidateReporting() throws InterruptedException {
       // LoginPageElements lp=new LoginPageElements(driver);
        lp.radVijayLogin();
      //  DashboardElements db=new DashboardElements(driver);
        db.clickOnWorklistArchive();
    //    RadWorklistElements rw=new RadWorklistElements(driver);
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
  //      ModularReportingElements Re = new ModularReportingElements(driver);
        Re.verifyPatientTab();
//        Re.getAllCardStudies();
        Re.selectTemplate();
        Thread.sleep(2000);
        Re.saveReport();
        Re.DraftReport();
        Re.SignReport();
        Re.PrintPreview();
        Re.EditTheReport();
        Re.backToWorklist();
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        rw.getResultStatus();
       // Re.saveReport();
        Re.SignReport();
        Re.backToWorklist();
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        rw.getResultStatus();

    }




}




