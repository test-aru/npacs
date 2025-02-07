package com.npacs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ModularReportingElements {

    WebDriver driver;

    public ModularReportingElements(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"mat-tab-list\"]/div/div[@class=\"mat-ripple mat-tab-label mat-focus-indicator mat-tab-label-active ng-star-inserted\"]/div/label") WebElement ActiveTab;
    @FindBy (xpath = "//*[@class=\"mat-tab-list\"]/div/div[@class=\"mat-ripple mat-tab-label mat-focus-indicator ng-star-inserted\"]/div/label") WebElement InActiveTabs;
    @FindBy (xpath ="//*[@class=\"arrow-down\"]") WebElement TemplateArrowDown;
    @FindBy (xpath = "//*[@class=\"mat-tab-label-content\"][contains(text(),'Relevant Templates')]") WebElement RelevantTemplatesTab;
    @FindBy (xpath = "//*[@class=\"mat-tab-label-content\"][contains(text(),'All Templates')]") WebElement AllTemplatesTab;
    @FindBy (xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-details/div/div[1]/div[6]/mat-tab-group/div/mat-tab-body/div/div/div[2]/div[3]/div[2]/div[1]/button/span[1]/span[1]/span[1]") WebElement SaveButton;
    @FindBy (xpath = "//*[contains(text(),'Sign Report')]/following-sibling::span[@class=\"arrow-border\"]") WebElement MarkasDraftedArrow;
    @FindBy (xpath = "//button/span[contains(text(),'Mark as DRAFTED')]") WebElement MarkasDraftedButton;
    @FindBy (xpath = "//table/tbody/tr/div/td[2]/span[2]") WebElement reportStatus;
    @FindBy (xpath = "//*[contains(text(),'Sign Report')]") WebElement SignReportButton;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-sign/div/div[2]") WebElement SignReportConfirmPopup;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-sign/div/div[3]/button[contains(text(),' Cancel ')]") WebElement SignCancelButton;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-sign/div/div[3]/button[contains(text(),' Yes, sign Report ')]") WebElement YesSignReportButton;
    @FindBy (xpath = "//*[contains(text(),'Print Preview')]") WebElement PrintPreviewButton;
    @FindBy (xpath = "//app-pdf-popup/div/h3/button/mat-icon[contains(text(),'close')]") WebElement PrintPreviewCloseButton;
    @FindBy (xpath = "//button/span[contains(text(),'Edit')]") WebElement EditButton;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-box/div/div[2]") WebElement EditConfirmPopup;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-box/div/div[3]/button[contains(text(),' No ')]") WebElement NoForEdit;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-box/div/div[3]/button[contains(text(),' Yes ')]") WebElement YesForEdit;



    public void verifyPatientTab(){
        String ActiveTabPatent = ActiveTab.getText();
        System.out.println("Active Tab Patient is : "+ ActiveTabPatent);
    }


    public void selectTemplate() throws InterruptedException {
        TemplateArrowDown.click();
        System.out.println("Clicked on Template Arrow Down");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        AllTemplatesTab.click();
        Thread.sleep(3000);
        getAllTemplatesListAndSelect();
    }

    public void getAllTemplatesListAndSelect(){
        WebElement AllTemplatesList = driver.findElement(By.xpath("/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-details/div/div[1]/div[6]/mat-tab-group/div/mat-tab-body/div/div/div[2]/div[1]/div/app-form-reporting/form/div/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/mat-form-field"));
        List<WebElement> AllTemp = AllTemplatesList.findElements(By.tagName("mat-option"));
        System.out.println("All Templates total is: " + AllTemp.size());

        //Print All templates in the All templates dropdown
         for (WebElement element : AllTemp){
             System.out.println("Template : " + element.getText());
         }

         //select any random template and click
        if (!AllTemp.isEmpty()){
            Random rand = new Random();
            int randomIndex = rand.nextInt(AllTemp.size());
            AllTemp.get(randomIndex).click();
            System.out.println("Loaded Template : " + AllTemp.get(randomIndex).getText());
        }else{
            System.out.println("No Template found!");
        }
    }

    public void getReportStatus(){
        String ReportStatus = reportStatus.getText();
        System.out.println("Report Status is : "+ ReportStatus);
    }




    public void saveReport() throws InterruptedException {
        Thread.sleep(2000);
        SaveButton.click();
        System.out.println("Clicked on Save Button");
        getReportStatus();
    }

    public void DraftReport() throws InterruptedException {
        Thread.sleep(2000);
        MarkasDraftedArrow.click();
        Thread.sleep(2000);
        MarkasDraftedButton.click();
        System.out.println("Clicked on Mark as Drafted Button");
        Thread.sleep(4000);
        getReportStatus();
    }

    public void SignReport() throws InterruptedException {
        Thread.sleep(2000);
        SignReportButton.click();
        System.out.println("Clicked on Sign Report Button");
        Thread.sleep(3000);
        if(SignReportConfirmPopup.isDisplayed()){
            System.out.println(SignReportConfirmPopup.getText());
            YesSignReportButton.click();
            Thread.sleep(4000);
            getReportStatus();
        }else{
            System.out.println("Sign report confirmation popup not displayed!");
        }
    }

    public void PrintPreview() throws InterruptedException {
        Thread.sleep(2000);
        PrintPreviewButton.click();
        System.out.println("Clicked on Print Preview Button");
        Thread.sleep(4000);
        PrintPreviewCloseButton.click();
    }

    public void EditTheReport() throws InterruptedException {
        Thread.sleep(2000);
        EditButton.click();
        System.out.println("Clicked on Edit Button");
        Thread.sleep(3000);
        if(EditConfirmPopup.isDisplayed()){
            System.out.println(EditConfirmPopup.getText());
            YesForEdit.click();
            Thread.sleep(4000);
        }else{
            System.out.println("Edit report confirmation popup not displayed!");
        }
    }

    public void checkResultStatusInWorklist() throws InterruptedException {
          RadWorklistElements RW = new RadWorklistElements(driver);
          RW.clickOnLast15Days();
          RW.searchPatient("");
    }


}
