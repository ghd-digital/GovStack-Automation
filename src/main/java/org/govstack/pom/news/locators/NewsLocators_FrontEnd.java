package org.govstack.pom.news.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsLocators_FrontEnd extends InitElements{

    @FindBy(xpath="//button[text()='Dismiss all alerts']")
    public WebElement dismissAllAlerts;
    @FindBy(xpath = "(//span[@class='gs-feed-list-author'])[1]")
    public WebElement authorList;
    @FindBy(xpath = "(//ul[@class='gs-feed-list-categories'])[1]")
    public WebElement categoriesList;
    @FindBy (id = "txtItemSearch")
    public WebElement searchNewsTxt;
    @FindBy(id="btnSearch")
    public WebElement searchBtn;
    @FindBy(xpath="//div[@class='gs-feed-list-meta']/a")
    public WebElement searchNewsLnk;
    @FindBy(xpath = "//div[@class='gs-feed-list-meta']/a")
    public WebElement newsTitleLnk;
    @FindBy(xpath = "//span[@class='gs-feed-list-description']/p")
    public WebElement newsDescriptionLnk;
    @FindBy(xpath = "//span[@class='gs-feed-list-author']/a")
    public WebElement newsAuthorLnk;
    @FindBy(xpath = "//ul[@class='gs-feed-list-categories']/li/a")
    public WebElement newsCategoryLnk;
}
