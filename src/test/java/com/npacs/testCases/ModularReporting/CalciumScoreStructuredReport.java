package com.npacs.testCases.ModularReporting;

import com.npacs.testCases.BaseClass;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;
import org.testng.annotations.Test;

public class CalciumScoreStructuredReport extends BaseClass {

    //Select study which have "Ca Score(Adult)" and "Coronary CTA" DESCRIPTIONS.
    String PatientID = "712108";
    // String PrelimPatientID = "688365";
    String ExpectedClinicalHistory = "Atherosclerotic cardiovascular disease risk stratification";

    @Test(priority = 0, groups = {"smoke"})
    public void NavigateReportingForm() throws InterruptedException {
        lp.radVijayLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        Thread.sleep(2000);
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void ValidateStudyAndClickOnCalciumReport() throws InterruptedException {
        Re.validateStudyDesc();
    }

    @Test(priority = 2)
    public void ValidateStudyTitle() throws InterruptedException {
        Re.validateStudyTitleinCalciumReportForm();
    }

    @Test(priority = 3)
    public void ValidateClinicalIndication() throws InterruptedException {
        Re.validateClinicalIndicationInCalciumReportForm(ExpectedClinicalHistory);
    }

    @Test(priority = 4)
    public void ValidateProtocol() throws InterruptedException {
        Re.validateProtocolinCalciumReportForm();
    }

    @Test(priority = 5)
    public void ValidateNormalCalciumReport() throws InterruptedException {
        Re.NormalCalciumScoreReport();
        Re.AddAdditionalFindings("Normal","25","10","16");
        Re.saveReport();
        Re.PrintPreview();

    }

    @Test(priority = 6)
    public void ValidateAbnormalCalciumReport(){
        Re.NormalCalciumScoreReport();
        Re.InputArteryValuesAndCalculateAgatstonScore();
        Re.getTotalAgatstonScoreInFormAndValidateAgatstonScore();
        Re.AddAdditionalFindings("Normal","25","10","16");
    }

    @Test(priority = 8)
    public void SaveCalciumReport() throws InterruptedException {
        Re.saveReport();
    }

    @Test(priority = 9)
    public void DraftCalciumReport() throws InterruptedException {
        Re.DraftReport();
    }

    @Test(priority = 10)
    public void ReviewCalciumReport() throws InterruptedException {
        Re.SignReport();
        Re.PrintPreview();
    }

    @Test(priority = 11)
    public void validateEditProvision() throws InterruptedException {
        Re.checkEditButtonInReporting();
    }

}
