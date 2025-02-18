package com.npacs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[1]/div/div[2]") WebElement TodayAndYesterday;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[2]/div/div[2]") WebElement Today;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[3]/div/div[2]") WebElement Yesterday;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[4]/div/div[2]") WebElement Last3Days;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[5]/div/div[2]") WebElement ThisWeek;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[6]/div/div[2]") WebElement LastWeek;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[7]/div/div[2]") WebElement Last15Days;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[8]/div/div[2]") WebElement ThisMonth;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div/div/div/mat-selection-list/mat-list-option[9]/div/div[2]") WebElement Last30Days;
    @FindBy(xpath = "//*[@data-placeholder=\"Patient Name/ID, Examination, Imaging Center ...\"]") WebElement globalSearch;
    @FindBy(xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-table/div/div[2]/div/div/div[1]/table") WebElement StudyTable;
    @FindBy(xpath = "//*[@class=\"float-r p-r d-ib ng-tns-c334-187\"]") WebElement studyStatus;
    @FindBy(xpath = "//tbody[@role=\"rowgroup\"]/tr") WebElement StudyRow;
    @FindBy(xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-table/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[7]/span[2]/span/img") WebElement AssignIcon;
    @FindBy(xpath = "//button[@role='menuitem']/span[contains(text(),'Assign To Me')]") WebElement AssignToMeButton;
    @FindBy(xpath = "//button[@role='menuitem']/span[contains(text(),'Select Ass')]") WebElement SelectAssigneeButton;
    @FindBy(xpath = "//td//span[@class=\"mat-tooltip-trigger d-ib mt-5 fs-12 font-bold grey-clr ng-tns-c334-7 ng-star-inserted\"]") WebElement RadiologistColumn;
    @FindBy(xpath = "//*[@class=\"mat-paginator-range-label\"]") WebElement WorklistPagination;
    @FindBy (xpath = "//app-report-table/div/div/form/div/div[3]/div[3]") WebElement AdvacnceFilterIcon;
    @FindBy(xpath = "//div/div/form/div[2]/div/mat-form-field/div/div/div/mat-select") WebElement RadiologistFilter;
    @FindBy(xpath = "//*[@role=\"listbox\"]") WebElement AllRadiologistsinFilter;
    @FindBy(xpath = "//*[contains(text(),'Apply')]") WebElement ApplyButton;
    @FindBy (name = "statusFilter") WebElement StatusFilter;
    @FindBy(xpath = "//div/div/div//*[@role=\"listbox\"]") WebElement AllStatuses;




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

    public void clickOnTodayAndYesterday() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        TodayAndYesterday.click();
        System.out.println("Today and Yesterday date filter is clicked");
    }

    public void clickOnToday() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        Today.click();
        System.out.println("Today date filter is clicked");
    }

    public void clickOnYesterday() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        Yesterday.click();
        System.out.println("Yesterday date filter is clicked");
    }

    public void clickOnLast3Days() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        Last3Days.click();
        System.out.println("Last 3 days date filter is clicked");
    }

    public void clickOnThisWeek() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        ThisWeek.click();
        System.out.println("This Week date filter is clicked");
    }

    public void clickOnLastWeek() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        LastWeek.click();
        System.out.println("Last Week date filter is clicked");
    }

    public void clickOnLast30Days() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        Last30Days.click();
        System.out.println("Last 30 days date filter is clicked");
    }

    public void clickOnThisMonth() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        ThisMonth.click();
        System.out.println("This month date filter is clicked");
    }

    public void clickOnLast15Days() throws InterruptedException {
        Thread.sleep(2000);
        WLdatepicker.click();
        System.out.println("clicked on date picker");
        Thread.sleep(2000);
        Last15Days.click();
        System.out.println("Last 15 days date filter is clicked");
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

    int rowIndex = 1;
    int colIndex = 7;

    public void checkStatusAndNavigate() throws InterruptedException {
        // get the columns size
       WebElement tableRow = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]/tr"));
        List<WebElement> colList = tableRow.findElements(By.tagName("td"));
        System.out.println("Total number of columns in the study table: " + colList.size());
        //get cell value from particular cell in row, get status of the study
        if(colIndex < colList.size()){
            WebElement cell = colList.get(colIndex);
            String cellValue = cell.getAccessibleName();
            System.out.println("Cell value at row: " + rowIndex + ", column: " + colIndex + " is: " + cellValue);
        } else {
            System.out.println("Column index " + colIndex + " is out of bounds for the row " + rowIndex);
        }

        // navigate to study report if status is not UNASSIGNED
        WebElement cell = colList.get(colIndex);
        String cellValue = cell.getAccessibleName();
        if (cellValue != null && !cellValue.equals("UNASSIGNED ")) {
            System.out.println("Study status is " + cellValue+"and Navigated to reporting screen.");
            Thread.sleep(2000);
            StudyRow.click();
        }else{
            System.out.println("Study status is " + cellValue);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            assignStudyToMe(1,6);
            Thread.sleep(2000);
            StudyRow.click();
        }
    }
    public void getStudyStatus(){
        System.out.println(studyStatus.getText());
    }

    public void searchPatient(String patientID) throws InterruptedException {
        globalSearch.sendKeys(patientID);
        Thread.sleep(2000);
        System.out.println("Search for patient entered");
    }


