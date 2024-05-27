package org.govstack.pom.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentMainLocators extends InitElements{

    @FindBy(xpath = "(//button[@data-element='tree-item-expand'])[1]")
    public WebElement mainSiteExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'News')]/parent::div/button")
    public WebElement newsExpandBtn;
    @FindBy(xpath = "//a[contains(text(),'Post')]")
    public WebElement postsBtn;
    @FindBy(xpath = "(//a[text()='News'])[1]")
    public WebElement selectNewsLnk;

}
