package org.govstack.WebDriver;

import org.govstack.framework.ConfigurationManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.util.Objects;

public class WebDriverCapabilities {

    public static ChromeOptions setChromeCapabilities(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addExtensions(new File(System.getProperty("user.dir")+"/Chrome Extension/Microsoft Single Sign On 1.0.8.0.crx"));
        if(Objects.requireNonNull(ConfigurationManager.getPropertyValue("HEADLESS_MODE")).equalsIgnoreCase("true")){
            options.addArguments("--headless=new");
        }
        return options;
    }

    public static EdgeOptions setEdgeCapabilities(){
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        if(Objects.requireNonNull(ConfigurationManager.getPropertyValue("HEADLESS_MODE")).equalsIgnoreCase("true")){
            options.addArguments("--headless=new");
        }
        return options;
    }
}
