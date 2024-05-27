package org.govstack.pom.news.pages;

import com.aventstack.extentreports.Status;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.news.locators.NewsLocators_FrontEnd;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class NewsFrontEndPage {

    LoginPage loginPage = new LoginPage();
    CommonMethods methods = new CommonMethods();
    NewsLocators_FrontEnd newsLocatorsFrontEnd = new NewsLocators_FrontEnd();

    public void launchFrontEndInNewTab() {
        methods.OpenAndSwitchNewTab();
        loginPage.launchFrontEndApplication();
        methods.clickElement(newsLocatorsFrontEnd.dismissAllAlerts);
    }

    public void validateToggleInFrontEnd() {
        methods.waitForElement(2);
        if (NewsPage.displayAuthors.equalsIgnoreCase("true")) {
            if (methods.isElementPresent(newsLocatorsFrontEnd.authorList)) {
                ExtentReporter.log(Status.PASS, "Author details displayed");
            } else {
                ExtentReporter.log(Status.FAIL, "Author details are not displayed");
                Assert.fail();
            }
        }
        if (NewsPage.displayAuthors.equalsIgnoreCase("false")) {
            if (methods.isElementNotPresent(newsLocatorsFrontEnd.authorList)) {
                ExtentReporter.log(Status.PASS, "Author details not displayed");
            } else {
                ExtentReporter.log(Status.FAIL, "Author details are displayed");
                Assert.fail();
            }
        }
    }

    public void validateContent() {
        methods.waitForElement(2);
        methods.sendTextToElement(newsLocatorsFrontEnd.searchNewsTxt, NewsPage.newsTitle);
        methods.clickElement(newsLocatorsFrontEnd.searchBtn);
        if (methods.getText(newsLocatorsFrontEnd.newsTitleLnk).equalsIgnoreCase(NewsPage.newsTitle)) {
            ExtentReporter.log(Status.PASS, NewsPage.newsTitle + " Validated");
        } else {
            ExtentReporter.log(Status.FAIL, NewsPage.newsTitle + " Not Validated");
        }
        if (methods.getText(newsLocatorsFrontEnd.newsDescriptionLnk).equalsIgnoreCase(TestData.getData("Text"))) {
            ExtentReporter.log(Status.PASS, TestData.getData("Text") + " validated");
        } else {
            ExtentReporter.log(Status.FAIL, TestData.getData("Text") + " Not Validated");
        }
        if (methods.getText(newsLocatorsFrontEnd.newsAuthorLnk).equalsIgnoreCase(TestData.getData("Author"))) {
            ExtentReporter.log(Status.PASS, TestData.getData("Author") + " Validated");
        } else {
            ExtentReporter.log(Status.FAIL, TestData.getData("Author") + " Not Validated");
        }
        if (methods.getText(newsLocatorsFrontEnd.newsDescriptionLnk).equalsIgnoreCase(TestData.getData("Post Category"))) {
            ExtentReporter.log(Status.PASS, TestData.getData("Post Category") + " validated");
        } else {
            ExtentReporter.log(Status.FAIL, TestData.getData("Post Category") + " Not Validated");
        }
    }
}
