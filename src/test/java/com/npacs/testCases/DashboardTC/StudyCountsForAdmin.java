package com.npacs.testCases.DashboardTC;

import com.npacs.pageObjects.DashboardElements;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.pageObjects.RadWorklistElements;
import com.npacs.testCases.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudyCountsForAdmin extends BaseClass{



    @BeforeClass
    public void userLogin() throws InterruptedException {
        LoginPageElements LP = new LoginPageElements(driver);
        LP.adminLogin();
        //LP.verifyLoginUser();
    }


    @Test (priority = 1)
    public void VerifyLastWeekTotalStudies() throws InterruptedException {
        DashboardElements DE = new DashboardElements(driver);
        RadWorklistElements RW = new RadWorklistElements(driver);
        RW.clickOnLastWeek();
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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
        //DE.clickOnAllTab();
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


}
