package com.tptrac.testscript;

import java.awt.AWTException;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.FrameworkandQuestionsUploadPage;
import com.tptrac.pom.FrameworksPage;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.FrameworkandQuestionsUploadPage;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorUpload;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class Frameworkquestionupload extends BaseClass1 {

	public static FluentWait<WebDriver> fWait;

	@Test(priority = 1, testName = "Q", enabled = true)
	public void addframework() throws EncryptedDocumentException, IOException, InterruptedException {
		Reporter.log("AddFramework", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		HomePage h = new HomePage(driver);
		FrameworksPage fp = new FrameworksPage(driver);
		FileLib f = new FileLib();

		String Frameworkname = f.getExcelData("AddFramework", 4, 3);
		String Description = f.getExcelData("AddFramework", 3, 4);
		String Hierarchylevel = f.getExcelData("AddFramework", 1, 5);

		h.setFrameworkMenu();
		logger.info("Framework Menu Clicked");
		fWait.until(ExpectedConditions.visibilityOf(fp.ClickonNewFramework()));
		Thread.sleep(2000);
		fp.ClickonNewFramework().click();
		logger.info("Clicked Add Framework button");
		fWait.until(ExpectedConditions.visibilityOf(fp.EnteredFrameworkName()));
		fp.EnteredFrameworkName().sendKeys(Frameworkname);
		logger.info("Entered Framework Name");
		fWait.until(ExpectedConditions.visibilityOf(fp.EnteredDescription()));
		fp.EnteredDescription().sendKeys(Description);
		logger.info("Entered Descriptions");
		fp.SelectHierarchy(Hierarchylevel);
		logger.info("Entered Hiearchy Level");
		// fWait.until(ExpectedConditions.visibilityOf(fp.Add()));
		// fp.Add().click();
		// Wait for the Add button to be visible and clickable
		WebElement addButton = fWait.until(ExpectedConditions.elementToBeClickable(fp.Add()));

		// Check if it's displayed and enabled
		if (addButton.isDisplayed() && addButton.isEnabled()) {
			addButton.click();
			logger.info("Add button clicked successfully.");
		} else {
			logger.warn("Add button is not displayed or not enabled.");
		}

		// Alternatively, use JavaScript click as a fallback
		if (!addButton.isSelected()) {
			try {
				addButton.click();
			} catch (Exception e) {
				logger.error("Standard click failed: " + e.getMessage());
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
				logger.info("Add button clicked using JavaScript.");
			}
		}

		String actualText = fp.GetActualFrameworkCreated(Frameworkname).getText();
		Assert.assertEquals(actualText, Frameworkname);
		Reporter.log("assertTrue", true);

		String StatuscodeInitiated = fp.statusCodeInitiated(Frameworkname).getText();
		Assert.assertEquals(StatuscodeInitiated, "Initiated");
		Reporter.log("assertTrueInitiatedstatuscode", true);

	}

	// frameworkupload

	@Test(priority = 2, testName = "Q", enabled = true)
	public void FrameworkUploadcancel() throws InterruptedException, AWTException, IOException {
		Reporter.log("FrameworkUploadcancel", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);
		FileLib f = new FileLib();
		String framework = f.getExcelData("Upload", 2, 0);
		qf.ClickonUpload().click();
		// Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(qf.clickFramework()));
		qf.clickFramework().click();
		Thread.sleep(3000);
		// fWait.until(ExpectedConditions.visibilityOf(qf.FileSelect()));
		qf.FileSelect().sendKeys(
				"C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\FrameworkUploadSample.xlsx");

		// fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework()));
		qf.dropdownFramework().click();
		Thread.sleep(2000);
		qf.selectFramework(framework).click();
		Thread.sleep(2000);
		// fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework()));
		qf.dropdownFramework().click();
		// Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(qf.uploadFrameworkcancel()));
		fWait.until(ExpectedConditions.elementToBeClickable(qf.uploadFrameworkcancel()));
		Thread.sleep(2000);
		qf.uploadFrameworkcancel().click();
//				FileLib f=new FileLib();
		String Nofile = f.getExcelData("AssertMessage", 1, 3);
		String nofile = qf.nofileChoosenerrormessage().getText();
		Assert.assertEquals(nofile, Nofile);
		Reporter.log("assertTrue", true);
	}

	@Test(priority = 3, testName = "Q", enabled = true)
	public void invalidfile() throws InterruptedException, AWTException, IOException {
	    Reporter.log("Invalid File Upload Test", true);
	    Logger logger = LoggerFactory.getLogger(getClass());

	    fWait = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(40))
	        .pollingEvery(Duration.ofMillis(1000))
	        .ignoring(NoSuchElementException.class, TimeoutException.class);

	    FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);
	    FileLib f = new FileLib();

	    String framework = f.getExcelData("Upload", 2, 0);
	    String file = f.getExcelData("Upload", 7, 1);
	    String status = f.getExcelData("Upload", 2, 2);
	    String successMessageExpected = f.getExcelData("AssertMessage", 4, 3);
	    String failureMessageExpected = f.getExcelData("AssertMessage", 6, 3);
	    String filePath = "C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx";

	    // Step 1: Open Upload Dialog
	    qf.ClickonUpload().click();
	    logger.info("Upload tab clicked");

	    fWait.until(ExpectedConditions.visibilityOf(qf.clickFramework())).click();

	    // Step 2: Upload File
	    qf.FileSelect().sendKeys(filePath);
	    logger.info("File selected");

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.dropdownFramework())).click();
	    Thread.sleep(4000);
	    qf.selectFramework(framework).click();
	    logger.info("Framework checkbox selected");

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.dropdownFramework())).click();  // Close dropdown
	    logger.info("Dropdown clicked & closed");

	    qf.clickFramework().click(); // Re-confirm framework
	    logger.info("Framework clicked again");
	    Thread.sleep(3000);
	    fWait.until(ExpectedConditions.elementToBeClickable(qf.uploadFramework())).click();
	    
	    logger.info("Upload button clicked");

	    // Step 3: Wait for success or failure message
	    try {
	        WebElement successMsg = fWait.until(ExpectedConditions.visibilityOf(qf.successMessage()));
	        String actualSuccessMessage = successMsg.getText();
	        Assert.assertEquals(actualSuccessMessage, successMessageExpected, "Success message did not match");
	        logger.info("✅ Success message validated: " + actualSuccessMessage);
	    } catch (TimeoutException e) {
	        logger.warn("❌ Success message not found. Checking failure message...");

	        WebElement failureMsg = fWait.until(ExpectedConditions.visibilityOf(qf.failureMessage()));
	        String actualFailureMessage = failureMsg.getText();
	        Assert.assertEquals(actualFailureMessage, failureMessageExpected, "Failure message did not match");
	        logger.info("✅ Failure message validated: " + actualFailureMessage);
	    }

	    qf.Clickok().click();
	    logger.info("Clicked on Ok Button");

	    // Step 4: Navigate to Framework Questions
	    fWait.until(ExpectedConditions.elementToBeClickable(qf.clickFrameworkquestion())).click();
	    logger.info("Clicked on Framework question tab");

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.clickFramework())).click();
	    logger.info("Clicked back on framework tab");

	    // Step 5: Verify uploaded file status
	    WebElement uploadStatus = fWait.until(ExpectedConditions.visibilityOf(qf.frameworkUploadpass(file, status)));
	    String actualStatus = uploadStatus.getText();
	    Assert.assertEquals(actualStatus, failureMessageExpected, "Upload status did not match expected failure");
	    Reporter.log("assertTruePASS", true);

	    // Step 6: Download uploaded file (retry on stale element)
	    for (int i = 0; i < 2; i++) {
	        try {
	            WebElement downloadBtn = qf.Uploadedfiledownload(file);
	            fWait.until(ExpectedConditions.elementToBeClickable(downloadBtn)).click();
	            logger.info("Downloaded uploaded file");
	            break;
	        } catch (StaleElementReferenceException e) {
	            logger.warn("StaleElementReferenceException caught. Retrying...");
	        }
	    }
	}

	@Test(priority = 4, testName = "Q", enabled = true)
	public void FrameworkUpload() throws InterruptedException, AWTException, IOException {
	    Reporter.log("FrameworkUpload", true);

	    fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(40))
	            .pollingEvery(Duration.ofMillis(1000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);

	    FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);
	    FileLib f = new FileLib();
	    HomePage h = new HomePage(driver);
	    String framework = f.getExcelData("Upload", 2, 0);
	    String file = f.getExcelData("Upload", 8, 1);
	    String status = f.getExcelData("Upload", 1, 2);
	    String successMessageExpected = f.getExcelData("AssertMessage", 4, 3);
	    String passMessageExpected = f.getExcelData("AssertMessage", 5, 3);
	    h.setFrameworkMenu();
	    // Open upload section
	    Thread.sleep(2000);
	    qf.ClickonUpload().click();
	    //fWait.until(ExpectedConditions.visibilityOf(qf.clickFrameworkquestion())).click();
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(qf.clickFramework()));
	    qf.clickFramework().click();
	    Thread.sleep(2000);
	    // Upload file
	    qf.FileSelect().sendKeys(
	        "C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\FrameworkUploadSample.xlsx"
	    );

	    // Select framework from dropdown
	    fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework()));
	    qf.dropdownFramework().click();
	    fWait.until(ExpectedConditions.visibilityOf(qf.selectFramework(framework)));
	    Thread.sleep(3000);
	    qf.selectFramework(framework).click();

	    // Refresh dropdown click (optional)
	    fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework()));
	    qf.dropdownFramework().click();

	    // Upload button - safe scroll + fallback JS click
	    WebElement uploadBtn = qf.uploadFramework();
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", uploadBtn);
	    fWait.until(ExpectedConditions.elementToBeClickable(uploadBtn));
	    try {
	        uploadBtn.click();
	    } catch (ElementClickInterceptedException e) {
	        Reporter.log("Upload button intercepted. Performing JavaScript click.", true);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadBtn);
	    }

	    // Assert success message
	    fWait.until(ExpectedConditions.visibilityOf(qf.successMessage()));
	    String actualSuccessMessage = qf.successMessage().getText();
	    Assert.assertEquals(actualSuccessMessage, successMessageExpected);

	    // Click OK on upload success dialog
	    WebElement okBtn = qf.Clickok();
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", okBtn);
	    fWait.until(ExpectedConditions.elementToBeClickable(okBtn));
	    try {
	        okBtn.click();
	    } catch (ElementClickInterceptedException e) {
	        Reporter.log("OK button intercepted. Performing JavaScript click.", true);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);
	    }

	    // Navigate to Framework Question tab
	    fWait.until(ExpectedConditions.elementToBeClickable(qf.clickFrameworkquestion()));
	    qf.clickFrameworkquestion().click();

	    fWait.until(ExpectedConditions.visibilityOf(qf.clickFramework()));
	    qf.clickFramework().click();

	    Reporter.log("assertTrueADDED", true);

	    // Verify uploaded file status
	    fWait.until(ExpectedConditions.visibilityOf(qf.frameworkUploadpass(file, status)));
	    String actualPassMessage = qf.frameworkUploadpass(file, status).getText();
	    Assert.assertEquals(actualPassMessage, passMessageExpected);

	    Reporter.log("assertTruePASS", true);

	    // Download uploaded file - re-fetch and click safely
	    By downloadBtnLocator = By.xpath("//label[contains(text(),'" + file +
	        "')]/../following-sibling::td[3]//img[contains(@src,'download')]");
	    fWait.until(ExpectedConditions.elementToBeClickable(downloadBtnLocator));
	    WebElement downloadBtn = driver.findElement(downloadBtnLocator);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", downloadBtn);
	    try {
	        downloadBtn.click();
	    } catch (ElementClickInterceptedException e) {
	        Reporter.log("Download button intercepted. Performing JavaScript click.", true);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadBtn);
	    }
	}


	@Test(priority = 5, testName = "Q", enabled = false)
	public void FrameworkquestionUploadcancel() throws InterruptedException, AWTException, IOException {
	    Reporter.log("FrameworkquestionUploadcancel", true);

	    fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(40))
	            .pollingEvery(Duration.ofMillis(1000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);

	    FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);
	    FileLib f = new FileLib();
	    String framework = f.getExcelData("Upload", 2, 0);

	    qf.ClickonUpload().click();
	    Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(qf.clickFrameworkquestion())).click();
	    Thread.sleep(2000);

	    qf.FileSelect().sendKeys(
	            "C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\FrameworkUploadSample.xlsx");
	    logger.info("File selected");

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.dropdownFramework1())).click();
	    Thread.sleep(2000);

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.selectFramework(framework))).click();
	    logger.info("Framework selected");

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.dropdownFramework1())).click();
	    Thread.sleep(4000);

	    fWait.until(ExpectedConditions.elementToBeClickable(qf.uploadFrameworkcancel1())).click();
	    logger.info("Cancel button clicked");

	    String expectedMessage = f.getExcelData("AssertMessage", 1, 3);
	    String actualMessage = qf.nofileChoosenerrormessage().getText();

	    Assert.assertEquals(actualMessage.trim(), expectedMessage.trim(), "No file message mismatch");
	    Reporter.log("assertTrue", true);
	}

	@Test(priority = 6, testName = "Q", enabled = true)
	public void invalidfileFQ() throws InterruptedException, AWTException, IOException {
		Reporter.log("invalidfileFQ", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);

		FileLib f = new FileLib();
		String framework = f.getExcelData("Upload", 2, 0);
		String file = f.getExcelData("Upload", 7, 1);
		String status = f.getExcelData("Upload", 2, 2);
		HomePage h = new HomePage(driver);
		 h.setFrameworkMenu();
		 Thread.sleep(3000);
		qf.ClickonUpload().click();
		fWait.until(ExpectedConditions.visibilityOf(qf.clickFrameworkquestion()));
		qf.clickFrameworkquestion().click();
		Thread.sleep(3000);
		qf.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx");
		Thread.sleep(3000);
		fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework1()));
		qf.dropdownFramework1().click();
		Thread.sleep(2000);
		qf.selectFramework(framework).click();
		fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework1()));
		Thread.sleep(2000);
		qf.dropdownFramework1().click();
		//Thread.sleep(2000);
		//qf.clickFrameworkquestion().click();
		Thread.sleep(2000);
		// fWait.until(ExpectedConditions.visibilityOf(qf.uploadFramework()));
		// fWait.until(ExpectedConditions.elementToBeClickable(qf.uploadFramework()));
		qf.uploadFramework().click();
		// Thread.sleep(2000);

		String successmess = f.getExcelData("AssertMessage", 4, 3);
		String Successmess = qf.successMessage().getText();
		Assert.assertEquals(Successmess, successmess);
		qf.Clickok().click();
		fWait.until(ExpectedConditions.visibilityOf(qf.clickFramework()));
		fWait.until(ExpectedConditions.elementToBeClickable(qf.clickFramework()));
		Thread.sleep(2000);
		qf.clickFramework().click();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(qf.clickFrameworkquestion()));
		qf.clickFrameworkquestion().click();

		String fail = f.getExcelData("AssertMessage", 6, 3);
		String Ffail = qf.frameworkUploadpass(file, status).getText();
		Assert.assertEquals(Ffail, fail);
		Reporter.log("assertTruePASS", true);
		Thread.sleep(4000);
		qf.Uploadedfiledownload(file).click();
	}

	@Test(priority = 7, testName = "Q", enabled = true)
	public void FrameworkQuestionUpload() throws InterruptedException, AWTException, IOException {
		Reporter.log("FrameworkQuestionUpload", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);

		FileLib f = new FileLib();
		String framework = f.getExcelData("Upload", 2, 0);
		String file = f.getExcelData("Upload", 8, 1);
		String status = f.getExcelData("Upload", 1, 2);
		HomePage h = new HomePage(driver);
		 h.setFrameworkMenu();
		 Thread.sleep(3000);
		qf.ClickonUpload().click();
		fWait.until(ExpectedConditions.visibilityOf(qf.clickFrameworkquestion()));
		qf.clickFrameworkquestion().click();
		Thread.sleep(3000);
		qf.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\FrameworkUploadSample.xlsx");
		Thread.sleep(3000);
		fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework1()));
		Thread.sleep(3000);
		qf.dropdownFramework1().click();
		Thread.sleep(2000);
		qf.selectFramework(framework).click();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(qf.dropdownFramework1()));
		qf.dropdownFramework1().click();
		//qf.clickFrameworkquestion().click();
		Thread.sleep(2000);
		qf.uploadFramework().click();
