package com.tptrac.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.AssessmentStatisticsPage;
import com.tptrac.pom.ObservationTrackerPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class ObservationTrackerModule extends BaseClass1
{
	
	ObservationTrackerPage OT1;
	
	@Test(priority=1,testName="M", enabled=true)
	public void Navigate2ObservationTracker() throws InterruptedException
	{
		//the disadvantage - on this first test case- object is instantiated 
		OT1= new ObservationTrackerPage(driver);
		Thread.sleep(3000);
		OT1.ClickAssessment().click();
		Thread.sleep(3000);
		OT1.ObservationTracker().click();
		Thread.sleep(3000);
		OT1.DownloadReport().click();
	}
	
	@Test(priority=2,testName="M",enabled=true)
	public void FilterAssessment() throws InterruptedException, EncryptedDocumentException, IOException
	{
		FileLib f=new FileLib();
		String onboardingStatus = f.getExcelData("ObservationTracker",1, 0);
		logger.info("Get onboarding status data");
		String vendorCategory = f.getExcelData("ObservationTracker",1, 1);
		logger.info("Get vendor category data");
		String vendorName = f.getExcelData("ObservationTracker",1, 2);
		logger.info("Get vendor data");
		String assessmentStatus = f.getExcelData("ObservationTracker",5, 3);
		logger.info("Get assessment status data");
		String assessment = f.getExcelData("ObservationTracker",1, 4);
		logger.info("Get assessment data");
		String invalidData = f.getExcelData("ObservationTracker",1, 5);
		logger.info("Get invalid data");
		String frameworkassessment = f.getExcelData("ObservationTracker",2, 4);
		logger.info("Get frameworkassessment data");
		String risk1 = f.getExcelData("ObservationTracker",1, 6);
		logger.info("Get risk data");
		String risk2 = f.getExcelData("ObservationTracker",2, 6);
		logger.info("Get risk data");
		String validData = f.getExcelData("ObservationTracker",1, 2);
		logger.info("Get valid data");
	
		OT1.ClickAssessment().click();
		Thread.sleep(3000);
		OT1.ObservationTracker().click();
		Thread.sleep(3000);
		
		//Selecting on boarding status
		OT1.OnBoradingStatusDropDown().click();
		OT1.OnBoradingDropdownSearch().sendKeys(onboardingStatus);
		Actions action = new Actions(driver);
		action.moveToElement(OT1.SelectOnboardingStatus()).click().build().perform();
		
		//selecting vendor category
		Thread.sleep(2000);
		OT1.VendorCategoryDropDown().click();
		OT1.VendorcategorySearch().sendKeys(vendorCategory);
		action.moveToElement(OT1.SelectVendorCategory()).click().build().perform();   
		
		//selecting Vendor 
		Thread.sleep(2000);
		OT1.VendorDropDown().click();
		OT1.VendorSearch().sendKeys(vendorName);
		action.moveToElement(OT1.SelectVendor()).click().build().perform();
		
		//selecting AssessmentStatus
		Thread.sleep(2000);
		OT1.AssessmentStatusDropDown().click();
		OT1.AssessmentStatusSearch().sendKeys(assessmentStatus);
		action.moveToElement(OT1.SelectAssessmentStatus()).click().build().perform();
		
		//selecting Assessment
		Thread.sleep(2000);
		OT1.AssessmentDropDown().click();
		OT1.AssessmentSearch().sendKeys(assessment);
		action.moveToElement(OT1.SelectAssessment()).click().build().perform();
		
		if(OT1.verify_Data().size()>0) {
			Assert.assertTrue(OT1.verifyAssessmentData(assessment,assessmentStatus,vendorName).isDisplayed());
		}else {
			Assert.fail();
		}
		
		OT1.DownloadReport().click();
		Thread.sleep(2000);
		OT1.clickResetBtn().click();
		Thread.sleep(2000);
		
		action.moveToElement(OT1.FilterCritical()).click().build().perform();
		Thread.sleep(2000);
		if(OT1.verify_Data().size()>0) {
			Assert.assertTrue(OT1.verifyAssessmentDatawithRisk(assessment,assessmentStatus,vendorName,risk1).isDisplayed());
		}else {
			Assert.fail();
		}
		OT1.clickResetBtn().click();
		Thread.sleep(2000);
		
		action.moveToElement(OT1.FilterHigh()).click().build().perform();
		Thread.sleep(2000);
		if(OT1.verify_Data().size()>0) {
			Assert.assertTrue(OT1.verifyAssessmentDatawithRisk(frameworkassessment,assessmentStatus,vendorName,risk2).isDisplayed());
		}else {
			Assert.fail();
		}
		OT1.clickResetBtn().click();
		Thread.sleep(2000);
		
		action.moveToElement(OT1.FilterMedium()).click().build().perform();
		Thread.sleep(2000);
		if(OT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(OT1.verify_NoDataText().isDisplayed());
		}
		OT1.clickResetBtn().click();
		Thread.sleep(2000);
		
		OT1.clickSearchfield().sendKeys(validData);
		Thread.sleep(2000);
		if(OT1.verify_Data().size()>0) {
			Assert.assertTrue(OT1.verify_VDataText(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		Thread.sleep(2000);
		OT1.clickSearchfield().clear();
		Thread.sleep(2000);
		OT1.clickSearchfield().sendKeys(invalidData);
		Thread.sleep(2000);
		if(OT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
		Assert.assertTrue(OT1.verify_NoDataText().isDisplayed());
		}
	}
	
}