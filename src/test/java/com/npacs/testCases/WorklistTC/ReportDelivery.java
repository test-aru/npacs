package com.npacs.testCases.WorklistTC;

import com.npacs.testCases.BaseClass;
import com.npacs.utilities.Screenshot;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ReportDelivery extends BaseClass {

    String PatientID = "710467ck jenk";


    @Test (priority = 0, groups = {"smoke"})
    public void RadiologistReviewedTheReport() throws InterruptedException {
        lp.radPoornaPrakashLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        Thread.sleep(1000);
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
        Re.selectTemplate();
        Thread.sleep(3000);
        Re.saveReport();
        Thread.sleep(1000);
        Re.DraftReport();
        Thread.sleep(1000);
        Re.SignReport();
        db.Logout();
    }

    @Test(priority = 1, groups = {"smoke"})
    public void ValidateReportDelivery() throws InterruptedException {
        lp.gatekeeperLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        rw.searchPatient(PatientID);
        Actions ac = new Actions(driver);
        ac.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        rw.openReportDetailsPopup();
        rw.openDeliveryPopup();
        rw.fillDeliveryDetailsAndSubmit("2","patient","7092826714", "text@raster.in","Self","Delivered");
        rw.closeReportDetailsPopup();
    }

    @Test(priority = 2, groups = {"smoke"})
    public void ValidateToEditDeliveryLog() throws InterruptedException {
        rw.openReportDetailsPopup();
        rw.openDeliveryPopup();
        rw.clickOnDeliveryLogEdit();
        rw.UpdateDeliveryLogDetails("4");
        rw.closeDeliveryLogPopup();
    }

    @Test(priority = 3, groups = {"smoke"})
    public void ValidateToRevokeReportDelivery() throws InterruptedException {
        rw.openReportDetailsPopup();
        rw.openDeliveryPopup();
        rw.clickOnDeliveryLogEdit();
        rw.RevokeReportDelivery("Modify the Report");
        rw.closeDeliveryLogPopup();
        db.Logout();
    }

    @Test(priority = 4, groups = {"smoke"})
    public void ValidateEditButtonAfterDelivered() throws InterruptedException {
        lp.radPoornaPrakashLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Re.checkEditButtonInReporting();

    }

}
