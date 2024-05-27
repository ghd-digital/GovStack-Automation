package org.govstack.pom.news.pages;

import org.govstack.WebDriver.WebDriverManager;
import org.govstack.pom.news.locators.ContentMainLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.By;

public class ContentMainPage extends WebDriverManager {

    ContentMainLocators mainLocators = new ContentMainLocators();
    CommonMethods methods=new CommonMethods();

    public void SelectTheContent()  {
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollToElement(mainLocators.newsExpandBtn);
        methods.clickElement(mainLocators.newsExpandBtn);
        methods.waitForElement(2);
    }

    public void selectContent(){
        methods.clickElement(mainLocators.mainSiteExpandBtn);
        methods.waitForElement(2);
        methods.scrollAndClickElement(mainLocators.selectNewsLnk);
    }
}
