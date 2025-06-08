package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.*;
import com.npacs.testCases.BaseClass;
import com.npacs.utilities.Screenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadWorklistStudies extends BaseClass {

    String PatientID = "694435";
   // String PrelimPatientID = "688365";

    @Test (priority = 0)
    public void ValidateToCreatePrelimReport() throws InterruptedException {
        lp.radVijayLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
        Re.verifyPatientTab();
        Re.openPrelimReport();
        Re.AddPrelimContent();
        Re.SignReport();
        Re.PrintPreview();
        Screenshot.takeScreenshot(driver);
    }

    @Test (priority = 1)
    public void ValidateToCreateFinalReportAndSave() throws InterruptedException {
        Re.createFinalReport();
        Thread.sleep(1000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Thread.sleep(1000);
        Re.PrintPreview();
        Screenshot.takeScreenshot(driver);
    }

   @Test (priority = 2)
    public void ValidateToAddNewReportAndDraft() throws InterruptedException {
        Re.addNewReport();
       Thread.sleep(1000);
       Re.selectTemplate();
       Thread.sleep(3000);
       Re.saveReport();
       Re.DraftReport();
       Re.PrintPreview();
       Screenshot.takeScreenshot(driver);
    }

    @Test (priority = 3)
    public void ValidateToAddNewReportAndReview() throws InterruptedException {
        Re.addNewReport();
        Thread.sleep(2000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Re.DraftReport();
        Re.SignReport();
        Re.PrintPreview();
        Screenshot.takeScreenshot(driver);
    }

    @Test (priority = 4)
    public void ValidateToClickMultipleReports() throws InterruptedException {
         lp.radVijayLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
        Re.verifyPatientTab();
        Re.getReportRows();
    }





        public void ValidateToReviewFinalReport() throws InterruptedException {
//        lp.radVijayLogin();
//        db.clickOnWorklistArchive();
//        rw.clickOnLast15Days();
//        rw.searchPatient(PatientID);
//        Thread.sleep(2000);
//        rw.findTotalNosRow();
//        rw.checkStatusAndNavigate();
//        Thread.sleep(2000);
//        Re.verifyPatientTab();
//            Re.selectTemplate();
//            Thread.sleep(2000);
//            Re.saveReport();
//            Re.DraftReport();
//            Re.SignReport();
//            Re.PrintPreview();
//            Re.EditTheReport();
//        Re.backToWorklist();
//        rw.clickOnLast15Days();
//        rw.searchPatient(PatientID);
//        rw.getResultStatus();
//            Re.saveReport();
//            Re.SignReport();
//        Re.backToWorklist();
//        rw.clickOnLast15Days();
//        rw.searchPatient(PatientID);
//        rw.getResultStatus();
//            db.Logout();
        }




}




