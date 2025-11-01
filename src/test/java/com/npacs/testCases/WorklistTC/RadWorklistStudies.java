package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.*;
import com.npacs.testCases.BaseClass;
import com.npacs.utilities.Screenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class RadWorklistStudies extends BaseClass {

    String PatientID = "713031";
   // String PrelimPatientID = "688365";

    @Test (priority = 0, groups = {"smoke"})
    public void NavigateReprtingForm() throws InterruptedException {
        lp.radVijayLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        Thread.sleep(2000);
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
    }


    @Test (priority = 1, groups = {"smoke"})
    public void ValidateToSavePrelimReport() throws InterruptedException, IOException {
        Re.verifyPatientTab();
        Re.openPrelimReport();
        Re.AddPrelimContent();
        Re.saveReport();
    }

    @Test (priority = 2, groups = {"smoke"})
    public void ValidateToDiscardSavedPrelimReport() throws InterruptedException, IOException {
        Re.verifyPatientTab();
        Re.DiscardReport(Re.PrelimReportRow3dots, true);
    }

    @Test (priority = 3)
    public void ValidateToReviewPrelimReport() throws InterruptedException {
        Re.verifyPatientTab();
        Re.openPrelimReport();
        Re.AddPrelimContent();
        Re.saveReport();
        Thread.sleep(3000);
        Re.SignReport();
      //  Re.PrintPreview();
    }
//This testcase not executed dur to not able to escape from 3 dot menu in reporting
//    @Test (priority = 4, groups = {"smoke"})
//    public void ValidateToDiscardReviewedPrelimReport() throws InterruptedException, IOException {
//        Re.verifyPatientTab();
//        Re.DiscardReport(Re.PrelimReportRow3dots, false);
//    }

    @Test (priority = 5, groups = {"smoke"})
    public void ValidateToCreateFinalReportAndSave() throws InterruptedException, IOException {
        Re.createFinalReport();
        Thread.sleep(1000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Thread.sleep(1000);
     //   Re.PrintPreview();
    }

    @Test (priority = 6)
    public void ValidateToDiscardSavedFinalReport() throws InterruptedException {
    //    Re.verifyPatientTab();
        Re.DiscardReport(Re.SavedReportRow3dots, true);
        Thread.sleep(1000);
    }

    //Disable the Auto save, then only it is working fine
   @Test (priority = 7, groups = {"smoke"})
    public void ValidateToAddNewReportAndDraft() throws InterruptedException, IOException {
        Re.addNewReport();
       Thread.sleep(1000);
       Re.selectTemplate();
       Thread.sleep(3000);
       Re.saveReport();
       Thread.sleep(1000);
       Re.DraftReport();
       Thread.sleep(1000);
      // Re.PrintPreview();
    }

    @Test (priority = 8)
    public void ValidateToDiscardDraftedFinalReport() throws InterruptedException {
        Re.DiscardReport(Re.DraftedReportRow3dots, true);
        Thread.sleep(1000);
    }

    @Test (priority = 9, groups = {"smoke"})
    public void ValidateToAddNewReportAndReview() throws InterruptedException, IOException {
        Re.addNewReport();
        Thread.sleep(2000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Thread.sleep(1000);
        Re.DraftReport();
        Thread.sleep(1000);
        Re.SignReport();
        //Re.PrintPreview();
    }

    //This testcase not executed dur to not able to escape from 3 dot menu in reporting
//    @Test (priority = 10)
//    public void ValidateToDiscardReviewedReport() throws InterruptedException {
//             Re.DiscardReport(Re.ReviewedReportRow3dots, false);
//    }

    @Test (priority = 11, groups = {"smoke"})
    public void ValidateToEditReviewdReportAndSaveAndReConfirmed() throws InterruptedException {
        Thread.sleep(1000);
        Re.EditTheReport();
        Thread.sleep(1000);
        Re.saveReport();
        Thread.sleep(3000);
        Re.SignReport();
        Thread.sleep(1000);
    }

    @Test (priority = 12, groups = {"smoke"})
    public void ValidateToSaveAddendumReport() throws InterruptedException, IOException {
        Re.addAddendumReport();
        Thread.sleep(1000);
        Re.saveReport();
        Thread.sleep(1000);
    }

    @Test (priority = 13)
    public void ValidateToDiscardSavedAddendumReport() throws InterruptedException {
        Re.DiscardReport(Re.AddendumReportRow3dots, true);
        Thread.sleep(2000);
    }

    @Test (priority = 14, groups = {"smoke"})
    public void ValidateToReviewAddendumReport() throws InterruptedException, IOException {
        Re.addAddendumReport();
        Thread.sleep(1000);
        Re.saveReport();
        Thread.sleep(1000);
        Re.SignReport();
    }

    //This testcase not executed dur to not able to escape from 3 dot menu in reporting
//    @Test (priority = 15)
//    public void ValidateToDiscardReviewedAddendumReport() throws InterruptedException {
//        Re.verifyPatientTab();
//        Re.DiscardReport(Re.AddendumReportRow3dots, false);
//    }



}




