package com.npacs.testCases.ModularReporting;

import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.ModularReportingElements;
import com.npacs.testCases.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ReportEditRquest extends BaseClass {
    String PatientID = "360754";
    private String reportName = "Child Air way-SV";
    private String patientName = "RAJAMANI 85F";

 /*   @Test
    public void ReviewFinalReport() throws InterruptedException {
        lp.radPoornaPrakashLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
      //  rw.findTotalNosRow();
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

    @Test
    public void ReportDeliveryByGatekeeper() throws InterruptedException {
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
        db.Logout();
    }

    @Test (priority = 2)
    public void ValidateToSendEditRequest() throws InterruptedException {
        lp.radPoornaPrakashLogin();
        db.clickOnWorklistArchive();
        rw.clickOnLast30Days();
        rw.searchPatient(PatientID);
        Thread.sleep(2000);
        //  rw.findTotalNosRow();
        rw.checkStatusAndNavigate();
        Thread.sleep(2000);
        Re.RequestToEdit(Re.ReviewedReportRow3dots, true);
        reportName = Re.SendReportEditRequest();
        patientName = Re.verifyPatientTab();
        db.Logout();
    }*/

    @Test (priority = 3)
    public void EditRequestApproveByHOD() throws InterruptedException {
        lp.radVijayLogin();
        db.VerifyEditRequest(reportName,patientName);


    }




}
