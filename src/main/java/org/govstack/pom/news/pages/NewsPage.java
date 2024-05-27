package org.govstack.pom.news.pages;

import com.aventstack.extentreports.Status;
import org.govstack.WebDriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.news.locators.ContentMainLocators;
import org.govstack.pom.news.locators.NewsLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class NewsPage extends WebDriverManager {
    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators = new NewsLocators();
    ContentMainLocators mainLocators=new ContentMainLocators();
    public static String newsTitle;
    public static String displayAuthors;
    public static String displayCategories;
    public static String displayDates;

    public void enterNewsDetails() {
        enterSettingsDetails();
        enterSummaryDetails();
    }

    public void publishTheNews(){
        saveAndPublish();
        verifyPublish();
    }

    public void verifyPublish(){
        methods.clickElement(mainLocators.postsBtn);
        methods.clickElement(newsLocators.searchTxt);
        methods.sendTextToElement(newsLocators.searchTxt,newsTitle);
        for(WebElement ele: newsLocators.results){
            if(ele.getText().contains(newsTitle)){
                CommonMethods.highlightElement(ele);
                methods.waitForElement(2);
                ExtentReporter.log(Status.PASS,"News Created");
                ExtentReporter.logWithScreenshot(Status.PASS,"News Created");
                break;
            }else{
                ExtentReporter.log(Status.FAIL,"News not Created");
                ExtentReporter.logWithScreenshot(Status.FAIL,"News not Created");
            }
        }
    }

    public void requestPublish(){
        methods.clickElement(newsLocators.requestPublishBtn);
        methods.waitForElement(3);
        methods.sendTextToElement(newsLocators.workflowCommentTxt,TestData.getData("Descripbe the Changes"));
        methods.waitForElement(2);
        methods.clickElement(newsLocators.requestPublishFinalBtn);
        methods.waitForElement(8);
    }
    public void enterSettingsDetails() {
        methods.clickElement(mainLocators.postsBtn);
        methods.waitForElement(2);
        methods.clickElement(newsLocators.creatNewpost);
        newsTitle=TestData.getData("Header Name") + "_" + methods.generateRandomString();
        methods.sendTextToElement(newsLocators.headerNameTxt, newsTitle);
        methods.clickElement(newsLocators.datePicker);
        methods.waitForElement(2);
        if (TestData.getData("Post Date").equalsIgnoreCase("currentdate")) {
            methods.selectOptionFromList(newsLocators.postDateTxt, methods.getCurrentDate());
        }
        methods.javaScriptClickElement(newsLocators.postCategoriesBtn);
        methods.waitForElement(3);
        methods.selectOptionFromList(newsLocators.selectCategory, TestData.getData("Post Category"));
        methods.waitForElement(1);
        methods.clickElement(newsLocators.submitBtn);
        methods.waitForElement(2);
        methods.javaScriptClickElement(newsLocators.authorBtn);
        methods.waitForElement(2);
        methods.selectOptionFromList(newsLocators.selectAuthor, TestData.getData("Author"));
        methods.waitForElement(1);
        methods.clickElement(newsLocators.submitBtn);
        methods.waitForElement(2);
    }

    public void enterContentDetails() {
        methods.clickElement(newsLocators.contentMenuBtn);
        methods.sendTextToElement(newsLocators.pageTitleTxt, TestData.getData("Page title") + "_" + methods.generateRandomString());
    }

    public void enterSummaryDetails() {
        methods.clickElement(newsLocators.summaryBtn);
        methods.sendTextToElement(newsLocators.pageListingHeadingTxt, newsTitle);
        methods.sendTextToElement(newsLocators.secondaryheadingTxt,TestData.getData("Secondary Heading"));
        methods.switchToframe(newsLocators.pageSummaryFrame);
        methods.sendTextToElement(newsLocators.textTxt,TestData.getData("Text"));
        methods.switchToDefaultContent();
        methods.clickElement(newsLocators.imageButton);
        methods.sendTextToElement(newsLocators.searchImageLnk,TestData.getData("Image type"));
        methods.clickElement(newsLocators.selectImagelnk);
        methods.clickElement(newsLocators.summarySelectBtn);
    }

   public void updateSettings(){
        methods.scrollAndClickElement(newsLocators.displayAuthorsToggle);
        methods.clickElement(newsLocators.displayCategoriesToggle);
        methods.clickElement(newsLocators.displayDatesToggle);
        displayAuthors=methods.getAttributeValue(newsLocators.displayAuthorsToggle,"aria-checked");
       displayCategories=methods.getAttributeValue(newsLocators.displayCategoriesToggle,"aria-checked");
       displayDates=methods.getAttributeValue(newsLocators.displayDatesToggle,"aria-checked");
   }

   public void saveAndPublish() {
       methods.clickElement(newsLocators.buttonGroupToggle);
       methods.waitForElement(2);
       methods.clickElement(newsLocators.saveAndPublishBtn);
       methods.waitForElement(2);
       methods.clickElement(newsLocators.saveAndPublishFinalBtn);
       methods.waitForElement(5);
       ExtentReporter.logWithScreenshot(Status.PASS,"News Detail Settings is updated");
   }

    public void publishWithDec(){
        methods.clickElement(newsLocators.buttonGroupToggle);
        methods.waitForElement(1);
        methods.clickElement(newsLocators.publishWithDecBtn);
    }
}

