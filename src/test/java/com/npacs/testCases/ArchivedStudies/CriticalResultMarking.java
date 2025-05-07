package com.npacs.testCases.ArchivedStudies;

import com.npacs.pageObjects.ArchivedStudiesElements;
import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.BeforeClass;

public class CriticalResultMarking extends BaseClass {

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


}
