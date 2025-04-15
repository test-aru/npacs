package com.npacs.testCases.DashboardTC;

import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class StudyCountsForHOD extends BaseClass{



    @BeforeClass
    public void userLogin() throws InterruptedException {
        LoginPageElements LP = new LoginPageElements(driver);
        LP.radVijayLogin();
    }


    @Test (priority = 1)
    public void VerifyLastWeekTotalStudies() throws InterruptedException {
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnLastWeek();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");

    }

    @Test (priority = 2)
    public void VerifyThisWeekTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisWeek();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnThisWeek();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 3)
    public void VerifyThisMonthTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisMonth();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnThisMonth();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 4)
    public void VerifyLast15DaysTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLast15Days();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnLast15Days();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 5)
    public void VerifyLast30DaysTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLast30Days();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnLast30Days();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 6)
    public void VerifyLast3DaysTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLast3Days();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnLast3Days();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 7)
    public void VerifyTodayTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnToday();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnToday();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 8)
    public void VerifyTodayAndYesterdayTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnTodayAndYesterday();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnTodayAndYesterday();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 9)
    public void VerifyYesterdayTotalStudies() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnYesterday();
        DE.clickOnAllTab();
        DE.clickOnShowMore();
        int TotalStudiesCount = DE.TotalStudiesCountInAll();
        DE.clickOnWorklistArchive();
        RW.clickOnYesterday();
        Thread.sleep(3000);
        //RW.getCountTotalFromPagination();
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(TotalStudiesCount, WorklistTotalCount);
        System.out.println("-----Last week study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 10)
    public void verifyLastWeekAssignedStudiesInMyStatus() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        DE.clickOnMyStatusTab();
        int AssignedStudiesCountInMyStatus = DE.AssignedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnLastWeek();
        Thread.sleep(1000);
        RW.ApplyRadiologistFilter("Dr. Vijay");
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount,AssignedStudiesCountInMyStatus);
        System.out.println("-----Last week Assigned study counts matched in both worklist and Dashboard!-----");

    }

    @Test (priority = 11)
    public void verifyLastWeekUnreadStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        DE.clickOnMyStatusTab();
        int UnreadStudiesCountInMyStatus = DE.UnreadStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnLastWeek();
        Thread.sleep(1000);
        RW.ApplyUnreadStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, UnreadStudiesCountInMyStatus);
        System.out.println("-----Last week Unread study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 13)
    public void verifyLastWeekOpenedStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        DE.clickOnMyStatusTab();
        int OpenedStudiesCountInMyStatus = DE.OpenedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnLastWeek();
        Thread.sleep(1000);
        RW.ApplyOpenedStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, OpenedStudiesCountInMyStatus);
        System.out.println("-----Last week Unread study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 14)
    public void verifyLastWeekDraftedStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        DE.clickOnMyStatusTab();
        int DraftedStudiesCountInMyStatus = DE.DraftedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnLastWeek();
        Thread.sleep(1000);
        RW.ApplyDraftedStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, DraftedStudiesCountInMyStatus);
        System.out.println("-----Last week Unread study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 15)
    public void verifyLastWeekReviewedStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        DE.clickOnMyStatusTab();
        int ReviewedStudiesCountInMyStatus = DE.ReviewedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnLastWeek();
        Thread.sleep(1000);
        RW.ApplyReviewedStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, ReviewedStudiesCountInMyStatus);
        System.out.println("-----Last week Unread study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 16)
    public void verifyThisWeekAssignedStudiesInMyStatus() throws InterruptedException {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisWeek();
        DE.clickOnMyStatusTab();
        int AssignedStudiesCountInMyStatus = DE.AssignedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnThisWeek();
        Thread.sleep(1000);
        RW.ApplyRadiologistFilter("Dr. Vijay");
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount,AssignedStudiesCountInMyStatus);
        System.out.println("-----This week Assigned study counts matched in both worklist and Dashboard!-----");

    }

    @Test (priority = 17)
    public void verifyThisWeekUnreadStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisWeek();
        DE.clickOnMyStatusTab();
        int UnreadStudiesCountInMyStatus = DE.UnreadStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnThisWeek();
        Thread.sleep(1000);
        RW.ApplyUnreadStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, UnreadStudiesCountInMyStatus);
        System.out.println("-----This week Unread study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 18)
    public void verifyThisWeekOpenedStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisWeek();
        DE.clickOnMyStatusTab();
        int OpenedStudiesCountInMyStatus = DE.OpenedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnThisWeek();
        Thread.sleep(1000);
        RW.ApplyOpenedStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, OpenedStudiesCountInMyStatus);
        System.out.println("-----This Week Opened study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 19)
    public void verifyThisWeekDraftedStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisWeek();
        DE.clickOnMyStatusTab();
        int DraftedStudiesCountInMyStatus = DE.DraftedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnThisWeek();
        Thread.sleep(1000);
        RW.ApplyDraftedStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, DraftedStudiesCountInMyStatus);
        System.out.println("-----This Week Drafted study counts matched in both worklist and Dashboard!-----");
    }

    @Test (priority = 20)
    public void verifyThisWeekReviewedStudiesInMyStatus() throws Exception {
        driver.navigate().back();
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnThisWeek();
        DE.clickOnMyStatusTab();
        int ReviewedStudiesCountInMyStatus = DE.DraftedStudiesInMyStatus();
        DE.clickOnWorklistArchive();
        RW.clickOnThisWeek();
        Thread.sleep(1000);
        RW.ApplyReviewedStatus();
        Thread.sleep(2000);
        int WorklistTotalCount = RW.getCountTotalFromPagination();
        Assert.assertEquals(WorklistTotalCount, ReviewedStudiesCountInMyStatus);
        System.out.println("-----This Week Reviewed study counts matched in both worklist and Dashboard!-----");
    }



}
