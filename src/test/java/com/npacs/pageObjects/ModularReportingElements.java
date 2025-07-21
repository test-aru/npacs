package com.npacs.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
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
    @FindBy (xpath = "//*[contains(@class, 'icon-save-icon')]") WebElement SaveButton;
    @FindBy (xpath = "//*[contains(text(),'Sign Report')]/following-sibling::span[@class=\"arrow-border\"]") WebElement MarkasDraftedArrow;
    @FindBy (xpath = "//button/span[contains(text(),'Mark as DRAFTED')]") WebElement MarkasDraftedButton;
    @FindBy (xpath = "//table/tbody/tr/div/td[2]/span[2]") WebElement reportStatus;
    @FindBy (xpath = "//*[contains(text(),'Sign Report')]") WebElement SignReportButton;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-sign/div/div[2]") WebElement SignReportConfirmPopup;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-sign/div/div[3]/button[contains(text(),' Cancel ')]") WebElement SignCancelButton;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-sign/div/div[3]/button[2]") WebElement YesSignReportButton;
    @FindBy (xpath = "//*[contains(text(),'Print Preview')]") WebElement PrintPreviewButton;
    @FindBy (xpath = "//app-pdf-popup/div/h3/button/mat-icon[contains(text(),'close')]") WebElement PrintPreviewCloseButton;
    @FindBy (xpath = "//button/span[contains(text(),'Edit')]") WebElement EditButton;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-box/div/div[2]") WebElement EditConfirmPopup;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-box/div/div[3]/button[contains(text(),' No ')]") WebElement NoForEdit;
    @FindBy (xpath = "//*[@role=\"dialog\"]/app-confirm-box/div/div[3]/button[contains(text(),' Yes ')]") WebElement YesForEdit;
    //@FindBy (xpath = "//*[@href=\"/radiologist-worklist/my-worklist\"]") WebElement BackToWorklistBreadcrumb;
    @FindBy (xpath = "/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-details/div/div[1]/div[1]/div[1]") WebElement CardViewList;
    @FindBy (xpath = "//div/label/div[3]/span[3]") WebElement CardStatus;
    @FindBy (xpath = "//div/label/div[2]/span[1]") WebElement CardPatientID;
    @FindBy (xpath = "//*[@data-placeholder=\"Search\"]") WebElement CardSearch;
    @FindBy (xpath = "//div[1]/label[@for=\"panel-0\"]") WebElement firstCardView;
    @FindBy (xpath = "//*[contains(text(),'Create Provisional Report')]") WebElement PrelimLink;
    @FindBy (xpath = "//*[contains(text(),'Provisional Report')]") WebElement ProvisionalReportFormTitle;
    @FindBy (xpath = "//*[@formcontrolname=\"preliminaryTitle\"]") WebElement PrelimTitle;
    @FindBy (xpath = "//*[@id=\"editorFindings\"]/div/div/div") WebElement PrelimFindings;
    @FindBy (xpath = "//*[@id=\"editorImpression\"]/div/div/div") WebElement PrelimImpression;
    @FindBy (xpath = "//*[contains(text(),\"Create Final Report\")]") WebElement CreateFinalReport;
    @FindBy (xpath = "//*[contains(text(),\" Add New Report \")]") WebElement AddNewReport;
    @FindBy (xpath = "//*[@class=\"mat-tab-label-content\"][contains(text(),'Reports')]") WebElement ReportsTab;
   // @FindBy (xpath = "//mat-tab-body[2]//table[1]//tbody") WebElement ReportRowTable;
    @FindBy (xpath = "//mat-tab-body[2]//table[1]//tbody//tr[.//span[@mattooltip=\"Prelim report\"]]//button[.//mat-icon[text()=\"more_vert\"]]") public WebElement PrelimReportRow3dots;
    @FindBy (xpath = "//mat-tab-body[2]//table[1]//tbody//tr[.//td[contains(., 'REVIEWED')]]//button[.//mat-icon[text()='more_vert']]") public WebElement ReviewedReportRow3dots;
    @FindBy (xpath = "//mat-tab-body[2]//table[1]//tbody//tr[.//td[contains(., 'Saved')]]//button[.//mat-icon[text()='more_vert']]") public WebElement SavedReportRow3dots;
    @FindBy (xpath = "//mat-tab-body[2]//table[1]//tbody//tr[.//td[contains(., 'DRAFTED')]]//button[.//mat-icon[text()='more_vert']]") public WebElement DraftedReportRow3dots;
    @FindBy (xpath = "//mat-tab-body[2]//table[1]//tbody//tr[.//span[@mattooltip=\"Addendum report\"]]//button[.//mat-icon[text()=\"more_vert\"]]") public WebElement AddendumReportRow3dots;
    @FindBy (xpath = "//*[contains(text(),'Addendum Report')]") WebElement AddendumReportOption;
    @FindBy (xpath = "//*[@class=\"addendum-report\"]") WebElement AddendumForm;
    @FindBy (xpath = "//*[@formcontrolname=\"addendumTitle\"][@type=\"text\"]") WebElement AddendumTitle;
    @FindBy (xpath = "//app-addendum-report/div/form/div[2]/angular-editor/div/div/div[@class=\"angular-editor-textarea\"]") WebElement AddendumFindingsTextArea;
    @FindBy (xpath = "//app-addendum-report/div/form/div[3]/angular-editor/div/div/div[@class=\"angular-editor-textarea\"]") WebElement FinalImpressionTextArea;
    @FindBy (xpath = "//*[contains(text(),\"Discard\")]") WebElement DiscardButton;
    @FindBy (xpath = "//app-confirm-save/div/div[3]//button[1][contains(text(),\" No \")]") WebElement NoforDiscard;
    @FindBy (xpath = "//app-confirm-save/div/div[3]//button[2][contains(text(),\" Yes \")]") WebElement YesforDiscard;

  //  WebElement ReportRows = driver.findElement(By.xpath("//mat-tab-body[2]//table[1]//tbody"));
  //  List<WebElement> rows = ReportRows.findElements(By.tagName("tr"));

    public boolean checkDiscardOptionAndProceed(){
        try{
            DiscardButton.click();
            System.out.println("Discard option is clicked!");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Discard option not found.");
            return false;
        }
    }

