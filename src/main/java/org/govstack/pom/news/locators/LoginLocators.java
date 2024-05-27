package org.govstack.pom.news.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators extends InitElements {

    @FindBy(id = "Umbraco.BackOffice.OpenIdConnect")
    public WebElement signinWithB2Cbtn;
    @FindBy(id = "signInName")
    public WebElement userNameTxt;
    @FindBy(xpath = "//button[text()='Next']")
    public WebElement nextBtn;
    @FindBy(name = "passwd")
    public WebElement passwordTxt;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInBtn;

    @FindBy(id="idSIButton9")
    public WebElement staySignedInBth;

    @FindBy(id="KmsiCheckboxField")
    public WebElement staySignedInChk;


}