//		FileLib f=new FileLib();
		String successmess = f.getExcelData("AssertMessage", 4, 3);
		String Successmess = qf.successMessage().getText();
		Assert.assertEquals(Successmess, successmess);
		Reporter.log("assertTrueADDED", true);
		fWait.until(ExpectedConditions.visibilityOf(qf.Clickok()));
		qf.Clickok().click();
		Thread.sleep(2000);
		qf.clickFramework().click();
		fWait.until(ExpectedConditions.visibilityOf(qf.clickFrameworkquestion()));
		fWait.until(ExpectedConditions.elementToBeClickable(qf.clickFrameworkquestion()));
		Thread.sleep(2000);
		qf.clickFrameworkquestion().click();

		String pass = f.getExcelData("AssertMessage", 5, 3);
		String FPass = qf.frameworkUploadpass(file, status).getText();
		Assert.assertEquals(FPass, pass);
		Reporter.log("assertTruePASS", true);
		Thread.sleep(2000);
		qf.Uploadedfiledownload(file).click();

	}

	@Test(priority = 8, testName = "Q", enabled = true)
	public void SubmitFramework() throws InterruptedException, EncryptedDocumentException, IOException {

		Reporter.log("SubmitFramework", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		HomePage h = new HomePage(driver);
		FrameworksPage fp = new FrameworksPage(driver);
		UsersListPage u = new UsersListPage(driver);
		FileLib f = new FileLib();
		String Frameworkname = f.getExcelData("AddFramework", 4, 3);
		h.setFrameworkMenu();
		// fWait.until(ExpectedConditions.visibilityOf(u.searchUser()));
		Thread.sleep(3000);
		fp.FrameworkSearch().sendKeys(Frameworkname);
		// Thread.sleep(4000);
		boolean elementFound = false;
		while (!elementFound) {
			try {

				fWait.until(ExpectedConditions.elementToBeClickable(fp.addNodedata(Frameworkname))).click();
				// fp.addNodedata(Frameworkname).click();// click on the element if found
				elementFound = true; // set the flag to true if element is found

			} catch (NoSuchElementException e) {
				fWait.until(ExpectedConditions.elementToBeClickable(fp.ClickNext())).click();
				// fp.ClickNext().click();
			}
		}

		// Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(fp.NodeDatasubmit())).click();
		// fp.NodeDatasubmit().click();
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(fp.nodeDataclickback())).click();
		// fp.nodeDataclickback().click();
		 Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(fp.FrameworkSearch()));
		fp.FrameworkSearch().sendKeys(Frameworkname);

		String StatuscodeSubmitted = fWait.until(ExpectedConditions.visibilityOf(fp.statusCodeSubmitted(Frameworkname)))
				.getText();
		// Thread.sleep(2000);
		// String StatuscodeSubmitted = fp.statusCodeSubmitted(Frameworkname).getText();
		Assert.assertEquals(StatuscodeSubmitted, "Submitted");
		Reporter.log("assertTrueSumittedstatuscode", true);
	}

	@Test(priority = 9, testName = "Q", enabled = true)
	public void approveFramework() throws InterruptedException, EncryptedDocumentException, IOException {

		Reporter.log("approveFramework", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		HomePage h = new HomePage(driver);

		FrameworksPage fp = new FrameworksPage(driver);
		UsersListPage u = new UsersListPage(driver);
		FileLib f = new FileLib();
		String Frameworkname = f.getExcelData("AddFramework", 4, 3);
		h.setFrameworkMenu();
		Thread.sleep(2000);
		fp.FrameworkSearch().clear();
		fWait.until(ExpectedConditions.visibilityOf(fp.FrameworkSearch()));
		fp.FrameworkSearch().sendKeys(Frameworkname);
		fWait.until(ExpectedConditions.visibilityOf(fp.approveNotification(Frameworkname)));
		fp.approveNotification(Frameworkname).click();

		Thread.sleep(4000);
		// fWait.until(ExpectedConditions.visibilityOf(fp.NodeDataApprove()));
		fp.NodeDataApprove().click();
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.visibilityOf(fp.approveComment()));
		fp.approveComment().sendKeys("approve");
		fWait.until(ExpectedConditions.visibilityOf(fp.approveSend()));
		fp.approveSend().click();
		Thread.sleep(4000);
		fp.notificationClickback().click();
		Thread.sleep(3000);
		fp.FrameworkSearch().sendKeys(Frameworkname);

		String StatuscodeApproved = fp.statusCodeApproved(Frameworkname).getText();
		Assert.assertEquals(StatuscodeApproved, "Approved");
		Reporter.log("assertTrueApprovestatuscode", true);

	}

}