//    public void assignStudyToMe(int rowIndex,int colIndex) throws InterruptedException {
//        AssignIcon.click();
//        Thread.sleep(2000);
//        AssignToMeButton.click();
//        Thread.sleep(2000);
//        WebElement tableRow = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]/tr"));
//        List<WebElement> colList = tableRow.findElements(By.tagName("td"));
////        int rowIndex = 1;
////        int colIndex = 6;
//        if(colIndex < colList.size()){
//            WebElement cell = colList.get(colIndex);
//            String cellValue = cell.getAccessibleName();
//            Thread.sleep(3000);
//            System.out.println("Study Assigned to Radiologist " + cellValue);
//        } else {
//            System.out.println("Column index " + colIndex + " is out of bounds for the row " + rowIndex);
//        }
//    }

    public void assignStudyToMe(int rowIndex,int colIndex) throws InterruptedException {
        AssignIcon.click();
        Thread.sleep(2000);
        AssignToMeButton.click();
        Thread.sleep(2000);
        WebElement tableRow = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]/tr"));
        List<WebElement> colList = tableRow.findElements(By.tagName("td"));
        if(colIndex < colList.size()){
            WebElement cell = colList.get(colIndex);
            String cellValue = cell.getAccessibleName();
            Thread.sleep(3000);
            System.out.println("Study Assigned to Radiologist " + cellValue);
        } else {
            System.out.println("Column index " + colIndex + " is out of bounds for the row " + rowIndex);
        }
    }



    public void getResultStatus() throws InterruptedException {
        WebElement tableRow = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]/tr"));
        List<WebElement> colList = tableRow.findElements(By.tagName("td"));
        if(colIndex < colList.size()){
            WebElement cell = colList.get(colIndex);
            String cellValue = cell.getAccessibleName();
            Thread.sleep(2000);
            System.out.println("Result status is " + cellValue);
            StudyRow.click();
        } else {
            System.out.println("Column index " + colIndex + " is out of bounds for the row " + rowIndex);
        }
    }

    public int getCountTotalFromPagination(){
        String WorklistStudyCounts = WorklistPagination.getText();
        System.out.println("Pagination text: " + WorklistStudyCounts);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(WorklistStudyCounts);

    int start = 0, end = 0, total = 0;

    // Extract the numbers from the string
    int index = 0;
    while (matcher.find()) {
        if (index == 0) {
            start = Integer.parseInt(matcher.group());  // First number (start)
        } else if (index == 1) {
            end = Integer.parseInt(matcher.group());  // Second number (end)
        } else if (index == 2) {
            total = Integer.parseInt(matcher.group());  // Third number (total)
        }
        index++;
    }
    // Ensure we found the expected numbers
    if (total == -1) {
        System.out.println("Total count not found.");
    } else {
        System.out.println("Worklist Total study count is : " + total);
    }
    return total;

    }

    public void ApplyRadiologistFilter(String Radiologist) throws InterruptedException {
        AdvacnceFilterIcon.click();
        Thread.sleep(2000);
        RadiologistFilter.click();

        WebElement RadFilter = driver.findElement(By.xpath("//*[@role=\"listbox\"]"));
        List<WebElement> AllRad = RadFilter.findElements(By.tagName("mat-option"));
        System.out.println("Total radiologists in the list: " + AllRad.size());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ApplyButton));

        for (WebElement element : AllRad){
            if (element.getText().contains(Radiologist)){
                Thread.sleep(500);
                element.click();
                Thread.sleep(500);
                ApplyButton.click();
                break;
            }
        }
    }

    public List<WebElement> clickOnStatusFilter() throws InterruptedException {
        StatusFilter.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(AllStatuses));

        WebElement getAllStatus = driver.findElement(By.xpath("//div/div/div//*[@role=\"listbox\"]"));
        List<WebElement> AllStatus = getAllStatus.findElements(By.tagName("mat-option"));
        return AllStatus;
    }


    public void ApplyUnreadStatus() throws InterruptedException {
        List<WebElement> AllStatus = clickOnStatusFilter();
        for (WebElement element : AllStatus){
            if (element.getText().contains("UNREAD")){
                Thread.sleep(500);
                element.click();
                System.out.println("UNREAD status applied!");
                break;
            }
        }
    }

    public void ApplyOpenedStatus() throws InterruptedException {
        List<WebElement> AllStatus = clickOnStatusFilter();
        for (WebElement element : AllStatus){
            if (element.getText().contains("OPENED")){
                Thread.sleep(500);
                element.click();
                System.out.println("OPENED filter applied!");
                break;
            }
        }
    }

    public void ApplyDraftedStatus() throws InterruptedException {
        List<WebElement> AllStatus = clickOnStatusFilter();
        for (WebElement element : AllStatus){
            if (element.getText().contains("DRAFTED")){
                Thread.sleep(500);
                element.click();
                System.out.println("DRAFTED filter applied!");
                break;
            }
        }
    }

    public void ApplyReviewedStatus() throws InterruptedException {
        List<WebElement> AllStatus = clickOnStatusFilter();
        for (WebElement element : AllStatus){
            if (element.getText().contains("REVIEWED")){
                Thread.sleep(500);
                element.click();
                System.out.println("REVIEWED filter applied!");
                break;
            }
        }
    }

}
