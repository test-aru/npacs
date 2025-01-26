package com.npacs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadWorklistElements {

    WebDriver driver;
    public RadWorklistElements(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Reporting')]")
    WebElement reportingMenu;
    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Recently Signed')]")
    WebElement recentlySignedMenu;
    @FindBy(xpath = "//div[@class=\"ng-tns-c278-6 ng-star-inserted active\"]//a[contains(text(),'Archived Studies')]")
    WebElement archivedStudiesMenu;

    @FindBy(xpath = "//*[@class=\"cursor-p treeview-open p-a d-ib ng-tns-c278-19\"]") WebElement worklistMenuCursor;
    @FindBy(xpath = "//button[@class=\"close-btn p-a ng-tns-c278-19\"]") WebElement worklistMenuClose;

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

}
