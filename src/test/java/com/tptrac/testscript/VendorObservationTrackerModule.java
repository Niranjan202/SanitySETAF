package com.tptrac.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tptrac.generic.BaseClass;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.VendorObservationTrackerPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class VendorObservationTrackerModule  extends BaseClass

{

	VendorObservationTrackerPage VOT1;
	
	@Test(priority=1,testName="N",enabled=true)
	public void Navigate2VendorObservationTracker() throws InterruptedException, IOException
	{
		
		//the disadvantage - on this first test case- object is instantiated 
		//VOT1= new VendorObservationTrackerPage(driver);
		VOT1= new VendorObservationTrackerPage(driver);
		Thread.sleep(4000);
		VOT1.ClickVendorObservtaionTracker().click();
		Thread.sleep(3000);
		VOT1.DownloadReport().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=0,testName="N",enabled=true)
	public void FilterByHeader() throws InterruptedException,EncryptedDocumentException, IOException
	{
		FileLib f=new FileLib();
		String assessment = f.getExcelData("VendorObservation",1, 0);
		logger.info("Get assessment data");
		String obsTitle1 = f.getExcelData("VendorObservation",1, 1);
		logger.info("Get observation title data");
		String obsTitle2 = f.getExcelData("VendorObservation",2, 1);
		logger.info("Get observation title data");
		String risk1 = f.getExcelData("VendorObservation",1, 2);
		logger.info("Get risk data");
		String risk2 = f.getExcelData("VendorObservation",2, 2);
		logger.info("Get risk data");
		String invalidData = f.getExcelData("VendorObservation",1, 3);
		logger.info("Get invalid data");
		String frameworkassessment = f.getExcelData("VendorObservation",2, 0);
		logger.info("Get frameworkassessment data");
		String status = f.getExcelData("VendorObservation",1, 4);
		logger.info("Get status data");
		String validData = f.getExcelData("VendorObservation",1, 0);
		logger.info("Get valid data");
		
		VOT1= new VendorObservationTrackerPage(driver);
		Thread.sleep(4000);
		VOT1.ClickVendorObservtaionTracker().click();
		Thread.sleep(3000);
		VOT1.DownloadReport().click();
		
		Thread.sleep(4000);
		Actions action = new Actions(driver);
        action.moveToElement(VOT1.FilterCritical()).click().build().perform();
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.assertTrue(VOT1.verifyAssessmentData(assessment,obsTitle1,risk1).isDisplayed());
		}else {
			Assert.fail();
		}
		VOT1.clickResetBtn().click();
		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		
	
        action.moveToElement(VOT1.FilterHigh()).click().build().perform();
		
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.assertTrue(VOT1.verifyAssessmentData(frameworkassessment,obsTitle2,risk2).isDisplayed());
		}else {
			Assert.fail();
		}
		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		
        action.moveToElement(VOT1.FilterMedium()).click().build().perform();
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
//		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
	
        action.moveToElement(VOT1.FilterLow()).click().build().perform();
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		
        action.moveToElement(VOT1.FilterOverdue()).click().build().perform();
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
//		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		 action.moveToElement(VOT1.OpenFilter()).click().build().perform();
	
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
	
		action.moveToElement(VOT1.CloseFilter()).click().build().perform();
		if(VOT1.verify_Data().size()>0) {
			Assert.assertTrue(VOT1.verifyAssessmentDatawithStatus(frameworkassessment,obsTitle2,risk2,status).isDisplayed());
			Assert.assertTrue(VOT1.verifyAssessmentDatawithStatus(assessment,obsTitle1,risk1,status).isDisplayed());

		}else {
			Assert.fail();
		}
		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		 action.moveToElement(VOT1.ClaimClosedFilter()).click().build().perform();
		Thread.sleep(3000);
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
//		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.WaiverRequestFilter().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.WaiverRequestApproved().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.WaiverRequestRejected().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.ExtensionRequestRejected().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.ExtensionRequestApproved().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.ExtensionRequest().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
		//VOT1.DownloadReport().click();
		VOT1.ResetAll().click();
		
		Thread.sleep(3000);
		VOT1.ClaimClosedRejected().click();
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
//		VOT1.DownloadReport().click();
		VOT1.ResetAll().click();	
		
		//selecting Assessment
		VOT1.AssessmentDropDown().click();
		VOT1.AssessmentSearch().sendKeys(assessment);
		action.moveToElement(VOT1.SelectAssessment(assessment)).click().build().perform();
				
		Assert.assertTrue(VOT1.verifyAssessmentDatawithStatus(assessment,obsTitle1,risk1,status).isDisplayed());
				
		VOT1.DownloadReport().click();
		Thread.sleep(2000);
		VOT1.ResetAll().click();
		
		VOT1.clickSearchfield().sendKeys(validData);
		Thread.sleep(2000);
		if(VOT1.verify_Data().size()>0) {
			Assert.assertTrue(VOT1.verify_VDataText(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		Thread.sleep(2000);
		VOT1.clickSearchfield().clear();
		Thread.sleep(2000);
		VOT1.clickSearchfield().sendKeys(invalidData);
		Thread.sleep(2000);
		if(VOT1.verify_Data().size()>0) {
			Assert.fail();
		}else {
		Assert.assertTrue(VOT1.verify_NoDataText().isDisplayed());
		}
	}
	
}
