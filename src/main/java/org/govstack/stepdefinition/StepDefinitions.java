package org.govstack.stepdefinition;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.news.pages.ContentMainPage;
import org.govstack.pom.news.pages.LoginPage;
import org.govstack.pom.news.pages.NewsFrontEndPage;
import org.govstack.pom.news.pages.NewsPage;

public class StepDefinitions {
    LoginPage loginPage = new LoginPage();
    ContentMainPage mainPage = new ContentMainPage();
    NewsPage newsPage = new NewsPage();
    NewsFrontEndPage frontEndPage = new NewsFrontEndPage();

    @Given("I launch and login to the Govstack application")
    public void i_launch_and_login_to_the_govstack_application() {
        loginPage.loginToGovStack_BackEnd();
    }

    @When("I selects the news {string}")
    public void i_selects_the_news(String testCaseID) throws InterruptedException {
        TestData.readTestData(testCaseID);
        mainPage.SelectTheContent();
    }

    @When("I selects the news")
    public void i_selects_the() {
        mainPage.selectContent();
    }

    @When("I enter all the details")
    public void i_enter_all_the_details() {
        newsPage.enterNewsDetails();
    }

    @And("I should be able to publish the news")
    public void i_should_be_able_to_publsh_the_news() {
        newsPage.publishTheNews();
    }

    @When("I launch the News frond end application in new tab")
    public void I_launch_the_News_frond_end_application_in_new_tab() {
        frontEndPage.launchFrontEndInNewTab();
    }

    @And("News should be posted to front end application")
    public void news_should_be_posted_to_front_end_application() {
        frontEndPage.validateContent();
    }

    @And("update News Widgets in Setting")
    public void update_news_widgets_in_setting() {
        newsPage.updateSettings();
        newsPage.saveAndPublish();
    }

    @Then("verify Widgets updated in front End")
    public void verify_widgets_updated_in_front_end() {
        frontEndPage.validateToggleInFrontEnd();
    }

}
