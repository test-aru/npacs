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
    @FindBy(xpath = "//*[@mattooltip=\"Search\"]")
    WebElement SearchIcon;


    public void ApplyThisMonthDate() throws InterruptedException {
        Thread.sleep(500);
        PresetDate.click();
        Thread.sleep(500);
        ThisMonth.click();
    }

    public void searchPatient(String patientID) throws InterruptedException {
        PatientIDsearch.sendKeys(patientID);
        Thread.sleep(500);
        SearchIcon.click();
    }

}
