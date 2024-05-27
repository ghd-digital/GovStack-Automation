package org.govstack.framework;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.govstack.utils.CommonMethods;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentReporter extends CommonMethods {

    public static String reportPath;
    static ExtentReports extent;
    static ExtentSparkReporter spark;
    static ExtentTest extentTest;

    public static void initReport(String SuiteName) {
        String path = System.getProperty("user.dir") + "\\Reports\\";
        String fileName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        new File(path + "Report_" + fileName).mkdirs();
        reportPath = path + "Report_" + fileName;
        System.setProperty("Report_Path", reportPath);
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(reportPath);
        extent.attachReporter(spark);
    }

    public static void initTest(String testName) {
        extentTest = extent.createTest(testName);
    }

    public static void log(Status logStatus, String stepName) {
        switch (logStatus) {
            case PASS, INFO, SKIP, FAIL -> extentTest.log(logStatus, stepName);
            default -> {
            }
        }
    }

    public static void logWithScreenshot(Status logStatus, String stepName) {
        switch (logStatus) {
            case PASS, INFO, SKIP, FAIL -> extentTest.addScreenCaptureFromPath(CommonMethods.captureScreen(), stepName);
            default -> {
            }
        }
    }

    public static void endReport() {
        extent.flush();
    }

}

