package org.govstack.pom.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsLocators extends InitElements {

    @FindBy(id = "displayAuthors")
    public WebElement displayAuthorsToggle;

    @FindBy(id = "displayCategories")
    public WebElement displayCategoriesToggle;

    @FindBy(id = "displayDates")
    public WebElement displayDatesToggle;

    @FindBy(xpath = "//button[contains(text(),'Settings')]")
    public WebElement settingsBtn;

    @FindBy(xpath = "//button[@class='btn btn-outline umb-outline']")
    public WebElement creatNewpost;


    /**
     * Settings Section
     **/
    @FindBy(id = "headerName")
    public WebElement headerNameTxt;

    @FindBy(xpath = "//span[@icon='icon-calendar']")
    public WebElement datePicker;
    @FindBy(xpath = "//div[@class='dayContainer']/span")
    public List<WebElement> postDateTxt;

    @FindBy(xpath = "//div[@class='umb-editor-footer']/div/div[2]/umb-button/div/button")
    public WebElement saveBtn;

    @FindBy(xpath = "//button[@id='postCategories']")
    public WebElement postCategoriesBtn;
    @FindBy(xpath = "//a[@class='umb-tree-item__label']")
    public List<WebElement> selectCategory;
    @FindBy(xpath = "//umb-button[@label-key='general_submit']/div/button")
    public WebElement submitBtn;
    @FindBy(xpath = "//button[@id='postAuthor']")
    public WebElement authorBtn;
    @FindBy(xpath = "//div[@class='umb-table-cell black umb-minilistview__fade-not-allowed']")
    public List<WebElement> selectAuthor;
    @FindBy(xpath = "//span[@id='disableComments]")
    public WebElement disableCommentsTxt;
    @FindBy(xpath = "//div[@class='umb-toggle__toggle']")
    public WebElement sendSubscriberNotificationTxt;
    @FindBy(xpath = "//body[contains(@data-id,'customMessage')]")
    public WebElement customMessageTxt;


    /**
     * Content
     **/
    @FindBy(xpath = "(//button[contains(text(),'Content')])[1]")
    public WebElement contentMenuBtn;
    @FindBy(xpath = "//input[@value='pageLayoutFull']")
    public WebElement layoutFullLnk;
    @FindBy(xpath = "//label[@class='usn-item item  pageLayoutLeft']")
    public WebElement layoutLeftTxt;
    @FindBy(xpath = "//label[@class='usn-item item  pageLayoutRight']")
    public WebElement layoutRightTxt;
    @FindBy(xpath = "//span[@id='removePageHeading']")
    public WebElement removePageHeadingsTxt;
    @FindBy(xpath = "//span[@id='hidePageHeading']")
    public WebElement hidePageHeadingsTxt;
    @FindBy(xpath = "//input[@id='onPageTitle']")
    public WebElement pageTitleTxt;
    @FindBy(id = "pageListingSecondaryHeading")
    public WebElement secondaryheadingTxt;
    @FindBy(xpath = "//iframe[contains(@id,'pageSummary')]")
    public WebElement pageSummaryFrame;
    @FindBy(id = "tinymce")
    public WebElement textTxt;

    @FindBy(xpath = "(//button[@aria-label='Open media picker'])[1]")
    public WebElement imageButton;
    @FindBy(xpath = "//input[@id='datatype-search']")
    public WebElement searchImageLnk;
    @FindBy(xpath = "//div[@data-element='media-grid-item-0']")
    public WebElement selectImagelnk;
    @FindBy(xpath = "(//umb-button[@button-style=\"success\"]/div/button)[2]")
    public WebElement summarySelectBtn;

    /**
     * Extra Content
     **/

    @FindBy(xpath = "//span[@id='hideDefaultTopComponents']")
    public WebElement hideGlobalTopComponentsTxt;
    @FindBy(xpath = "//button[@id='button_aboveMainContent']")
    public WebElement aboveMainContentTxt;
    @FindBy(xpath = "//button[@id='button_belowMainContent']")
    public WebElement belowMainContentTxt;
    @FindBy(xpath = "//span[@id='hideDefaultBottomComponents']")
    public WebElement hideGlobalBottomComponentsTxt;
    @FindBy(xpath = "//span[@id='hideDefaultPods']")
    public WebElement hideGlobalPodsTxt;
    @FindBy(xpath = "//button[@id='button_pagePods']")
    public WebElement podsTxt;
    @FindBy(xpath = "//input[@value='modal-timed']")
    public WebElement modalWindowTimedTxt;
    @FindBy(xpath = "//input[@value='modal-scroll']")
    public WebElement modalWindowScrollTxt;

    /**
     * Summary
     **/
    @FindBy(xpath = "//button[contains(text(),'Summary')]")
    public WebElement summaryBtn;
    @FindBy(id = "pageListingHeading")
    public WebElement pageListingHeadingTxt;

    /**
     * Navigation
     **/


    @FindBy(xpath = "//span[@id='umbracoNaviHide']")
    public WebElement hideFromAllNavigationTxt;
    @FindBy(xpath = "//span[@id='hideFromInternalSearch']")
    public WebElement hideFromInternalSearchTxt;
    @FindBy(xpath = "//span[@id='hideBreadcrumb']")
    public WebElement hideBreadcrumbTxt;
    @FindBy(xpath = "//input[@id='htmlSitemapLinkTxt']")
    public WebElement hTMLsitemaplinkTxtTxt;
    @FindBy(xpath = "//input[@id='breadcrumbLinkTxt']")
    public WebElement breadcrumblinkTxtTxt;

    /**
     * SEO&Share
     **/

    @FindBy(xpath = "//div[@class='usn-google-search']")
    public WebElement titleAndDescriptionTxt;
    @FindBy(xpath = "//input[@ng-model='model.value.title']")
    public WebElement titleTxt;
    @FindBy(xpath = "//Txtarea[@class='usn-Txt-field usn-Txt-area ng-pristine ng-untouched ng-valid ng-empty']")
    public WebElement descriptionTxt;

    @FindBy(xpath = "")
    public WebElement socialshareimageTxt;


    @FindBy(xpath = "//input[@id='twitterCreatorUsername']")
    public WebElement twitterCreatorUsernameTxt;
    @FindBy(xpath = "//span[@id='hideFromSearchEngines']")
    public WebElement hideFromSearchEnginesTxt;
    @FindBy(xpath = "//span[@id='stopInternalLinksBeingFollowed']")
    public WebElement stopInternalLinksBeingFollowedTxt;
    @FindBy(xpath = "//input[@name='taboptions_6710']")
    public WebElement sitemapXMLchangeFrequencyAlways;
    @FindBy(xpath = "//input[@value='sitemap_Hourly']")
    public WebElement sitemapXMLchangeFrequencyHourly;
    @FindBy(xpath = "//input[@value='sitemap_Daily']")
    public WebElement sitemapXMLchangeFrequencyDaily;
    @FindBy(xpath = "//input[@value='sitemap_Weekly']")
    public WebElement sitemapXMLchangeFrequencyWeekly;
    @FindBy(xpath = "//input[@value='sitemap_Monthly']")
    public WebElement sitemapXMLchangeFrequencyMonthly;
    @FindBy(xpath = "//input[@value='sitemap_Yearly']")
    public WebElement sitemapXMLchangeFrequencyYearly;
    @FindBy(xpath = "//input[@value='sitemap_Never']")
    public WebElement sitemapXMLchangeFrequencyNever;
    @FindBy(xpath = "//input[@id='overrideCanonicalURL']")
    public WebElement overrideCanonicalURL;
    @FindBy(xpath = "//input[@id='umbracoUrlAlias']")
    public WebElement alternativeURLTxt;
    @FindBy(xpath = "id=umbracoUrlName")
    public WebElement alternativeNameTxt;


    /**
     * Scripts
     **/

    @FindBy(xpath = "//div[@class='ace_content']")
    public WebElement headerOpeningScriptsTxt;


    @FindBy(xpath = "")
    public WebElement headerClosingScriptsTxt;
    @FindBy(xpath = "")
    public WebElement afterOpeningBodyScriptsTxt;
    @FindBy(xpath = "")
    public WebElement beforeClosingBodyScriptsTxt;


    /**
     * Advanced
     **/
    @FindBy(xpath = "//span[@id='hideWebsiteHeaderSection']")
    public WebElement hideWebsiteHeaderSectionTxt;
    @FindBy(xpath = "//span[@id='hideWebsiteFooterSection']")
    public WebElement hideWebsiteFooterSectionTxt;
    @FindBy(xpath = "//button[@id='overrideWebsiteStyle']")
    public WebElement overrideDesignStyleTxt;
    @FindBy(xpath = "overrideWebsiteLogo")
    public WebElement overrideWebsiteLogoTxt;
    @FindBy(xpath = "//input[@value='ltr']")
    public WebElement overrideContentDirectionLTRTxt;
    @FindBy(xpath = "//input[@value='rtl']")
    public WebElement overrideContentDirectionRTLTxt;
    @FindBy(xpath = "//input[@id='customBodyClasses']")
    public WebElement customPageClassesTxt;
    @FindBy(xpath = "//span[@id='disableDelete']")
    public WebElement disableDeleteTxt;

    @FindBy(xpath = "(//span[@class='umb-button__content'])[4]")
    public WebElement requestPublishBtn;
    @FindBy(id="workflowComment")
    public WebElement workflowCommentTxt;

    @FindBy(xpath = "(//span[@class='umb-button__content'])[6]")
    public WebElement requestPublishFinalBtn;

    @FindBy(xpath = "//input[contains(@id,'search')]")
    public WebElement searchTxt;

    @FindBy(xpath = "//a[@class='umb-content-grid__item-name umb-outline -light']/span[2]")
    public List<WebElement> results;


    @FindBy(xpath = "//button[@data-element='button-group-toggle']")
    public WebElement buttonGroupToggle;

    @FindBy(xpath = "//localize[text()='Publish with descendants']")
    public WebElement publishWithDecBtn;

    @FindBy(xpath = "//localize[text()='Save and publish']")
    public WebElement saveAndPublishBtn;

    @FindBy(xpath = "//*[contains(.,'Save and publish')]/parent::button")
    public WebElement saveAndPublishFinalBtn;
}
