package org.govstack.WebDriver;


import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Objects;

public class WebDriverManager extends WebDriverCapabilities{

    @Getter
    static WebDriver driver;


    public static void initDriver(){
        String browserName=ConfigurationManager.getPropertyValue("BROWSER");
        switch(Objects.requireNonNull(browserName).toLowerCase()){
            case "chrome":
                driver =new ChromeDriver(setChromeCapabilities());
                break;
            case "edge":
                driver=new EdgeDriver(setEdgeCapabilities());
                break;
            default:
                ExtentReporter.log(Status.FAIL,"Browser is name is null");
        }

    }

    public static void closeBrowser(){
        driver.close();
    }

    public static void closeAllBrowsers(){
        driver.quit();
    }

}
