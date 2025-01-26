package com.npacs.pageObjects;

import com.npacs.assertions.LoginAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardElements {

    WebDriver driver;

    public DashboardElements(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Reporting')]")
    WebElement reportingMenu;
    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Recently Signed')]")
    WebElement recentlySignedMenu;
    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Archived Studies')]")
    WebElement archivedStudiesMenu;


    @FindBy(xpath = "//*[contains(text(),\"Worklist Archive\")]")
    WebElement worklistArchiveLink;


    public boolean validateReportingMenu() {
        String expectedMenu = " Reporting ";
        String actualMenu = reportingMenu.getText();
        boolean isClickedMenu = actualMenu.contains(expectedMenu);
        if (isClickedMenu) {
            System.out.println("Current screen is Worklist : " + actualMenu);
        } else {
            System.out.println("Current screen is not worklist. Landed screen is : " + actualMenu);
        }
        return isClickedMenu;
    }


    public void clickOnWorklistArchive() {
        worklistArchiveLink.click();
        validateReportingMenu();

    }


}
