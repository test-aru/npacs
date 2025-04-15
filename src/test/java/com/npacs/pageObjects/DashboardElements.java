package com.npacs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class DashboardElements {

    WebDriver driver;

    public DashboardElements(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-dashboard/div/div[2]/div[1]/div[1]/div[1]/a[2]")
    WebElement worklistArchiveLink;

    @FindBy (xpath = "//*[@class=\"mat-datepicker-toggle-default-icon ng-star-inserted\"]") WebElement DashboardDatePicker;
    @FindBy (xpath = "//*[@placeholder=\"Start date\"]") WebElement StartDate;
    @FindBy (xpath = "//*[@placeholder=\"End date\"]") WebElement EndDate;
    @FindBy (xpath = "//*[@role=\"tab\"]/div[contains(text(),'All')]") WebElement AllTab;

    @FindBy (xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-dashboard/div/div[2]/div[2]/div[2]/mat-tab-group/div/mat-tab-body/div/div") WebElement AllCountPanel;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[1][contains(text(),'Total Studies ')]") WebElement TotalStudiesPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[2][contains(text(),'Unassigned ')]") WebElement UnassignedPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[3][contains(text(),'Assigned ')]") WebElement AssignedPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[4][contains(text(),'Unread ')]") WebElement UnreadPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[5]/div[1][contains(text(),'Opened ')]") WebElement OpenedPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[5]/div[2][contains(text(),'Drafted ')]") WebElement DraftedPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[5]/div[3][contains(text(),'Reviewed')]") WebElement ReviewedPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[5]/div[4][contains(text(),'Critical ')]") WebElement CriticalPanelInAll;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[5]/div[5][contains(text(),'Scheduled ')]") WebElement ScheduledPanelInAll;

    @FindBy (xpath = "//*[@role=\"tab\"]/div[contains(text(),'My Status')]") WebElement MyStatusTab;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[1][contains(text(),'Assigned ')]") WebElement AssignedPanelMyStatus;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[2][contains(text(),'Unread')]") WebElement UnreadPanelMyStatus;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[3][contains(text(),'Opened')]") WebElement OpenedPanelMyStatus;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[4][contains(text(),'Drafted')]") WebElement DraftedPanelMyStatus;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[5][contains(text(),'Reviewed')]") WebElement ReviewedPanelMyStatus;
    @FindBy (xpath = "//div/mat-tab-body[@role=\"tabpanel\"]/div/div/div[6][contains(text(),'Critical')]") WebElement CriticalPanelMyStatus;

    @FindBy(xpath = "//*[contains(text(),'Show More')]") WebElement ShowMorePanel;

    RadWorklistElements Rw;

    public void clickOnAllTab() throws InterruptedException {
        Thread.sleep(2000);
        AllTab.click();
    }

    public void clickOnMyStatusTab() throws InterruptedException {
        Thread.sleep(2000);
        MyStatusTab.click();
    }

    public void clickOnShowMore(){
        ShowMorePanel.click();
    }

    public void clickOnWorklistArchive() throws InterruptedException {
        Thread.sleep(3000);
        worklistArchiveLink.click();
    }

    public void validateDateRange() throws InterruptedException {
        Thread.sleep(1000);
        String FromDate = StartDate.getAccessibleName();
        String ToDate = EndDate.getAccessibleName();
        System.out.println("Date Range is : "+ FromDate + "-" + ToDate);
    }

    public void getCountsFromAllTab(){
        List<WebElement> panels = AllCountPanel.findElements(By.tagName("div"));
        System.out.println("Number of panels : "+ panels.size());

        for (WebElement panel : panels){
            System.out.println(panel.getText().replaceAll("[^0-9]", ""));
        }

    }


    public int TotalStudiesCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int TotalStudyCount = Integer.parseInt(TotalStudiesPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Total Studies Count in All : "+ TotalStudyCount);
        return TotalStudyCount;
    }

    public int UnassignedCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int UnassignedCount = Integer.parseInt(UnassignedPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Unassigned Count in All : "+ UnassignedCount);
        return UnassignedCount;
    }

    public int AssignedCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int AssignedCount = Integer.parseInt(AssignedPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Assigned Count in All : "+ AssignedCount);
        return AssignedCount;
    }

    public int UnreadCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int UnreadCount = Integer.parseInt(UnreadPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Unread Count in All : "+ UnreadCount);
        return UnreadCount;

    }

    public int OpenedCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int OpenedCount = Integer.parseInt(OpenedPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Opened Count in All : "+ OpenedCount);
        return OpenedCount;
    }

    public int DraftedCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int DraftedCount = Integer.parseInt(DraftedPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Drafted Count in All : "+ DraftedCount);
        return DraftedCount;
    }

    public int ReviewedCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int ReviewedCount = Integer.parseInt(ReviewedPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Reviewed Count in All : "+ ReviewedCount);
        return ReviewedCount;
    }

    public int CriticalCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int CriticalCount = Integer.parseInt(CriticalPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Critical Count in All : "+ CriticalCount);
        return CriticalCount;
    }

    public int ScheduledCountInAll() throws InterruptedException {
        Thread.sleep(1000);
        int ScheduledCount = Integer.parseInt(ScheduledPanelInAll.getText().replaceAll("[^0-9]", ""));
        System.out.println("Scheduled Count in All : "+ ScheduledCount);
        return ScheduledCount;
    }
    public void getAllTabCounts() throws InterruptedException {
        TotalStudiesCountInAll();
        UnassignedCountInAll();
        AssignedCountInAll();
        UnreadCountInAll();
        OpenedCountInAll();
        DraftedCountInAll();
        ReviewedCountInAll();
        CriticalCountInAll();
        ScheduledCountInAll();
    }

    public void getTodayYesterdayCountsInAll() throws InterruptedException {
        Rw = new RadWorklistElements(driver);
        Rw.clickOnTodayAndYesterday();
        System.out.println("Today and Yesterday preset date filter applied!");
        validateDateRange();
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getTodayCountsInAll() throws InterruptedException {
        Rw = new RadWorklistElements(driver);
        Rw.clickOnToday();
        System.out.println("Today preset date filter applied!");
        validateDateRange();
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getYesterdayCountsInAll() throws InterruptedException {
        RadWorklistElements Rw = new RadWorklistElements(driver);
        Rw.clickOnYesterday();
        System.out.println("Yesterday preset date filter applied!");
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getLastWeekCountsInAll() throws InterruptedException {
        RadWorklistElements Rw = new RadWorklistElements(driver);
        Rw.clickOnLastWeek();
        System.out.println("This Week preset date filter applied!");
        validateDateRange();
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getThisMonthCountsInAll() throws InterruptedException {
        RadWorklistElements Rw = new RadWorklistElements(driver);
        Rw.clickOnThisMonth();
        System.out.println("This Month preset date filter applied!");
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getThisWeekCountsInAll() throws InterruptedException {
        RadWorklistElements Rw = new RadWorklistElements(driver);
        Rw.clickOnThisWeek();
        System.out.println("This week preset date filter applied!");
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getLast15DaysCountsInAll() throws InterruptedException {
        RadWorklistElements Rw = new RadWorklistElements(driver);
        Rw.clickOnLast15Days();
        System.out.println("Last 15 days preset date filter applied!");
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void getLast30DaysCountsInAll() throws InterruptedException {
        RadWorklistElements Rw = new RadWorklistElements(driver);
        Rw.clickOnLast30Days();
        System.out.println("Last 30 days preset date filter applied!");
        getAllTabCounts();
        //compareTotalStudiesWithAssignedAndUnassigned();
        //compareAssignedStudiesWithStatusCounts();
    }

    public void compareTotalStudiesWithAssignedAndUnassigned() throws InterruptedException {
        System.out.println("---------------------------------------------------------------");
        int actualCount = UnassignedCountInAll() + AssignedCountInAll();
        assertEquals(actualCount,TotalStudiesCountInAll());
        System.out.println("Total Studies Count matches with Assigned and Unassigned Counts");
    }

    public void compareAssignedStudiesWithStatusCounts() throws InterruptedException {
        System.out.println("---------------------------------------------------------------");
        int actualCount = UnreadCountInAll() + OpenedCountInAll() + DraftedCountInAll() + ReviewedCountInAll();
        assertEquals(actualCount,AssignedCountInAll());
        System.out.println("Assigned Studies Count matches with All status Counts");
        System.out.println("---------------------------------------------------------------");
    }

    public int AssignedStudiesInMyStatus() throws InterruptedException {
        Thread.sleep(1000);
        int AssignedStudyCount = Integer.parseInt(AssignedPanelMyStatus.getText().replaceAll("[^0-9]", ""));
        System.out.println("Total Studies Count in My status panel : "+ AssignedStudyCount);
        return AssignedStudyCount;
    }

    public int UnreadStudiesInMyStatus() throws InterruptedException {
        Thread.sleep(1000);
        int UnreadStudyCount = Integer.parseInt(UnreadPanelMyStatus.getText().replaceAll("[^0-9]", ""));
        System.out.println("Unread Studies Count in My status panel : "+ UnreadStudyCount);
        return UnreadStudyCount;
    }

    public int OpenedStudiesInMyStatus() throws InterruptedException {
        Thread.sleep(1000);
        int OpenedStudyCount = Integer.parseInt(OpenedPanelMyStatus.getText().replaceAll("[^0-9]", ""));
        System.out.println("Opened Studies Count in My status panel : "+ OpenedStudyCount);
        return OpenedStudyCount;
    }

    public int DraftedStudiesInMyStatus() throws InterruptedException {
        Thread.sleep(1000);
        int DraftedStudyCount = Integer.parseInt(DraftedPanelMyStatus.getText().replaceAll("[^0-9]", ""));
        System.out.println("Drafted Studies Count in My status panel : "+ DraftedStudyCount);
        return DraftedStudyCount;
    }

    public int ReviewedStudiesInMyStatus() throws InterruptedException {
        Thread.sleep(1000);
        int ReviewedStudyCount = Integer.parseInt(ReviewedPanelMyStatus.getText().replaceAll("[^0-9]", ""));
        System.out.println("Reviewed Studies Count in My status panel : "+ ReviewedStudyCount);
        return ReviewedStudyCount;
    }





}
