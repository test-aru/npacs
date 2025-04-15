package com.npacs.testCases.ArchivedStudies;

import com.npacs.pageObjects.ArchivedStudiesElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientStudyInfoUpdate extends BaseClass {
       String patientID = "001100";
       String patientName = "UNNAMALAIAMMAN";

    LoginPageElements lp;
    DashboardElements db;
    RadWorklistElements rw;
    ArchivedStudiesElements Ae;

       @BeforeClass
       public void setUp() throws InterruptedException {
           lp=new LoginPageElements(driver);
           db=new DashboardElements(driver);
           rw=new RadWorklistElements(driver);
           Ae = new ArchivedStudiesElements(driver);
           lp.adminLogin();
           db.clickOnWorklistArchive();
           rw.ClickOnArchivedStudies();
       }

    @Test(priority = 0)
    public void ValidateToEditPatientID() throws InterruptedException {
        Ae.ApplyThisMonthDate();
        Ae.searchPatientID("005600");
        Ae.openPatientEditPopup();
        Ae.EditPatientID(patientID);
        Ae.searchPatientID(patientID);
        Ae.verifyUpdatedPatientID(patientID);
        Ae.resetSearch();
    }

    @Test(priority = 1)
    public void ValidateToEditPatientName() throws InterruptedException {
        Ae.ApplyThisMonthDate();
        Ae.searchPatientName("UNNAMALAI");
        Ae.openPatientEditPopup();
        Ae.EditPatientName(patientName);
        Ae.searchPatientName(patientName);
        Ae.verifyUpdatedPatientName(patientName);
        Ae.resetSearch();
    }



}
