package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.*;
import com.npacs.testCases.BaseClass;
import com.npacs.utilities.Screenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class RadWorklistStudies extends BaseClass {

    String PatientID = "695545";
   // String PrelimPatientID = "688365";

    @Test (priority = 0)
    public void NavigateReprtingForm() throws InterruptedException {
        lp.radVijayLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
    }


    @Test (priority = 1)
    public void ValidateToCreatePrelimReport() throws InterruptedException, IOException {
//        lp.radVijayLogin();
//        db.clickOnWorklistArchive();
//        rw.clickOnLast15Days();
//        rw.searchPatient(PatientID);
//        Thread.sleep(2000);
//        rw.findTotalNosRow();
//        rw.checkStatusAndNavigate();
//        Thread.sleep(2000);
        Re.verifyPatientTab();
        Re.openPrelimReport();
        Re.AddPrelimContent();
        Re.SignReport();
        Re.PrintPreview();

    }

    @Test (priority = 2)
    public void ValidateToCreateFinalReportAndSave() throws InterruptedException, IOException {
        Re.createFinalReport();
        Thread.sleep(1000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Thread.sleep(1000);
        Re.PrintPreview();

    }

   @Test (priority = 3)
    public void ValidateToAddNewReportAndDraft() throws InterruptedException, IOException {
        Re.addNewReport();
       Thread.sleep(1000);
       Re.selectTemplate();
       Thread.sleep(3000);
       Re.saveReport();
       Re.DraftReport();
       Re.PrintPreview();

    }

    @Test (priority = 4)
    public void ValidateToAddNewReportAndReview() throws InterruptedException, IOException {
        Re.addNewReport();
        Thread.sleep(2000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Re.DraftReport();
        Re.SignReport();
        //Re.PrintPreview();

    }

    @Test (priority = 5)
    public void ValidateToClickMultipleReports() throws InterruptedException, IOException {

//        lp.radVijayLogin();
//        db.clickOnWorklistArchive();
//        rw.clickOnLast15Days();
//        rw.searchPatient(PatientID);
//        Thread.sleep(2000);
//        rw.findTotalNosRow();
//        rw.checkStatusAndNavigate();
//        Thread.sleep(2000);
        Re.verifyPatientTab();
        Re.ClickOnReport("DRAFTED");
        Re.saveReport();
        Thread.sleep(2000);
        Re.ClickOnReport("REVIEWED");
        // Thread.sleep(2000);
       // Re.ClickOnReport("Saved");

    }

    @Test (priority = 6)
    public void ValidateToSwitchDraftedAndRevieweAndEdit() throws InterruptedException, IOException {
       // Re.verifyPatientTab();
        Re.ClickOnReport("DRAFTED");
        Re.saveReport();
        Re.SignReport();
        Re.PrintPreview();
        Re.EditTheReport();
        // Thread.sleep(2000);
        // Re.ClickOnReport("Saved");

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




