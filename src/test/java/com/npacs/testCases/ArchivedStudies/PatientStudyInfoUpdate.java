package com.npacs.testCases.ArchivedStudies;

import com.npacs.pageObjects.ArchivedStudiesElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatientStudyInfoUpdate extends BaseClass {
       String searchPatientID = "688854";
       String searchPatientName = "PERIYATHAYE";

       String editPatientID = "798854";
       String editPatientName = "KIRUBA";

       @BeforeClass
       public void GoToArchivedStudies() throws InterruptedException {
           lp.loginApplication("admin","123");
           db.clickOnWorklistArchive();
           rw.ClickOnArchivedStudies();
       }

    @Test(priority = 1)
    public void ValidateToEditPatientID() throws InterruptedException {
        Ae.ApplyThisMonthDate();
        Ae.searchPatientID(searchPatientID);
        Ae.openPatientEditPopup();
        Ae.EditPatientID(editPatientID);
        Ae.searchPatientID(editPatientID);
        Ae.verifyUpdatedPatientID(editPatientID);
        Ae.resetSearch();
    }

    @Test(priority = 2)
    public void ValidateToEditPatientName() throws InterruptedException {
        Ae.ApplyThisMonthDate();
        Ae.searchPatientName(searchPatientName);
        Ae.openPatientEditPopup();
        Ae.EditPatientName(editPatientName);
        Ae.searchPatientName(editPatientName);
        Ae.verifyUpdatedPatientName(editPatientName);
        Ae.resetSearch();
    }



}
