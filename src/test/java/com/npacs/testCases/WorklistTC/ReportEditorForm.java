package com.npacs.testCases.WorklistTC;

import com.npacs.pageObjects.*;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReportEditorForm extends BaseClass {

    String PatientID = "689789";

    LoginPageElements lp;
    DashboardElements db;
    RadWorklistElements rw;
    ArchivedStudiesElements Ae;
    ModularReportingElements Re;

    @BeforeClass
    public void setUp() throws InterruptedException {
        lp = new LoginPageElements(driver);
        db = new DashboardElements(driver);
        rw = new RadWorklistElements(driver);
        Ae = new ArchivedStudiesElements(driver);
        Re = new ModularReportingElements(driver);
        lp.radVijayLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast15Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
        Re.verifyPatientTab();
    }

    @Test(priority = 0)
    public void ValidatePDFPreviewWithMetaTag() throws InterruptedException, IOException {
        Re.selectTemplate();
        Thread.sleep(2000);
        Re.EnterMetaTagContent();
        Thread.sleep(1000);
        Re.saveReport();
        Thread.sleep(1000);
        Re.PrintPreview();

    }
}
