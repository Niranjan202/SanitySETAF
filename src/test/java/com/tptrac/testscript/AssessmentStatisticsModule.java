package com.tptrac.testscript;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.AssessmentStatisticsPage;


@Listeners(com.tptrac.generic.ExtentListener.class)
public class AssessmentStatisticsModule extends BaseClass1
{
	AssessmentStatisticsPage dr1;	
	
	@Test(priority=1,testName="L", enabled=true)
	public void NavigateToAssessmentStatistics() throws InterruptedException
	{
		//the disadvantage - on this first test case- object is instantiated 
		dr1= new AssessmentStatisticsPage(driver);
		Thread.sleep(3000);
		dr1.ClickAssessment().click();
		Thread.sleep(3000);
		dr1.ClickAssessmentStatistics().click();
		Thread.sleep(5000);
		dr1.DownloadReport().click();
	}

	@Test(priority=2,testName="L",enabled=true)
	public void FilterAssessment() throws InterruptedException, EncryptedDocumentException, IOException
	{
		FileLib f=new FileLib();
		String onboardingStatus = f.getExcelData("AssessmentStatistics",1, 0);
		logger.info("Get onboarding status data");
		String vendorCategory = f.getExcelData("AssessmentStatistics",2, 1);
		logger.info("Get vendor category data");
		String vendorName = f.getExcelData("AssessmentStatistics",2, 2);
		logger.info("Get vendor data");
		String assessment = f.getExcelData("AssessmentStatistics",1, 3);
		logger.info("Get assessment data");
		String invalidData = f.getExcelData("AssessmentStatistics",1, 4);
		logger.info("Get invalid data");
		String validData = f.getExcelData("AssessmentStatistics",2, 2);
		logger.info("Get valid data");
		
		Thread.sleep(3000);
		dr1.ClickAssessment().click();
		Thread.sleep(3000);
		dr1.ClickAssessmentStatistics().click();
		
		
		//Selecting on boarding status
		dr1.OnBoradingStatusDropDown().click();
		dr1.OnBoradingDropdownSearch().sendKeys(onboardingStatus);
		Actions action = new Actions(driver);
		action.moveToElement(dr1.SelectOnboardingStatus(onboardingStatus)).click().build().perform();
		
		//selecting vendor category
		Thread.sleep(2000);
		dr1.VendorCategoryDropDown().click();
		dr1.VendorcategorySearch().sendKeys(vendorCategory);
		action.moveToElement(dr1.SelectVendorCategory(vendorCategory)).click().build().perform();   
		
		//selecting Vendor
		Thread.sleep(2000);
		dr1.VendorDropDown().click();
		dr1.VendorSearch().sendKeys(vendorName);
		action.moveToElement(dr1.SelectVendor(vendorName)).click().build().perform();
		
		//selecting Assessment
		Thread.sleep(2000);
		dr1.AssessmentDropDown().click();
		dr1.AssessmentSearch().sendKeys(assessment);
		action.moveToElement(dr1.SelectAssessment(assessment)).click().build().perform();
		
		Assert.assertTrue(dr1.verifyAssessment(vendorName, assessment).isDisplayed());
		
		dr1.DownloadReport().click();
		Thread.sleep(2000);
		dr1.clickSearchfield().sendKeys(validData);
		Thread.sleep(2000);
		if(dr1.verify_Data().size()>0) {
			Assert.assertTrue(dr1.verify_VDataText(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		Thread.sleep(2000);
		dr1.clickSearchfield().clear();
		Thread.sleep(2000);
		dr1.clickSearchfield().sendKeys(invalidData);
		Thread.sleep(2000);
		if(dr1.verify_Data().size()>0) {
			Assert.fail();
		}else {
		Assert.assertTrue(dr1.verify_NoDataText().isDisplayed());
		}
	}
	
	
	
}

