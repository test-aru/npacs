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



    @FindBy(xpath = "//*[contains(text(),\"Worklist Archive\")]")
    WebElement worklistArchiveLink;





    public void clickOnWorklistArchive() {
        worklistArchiveLink.click();

    }


}
