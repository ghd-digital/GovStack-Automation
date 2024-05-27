package org.govstack.pom.news.pages;

import com.aventstack.extentreports.Status;
import org.govstack.WebDriver.WebDriverManager;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.news.locators.LoginLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;



public class LoginPage extends WebDriverManager {

    WebDriver driver= getDriver();
    LoginLocators locators=new LoginLocators();
    CommonMethods methods=new CommonMethods();
    public static final String GOVSTACK_CMS_URL=ConfigurationManager.getPropertyValue("GOVSTACK_CMS_"+ConfigurationManager.getPropertyValue("ENV"));
    public static final String GOVSTACK_CMS_FRONT_END_URL=ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_"+ConfigurationManager.getPropertyValue("ENV"));

    public void loginToGovStack_BackEnd(){
        try {
            driver.get(GOVSTACK_CMS_URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            methods.clickElement(locators.signinWithB2Cbtn);
            methods.sendTextToElement(locators.userNameTxt, ConfigurationManager.getPropertyValue("CMS_QA_USERNAME"));
            methods.clickElement(locators.nextBtn);
            methods.sendTextToElement(locators.passwordTxt,ConfigurationManager.getPropertyValue("CMS_QA_PASSWORD"));
            methods.clickElement(locators.signInBtn);
            methods.clickElement(locators.staySignedInChk);
            methods.clickElement(locators.staySignedInBth);
            ExtentReporter.log(Status.PASS,GOVSTACK_CMS_URL+" Launched application");
            methods.waitForElement(5);
        }catch (Exception e){
            ExtentReporter.log(Status.FAIL,"Unable to login to the application");
            Assert.fail();
        }
    }

    public void launchFrontEndApplication(){
        driver.get(GOVSTACK_CMS_FRONT_END_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


}

