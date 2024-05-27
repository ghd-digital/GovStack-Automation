package org.govstack.pom.news.pages;

import com.aventstack.extentreports.Status;
import org.govstack.WebDriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.news.locators.NewsLocators;
import org.govstack.pom.news.locators.UpdatePost_Locators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UpdatePost_Page extends WebDriverManager {

    UpdatePost_Locators updatepostLoc = new UpdatePost_Locators();
    CommonMethods methods = new CommonMethods();
    NewsLocators newsLocators = new NewsLocators();
    LoginPage loginpage = new LoginPage();

    String updateText = "_" + methods.generateRandomString();

    public void selectExistingPost() {
        try {
            methods.clickElementFromList(updatepostLoc.postlist, TestData.getData("post name"));
            methods.threadWait(2);
            ExtentReporter.log(Status.PASS, "successfully selectExistingPost");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to select existing post");
        }
    }

    public void updatePostname() {
        try {
            methods.sendTextToElement(updatepostLoc.postname, updateText);
            methods.threadWait(1);
            ExtentReporter.log(Status.PASS, "successfully updatePostname");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to update postname");
        }
    }

    public void updateCurrentDate() {
        try {
            methods.clickElement(newsLocators.datePicker);
            methods.selectOptionFromList(newsLocators.postDateTxt, methods.getCurrentDate());
            methods.clickElement(newsLocators.headerNameTxt);
            ExtentReporter.log(Status.PASS, "successfully updateCurrentDate");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to update current date");
        }
    }

    public void removeCategory() {
        try {
            if (methods.isElementPresent(updatepostLoc.selectedCatg)) {
                methods.clickElement(updatepostLoc.removeCatg);
                methods.threadWait(2);
                ExtentReporter.log(Status.PASS, "successfully removeCategory");
            } else {
                ExtentReporter.log(Status.INFO, "SELECT CATEGORY TO REMOVE");
                Assert.assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        }
    }

    public void addCategory() {
        try {
            methods.clickElement(newsLocators.postCategoriesBtn);
            methods.selectOptionFromList(updatepostLoc.catgList, TestData.getData("post categories"));
            methods.clickElement(newsLocators.submitBtn);
            methods.threadWait(3);
            methods.assertTrueForElementPresense(updatepostLoc.selectedCatg);
            ExtentReporter.log(Status.PASS, "successfully addCategory");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to add category");
        }
    }

    public void removeAuthor() {
        try {
            if (methods.isElementPresent(updatepostLoc.selectedAuth)) {
                methods.clickElement(updatepostLoc.removeAuth);
                methods.threadWait(2);
                ExtentReporter.log(Status.PASS, "successfully removeAuthor");
            } else {
                ExtentReporter.log(Status.INFO, "SELECT AUTHOR TO REMOVE");
                Assert.assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        }
    }

    public void addAuthor() {
        try {
            methods.clickElement(newsLocators.authorBtn);
            methods.threadWait(2);
            methods.selectOptionFromList(newsLocators.selectAuthor, TestData.getData("author"));
            methods.threadWait(1);
            methods.clickElement(newsLocators.submitBtn);
            methods.threadWait(2);
            methods.assertTrueForElementPresense(updatepostLoc.selectedAuth);
            ExtentReporter.log(Status.PASS, "successfully addAuthor");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to add author");
        }
    }

    public void navigateSummary() {
        try {
            methods.clickElement(newsLocators.summaryBtn);
            methods.threadWait(1);
            ExtentReporter.log(Status.PASS, "successfully navigateSummary");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to navigate summary");
        }

    }

    public void updateSummaryHeadings() {
        try {
            methods.sendTextToElement(updatepostLoc.summaryHeading1, methods.generateRandomString());
            methods.threadWait(1);
            methods.sendTextToElement(updatepostLoc.summaryHeading2, methods.generateRandomString());
            methods.threadWait(1);
            ExtentReporter.log(Status.PASS, "successfully updateSummaryHeadings");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to update summary headings");
        }
    }

    public void updateSummaryText() {
        try {
            getDriver().switchTo().frame(updatepostLoc.summaryTextIframe);
            methods.clickElement(updatepostLoc.summarytextInput);
            methods.sendTextToElement(updatepostLoc.summarytextInput, methods.generateRandomString());
            getDriver().switchTo().defaultContent();
            ExtentReporter.log(Status.PASS, "successfully updateSummaryText");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to update summary text");
        }

    }

    public void removeImg() {
        try {
            if (methods.isElementPresent(updatepostLoc.imgThumb)) {
                methods.moveToElementAction(updatepostLoc.imgThumb);
                methods.threadWait(1);
                methods.clickElement(updatepostLoc.removeImg);
                methods.threadWait(2);
                ExtentReporter.log(Status.PASS, "successfully removeImg");
            } else {
                ExtentReporter.log(Status.INFO, "SELECT IMAGE TO REMOVE");
                Assert.assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        }
    }

    public void updateImage() {
        try {
            methods.clickElement(updatepostLoc.addImg);
            methods.threadWait(2);
            methods.inputFile(TestData.getData("image"), updatepostLoc.imgInput);
            methods.waitForElementClickable(updatepostLoc.selectImgBtn, 30);
            methods.clickElement(updatepostLoc.selectImgBtn);
            methods.waitForElementVisibility(updatepostLoc.imgThumb, 10);
            ExtentReporter.log(Status.PASS, "successfully updateImage");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to update image");
        }
    }

    public void clickSave() {
        try {
            //pagesave
            methods.clickElement(updatepostLoc.pagesave);
            methods.waitForElementVisibility(updatepostLoc.readytoSavePopup, 10);
            //popupsave
            methods.clickElement(updatepostLoc.savepopup);
            methods.waitForElementInVisibility(updatepostLoc.readytoSavePopup, 10);
            ExtentReporter.log(Status.PASS, "successfully clickSave");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click save or save overlay");
        }
    }

    public void clickBack() {
        try {
            methods.clickElement(updatepostLoc.back);
            methods.threadWait(2);
            ExtentReporter.log(Status.PASS, "successfully clickBack");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click back");
        }
    }

    public void clickPublish() {
        try {
            methods.clickElement(updatepostLoc.PublishBtn);
            methods.threadWait(2);
            ExtentReporter.log(Status.PASS, "successfully clickPublish");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click publish");
        }
    }

    public void selectPostCard() {
        try {
            for (WebElement ele : updatepostLoc.postlist) {
                if (methods.getTextofElementContains(ele, TestData.getData("post name"))) {
                    methods.clickElement(updatepostLoc.getPostCardtoSelect(ele));
                    methods.threadWait(2);
                    ExtentReporter.log(Status.PASS, "successfully selectPostCard");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to select post card");
        }
    }

    public void publishConfirmationPopup() {
        try {
            methods.clickElement(updatepostLoc.popupPublishBtn);
            methods.threadWait(3);
            ExtentReporter.log(Status.PASS, "successfully publishConfirmationPopup");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click publish confirmation ovrerlay");
        }
    }

    public void verifyPostStatus() {
        try {
            for (WebElement post : updatepostLoc.postlist) {
                if (methods.getTextofElement(post).contains(updateText)) {
                    //status published
                    methods.assertEqualsString(methods.getTextofElement(updatepostLoc.getPublishedStatusValue(post)), TestData.getData("published status value"));
                    ExtentReporter.log(Status.PASS, "successfully verifyPostStatus");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify post status");
        }
    }

    public void verifyLastEditedCurentDate() {
        try {
            for (WebElement post : updatepostLoc.postlist) {
                if (methods.getTextofElement(post).contains(updateText)) {
                    String date = methods.getTextofElement(updatepostLoc.getLastEditedDateValue(post)).trim().split(" ")[0];
                    LocalDate currentDate = LocalDate.now();
                    methods.assertEqualsString(date, currentDate.toString());
                    ExtentReporter.log(Status.PASS, "successfully verifyLastEditedCurentDate");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify last edited date as current date");
        }
    }

    public void verifyCreatedby() {
        try {
            for (WebElement post : updatepostLoc.postlist) {
                if (methods.getTextofElement(post).contains(updateText)) {
                    methods.assertEqualsOfElementText(updatepostLoc.getCreatedbyValue(post), TestData.getData("createdby"));
                    ExtentReporter.log(Status.PASS, "successfully verifyCreatedby");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify createdby user");
        }
    }

    public void updateFutureDate() {
        try {
            methods.clickElement(newsLocators.datePicker);
            if (TestData.getData("post date").equalsIgnoreCase("futuredate")) {
                methods.selectOptionFromList(newsLocators.postDateTxt, methods.getFutureDate(2));
            }
            methods.clickElement(newsLocators.headerNameTxt);
            ExtentReporter.log(Status.PASS, "successfully updateFutureDate");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed update future date");
        }
    }

    public void verifyLastEditedFutureDate() {
        try {
            for (WebElement post : updatepostLoc.postlist) {
                if (methods.getTextofElement(post).contains(updateText)) {
                    String futuredateStr = methods.getTextofElement(updatepostLoc.getLastEditedDateValue(post)).trim().split(" ")[0];
                    LocalDate futuredate = LocalDate.parse(futuredateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    LocalDate currentDate = LocalDate.now();
                    Assert.assertTrue(futuredate.isAfter(currentDate));
                    ExtentReporter.log(Status.PASS, "successfully verifyLastEditedFutureDate");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify lastedited date as future date");
        }
    }

    public void updateBlankDate() {
        try {
            if (methods.getAttributeOfElementEquals(updatepostLoc.calInput, "aria-invalid", "false")) {
                methods.clickElement(updatepostLoc.calClearBtn);
                methods.threadWait(1);
                methods.assertEqualsOfElementAttribute(updatepostLoc.calInput, "aria-invalid", "true");
                ExtentReporter.log(Status.PASS, "successfully updateBlankDate");
            } else {
                ExtentReporter.log(Status.INFO, "SELECT DATE TO CLEAR");
                Assert.fail("BUG");
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        } catch (NullPointerException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        }
    }

    public void validateErrorStringOnSave() {
        try {
            methods.clickElement(updatepostLoc.pagesave);
            methods.clickElement(updatepostLoc.savepopup);
            methods.assertTrueForElementTextContains(updatepostLoc.validationFailedOnSave, TestData.getData("validatoin failed on save"));
            methods.clickElement(updatepostLoc.closepopup);
            ExtentReporter.log(Status.PASS, "successfully validateErrorStringOnSave");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to validate error string on clicking save button");
        }
    }

    public void validateMadatoryErrorStrings() {
        try {
            methods.assertEqualsOfElementText(updatepostLoc.calBlankErrorAlert, TestData.getData("erorr"));
            methods.assertEqualsOfElementText(updatepostLoc.requiredErrorHelpString, TestData.getData("requied help error"));
            ExtentReporter.log(Status.PASS, "successfully validateMadatoryErrorStrings");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to validate madatory error strings");
        }
    }

    public void navigateContent() {
        try {
            methods.clickElement(newsLocators.contentMenuBtn);
            ExtentReporter.log(Status.PASS, "successfully navigateContent");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to navigate content");
        }
    }

    public void deleteContentPageTitle() {
        try {
            methods.clearElementInput(newsLocators.pageTitleTxt);
            ExtentReporter.log(Status.PASS, "successfully deleteContentPageTitle");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to delete content page title");
        }
    }

    public void deleteContentSecondHeading() {
        try {
            methods.clearElementInput(updatepostLoc.contentSecondHeading);
            ExtentReporter.log(Status.PASS, "successfully deleteContentSecondHeading");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to delete content secondary heading");
        }
    }

    public void deleteContentMainContent() {
        try {
            if (methods.isElementPresent(updatepostLoc.getHoveronContentMaincontentImg())) {
                methods.moveToElementAction(updatepostLoc.getHoveronContentMaincontentImg());
                methods.clickElement(updatepostLoc.contentImgDeleteIcon);
                methods.clickElement(updatepostLoc.contentImgDeleteBtn);
                methods.waitForElementInVisibility(updatepostLoc.contentImgDeleteOverlay, 5);
                ExtentReporter.log(Status.PASS, "successfully deleteContentMainContent");
            } else {
                ExtentReporter.log(Status.INFO, "SELECT CONTENT TO DELETE");
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        }
    }

    public void verfiydeleteContentPageTitle() {
        try {
            methods.assertTrueOfElementTextEmpty(newsLocators.pageTitleTxt);
            ExtentReporter.log(Status.PASS, "successfully verfiydeleteContentPageTitle");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify deleted content page title");
        }
    }

    public void verifydeleteContentSecondHeading() {
        try {
            methods.assertTrueOfElementTextEmpty(updatepostLoc.contentSecondHeading);
            ExtentReporter.log(Status.PASS, "successfully verifydeleteContentSecondHeading");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify deleted content secondary heading");
        }
    }

    public void verifydeleteContentMainContent() {
        try {
            methods.assertTrueForElementNotPresent(updatepostLoc.getHoveronContentMaincontentImg());
            ExtentReporter.log(Status.PASS, "successfully verifydeleteContentMainContent");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify deleted content main content sample gallery image");
        }
    }


    public void clickRequestPublishMenuButton() {
        try {
            if (methods.isElementPresent(updatepostLoc.requestPublishBtn)) {
                methods.clickElement(updatepostLoc.requestPublishBtnMenu);
                methods.threadWait(1);
                ExtentReporter.log(Status.PASS, "successfully clickRequestPublishMenuButton");
            } else {
                ExtentReporter.log(Status.FAIL, "REQUEST PUBLISH BUTTON NOT AVAILABLE");
                Assert.fail();
            }
        } catch (NoSuchElementException e) {
            ExtentReporter.log(Status.INFO, e.getMessage());
        }
    }

    public void clickSaveAndPublish() {
        try {
            methods.clickElement(updatepostLoc.saveAndPublish);
            methods.threadWait(2);
            ExtentReporter.log(Status.PASS, "successfully clickSaveAndPublish");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click on saveandpublish");
        }
    }

    public void clickReadyToSaveAndPublish() {
        try {
            methods.clickElement(updatepostLoc.readyTosaveAndPublishOverlayBtn);
            methods.waitForElementInVisibility(updatepostLoc.readyTosaveAndPublishOverlay, 5);
            ExtentReporter.log(Status.PASS, "successfully clickReadyToSaveAndPublish");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click ready to saveandpublish overlay");
        }
    }

    public void validateRequiredHelplineError() {
        try {
            methods.assertEqualsOfElementText(updatepostLoc.requiredErrorHelpString, TestData.getData("requied help error"));
            ExtentReporter.log(Status.PASS, "successfully validateRequiredHelplineError");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to validate required help error string");
        }
    }

    public void validatePropertyInvalidError() {
        try {
            methods.assertEqualsOfElementText(updatepostLoc.propertyError, TestData.getData("property error"));
            ExtentReporter.log(Status.PASS, "successfully validatePropertyInvalidError");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to validate property invalid error string");
        }
    }

    public void navigateFENewsListingPage() {
        try {
            methods.OpenAndSwitchNewTab();
            ExtentReporter.log(Status.INFO, "successfully OpenAndSwitchNewTab");
            loginpage.launchFrontEndApplication();
            ExtentReporter.log(Status.PASS, "successfully launchFrontEndApplication");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to navigate frontend news listing page");
        }
    }

    public void dismissAllAlertsOnFEPage() {
        try {
            methods.clickElement(updatepostLoc.dismisallalerts);
            methods.threadWait(2);
            ExtentReporter.log(Status.PASS, "successfully dismissAllAlertsOnFEPage");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to click on dismiss all alerts");
        }
    }

    public void selectNewsPost() {
        try {
            methods.clickElementFromList(updatepostLoc.newsPostListOnFE, TestData.getData("news post name"));
            ExtentReporter.log(Status.PASS, "successfully selectNewsPost");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to select news post on frontend page");
        }
    }

    public void verifyNewsPostContentPageTitle() {
        try {
            methods.assertTrueForElementPresense(updatepostLoc.newsPostContentPageTitle);
            ExtentReporter.log(Status.PASS, "successfully verifyNewsPostContentPageTitle");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify content page title inside news post");
        }
    }

    public void verifyNewsPostContentH2() {
        try {
            methods.assertTrueForElementPresense(updatepostLoc.newsPostContentH2);
            ExtentReporter.log(Status.PASS, "successfully verifyNewsPostContentH2");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify content secondary heading inside news post");
        }
    }

    public void verifyNewsPostContentGalleryImg() {
        try {
            methods.assertTrueForElementPresense(updatepostLoc.newsPostContentGalleryImg);
            ExtentReporter.log(Status.PASS, "successfully verifyNewsPostContentGalleryImg");
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, e.getMessage());
            Assert.fail("failed to verify content main content gallery image inside news post");
        }
    }
}