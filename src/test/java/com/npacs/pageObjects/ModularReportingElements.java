package com.npacs.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
    //------------------------------------Edit rquest Elements----------------------------------------------------------------------------------//
    @FindBy (xpath = "//*[contains(text(),'Request To Edit')]") WebElement RequestToEditButton;
    @FindBy (xpath = "//app-edit-request//div//form//div[2]//p[contains(@class,'report-name')]") WebElement reportNameInRequestPopup;
    @FindBy (xpath = "//*[@formcontrolname=\"selectedRadiologist\"]") WebElement RadiologistDropdownInRequestPopup;
    @FindBy (xpath = "//*[contains(text(),' Dr. Vijay Sadasivam DMRD, DNB. ')]") WebElement RadiologistDrVijay;
    @FindBy (xpath = "//*[@formcontrolname=\"requestReason\"]") WebElement RequestReason;
    @FindBy (xpath = "//*[contains(text(),'Submit')]") WebElement SubmitButtonforReportRequest;
    @FindBy (xpath = "//*[contains(text(),'Cancel')]") WebElement CancelButtonforReportRequest;
    //-----------------------------------Calcium report Elements----------------------------------------------------------------------------
    @FindBy (xpath = "//*[@formcontrolname=\"procedureInformation\"]") WebElement StudyTitle;
    @FindBy (id = "clinicalIndication") WebElement ClinicalIndication;
    @FindBy (xpath = "//*[@id=\"editorProtocol\"]/div/div/div") WebElement ProtocolEditorInFinalReport;
    @FindBy (xpath = "//*[@id=\"protocol\"]") WebElement ProtocolInCalciumReport;
    @FindBy (xpath = "//*[@formcontrolname=\"lm\"]") WebElement LeftMain;
    @FindBy (xpath = "//*[@formcontrolname=\"lad\"]") WebElement LeftAntDesc;
    @FindBy (xpath = "//*[@formcontrolname=\"lcx\"]") WebElement LeftCircum;
    @FindBy (xpath = "//*[@formcontrolname=\"rca\"]") WebElement RightMain;
    @FindBy (id = "agatstonScore") WebElement AgatstonScoreField;
    @FindBy (id = "pericardium") WebElement PericardiumField;
    @FindBy (id = "ascendingAorta" ) WebElement AscendingAorta;
    @FindBy (id = "descendingAorta") WebElement DescendingAorta;
    @FindBy (id = "pulmonaryTrunk") WebElement PulmonaryTrunk;
    @FindBy (xpath = "//*[@formcontrolname=\"aortic\"]") WebElement AorticValueCalcification;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"aortic\"]//mat-radio-button[@value=\"No\"]") WebElement AorticValueNo;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"aortic\"]//mat-radio-button[@value=\"Mild\"]") WebElement AorticValueMild;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"aortic\"]//mat-radio-button[@value=\"Moderate\"]") WebElement AorticValueModerate;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"aortic\"]//mat-radio-button[@value=\"Severe\"]") WebElement AorticValueSevere;
    @FindBy (xpath = "//*[@formcontrolname=\"thoracic\"]") WebElement ThoracicAorticCalcification;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"thoracic\"]//mat-radio-button[@value=\"No\"]") WebElement ThoracicValueNo;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"thoracic\"]//mat-radio-button[@value=\"Mild\"]") WebElement ThoracicValueMild;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"thoracic\"]//mat-radio-button[@value=\"Moderate\"]") WebElement ThoracicValueModerate;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"thoracic\"]//mat-radio-button[@value=\"Severe\"]") WebElement ThoracicValueSevere;
    @FindBy (xpath = "//*[@formcontrolname=\"mitral\"]") WebElement MitralAnnularCalcification;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"mitral\"]//mat-radio-button[@value=\"No\"]") WebElement MitralValueNo;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"mitral\"]//mat-radio-button[@value=\"Mild\"]") WebElement MitralValueMild;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"mitral\"]//mat-radio-button[@value=\"Moderate\"]") WebElement MitralValueModerate;
    @FindBy (xpath = "//mat-radio-group[@formcontrolname=\"mitral\"]//mat-radio-button[@value=\"Severe\"]") WebElement MitralValueSevere;
    @FindBy (xpath = "//*[@formcontrolname=\"isNormal\"]") WebElement NormalCheckBox;
    @FindBy (xpath = "//h3[2]//span[3]") WebElement StudyDescInReportingScreen;
    @FindBy (xpath = "//*[contains(text(),' Create Calcium Report')]") WebElement CalciumReportLink;

    public double calculatedAgatstonScore;

    public void NormalCalciumScoreReport(){
        NormalCheckBox.click();
    }




    public void AddAdditionalFindings(String Pericardium, String AscAorta, String DescAorta, String PulmTrunk){
        PericardiumField.clear();
        PericardiumField.sendKeys(Pericardium);
        AscendingAorta.clear();
        AscendingAorta.sendKeys(AscAorta);
        DescendingAorta.clear();
        DescendingAorta.sendKeys(DescAorta);
        PulmonaryTrunk.clear();
        PulmonaryTrunk.sendKeys(PulmTrunk);
        AddAorticExtraCoronaryCalcifications("Mild");
        AddThoracicExtraCoronaryCalcifications("Moderate");
        AddMitralExtraCoronaryCalcifications("No");
    }


    public void AddAorticExtraCoronaryCalcifications(String expectedValue){
        WebElement AorticValueCalc = driver.findElement(By.xpath("//*[@formcontrolname=\"aortic\"]"));
        List<WebElement> AorticValue = AorticValueCalc.findElements(By.tagName("mat-radio-button"));
        for (WebElement element : AorticValue) {
            String actualValue = element.findElement(By.cssSelector(".mat-radio-label-content")).getText().trim();
            System.out.println("Actual value : "+ actualValue);
            if (actualValue.equals(expectedValue)) {
                element.click();
                System.out.println("Clicked element with value: " + expectedValue);
            }
        }
        System.out.println("No element found with value: " + expectedValue);
    }

    public void AddThoracicExtraCoronaryCalcifications(String expectedValue){
        WebElement AorticValueCalc = driver.findElement(By.xpath("//*[@formcontrolname=\"aortic\"]"));
        List<WebElement> AorticValue = AorticValueCalc.findElements(By.tagName("mat-radio-button"));
        for (WebElement element : AorticValue) {
            String actualValue = element.findElement(By.cssSelector(".mat-radio-label-content")).getText().trim();
            System.out.println("Actual value : "+ actualValue);
            if (actualValue.equals(expectedValue)) {
                element.click();
                System.out.println("Clicked element with value: " + expectedValue);
            }
        }
        System.out.println("No element found with value: " + expectedValue);
    }

    public void AddMitralExtraCoronaryCalcifications(String expectedValue){
        WebElement AorticValueCalc = driver.findElement(By.xpath("//*[@formcontrolname=\"aortic\"]"));
        List<WebElement> AorticValue = AorticValueCalc.findElements(By.tagName("mat-radio-button"));
        for (WebElement element : AorticValue) {
            String actualValue = element.findElement(By.cssSelector(".mat-radio-label-content")).getText().trim();
            System.out.println("Actual value : "+ actualValue);
            if (actualValue.equals(expectedValue)) {
                element.click();
                System.out.println("Clicked element with value: " + expectedValue);
            }
        }
        System.out.println("No element found with value: " + expectedValue);
    }

