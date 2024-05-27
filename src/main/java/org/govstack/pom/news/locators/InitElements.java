package org.govstack.pom.news.locators;

import org.govstack.WebDriver.WebDriverManager;
import org.openqa.selenium.support.PageFactory;


public class InitElements extends WebDriverManager {

    public InitElements(){
        PageFactory.initElements(getDriver(),this);
    }
}
