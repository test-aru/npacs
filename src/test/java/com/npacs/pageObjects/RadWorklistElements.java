package com.npacs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadWorklistElements {

    WebDriver driver;
    public RadWorklistElements(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"ng-tns-c278-134\"]//a[contains(text(),'Reporting')]")
    WebElement reportingMenu;
    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Recently Signed')]")
    WebElement recentlySignedMenu;
    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Archived Studies')]")
    WebElement archivedStudiesMenu;

    @FindBy(xpath = "//*[@class=\"cursor-p treeview-open p-a d-ib ng-tns-c278-19\"]") WebElement worklistMenuCursor;
    @FindBy(xpath = "//button[@class=\"close-btn p-a ng-tns-c278-19\"]") WebElement worklistMenuClose;

    @FindBy(xpath = "//*[@class=\"mat-datepicker-toggle-default-icon ng-star-inserted\"]") WebElement WLdatepicker;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[7]/div/div[2]") WebElement Last15Days;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[8]/div/div[2]") WebElement ThisMonth;

    @FindBy(xpath = "//*[@data-placeholder=\"Patient Name/ID, Examination, Imaging Center ...\"]") WebElement globalSearch;

    @FindBy(xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-table/div/div[2]/div/div/div[1]/table") WebElement StudyTable;

    @FindBy(xpath = "//*[@class=\"float-r p-r d-ib ng-tns-c334-187\"]") WebElement studyStatus;

    @FindBy(xpath = "//tbody[@role=\"rowgroup\"]/tr") WebElement StudyRow;

    public boolean validateReportingMenu() {
        String expectedMenu = " Reporting ";
        String actualMenu = reportingMenu.getText();
        boolean isClickedMenu = actualMenu.contains(expectedMenu);
        if (isClickedMenu) {
            System.out.println("Current screen is Worklist : " + actualMenu);
        } else {
            System.out.println("Current screen is not Worklist. Landed screen is : " + actualMenu);
        }
        return isClickedMenu;
    }


    public void openWorklistMenu(){
        worklistMenuCursor.click();
    }

    public void closeWorklistMenu(){
        worklistMenuClose.click();
    }

    public void clickOnThisMonth() throws InterruptedException {
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        ThisMonth.click();
        System.out.println("This month is clicked");
    }

    public void clickOnLast15Days() throws InterruptedException {
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        Last15Days.click();
        System.out.println("This month is clicked");
    }

    public void findTotalNosRow(){
        // Locate the table element and get the rows
        WebElement table = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]"));
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));
        System.out.println("Total number of rows in the study table: " + rowsList.size());

        //get column data
        List<WebElement> columnsList = null;
        for (WebElement row : rowsList) {
            columnsList = row.findElements(By.tagName("td"));

            for (WebElement column : columnsList) {
                System.out.println(column.getText()+",");
            }
        }

    }

    public void checkStatusAndNavigate() throws InterruptedException {
        // get the columns size
        WebElement tableRow = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]/tr"));
        List<WebElement> colList = tableRow.findElements(By.tagName("td"));
        System.out.println("Total number of columns in the study table: " + colList.size());

        //get cell value from particular cell in row, get status of the study
        int rowIndex = 1;
        int colIndex = 7;
        if(colIndex < colList.size()){
            WebElement cell = colList.get(colIndex);
            String cellValue = cell.getAccessibleName();
            System.out.println("Cell value at row: " + rowIndex + ", column: " + colIndex + " is: " + cellValue);
        } else {
            System.out.println("Column index " + colIndex + " is out of bounds for the row " + rowIndex);
        }

        WebElement cell = colList.get(colIndex);
        String cellValue = cell.getAccessibleName();
        if (!cellValue.equals("UNASSIGNED")) {
            System.out.println("Study status is " + cellValue+". Navigated to reporting screen.");
            Thread.sleep(1000);
            StudyRow.click();
        }else{
            System.out.println("Study status is UNASSIGNED!");
        }
    }
    public void getStudyStatus(){
        System.out.println(studyStatus.getText());
    }

    public void searchPatient(String patientID){
        globalSearch.sendKeys(patientID);
        System.out.println("Search for patient entered");
    }


}
