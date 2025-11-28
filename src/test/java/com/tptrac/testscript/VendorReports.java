package com.tptrac.testscript;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.VendorObservationTrackerPage;
import com.tptrac.pom.VendorreportsPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class VendorReports extends BaseClass{
	VendorreportsPage VR1;
	
	@Test(priority=1,testName="P")
	public void Navigate2VendorReports() throws InterruptedException, IOException
	{
		VR1= new VendorreportsPage(driver);
		Thread.sleep(2000);
		
		FileLib f=new FileLib();
		String year = f.getExcelData("VendorReport",1,0);
		String quarter = f.getExcelData("VendorReport",1,1);
		String assessmentStatus = f.getExcelData("VendorReport",1,2);
		String frameworkName = f.getExcelData("VendorReport",1,3);
		String templateName = f.getExcelData("VendorReport",1,4);
		String vendorName = f.getExcelData("VendorReport",1,5);
		String invalidData = f.getExcelData("VendorReport",1,6);
		String invalidData1 = f.getExcelData("VendorReport",2,6);
		String validData = f.getExcelData("VendorReport",1,3);
		String validData1 = f.getExcelData("VendorReport",1,4);
		Thread.sleep(4000);
		VR1.clickVReports().click();
		Thread.sleep(2000);
		VR1.Clickyear().click();
		VR1.selectYear(year).click();
		VR1.Clickyear().click();
	    Thread.sleep(2000);
	    VR1.clickquarter().click();
	    VR1.selectquarter(quarter).click();
	    VR1.clickquarter().click();
	    Thread.sleep(2000);
	    
	    VR1.clickassessmentstatus().click();
	    VR1.selectassessmentstatus(assessmentStatus).click();
	    VR1.clickassessmentstatus().click();
	    Thread.sleep(2000);
	    
	    VR1.selectFrmework(frameworkName).click();
	    Thread.sleep(2000);
	    //Assert.assertTrue(VR1.verifyVendor(vendorName).isDisplayed());
	    
	    VR1.exporttoexcel().click();
	    Thread.sleep(4000);
	    
	    VR1.exporttopdf().click();
	    Thread.sleep(2000);
//	    String actualText = VR1.pfderrormessage().getText(); 
//		String pfdexcel = f.getExcelData("AssertMessage",19, 3);
//		Assert.assertTrue(actualText.contains("Export to PDF supports only upto 8 columns"));
//	    Thread.sleep(4000);
//	    VR1.clickOK().click();
//	    
//	    Thread.sleep(2000);
		
	    VR1.clickSearchfield().sendKeys(validData);
		Thread.sleep(2000);
		if(VR1.verify_FData().size()>0) {
			Assert.assertTrue(VR1.verifyFrmeworkData(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		Thread.sleep(2000);
		VR1.clickSearchfield().clear();
		Thread.sleep(2000);
		VR1.clickSearchfield().sendKeys(invalidData);
		Thread.sleep(2000);
		if(VR1.verify_FData().size()>0) {
			Assert.fail();
		}else {
		Assert.assertTrue(VR1.verify_NoDataText().isDisplayed());
		}	
		VR1.clickSearchfield().clear();
		Thread.sleep(2000);
	    
//	    int j1=0;
//	    List<WebElement> allLinks = driver.findElements(By.xpath("//img[@class='d-inline-block align-top']"));
// 
//	    Iterator<WebElement> itr = allLinks.iterator();
//	    Thread.sleep(2000);
//	    while(itr.hasNext()) {
//	    	Thread.sleep(4000);
//	    	j1++;
//	    	Thread.sleep(4000);
//	        itr.next().click();
//	        Thread.sleep(4000);
//	        if(j1==9) {
//	        	break;
//	        }
//	    }
//	    Thread.sleep(4000);
//	    VR1.exporttopdf().click();
//	    Thread.sleep(2000);
	    
	    VR1.clickFReset().click();
	    Thread.sleep(2000);
	    VR1.selectTemplate(templateName).click();
	    Thread.sleep(4000);
	    
	    Assert.assertTrue(VR1.verifyVendorAndtemplate(vendorName,templateName).isDisplayed());
	    
	    VR1.exporttoexcel().click();
	    Thread.sleep(4000);
	    
	    VR1.exporttopdf().click();
	    Thread.sleep(2000);
//		Assert.assertTrue(actualText.contains("Export to PDF supports only upto 8 columns"));
//	    Thread.sleep(4000);
//	    VR1.clickOK().click();
	    
	    VR1.clickQSearchfield().sendKeys(validData1);
		Thread.sleep(2000);
		if(VR1.verify_QData().size()>0) {
			Assert.assertTrue(VR1.verifyTemplateData(validData1).isDisplayed());
		}else {
		Assert.fail();
		}
	    Thread.sleep(2000);
	    VR1.clickQSearchfield().clear();
	    Thread.sleep(2000);
	    VR1.clickQSearchfield().sendKeys(invalidData1);
		Thread.sleep(2000);
		if(VR1.verify_QData().size()>0) {
			Assert.fail();
		}else {
		Assert.assertTrue(VR1.verify_NoDataText().isDisplayed());
		}
		
		VR1.clickQSearchfield().clear();
		Thread.sleep(2000);
//	    int k1=0;
//	    List<WebElement> allLinks1 = driver.findElements(By.xpath("//img[@class='d-inline-block align-top']"));
// 
//	    Iterator<WebElement> itr1 = allLinks1.iterator();
//	    while(itr1.hasNext()) {
//	    	k1++;
//	        itr1.next().click();
//	        Thread.sleep(4000);
//	        if(k1==3) {
//	        	break;
//	        }
//	    }
//	    Thread.sleep(4000);
//	    VR1.exporttopdf().click();
	}
}
