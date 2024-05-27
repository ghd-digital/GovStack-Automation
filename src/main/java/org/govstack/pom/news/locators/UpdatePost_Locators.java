package org.govstack.pom.news.locators;

import org.govstack.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpdatePost_Locators extends InitElements {
    //posts page
    @FindBy(xpath = " //div[@class='umb-content-grid']//div//a")
    public List<WebElement> postlist;
    @FindBy(xpath = "//umb-button//button[contains(.,'Publish')]")
    public WebElement PublishBtn;
    @FindBy(xpath = "//div[@name='overlay.name']//button[contains(.,'Publish')]")
    public WebElement popupPublishBtn;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']//ul//li//div[@class='umb-content-grid__details-label']")
    public List<WebElement> postlabel;
    @FindBy(xpath = "//div[@class='umb-content-grid__content']//ul//li//div[@class='umb-content-grid__details-value']")
    public List<WebElement> postvalue;
    @FindBy(xpath = "//*[@id='contentcolumn']//form//div[@class='umb-content-grid__content']//ul[@class='umb-content-grid__details-list']")
    public WebElement publishedpost;
    @FindBy(xpath = "//*[@id='contentcolumn']//form//div[@class='umb-content-grid__content']//ul[@class='umb-content-grid__details-list -light']")
    public WebElement unpublishedpost;
    //post open page
    @FindBy(id = "headerName")
    public WebElement postname;
    @FindBy(xpath = "//button[@hotkey='ctrl+s']")
    public WebElement pagesave;
    @FindBy(xpath = "//button[@umb-auto-focus='true']")
    public WebElement savepopup;
    @FindBy(xpath = "//button[normalize-space()='Close']")
    public WebElement closepopup;
    @FindBy(css = ".umb-editor-header__back")
    public WebElement back;
    @FindBy(xpath = "//ng-form[@name='overlayForm']")
    public WebElement readytoSavePopup;
    @FindBy(xpath = "//button[@class='btn umb-button__button btn-success umb-button-- umb-outline']")
    public WebElement requestPublishBtn;
    @FindBy(xpath = "//button[@class='btn btn-success dropdown-toggle umb-button-group__toggle ']")
    public WebElement requestPublishBtnMenu;
    @FindBy(xpath = "//button[@data-element='button-saveAndPublish']")
    public WebElement saveAndPublish;
    @FindBy(xpath = " //ul//li[@role='menuitem']//button") //[contains(.,'Save and publish')]
    public List<WebElement> requestPublishBtnMenulist;
    @FindBy(xpath = "//button[@umb-auto-focus='true']")
    public WebElement readyTosaveAndPublishOverlayBtn;
    @FindBy(xpath = "//div[@name='overlay.name']")
    public WebElement readyTosaveAndPublishOverlay;
    @FindBy(xpath = "//div[@class='alert alert-error property-error']")
    public WebElement propertyError;
    //request publish
    @FindBy(xpath = "//button//span[normalize-space()='Request publish']")
    //@FindBy(partialLinkText = "Request publish")
    public WebElement requestPublish;
    @FindBy(xpath = "//textarea[@id='workflowComment']")
    public WebElement describeChangesTxt;
    //settings tab
    @FindBy(xpath = "//umb-property[@data-element='property-postAuthor']//div[@class='umb-node-preview__name']")
    public WebElement selectedAuth;
    @FindBy(xpath = "//umb-property[@data-element='property-postCategories']//div[@class='umb-node-preview__name']")
    public WebElement selectedCatg;
    @FindBy(xpath = "//div[@data-element='tab-content-settings']")
    public WebElement body;
    @FindBy(xpath = "//div[@id='nameField']//h1[text()='Select content']")
    public WebElement catgFormheading;
    @FindBy(xpath = "//div[@class='umb-control-group']//following-sibling::div//a")
    public List<WebElement> catgList;
    @FindBy(xpath = "//umb-property[@data-element='property-postCategories']//localize[@key='general_remove'][normalize-space()='Remove']")
    public WebElement removeCatg;
    @FindBy(xpath = "//umb-property[@data-element='property-postAuthor']//localize[@key='general_remove'][normalize-space()='Remove']")
    public WebElement removeAuth;
    @FindBy(xpath = "//input[@id='postDate']")
    public WebElement calInput;
    @FindBy(xpath = "//button[@class='btn-clear']")
    public WebElement calClearBtn;
    @FindBy(css = ".text-warning")
    public WebElement validationFailedOnSave;
    @FindBy(xpath = " //div[@class='alert alert-error property-error']")
    public WebElement calBlankErrorAlert;
    @FindBy(css = ".help-inline")
    public WebElement requiredErrorHelpString;
    //summary tab
    @FindBy(xpath = "//input[@id='pageListingHeading']")
    public WebElement summaryHeading1;
    @FindBy(xpath = "//input[@id='pageListingSecondaryHeading']")
    public WebElement summaryHeading2;
    @FindBy(xpath = "//button[@aria-label='Open media picker']")
    public WebElement addImg;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement imgInput;
    @FindBy(xpath = "//img[contains(@alt, 'Summaryimg')]")
    public WebElement uploadedImg;
    @FindBy(xpath = "//umb-button[@label-key='buttons_select']//button[@type='button']")
    public WebElement selectImgBtn;
    @FindBy(css = ".umb-sortable-thumbnails__wrapper")
    public WebElement imgThumb;
    @FindBy(css = "button[aria-label='Remove']")
    public WebElement removeImg;
    @FindBy(xpath = "//iframe[contains(@id,'customMessage_')]")
    public WebElement summaryTextIframe;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement summarytextInput;
    //content
    @FindBy(xpath = " //input[@placeholder='Heading goes here']")
    public WebElement contentSecondHeading;
    @FindBy(xpath = " //button[@title='Delete']")
    public WebElement contentImgDeleteIcon;
    @FindBy(css = ".umb-block-list__block--content.blockelement__draggable-element.ui-sortable-handle")
    public WebElement contentMaincontentImgShadowroot;
    public String contentMaincontentImgCSS = ".usn-block-list-wrap";
    @FindBy(xpath = " //div[@name='overlay.name']")
    public WebElement contentImgDeleteOverlay;
    @FindBy(xpath = " //button[@umb-auto-focus='true']")
    public WebElement contentImgDeleteBtn;
    //front end
    @FindBy(xpath = "//button[normalize-space()='Dismiss all alerts']")
    public WebElement dismisallalerts;
    @FindBy(xpath = "//a[@title='Click to open ']")
    public List<WebElement> newsPostListOnFE;
    @FindBy(xpath = "//p[@class='secondary-heading lg base-secondary-heading']")
    public WebElement newsPostContentPageTitle;
    @FindBy(xpath = "//h1[@class='heading main base-heading']")
    public WebElement newsPostContentH2;
    @FindBy(xpath = "//img[@class=' lazyloaded']")
    public WebElement newsPostContentGalleryImg;
    CommonMethods methods = new CommonMethods();

    public WebElement getStatusLabel(WebElement ele) {
        return ele.findElement(By.xpath("following-sibling::ul//li//div[@class='umb-content-grid__details-label']//localize[@key='general_status'][normalize-space()='Status:']"));
    }

    public WebElement getPublishedStatusValue(WebElement ele) {
        return ele.findElement(By.xpath("following-sibling::ul//div[@class='umb-content-grid__details-value'][contains(.,'Published')]"));
    }

    public WebElement getUnpublishedStatusValue(WebElement ele) {
        return ele.findElement(By.xpath("following-sibling::ul//li//div[@class='umb-content-grid__details-value']//localize[@key='general_status'][normalize-space()='UnPublished']"));
    }

    public WebElement getPublishPendingStatusValue(WebElement ele) {
        return ele.findElement(By.xpath("following-sibling::ul//li//div[@class='umb-content-grid__details-value']//localize[@key='general_status'][normalize-space()='Published (pending changes)']"));
    }

    public WebElement getPostCardtoSelect(WebElement ele) {
        return ele.findElement(By.xpath("//ancestor::div[@class='umb-content-grid__item umb-outline umb-outline--surrounding -clickable']"));
    }

    public WebElement getLastEditedDateValue(WebElement ele) {
        return ele.findElement(By.xpath("//following-sibling::ul//div[@class='umb-content-grid__details-label'][contains(.,'Last edited:')]//following-sibling::div[@class='umb-content-grid__details-value']"));
    }

    public WebElement getLastEditedLabel(WebElement ele) {
        return ele.findElement(By.xpath("//following-sibling::ul//div[@class='umb-content-grid__details-label'][contains(.,'Last edited:')]"));
    }

    public WebElement getCreatedbyValue(WebElement ele) {
        return ele.findElement(By.xpath("//following-sibling::ul//div[@class='umb-content-grid__details-label'][contains(.,'Created by:')]//following-sibling::div[@class='umb-content-grid__details-value']"));
    }

    public WebElement getHoveronContentMaincontentImg() {
        return methods.getShadowElementByCSS(contentMaincontentImgShadowroot, contentMaincontentImgCSS);
    }

}
