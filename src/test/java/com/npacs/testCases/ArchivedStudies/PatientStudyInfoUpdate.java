package com.npacs.testCases.ArchivedStudies;

import com.npacs.pageObjects.ArchivedStudiesElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.Test;

public class PatientStudyInfoUpdate extends BaseClass {
       String patientID = "947999";
       String patientName = "MANIKANDAN";


    @Test(priority = 0)
    public void ValidateToEditPatientID() throws InterruptedException {
        LoginPageElements lp=new LoginPageElements(driver);
        lp.adminLogin();
        DashboardElements db=new DashboardElements(driver);
        db.clickOnWorklistArchive();
        RadWorklistElements rw=new RadWorklistElements(driver);
        rw.ClickOnArchivedStudies();
        ArchivedStudiesElements Ae = new ArchivedStudiesElements(driver);
        Ae.ApplyThisMonthDate();
        Ae.searchPatientID("848885");
        Ae.openPatientEditPopup();
        Ae.EditPatientID(patientID);
        Ae.searchPatientID(patientID);
        Ae.verifyUpdatedPatientID(patientID);
    }

    @Test(priority = 1)
    public void ValidateToEditPatientName() throws InterruptedException {
        LoginPageElements lp=new LoginPageElements(driver);
        lp.adminLogin();
        DashboardElements db=new DashboardElements(driver);
        db.clickOnWorklistArchive();
        RadWorklistElements rw=new RadWorklistElements(driver);
        rw.ClickOnArchivedStudies();
        ArchivedStudiesElements Ae = new ArchivedStudiesElements(driver);
        Ae.ApplyThisMonthDate();
        Ae.searchPatientName("ADAM");
        Ae.openPatientEditPopup();
        Ae.EditPatientName(patientName);
        Ae.searchPatientName(patientName);
        Ae.verifyUpdatedPatientName(patientName);
    }



}