//    public void DiscardSavedPrelimReport() throws InterruptedException {
//        PrelimReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//        Thread.sleep(1000);
//        YesforDiscard.click();
//        System.out.println("Saved Prelim Report Discarded Successfully!");
//    }
//
//    public void DiscardSavedAddendumReport() throws InterruptedException {
//        AddendumReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//        Thread.sleep(1000);
//        YesforDiscard.click();
//        System.out.println("Saved Addendum Report Discarded Successfully!");
//    }
//
//    public void DiscardSavedFinalReport() throws InterruptedException {
//        SavedReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//        Thread.sleep(1000);
//        YesforDiscard.click();
//        System.out.println("Saved Final Report Discarded Successfully!");
//    }
//
//    public void DiscardDraftedFinalReport() throws InterruptedException {
//        DraftedReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//        Thread.sleep(1000);
//        YesforDiscard.click();
//        System.out.println("Saved Final Report Discarded Successfully!");
//    }
//
//    public void DiscardReviewedFinalReport() throws InterruptedException {
//        ReviewedReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//    }
//
//    public void DiscardReviewedPrelimReport() throws InterruptedException {
//        PrelimReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//    }
//
//    public void DiscardReviewedAddendumReport() throws InterruptedException {
//        AddendumReportRow3dots.click();
//        Thread.sleep(1000);
//        checkDiscardOptionAndProceed();
//    }



    public void DiscardReport(WebElement threeDotsElement, boolean confirmDiscard) throws InterruptedException {
//        try{
//            threeDotsElement.click();
//            Thread.sleep(1000);
//
//            if(checkDiscardOptionAndProceed()){
//                if(confirmDiscard) {
//                    Thread.sleep(1000);
//                    YesforDiscard.click();
//                    System.out.println("Report discarded successfuly!");
//                }
//                else {
//                    System.out.println("Discard option was not available.");
//                }
//            }
//        } catch (NoSuchElementException e){
//            System.out.println("3-dots menu not found.");
//        } catch (Exception e){
//            System.out.println("Error while discarding report: " + e.getMessage());
//        }

        try{
            threeDotsElement.click();
            Thread.sleep(1000);

            if(DiscardButton != null && DiscardButton.isDisplayed() && DiscardButton.isEnabled()){
                DiscardButton.click();
                System.out.println("Discard option is clicked!");

                if(confirmDiscard){
                    Thread.sleep(1000);
                    YesforDiscard.click();
                    System.out.println("Report Discarded Successfully!");
                }else{
                    System.out.println("Discard clicked but Confirmation popup not displayed.");
                    ActiveTab.click();
                }

            }else{
                System.out.println("Discard option is Not available. Menu is closed.");
                threeDotsElement.sendKeys(Keys.ESCAPE);
            }

        }catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (StaleElementReferenceException e) {
            System.out.println("Discard element is stale—refetch it.");
        } catch (Exception e) {
            System.out.println("❗Unexpected error: " + e.getMessage());
        }
    }



    public void addAddendumReport() throws InterruptedException {
        Actions ac = new Actions(driver);
        ReviewedReportRow3dots.click();
        AddendumReportOption.click();
        Thread.sleep(2000);
        System.out.println(AddendumTitle.getAttribute("value"));
        System.out.println(FinalImpressionTextArea.getAttribute("value"));
        AddendumFindingsTextArea.sendKeys(
                "Cerebral parenchymal grey matter and white matter show normal signal intensity...\n" +
                        "No abnormal contrast enhancement...\n" +
                        "Thalami are normal..."
        );
    }


    public void ClickOnReport(String status) throws InterruptedException {
       ReportsTab.click();
       Thread.sleep(1000);
       WebElement ReportRows = driver.findElement(By.xpath("//mat-tab-body[2]//table[1]//tbody"));
       List<WebElement> rows = ReportRows.findElements(By.tagName("tr"));
       System.out.println("Number of reports : "+ rows.size());

       for(int i=0;i<rows.size();i++){
           WebElement row = rows.get(i);
           String rowText = row.getText();

           if(rowText.contains(status)){
               System.out.println("Clicking row at index : " + i);
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               JavascriptExecutor je = (JavascriptExecutor) driver;
               je.executeScript("arguments[0].scrollIntoView(false);", row);
                wait.until(ExpectedConditions.elementToBeClickable(row));
               Thread.sleep(2000);
               row.click();
               System.out.println(row.getText());
               break;
           }
       }
//       for (WebElement ele : rows){
//           String reportRow = ele.getText();
//           System.out.println("Report : "+ reportRow);
//       }
   }





    public void openPrelimReport(){
        PrelimLink.click();
        System.out.println(ProvisionalReportFormTitle.getText() + "Form is loaded");
    }

    public void AddPrelimContent(){
        PrelimTitle.sendKeys("PRELIM");
        PrelimFindings.sendKeys("Brainstem is normal. Cerebello-pontine angles are normal. Vermis and both cerebellar hemispheres are normal. Fourth ventricle is normal.");
        PrelimImpression.sendKeys("No intracranial abnormality.");

    }

    public void createFinalReport() throws InterruptedException {
        Thread.sleep(1000);
        CreateFinalReport.click();
        System.out.println("Final report form is Created!");
    }

    public void addNewReport() throws InterruptedException {
        Thread.sleep(1000);
        AddNewReport.click();
        System.out.println("New Final report form is Loaded!");
    }

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
        WebElement AllTemplatesList = driver.findElement(By.xpath("//*[@formcontrolname=\"findingsHeaderValue\"]"));
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
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void backToWorklist() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Clicked on Back to Worklist breadcrumb");
    }

    public String getCardStatus(WebElement card){
        return card.findElement(By.xpath("//div/label/div[3]/span[3]")).getText().trim();
//        WebElement cardStatusElement = card.findElement(By.xpath("//div/label/div[3]/span[3]"));
//        String cardStatus = cardStatusElement.getText().trim();
//        System.out.println("Card Status: '" + cardStatus + "'");
//        return cardStatus;
    }


    public void getAllCardStudies() throws InterruptedException {
            WebElement cardViewList = driver.findElement(By.xpath("/html/body/app-root/app-main-layout/app-side-nav/mat-sidenav-container/mat-sidenav-content/app-container/div/div/app-radiologist-worklist/div/div/div/div/div[2]/app-report-details/div/div[1]/div[1]/div[1]"));
            List<WebElement> cardList = cardViewList.findElements(By.xpath("div"));
            System.out.println("Total Card View List Studies: " + cardList.size());

          for (int i=0; i < cardList.size(); i++) {
              Thread.sleep(1000);
              WebElement cardElement = cardList.get(i);
              Thread.sleep(1000);
              try{
                  WebElement statusElement = cardElement.findElement(By.xpath("//div/label/div[3]"));
                  String CardSTATUS = statusElement.getText().trim(); //trim whitespaces
                  System.out.println("Checking card : " + (i + 1) + " , Status: '" + CardSTATUS + "'");
                  Thread.sleep(1000);
                  if (CardSTATUS.toUpperCase().contains("UNREAD")){
                      System.out.println("Found UNREAD card at index " + i + ", performing actions.");
//                       String PtID = CardPatientID.getText();
//                       System.out.println("PtID");
//                       Thread.sleep(1000);
//                       CardSearch.sendKeys(PtID);
//                       Thread.sleep(1000);
//                       firstCardView.click();
//                       CardSearch.clear();
                  }else {
                      System.out.println("Card " + (i + 1) + " is already read. Skipping.");
                  }
              }catch (NoSuchElementException e) {
                  System.out.println("Status not found for card " + (i + 1) + ". Skipping to next card.");
              }
          }
      //  for (WebElement element : cardList){
//            System.out.println("Cards : " + element.getText());
//            WebElement statusElement = element.findElement(By.xpath("//div/label/div[3]"));
//            String CardSTATUS = statusElement.getText();
//            System.out.println("Card Status: '" + CardSTATUS + "'");
      //  }

        }
        @FindBy (xpath = "//*[@id=\"editorFindings\"]//div//div//div[@class=\"angular-editor-textarea\"]") WebElement FindingsBlock;

    FileReader fr = null;
    BufferedReader br = null;
    String readLine;
    String DataFilePath;
    StringBuffer sb=new StringBuffer();
    String line;
    String filePath = "./testData/metatag.txt";

    private StringBuffer readTextFromFile(String filePath) throws IOException {
        fr = new FileReader(filePath);
        br = new BufferedReader(fr);
        while ((readLine= br.readLine()) != null) {
            line = readLine;
            sb.append(line+"\n");
    }
        return sb;
  }
    public void EnterMetaTagContent() throws IOException, InterruptedException {
       // StringBuffer sbb = readTextFromFile(filePath);
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println(fileContent);
        Thread.sleep(1500);
        EditFindings(fileContent);
    }

    public void EditFindings(String text) throws InterruptedException {
        FindingsBlock.clear();
        FindingsBlock.sendKeys(text);
        Thread.sleep(1000);
        Actions ac = new Actions(driver);
        ac.moveToElement(SaveButton).click().build().perform();
    }
}



