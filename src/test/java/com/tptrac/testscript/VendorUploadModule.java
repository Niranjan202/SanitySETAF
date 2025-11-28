package com.tptrac.testscript;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.FrameworkandQuestionsUploadPage;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.VendorCategoryManagementPage;
import com.tptrac.pom.VendorUploadPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class VendorUploadModule extends BaseClass1 {

	public static FluentWait<WebDriver> fWait;

	@Test(priority = 1, testName = "R", enabled = true)
	public void AddVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {

		Reporter.log("AddVendorCategoryforUploadthroughExcel", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		FileLib f = new FileLib();
		String vendorcategoryname = f.getExcelData("AddVendorCategory", 2, 3);
		String vendorcategorycode = f.getExcelData("AddVendorCategory", 2, 4);
		HomePage h = new HomePage(driver);
		VendorCategoryManagementPage vc = new VendorCategoryManagementPage(driver);
		h.setVendorMenu();
		logger.info("Click on vendor menu");
		fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
		vc.clickvcmanagement().click();
		logger.info("Click on vendor category management ");
		fWait.until(ExpectedConditions.visibilityOf(vc.AddNewvcManagement()));
		vc.AddNewvcManagement().click();
		logger.info("Click on add new vendor category management ");
		fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogryname()));
		vc.addvendorcateogryname().sendKeys(vendorcategoryname);
		logger.info("entered vendor category name ");
		fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogrycode()));
		vc.addvendorcateogrycode().sendKeys(vendorcategorycode);
		logger.info("entered vendor category code ");
		vc.ClickOnAdd().click();
		logger.info("Added a new vendor category management successfully ");
		String actualText = vc.GetActualUserCreated(vendorcategoryname).getText(); // added parameters
		Assert.assertEquals(actualText, vendorcategoryname);

	}

	@Test(priority = 2, testName = "R", enabled = false)
	public void vendorUploadCancel() throws InterruptedException, AWTException, IOException {
		Reporter.log("VendorUploadCancel", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		HomePage h = new HomePage(driver);
		VendorUploadPage a = new VendorUploadPage(driver);
		//a.ClickonUpload().click();
		// logger.info("Select upload menu");
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(a.ClickonUpload())).click();
		fWait.until(ExpectedConditions.visibilityOf(a.ClickVendor()));
		a.ClickVendor().click();
		Thread.sleep(3000);
		a.FileSelect().sendKeys(
				"C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\VendorUploadSample.xlsx");

		FileLib f = new FileLib();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(a.uploadFilecancel()));
		a.uploadFilecancel().click();

		String Nofile = f.getExcelData("AssertMessage", 1, 3);
		String nofile = a.nofileChoosenerrormessage().getText().trim();
		System.out.println(Nofile);
		System.out.println(nofile);
		Assert.assertEquals(nofile, Nofile);
		Reporter.log("assertTrue", true);
		fWait.until(ExpectedConditions.visibilityOf(a.SelectNo()));
		a.SelectNo().click();
