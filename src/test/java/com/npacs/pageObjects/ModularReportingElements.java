package com.npacs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


    public void verifyPatientTab(){
        String ActiveTabPatent = ActiveTab.getText();
        System.out.println("Active Tab Patient is : "+ ActiveTabPatent);
    }


    public void selectTemplate() throws InterruptedException {
        TemplateArrowDown.click();
        System.out.println("Clicked on Template Arrow Down");
        Thread.sleep(1000);
        AllTemplatesTab.click();
        Thread.sleep(1000);
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

    public void saveReport() throws InterruptedException {
        Thread.sleep(2000);
        SaveButton.click();
        System.out.println("Clicked on Save Button");
    }

}
