package org.govstack.utils;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.govstack.WebDriver.WebDriverManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonMethods extends WebDriverManager {

    WebDriverWait driverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    public static String captureScreen() {
        String path;
        File targetPath;
        try {
            File source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            path = ExtentReporter.reportPath + "/" + source.getName();
            targetPath = new File(path);
            FileUtils.copyFile(source, targetPath);
            return source.getName();
        } catch (Exception e) {
            return null;
        }
    }

    public static void highlightElement(WebElement ele) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", ele);
    }

    public void clickElement(WebElement ele) {
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(ele));
            highlightElement(ele);
            ele.click();
            ExtentReporter.log(Status.INFO, ele + " clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, ele + " Unable to click element " + e.getMessage());
            Assert.fail();
        }
    }

    public void javaScriptClickElement(WebElement ele) {
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(ele));
            highlightElement(ele);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", ele);
            ExtentReporter.log(Status.INFO, ele + " clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, ele + " Unable to click element " + e.getMessage());
            Assert.fail();
        }
    }

    public void sendTextToElement(WebElement ele, String text) {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(ele));
            highlightElement(ele);
            ele.sendKeys(text);
            ExtentReporter.log(Status.INFO, ele + " " + text + " entered successfully");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, ele + " Unable to enter a text to element " + e.getMessage());
            Assert.fail();
        }
    }

    public String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        return dateOnly.format(cal.getTime()).split("/")[1].toString();
    }

    public String generateRandomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public void selectOptionFromList(List<WebElement> element, String value) {
        try {
            for (WebElement ele : element) {
                if (ele.getText().equals(value)) {
                    //  highlightElement(ele);
                    clickElement(ele);
                    ExtentReporter.log(Status.INFO, value + " Selected");
                    break;
                }
            }
            waitForElement(2);
        } catch (Exception e) {
            ExtentReporter.log(Status.FAIL, "Unable to select " + value + " " + e.getMessage());
            ExtentReporter.logWithScreenshot(Status.FAIL, "Unable to select " + value + " " + e.getMessage());
            Assert.fail();
        }
    }

    public void waitForElement(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (Exception e) {
            ExtentReporter.log(Status.INFO, "");
            Assert.fail();
        }
    }

    public void scrollToElement(WebElement ele) {
        waitForElement(1);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'center',inline: 'nearest'});", ele);
    }

    public void scrollAndClickElement(WebElement ele) {
        try {
            scrollToElement(ele);
            ele.click();
            ExtentReporter.log(Status.INFO, ele + " clicked");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, "Unable to click " + ele + " " + e.getMessage());
            Assert.fail();
        }
    }

    public String getAttributeValue(WebElement ele, String attributeName) {
        try {
            return ele.getAttribute(attributeName);
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, "Unable to locate Element " + ele);
            Assert.fail();
            return null;
        }
    }

    public String getText(WebElement ele) {
        try {
            highlightElement(ele);
            return ele.getText();
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, "Unable to get text from " + ele);
            Assert.fail();
            return null;
        }
    }

    public void OpenAndSwitchNewTab() {
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public void switchToParentTab() {
        Set<String> allWindows = new HashSet<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(allWindows.toArray()[0].toString());
    }

    public boolean isElementPresent(WebElement ele) {
        try {
            ele.isDisplayed();
            highlightElement(ele);
            ExtentReporter.log(Status.INFO, ele + " is displayed");
            return true;
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, ele + " is not displayed");
            return false;
        }
    }

    public boolean isElementNotPresent(WebElement ele) {
        try {
            ele.isDisplayed();
            ExtentReporter.log(Status.FAIL, ele + " is displayed");
            return false;
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.INFO, ele + " is not displayed");
            return true;
        }
    }

    public void switchToframe(WebElement ele) {
        try {
            getDriver().switchTo().frame(ele);
            ExtentReporter.log(Status.INFO, ele + " Switch to Frame");
            waitForElement(1);
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(Status.FAIL, ele + " Unable to switch to frame");
        }
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }
}