//    public void clickElementWithValue(List<WebElement> elements, String expectedValue) {
//        for (WebElement element : elements) {
//            String actualValue = element.getAttribute("value");
//            if (actualValue != null && actualValue.equals(expectedValue)) {
//                element.click();
//                System.out.println("Clicked element with value: " + expectedValue);
//                return;
//            }
//        }
//        System.out.println("No element found with value: " + expectedValue);
//    }

    public void InputArteryValuesAndCalculateAgatstonScore(){
        DecimalFormat df = new DecimalFormat("0.00");

        double leftMainValue = ThreadLocalRandom.current().nextDouble(0.0, 400.0);
        double leftAntDescValue = ThreadLocalRandom.current().nextDouble(0.0, 400.0);
        double leftCircumValue = ThreadLocalRandom.current().nextDouble(0.0, 400.0);
        double rightMainValue = ThreadLocalRandom.current().nextDouble(0.0, 400.0);
        LeftMain.clear();
        LeftMain.sendKeys(df.format(leftMainValue));
        LeftAntDesc.clear();
        LeftAntDesc.sendKeys(df.format(leftAntDescValue));
        LeftCircum.clear();
        LeftCircum.sendKeys(df.format(leftCircumValue));
        RightMain.clear();
        RightMain.sendKeys(df.format(rightMainValue));

        double total = leftMainValue + leftAntDescValue + leftCircumValue + rightMainValue;
        calculatedAgatstonScore = total;

        System.out.println("LM : "+ df.format(leftMainValue));
        System.out.println("LAD : "+ df.format(leftAntDescValue));
        System.out.println("LCX : "+ df.format(leftCircumValue));
        System.out.println("RCA : "+ df.format(rightMainValue));
        System.out.println("Sum of all Artery values : "+ df.format(calculatedAgatstonScore));
    }

    public void getTotalAgatstonScoreInFormAndValidateAgatstonScore(){
        String TotalAgatstonScoreIs = AgatstonScoreField.getAttribute("value");
        double TotalAgatstonScore = Double.parseDouble(TotalAgatstonScoreIs);
        System.out.println("Total Agatston score in Report Form is : " + TotalAgatstonScore);
        double tolerance = 0.01;
        if (Math.abs(TotalAgatstonScore - calculatedAgatstonScore) <= tolerance) {
            System.out.println("Agatston Score matches!");
        } else {
            System.out.println("Agatston Score does NOT match!");
        }
    }

    public void validateStudyTitleinCalciumReportForm() throws InterruptedException {
        if(StudyTitle.isEnabled()){
            System.out.println("Able to Edit Study Title!");
        }else{
            System.out.println("Unable to Edit Study Title!");
        }
        Thread.sleep(1000);
    }

    public void validateClinicalIndicationInCalciumReportForm(String expectedClinicalHistory) throws InterruptedException {
        String actualClinicalHistory = ClinicalIndication.getAttribute("value");
        System.out.println("Opened Clinical Indication: " + actualClinicalHistory);

        // Check if default value matches expected
        if (actualClinicalHistory.equalsIgnoreCase(expectedClinicalHistory)) {
            System.out.println("Default Clinical Indication is displayed.");
        } else {
            System.out.println("Default Clinical Indication is NOT displayed. Actual value: " + actualClinicalHistory);
        }
         Thread.sleep(1000);
        // Check if field is editable
        if (ClinicalIndication.isEnabled()) {
            System.out.println("Clinical Indication field is editable.");
            ClinicalIndication.clear();
            ClinicalIndication.sendKeys("Fever");
        } else {
            System.out.println("Clinical Indication field is NOT editable.");
        }
    }

    public void validateProtocolinCalciumReportForm() throws InterruptedException {
        if(ProtocolInCalciumReport.isEnabled()){
            System.out.println("Able to Edit Protocol!");
        }else{
            System.out.println("Unable to Edit Protocol!");
        }
        Thread.sleep(1000);
    }


    public void validateStudyDesc() throws InterruptedException {
        String OpenedStudyDesc = StudyDescInReportingScreen.getText().trim();
        System.out.println("Opened Study Description :" + OpenedStudyDesc);
        if(OpenedStudyDesc.equals("Coronary CTA(Adult)") || OpenedStudyDesc.equals("Ca Score(Adult)")){
            System.out.println("Study Description Match found!");
            CalciumReportLink.click();
            System.out.println("Calcium report form is loaded!");
        }else{
            System.out.println("Study Match Not found!");
        }
        Thread.sleep(1000);
    }

    public String SendReportEditRequest() throws InterruptedException {
      //  String ActiveTabPatient = ActiveTab.getText();
        String repName = reportNameInRequestPopup.getText();
        System.out.println(repName);
        Thread.sleep(1000);
        RadiologistDropdownInRequestPopup.click();
        Thread.sleep(1000);
        RadiologistDrVijay.click();
        Thread.sleep(1000);
        RequestReason.sendKeys("Need to Modify the report");
        Thread.sleep(1000);
        SubmitButtonforReportRequest.click();
        return repName;

    }



    public void checkEditButtonInReporting() throws InterruptedException {
        List<WebElement> edits = driver.findElements(By.xpath("//button/span[contains(text(),'Edit')]"));
        if (edits.size() > 0 && edits.get(0).isDisplayed()) {
            System.out.println("Edit button is visible!");
        } else {
            System.out.println("Edit button is Not visible! as Expected.");
        }
    }


    public void DiscardReport(WebElement threeDotsElement, boolean confirmDiscard) throws InterruptedException {

        try{
            threeDotsElement.click();
            Thread.sleep(1000);

            if(DiscardButton != null && DiscardButton.isDisplayed() && DiscardButton.isEnabled()){
                if(confirmDiscard){
                    DiscardButton.click();
                    System.out.println("Discard option is clicked!");
                    Thread.sleep(1000);
                    YesforDiscard.click();
                    System.out.println("Report Discarded Successfully!");
                }
            }else{
                if(!confirmDiscard){
                    System.out.println("Discard option is Not available. Menu is closed.");
                    threeDotsElement.click();
                    Thread.sleep(1000);
                }
//                System.out.println("Discard option is Not available. Menu is closed.");
//                threeDotsElement.sendKeys(Keys.ESCAPE);
            }

        }catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (StaleElementReferenceException e) {
            System.out.println("Discard element is stale—refetch it.");
        } catch (Exception e) {
            System.out.println("❗Unexpected error: " + e.getMessage());
        }
    }

    public void RequestToEdit(WebElement threeDotsElement, boolean SendEditRequest ){
        try{
            threeDotsElement.click();
            Thread.sleep(1000);
               if(RequestToEditButton != null && RequestToEditButton.isDisplayed() && RequestToEditButton.isEnabled()){
                   if(SendEditRequest){
                       RequestToEditButton.click();
                       System.out.println("Request To Edit option is clicked!");
                   }
               }
            } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
        PrelimFindings.sendKeys("Brhjhjainstem is normal. Cerebello-pontine angles are normal. Vermis and both cerebellar hemispheres are normal. Fourth ventricle is normal.");
        PrelimImpression.sendKeys("Nojghj intracranial abnormality.");

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

    public String verifyPatientTab(){
        String ActiveTabPatient = ActiveTab.getText();
        System.out.println("Active Tab Patient is : "+ ActiveTabPatient);
        return ActiveTabPatient;
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
        Thread.sleep(3000);
        SaveButton.click();
        Thread.sleep(1000);
        System.out.println("Clicked on Save Button");
        Thread.sleep(3000);
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