//			a.selectvc();
		Thread.sleep(3000);
		a.clickVCdropdown().click();

		String vcategory = f.getExcelData("Upload", 2, 3);

		a.selectVendorCategory(vcategory).click();
		Thread.sleep(2000);
		a.clickVCdropdown().click();
		Thread.sleep(3000);
		a.FileSelect().sendKeys(
				"C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\VendorUploadSample.xlsx");

		Thread.sleep(3000);
		a.uploadFilecancel().click();
		// Thread.sleep(2000);
		logger.info("Clicked on cancel");
		String Nofile1 = f.getExcelData("AssertMessage", 1, 3);
		String nofile1 = a.nofileChoosenerrormessage().getText().trim();
		Assert.assertEquals(nofile1, Nofile1);
		Reporter.log("assertTrue", true);

	}

	@Test(priority = 3, testName = "R", enabled = true)
	public void invalidfilevendor() throws InterruptedException, AWTException, IOException {
		Reporter.log("InvalidVendorUploadFile", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		HomePage h = new HomePage(driver);
		VendorUploadPage a = new VendorUploadPage(driver);
		 h.setFrameworkMenu();
		 Thread.sleep(3000);
		a.ClickonUpload().click();
		// logger.info("Select upload menu");
		fWait.until(ExpectedConditions.visibilityOf(a.ClickVendor()));
		a.ClickVendor().click();
		Thread.sleep(3000);

		a.FileSelect().sendKeys(
				"C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx");
		// logger.info("Select vendor option");

		FileLib f = new FileLib();

		a.uploadDone().click();

//			
		String invalidfile = f.getExcelData("AssertMessage", 27, 3);
		String Invalidfile = a.validateinvalidtext().getText().trim();
		Assert.assertEquals(Invalidfile, invalidfile);
		Reporter.log("assertTrue", true);
		a.alertOk().click();
		/*
		 * fWait.until(ExpectedConditions.visibilityOf(a.uploadFilecancel()));
		 * a.uploadFilecancel().click();
		 * 
		 * fWait.until(ExpectedConditions.visibilityOf(a.SelectNo()));
		 * a.SelectNo().click();
		 * 
		 * fWait.until(ExpectedConditions.visibilityOf(a.clickVCdropdown()));
		 * a.clickVCdropdown().click();
		 * 
		 * String vcategory = f.getExcelData("Upload", 2, 3);
		 * fWait.until(ExpectedConditions.visibilityOf(a.selectVendorCategory(vcategory)
		 * )); a.selectVendorCategory(vcategory).click();
		 * 
		 * fWait.until(ExpectedConditions.visibilityOf(a.clickVCdropdown()));
		 * a.clickVCdropdown().click(); Thread.sleep(3000); a.FileSelect().sendKeys(
		 * "C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx"
		 * );
		 * 
		 * a.uploadDone().click(); String invalidfile1 = f.getExcelData("AssertMessage",
		 * 27, 3); String Invalidfile1 = a.validateinvalidtext().getText().trim();
		 * Assert.assertEquals(Invalidfile1, invalidfile1); Reporter.log("assertTrue",
		 * true); a.alertOk().click();
		 */

	}

	@Test(priority = 4, testName = "R", enabled = true)
	public void testVendorUpload() throws InterruptedException, AWTException, IOException {
		Reporter.log("VendorUpload", true);
		fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class, TimeoutException.class);

		HomePage h = new HomePage(driver);
		VendorUploadPage a = new VendorUploadPage(driver);
		 h.setFrameworkMenu();
		Thread.sleep(4000);
		a.ClickonUpload().click();
		fWait.until(ExpectedConditions.visibilityOf(a.ClickVendor()));
		Thread.sleep(3000);
		a.ClickVendor().click();
		// logger.info("Select vendor option");
		Thread.sleep(4000);
		a.FileSelect().sendKeys(
				"C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\VendorUploadSample.xlsx");

		FileLib f = new FileLib();

		fWait.until(ExpectedConditions.visibilityOf(a.uploadDone()));
		a.uploadDone().click();
		Thread.sleep(3000);
		// fWait.until(ExpectedConditions.visibilityOf(a.alertOk()));
		a.alertOk().click();

//			
		Reporter.log("assertTrueADDED", true);
		String file = f.getExcelData("Upload", 9, 1);
		String status = f.getExcelData("Upload", 1, 2);
		String pass = f.getExcelData("AssertMessage", 5, 3);
		String FPass = a.frameworkUploadpass(file, status).getText();
		Assert.assertEquals(FPass, pass);
		Reporter.log("assertTruePASS", true);
		Thread.sleep(3000);
		a.Uploadedfiledownload(file).click();
		// Thread.sleep(2000);
		/*fWait.until(ExpectedConditions.visibilityOf(a.SelectNo()));
		a.SelectNo().click();*/
		WebElement selectNoRadio = fWait.until(ExpectedConditions.elementToBeClickable(a.SelectNo()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectNoRadio);
//			a.selectvc();
		fWait.until(ExpectedConditions.visibilityOf(a.clickVCdropdown()));
		Thread.sleep(2000);
		a.clickVCdropdown().click();

		String vcategory = f.getExcelData("Upload", 2, 3);
		Thread.sleep(2000);
		a.selectVendorCategory(vcategory).click();
		Thread.sleep(2000);
		a.clickVCdropdown().click();
		Thread.sleep(2000);
		a.FileSelect().sendKeys(
				"C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\VendorUploadSample.xlsx");

		// fWait.until(ExpectedConditions.visibilityOf(a.uploadDone()));
		Thread.sleep(2000);
		a.uploadDone().click();
		logger.info("Upload a file successfully");
		// fWait.until(ExpectedConditions.visibilityOf(a.alertOk()));
		Thread.sleep(3000);
		a.alertOk().click();
		logger.info("Clicked ok on alert popup");

//			
		Reporter.log("assertTrueADDED", true);
		String file1 = f.getExcelData("Upload", 9, 1);
		String status1 = f.getExcelData("Upload", 1, 2);
		String pass1 = f.getExcelData("AssertMessage", 5, 3);
		String FPass1 = a.frameworkUploadpass(file1, status1).getText();
		Assert.assertEquals(FPass, pass);
		Reporter.log("assertTruePASS", true);
		Thread.sleep(3000);
		a.Uploadedfiledownload(file1).click();

	}
}