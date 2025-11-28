package com.tptrac.generic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener extends BaseClass1 implements ITestListener {

    private ExtentSparkReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest test;

    public void configureReport() {
        ReadConfig readConfig = new ReadConfig();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "TpTracReport-" + timestamp + ".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/TpTracReport/" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Add system/environment information to the report
        reports.setSystemInfo("Machine", "testpc1");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser", readConfig.getBrowser());
        reports.setSystemInfo("User Name", "Niranjan");

        // Configure the look and feel of the report
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("TPTrac Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("Report configuration initialized.");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished.");
        reports.flush(); // Ensure all information is written to the report
        try {
            Thread.sleep(5000); // Adjust the duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Test case failed: " + result.getName(), ExtentColor.RED));

        // Capture screenshot
        WebDriver driver = ((BaseClass1) result.getInstance()).getDriver();
        String screenshotName = result.getName() + ".png";
        String screenshotPath = System.getProperty("user.dir") + "/Reports/TpTracReport/" + screenshotName;

        // Ensure the directory exists
        File reportDirectory = new File(System.getProperty("user.dir") + "/Reports/TpTracReport/");
        if (!reportDirectory.exists()) {
            reportDirectory.mkdirs();
        }

        // Take screenshot and save it
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            // Encode the screenshot to Base64
            String base64Screenshot = encodeImageToBase64(screenshotPath);
            // Embed the Base64-encoded image in the report
            test.fail("Click on the above base64 img button to view the failed screenshot")
                .addScreenCaptureFromBase64String(base64Screenshot);
            System.out.println("Screenshot saved and embedded in report.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Test case skipped: " + result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Test case passed: " + result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used in this implementation
    }

    private String encodeImageToBase64(String imagePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
