package org.govstack.pom.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpdatePOCLocators extends InitElements {

    @FindBy(xpath = "//span[contains(normalize-space(),'donot delete')]")
    public WebElement existingpost;

    @FindBy(id = "headerName")
    public WebElement name;

    @FindBy(xpath = "//button[@hotkey='ctrl+s']")
    public WebElement save1;

    @FindBy(xpath = "//button[@umb-auto-focus='true']")
    public WebElement save2;

    @FindBy(xpath = "//button[@class='umb-editor-header__back']")
    public WebElement back;

    @FindBy(xpath = " //div[@class='umb-content-grid']//div//a")
    public List<WebElement> postlist;
}
