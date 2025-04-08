package com.npacs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ArchivedStudiesElements {

    WebDriver driver;

    public ArchivedStudiesElements(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/mat-form-field/div/div/div/mat-select[@placeholder=\"Search Date\"][@formcontrolname=\"defaultDateFilter\"]")
    WebElement PresetDate;
    @FindBy(xpath = "//*[@role=\"listbox\"]")
    WebElement PresetDates;
    @FindBy(xpath = "//*[@role=\"listbox\"]/mat-option[7]")
    WebElement ThisMonth;
    @FindBy(xpath = "//*[@formcontrolname=\"patientId\"]")
    WebElement PatientIDsearch;
    @FindBy(xpath = "//*[@formcontrolname=\"patientNameBoxValue\"]")
    WebElement PatientNamesearch;
    @FindBy(xpath = "//*[@mattooltip=\"Search\"]")
    WebElement SearchIcon;
    @FindBy(xpath = "//tr[1]/td[9]/button[2]/span/mat-icon")
    WebElement matIcon;
    @FindBy(xpath = "//div/button[3][contains(text(),'Update Patient / Study Info')]")
    WebElement UpdatePatientStudyInfo;
    @FindBy(xpath = "//div/h3[contains(text(),' Update Patient / Study Information ')]")
    WebElement UpdatePatientTitle;
    @FindBy(xpath = "//td[4]/span") WebElement PatientNameInStudyRow;
    @FindBy(xpath = "//tr[1]/td[3]") WebElement PatientIDInStudyRow;
    @FindBy(xpath = "//app-patient-info/div/div/div/div[1]/p[1]") WebElement PatientNameInPopup;
    @FindBy(xpath = "//*[contains(text(),' Patient Details')]") WebElement PatientDetailsCheckbox;
    @FindBy(xpath="//*[contains(text(),'Update Study Details')]") WebElement UpdateStudyDetailsCheckbox;
    @FindBy(xpath = "//*[contains(text(),'Update Other Details')]") WebElement UpdateOtherDetailsCheckbox;
    @FindBy(id = "patId") WebElement PatientID;
    @FindBy(xpath = "//*[@formcontrolname=\"issuerVal\"]") WebElement IssuerOfPatientID;
    @FindBy(id = "patName") WebElement PatientName;
    @FindBy(xpath = "//*[@id=\"mat-dialog-2\"]/app-patient-info/div/div[3]/form/div[2]/div[4]/mat-form-field/div/div[1]/div/mat-datepicker-toggle/button") WebElement DOB;
    @FindBy(xpath = "//*[@formcontrolname=\"gender\"]") WebElement Gender;
    @FindBy(xpath = "//app-patient-info/div/div[5]/button[2]") WebElement UpdateButton;
    @FindBy(xpath="//app-patient-info/div/div[5]/button[1]") WebElement CancelButton;

    public void ApplyThisMonthDate() throws InterruptedException {
        Thread.sleep(500);
        PresetDate.click();
        Thread.sleep(500);
        ThisMonth.click();
    }

    public void searchPatientID(String patientID) throws InterruptedException {
        PatientIDsearch.clear();
        PatientIDsearch.sendKeys(patientID);
        Thread.sleep(500);
        SearchIcon.click();
        Thread.sleep(500);
    }

    public void searchPatientName(String patientName) throws InterruptedException {
        PatientNamesearch.clear();
        PatientNamesearch.sendKeys(patientName);
        Thread.sleep(500);
        SearchIcon.click();
        Thread.sleep(500);
    }



    public void clickOnMatIcon() throws InterruptedException {
        Thread.sleep(500);
        matIcon.click();
        Thread.sleep(500);
        UpdatePatientStudyInfo.click();
    }

    public boolean verifyPopupTitle(){
        String expectedTitle = "Update Patient / Study Information";
        String actualTitle = UpdatePatientTitle.getText();
        boolean PopupTitle = actualTitle.contains(expectedTitle);
        if (PopupTitle) {
            System.out.println("Successfully opened and Current title: " + actualTitle);
        } else {
            System.out.println("Failed and Current title: " + actualTitle);
        }
        return PopupTitle;
    }

    public void verifyPatient(){
        String expectedPatientName = PatientNameInStudyRow.getText();
        String actualPatientName = PatientNameInPopup.getText();
        boolean patientName = actualPatientName.equals(expectedPatientName);
        if (patientName) {
            System.out.println("Patient Name is correct: " + actualPatientName);
        } else {
            System.out.println("Patient Name is incorrect: " + actualPatientName);
        }
    }

    public void openPatientEditPopup() throws InterruptedException {
        clickOnMatIcon();
        Thread.sleep(500);
        verifyPopupTitle();
        verifyPatient();
    }

    public void EditPatientDetails(){
        PatientDetailsCheckbox.click();
    }

    public void EditStudyDetails(){
        UpdateStudyDetailsCheckbox.click();
    }

    public void EditOtherDetails(){
        UpdateOtherDetailsCheckbox.click();
    }

    public void verifyUpdatedPatientID(String patientID){
        String PatientIDinStudy = PatientIDInStudyRow.getText();
        String[] lines = PatientIDinStudy.split("\n");
        String FirstRowText = lines[0];
        //System.out.println("Patient ID in study row is: " + FirstRowText);
        String EditedPatID = patientID;
        boolean patientid = FirstRowText.equals(EditedPatID);
        if (patientid) {
            System.out.println("Patient ID is Updated as : " + PatientIDinStudy);
        } else {
            System.out.println("Patient ID is not updated. Patient ID is : " + PatientIDinStudy);
        }

    }

    public void verifyUpdatedPatientName(String patientName){
        String PatientNameinStudy = PatientNameInStudyRow.getText();
        String[] lines = PatientNameinStudy.split("\n");
        String FirstRowText = lines[0];
        //System.out.println("Patient ID in study row is: " + FirstRowText);
        String EditedPatName = patientName;
        boolean patientid = FirstRowText.equals(EditedPatName);
        if (patientid) {
            System.out.println("Patient Name is Updated as : " + PatientNameinStudy);
        } else {
            System.out.println("Patient Name is not updated. Patient ID is : " + PatientNameinStudy);
        }

    }


    public void EditPatientID(String patientID) throws InterruptedException {
        EditPatientDetails();
        PatientID.clear();
        PatientID.sendKeys(patientID);
        UpdateButton.click();
        Thread.sleep(1000);
    }

    public void EditPatientName(String patientName) throws InterruptedException {
        EditPatientDetails();
        PatientName.clear();
        PatientName.sendKeys(patientName);
        UpdateButton.click();
        Thread.sleep(1000);
    }
}
