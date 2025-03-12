package com.npacs.testCases.ArchivedStudies;

import com.npacs.pageObjects.ArchivedStudiesElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.Test;

public class PatientStudyInfoUpdate extends BaseClass {

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
        Ae.searchPatient("685239");
    }




}
