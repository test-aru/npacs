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



    @FindBy(xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-dashboard/div/div[2]/div[1]/div[1]/div[1]/a[2]")
    WebElement worklistArchiveLink;





    public void clickOnWorklistArchive() {
        worklistArchiveLink.click();

    }


}
