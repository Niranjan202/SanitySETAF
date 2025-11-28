package com.tptrac.testscript;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.Reportpage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class ReportModule extends BaseClass1 {

	@Test(priority=0,testName="O",enabled= true)
	public void GenaralReport() throws InterruptedException, IOException {
		Reporter.log("GenaralReport",true);
		logger.info("click on General Report");
		Reportpage rp=new Reportpage(driver);
		
		FileLib f=new FileLib();
		String vendorCategory = f.getExcelData("General Report",1,0);
		String vendorStatus = f.getExcelData("General Report",2,2);
		String vendorName = f.getExcelData("General Report",1,3);
		String year = f.getExcelData("General Report",1,5);
		String quarter = f.getExcelData("General Report",1,6);
		String assessmentStatus = f.getExcelData("General Report",1,4);
		String frameworkName = f.getExcelData("General Report",1,7);
		String templateName = f.getExcelData("General Report",1,8);
		
		Thread.sleep(2000);
	    rp.clickonReport().click();
		Thread.sleep(4000);
	    rp.clickonGeneralReport().click();
	    Thread.sleep(4000);
	    rp.clickvendorcategory().click();
	    Thread.sleep(4000);
	    rp.selectvendorcategory(vendorCategory).click();
	    Thread.sleep(4000);
	    rp.clickvendorcategory().click();
	    Thread.sleep(4000);
	    
	    rp.selectpreonboard().click();
	    
	    rp.clickvendorstatus().click();
	    rp.selectvendorstatusdropdown(vendorStatus).click();
	    rp.clickvendorstatus().click(); 
	    Thread.sleep(4000);
	    
	    rp.clickvendor().click();
	    rp.selectvendordropdown(vendorName).click();
	    Thread.sleep(8000);
	    rp.clickvendor().click();
	    Thread.sleep(4000);
	    
	    rp.Clickyear().click();
	    rp.selectYear(year).click();
	    rp.Clickyear().click();
	    Thread.sleep(8000);
	    
	    rp.clickquarter().click();
	    rp.selectquarter(quarter).click();
	    rp.clickquarter().click();
	    Thread.sleep(4000);
	    
	    rp.clickassessmentstatus().click();
	    rp.selectassessmentstatus(assessmentStatus).click();
	    rp.clickassessmentstatus().click();
	    Thread.sleep(4000);
	    
	    rp.selectFrmework(frameworkName).click();
	    Thread.sleep(4000);
	    
	    Assert.assertTrue(rp.verifyVendor(vendorName).isDisplayed());
	    
	    rp.exporttoexcel().click();
	    Thread.sleep(4000);
	    
	    rp.exporttopdf().click();
	    Thread.sleep(2000);
//	    String actualText = rp.pfderrormessage().getText(); 
//		String pfdexcel = f.getExcelData("AssertMessage",19, 3);
//		Assert.assertTrue(actualText.contains("Export to PDF supports only upto 8 columns"));
//	    Thread.sleep(4000);
//	    rp.clickOK().click();
	    
	    //rp.clickpdfmenu().click();
	    //rp.clickOK().click();
	    
	    //rp.clickpdfmenu().click();
//	    int j1=0;
//	    List<WebElement> allLinks = driver.findElements(By.xpath("//img[@class='d-inline-block align-top']"));
// 
//	    Iterator<WebElement> itr = allLinks.iterator();
//	    while(itr.hasNext()) {
//	    	j1++;
//	        itr.next().click();
//	        Thread.sleep(4000);
//	        if(j1==9) {
//	        	break;
//	        }
//	    }
//	    Thread.sleep(4000);
//	    rp.exporttopdf().click();
//	    Thread.sleep(2000);
	    
//	    String actualText = rp.pfderrormessage().getText(); 
//	    FileLib f=new FileLib();
//		String pfdexcel = f.getExcelData("AssertMessage",19, 3);
//	    Assert.assertEquals(actualText,pfdexcel);
//	    Thread.sleep(4000);
	    
	    
	    //rp.clickpdfmenu().click();
	    //rp.clickOK().click();
	    
	   // Thread.sleep(4000);
	    //rp.clickpdfmenu().click();
	    //Thread.sleep(4000);
	    rp.clickFReset().click();
	    Thread.sleep(2000);
	    rp.selectTemplate(templateName).click();
	    Thread.sleep(4000);
	    
	    Assert.assertTrue(rp.verifyVendorAndtemplate(vendorName,templateName).isDisplayed());
	    
	    rp.exporttoexcel().click();
	    Thread.sleep(4000);
	    
	    rp.exporttopdf().click();
	    Thread.sleep(2000);
//		Assert.assertTrue(actualText.contains("Export to PDF supports only upto 8 columns"));
//	    Thread.sleep(4000);
//	    rp.clickOK().click();
	   
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
//	    rp.exporttopdf().click();
//	    Thread.sleep(2000);    
	}
	
	@Test(priority=1,testName="O",enabled= true)
	public void GenaralReportFramework() throws InterruptedException, IOException {
		Reporter.log("GenaralReportFramework",true);
		logger.info("click on Framework Report");
		Reportpage rp=new Reportpage(driver);
		
		FileLib f=new FileLib();
		String year = f.getExcelData("General Report",1,5);
		String quarter = f.getExcelData("General Report",1,6);
		String frameworkName = f.getExcelData("General Report",1,7);
		String vendorCategory = f.getExcelData("General Report",1,0);
		String vendorStatus = f.getExcelData("General Report",1,9);
		String assessmentStatus = f.getExcelData("General Report",1,4);
		String vendorName = f.getExcelData("General Report",1,3);
		
		Thread.sleep(2000);
	    rp.clickonReport().click();
		Thread.sleep(4000);
	    rp.clickonGeneralReport().click();
	    Thread.sleep(4000);
		rp.clickonframework().click();
		rp.selecttheframework().click();
		rp.frameworkdropdown(frameworkName).click();
		rp.selecttheframework().click();
		
		rp.Fassessmentstatus().click();
		rp.Fassessmentstatusdropdown(assessmentStatus).click();
		rp.Fassessmentstatus().click();
		
		
		rp.Fvendorcategory().click();
		rp.Fvendorcategorydropdown(vendorCategory).click();
		rp.Fvendorcategory().click();
		
		rp.selectpreonboard().click();
		
		rp.Fvendorstatus().click();
		rp.Fvendorstatusdropdwn(vendorStatus).click();
		Thread.sleep(2000);
		rp.Fvendorstatus().click();
		
		    rp.Clickyear().click();
		    rp.selectYear(year).click();
		    rp.Clickyear().click();
		    Thread.sleep(8000);
		    
		    rp.clickquarter().click();
		    rp.selectquarter(quarter).click();
		    rp.clickquarter().click();
		    Thread.sleep(4000);
		 
		    rp.selectFvenoders(vendorName).click();
		    Thread.sleep(4000);
		    
		    Assert.assertTrue(rp.verifyVendor(vendorName).isDisplayed());
		    rp.exporttoexcel().click();
		    Thread.sleep(4000);
		    
		    rp.exporttopdf().click();
		    Thread.sleep(2000);
//		    rp.clickOK().click();
//		    
//		    Thread.sleep(4000);
//		    int j1=0;
//		    List<WebElement> allLinks = driver.findElements(By.xpath("//img[@class='d-inline-block align-top']"));
//	 
//		    Iterator<WebElement> itr = allLinks.iterator();
//		    while(itr.hasNext()) {
//		    	j1++;
//		        itr.next().click();
//		        Thread.sleep(4000);
//		        if(j1==9) {
//		        	break;
//		        }
//		    }
//		    Thread.sleep(4000);
//		    rp.exporttopdf().click();
//		    Thread.sleep(2000);
//		    rp.clickpdfmenu().click();
//		    Thread.sleep(4000);	    
	}
	
	
	@Test(priority=2,testName="O",enabled= true)
	public void GenaralReportquestionnire() throws InterruptedException, IOException {
		Reporter.log("GenaralReportquestionnire",true);
		logger.info("click on Questionnaire Report");
		Reportpage rp=new Reportpage(driver);
		
		FileLib f=new FileLib();
		String year = f.getExcelData("General Report",1,5);
		String quarter = f.getExcelData("General Report",1,6);
		String vendorCategory = f.getExcelData("General Report",1,0);
		String vendorStatus = f.getExcelData("General Report",1,9);
		String vendorName = f.getExcelData("General Report",1,3);
		String assessmentStatus = f.getExcelData("General Report",1,4);
		String template = f.getExcelData("General Report",1,8);
		
		Thread.sleep(2000);
	    rp.clickonReport().click();
		Thread.sleep(4000);
	    rp.clickonGeneralReport().click();
		Thread.sleep(4000);
	    
	    rp.selectquestionnaire().click();
		Thread.sleep(4000);
		
	    rp.questionnairetemplate().click();
	    rp.questionnairetemplatedropdown(template).click();
		Thread.sleep(4000);
	    rp.questionnairetemplate().click();
	    
	    Thread.sleep(4000);
	    rp.QAssessmentstatus().click();
	    
	    rp.QAssessmentstatusdropdown(assessmentStatus).click();
	    Thread.sleep(4000);
	    rp.QAssessmentstatus().click();
	    
	    Thread.sleep(4000);
	    rp.selectpreonboard().click();
	    
	    rp.Qvendorcategory().click();
	    rp.Qvendorcategorydropdwon(vendorCategory).click();
	    Thread.sleep(4000);
	    rp.Qvendorcategory().click();
	    
	    rp.Qvendorstatus().click();
	    rp.Qvendorstatusdropdown(vendorStatus).click();
	    Thread.sleep(4000);
	    rp.Qvendorstatus().click();
	    

	    rp.Clickyear().click();
	    rp.selectYear(year).click();
	    rp.Clickyear().click();
	    Thread.sleep(2000);
	    
	    rp.clickquarter().click();
	    rp.selectquarter(quarter).click();
	    rp.clickquarter().click();
	    Thread.sleep(2000);
	    Thread.sleep(2000);
	    rp.Qvendor(vendorName).click();
	    
	    Assert.assertTrue(rp.verifyVendorAndtemplate(vendorName,template).isDisplayed());
	     
	    rp.exporttoexcel().click();
	    Thread.sleep(4000);
	    
	    rp.exporttopdf().click();
	    Thread.sleep(2000);
//	    rp.clickOK().click();
//	    
//	    Thread.sleep(4000);
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
//	    rp.exporttopdf().click();
//	    Thread.sleep(2000);
////	    rp.clickpdfmenu().click();
////	    Thread.sleep(4000);	    
	    
	}
	
	@Test(priority=3,testName="O",enabled= true)
	public void customReport() throws InterruptedException, IOException {
		Reporter.log("customReport",true);
		logger.info("click on custom Report");
		Reportpage rp=new Reportpage(driver);
		
		FileLib f=new FileLib();
       	String reportername = f.getExcelData("Reportpage",1, 3);
    	String reportype = f.getExcelData("Reportpage",1, 4);
    	//String Reportversion = f.getExcelData("Reportpage",1, 5);	
    	//String Date = f.getExcelData("Reportpage",1, 6);
    	String Preparedby = f.getExcelData("Reportpage",1, 5);
    	String Reviwedby = f.getExcelData("Reportpage",1, 6);
    	String Reportdescription = f.getExcelData("Reportpage",1, 7);
		String version = f.getExcelData("Reportpage",1, 12);
		String vCategory = f.getExcelData("Reportpage",1, 13);
		String vStatus1 = f.getExcelData("Reportpage",1, 14);
		String vStatus2 = f.getExcelData("Reportpage",2, 14);
		String vStatus3 = f.getExcelData("Reportpage",3, 14);
		String vStatus4 = f.getExcelData("Reportpage",4, 14);
		String vStatus5 = f.getExcelData("Reportpage",5, 14);
		String vendor = f.getExcelData("Reportpage",1, 15);
		String aStatus = f.getExcelData("Reportpage",1, 18);
		String oStatus = f.getExcelData("Reportpage",1, 19);
		String risk = f.getExcelData("Reportpage",1, 20);
		String invalidData = f.getExcelData("Reportpage",1, 16);
		
		Thread.sleep(2000);
	    rp.clickonReport().click();
		Thread.sleep(3000);
		
		rp.clickocustomreport().click();
		Thread.sleep(4000);
		rp.reportername().sendKeys(reportername);
		Thread.sleep(4000);
		rp.reportType().sendKeys(reportype);
		//String rversion=Reportversion.substring(1, 2);
	//	rp.reportVersion().sendKeys(rversion);
//		rp.reportVersion().sendKeys("1.1");
//		rp.reportDate().sendKeys("27-7-2023");
		rp.reportVersion().sendKeys(version);
		rp.selectReportDate();
		Thread.sleep(2000);
		rp.preparedBy().sendKeys(Preparedby);
		rp.reviewedBy().sendKeys(Reviwedby);
		rp.reportDescription().sendKeys(Reportdescription);
		
		rp.clickcheckbox().click();
		
		Thread.sleep(2000);
		rp.savenext().click();
		Thread.sleep(2000);
		
		rp.Generatereport().click();
		
		rp.OK().click();
		
		
		//vendor
		
		rp.addvendordetails().click();
		
		rp.Cvendorcategory().click();
		rp.Cvendorcategorydropdown(vCategory).click();
		rp.Cvendorcategory().click();
		
		rp.selectpreonboard().click();
		
//		rp.Cbeingassessed().click();
		rp.selectVendorStatus(vStatus1).click();
		rp.selectVendorStatus(vStatus2).click();
		rp.selectVendorStatus(vStatus3).click();
		rp.selectVendorStatus(vStatus4).click();
		rp.selectVendorStatus(vStatus5).click();
		
		rp.Cvendor().click();
		rp.Cvendordropdown(vendor).click();
		rp.Cvendor().click();
		Thread.sleep(2000);
		rp.checkbox1().click();
		Thread.sleep(2000);
		rp.checkbox2().click();
		Thread.sleep(2000);
		//rp.vendorSearchfield().sendKeys(vendor);
		//Thread.sleep(2000);
		//if(rp.verify_vize().size()>0) {
			//Assert.assertTrue(rp.verifyVData(vendor).isDisplayed());
		//}else {
			//Assert.fail();
		//}
		//rp.vendorSearchfield().clear();
		//Thread.sleep(2000);
		//rp.vendorSearchfield().sendKeys(invalidData);
		//Thread.sleep(2000);
		//if(rp.verify_vize().size()>0) {
			//Assert.fail();
		//}else {
			//Assert.assertTrue(rp.verify_vnoDataText().isDisplayed());
		//}
		//Thread.sleep(2000);
		//rp.vendorSearchfield().clear();
		//Thread.sleep(2000);
		rp.savenext1().click();
		
		rp.addvendordetails().click();
		
		rp.Generatereport().click();
		String reportname1 = f.getExcelData("Reportpage",1, 10);	
    	String reportdescription1 = f.getExcelData("Reportpage",1, 11);
		rp.GReportname().sendKeys(reportname1);
		
		rp.Reportfiledescription().sendKeys(reportdescription1);
		
		rp.downloadword().click();
		
		rp.customGeneratereport().click();
		Assert.assertTrue(rp.verifySavedMsg().isDisplayed());
		//generate pdf file 
		Thread.sleep(2000);
		
	    rp.Generatereport().click();
	    Thread.sleep(4000);
	    
	    String reportname2 = f.getExcelData("Reportpage",2, 10);	
		rp.GReportname().sendKeys(reportname2);
		Thread.sleep(4000);
		
		String reportdescription2 = f.getExcelData("Reportpage",2, 11);
		rp.Reportfiledescription2().sendKeys(reportdescription2);
		
		rp.downloadpdf().click();
		
		rp.customGeneratereport().click();
		
		//assessmentdetail
		
		Thread.sleep(6000);
		rp.assessmentdetailstab().click();
		
		rp.assessmentvendor().click();
		rp.assessmentvendordropdown(vendor).click();
		rp.assessmentvendor().click();
		
		rp.assessmentstatus().click();
		rp.assessmentstatusselectall(aStatus).click();
		rp.assessmentstatus().click();
		
		//rp.selectFrom().sendKeys("1-1-2023");
		//rp.selectTO().sendKeys("24-7-2023");
		
		rp.selectvendorofassessment().click();
		
		rp.checkboxassessment1().click();
		rp.checkboxassessment2().click();
		
		rp.avendorSearchfield().sendKeys(vendor);
		Thread.sleep(2000);
		if(rp.verify_Asize().size()>0) {
			Assert.assertTrue(rp.verifyVInAssessment(vendor).isDisplayed());
		}else {
			Assert.fail();
		}
		rp.avendorSearchfield().clear();
		Thread.sleep(2000);
		rp.avendorSearchfield().sendKeys(invalidData);
		Thread.sleep(2000);
		if(rp.verify_Asize().size()>0) {
			Assert.fail();
		}else {
//			Assert.assertTrue(rp.verify_ANoDataText().isDisplayed());
//			String nodata = rp.verify_ANoDataText().getText().trim();
//			System.out.println(nodata);
//			String expected = f.getExcelData("AssertMessage",28, 3);
//			System.out.println(expected);
//			Assert.assertEquals(nodata,expected);
			String nodata = rp.verify_ANoDataText().getAttribute("textContent").trim();
			System.out.println("from x-path"+nodata);
			String expected = f.getExcelData("AssertMessage",28, 3);
			System.out.println("sheet"+expected);
			Assert.assertEquals(nodata,expected);
		}
		Thread.sleep(2000);
		
		rp.savenextassessment().click();
		
		//evidence
		
		rp.evidencevendor().click();
		rp.evidencevendordropdown(vendor).click();
		rp.evidencevendor().click();
		
		rp.checkboxforevidence().click();
		
		rp.vendorSearchfieldinEvidence().sendKeys(vendor);
		Thread.sleep(2000);
		if(rp.verify_vizeInEvidence().size()>0) {
			Assert.assertTrue(rp.verifyVDataInEvidence(vendor).isDisplayed());
		}else {
			Assert.fail();
		}
		rp.vendorSearchfieldinEvidence().clear();
		Thread.sleep(2000);
		//rp.vendorSearchfieldinEvidence().sendKeys(invalidData);
		//Thread.sleep(2000);
		//if(rp.verify_vizeInEvidence().size()>0) {
		//	Assert.fail();
		//}
		//else {
			//Assert.assertTrue(rp.verify_ENoDataText().isDisplayed());
		//}
		//Thread.sleep(2000);
		
		rp.evidencesaveandnext().click();
		
		//observation
		
		rp.observationvendor().click();
		rp.observationvendordropdown(vendor).click();
		rp.observationvendor().click();
		
		rp.observationstatus().click();
		rp.observationstatusdropdown(oStatus).click();
		rp.observationstatus().click();
		
		rp.observationrisk().click();
		rp.observationriskdropdown(risk).click();
		rp.observationrisk().click();
		Thread.sleep(5000);
		
		rp.observationcheckbox1().click();
		rp.observationcheckbox2().click();
		rp.observationcheckbox3().click();
		rp.observationcheckbox4().click();
		Thread.sleep(2000);
		rp.observationsave().click();
		Thread.sleep(4000);
		//additional details
		
		rp.addnote().click();
		
	
       	String noteheader = f.getExcelData("Reportpage",1, 8);
    	String notetext = f.getExcelData("Reportpage",1, 9);
		rp.notesheader().sendKeys(noteheader);
		rp.notestext().sendKeys(notetext);
		rp.addtionalcheckbox().click();
		rp.additionalsave().click();
		
		//pdf
        Thread.sleep(2000);
		
	    rp.Generatereport().click();
	    String reportname3 = f.getExcelData("Reportpage",3, 10);	
    	String reportdescription3 = f.getExcelData("Reportpage",3, 11);
		rp.GReportname().sendKeys(reportname3);
		  Thread.sleep(2000);
		rp.Reportfiledescription3().sendKeys(reportdescription3);
		
		rp.downloadpdf().click();
	
		rp.customGeneratereport().click();
		Assert.assertTrue(rp.verifySavedMsg().isDisplayed());
		//word
		Thread.sleep(6000);
			
		rp.Generatereport().click();
		String reportname4 = f.getExcelData("Reportpage",4, 10);	
	    String reportdescription4 = f.getExcelData("Reportpage",4, 11);
	    rp.GReportname().sendKeys(reportname4);
	    Thread.sleep(2000);
		rp.Reportfiledescription2().sendKeys(reportdescription4);
			
		rp.downloadword().click();
		Thread.sleep(2000);
		rp.customGeneratereport().click();
		Thread.sleep(2000);
		Assert.assertTrue(rp.verifySavedMsg().isDisplayed());
		Thread.sleep(2000);
	}
	
	@Test(priority=4,testName="O",enabled= true)
	public void ReportRepository() throws InterruptedException, IOException {
		Reporter.log("ReportRepository",true);
		logger.info("click on Report repository");
		FileLib f=new FileLib();
		String vCategory = f.getExcelData("Reportpage",1, 13);
		String vendor = f.getExcelData("Reportpage",1, 15);
		String wreport = f.getExcelData("Reportpage",4, 10);
		String invalidData = f.getExcelData("Reportpage",1, 16);
		String preport = f.getExcelData("Reportpage",3, 10);
		String validData = f.getExcelData("Reportpage",1, 15);
		
		Reportpage rp=new Reportpage(driver);
		
		Thread.sleep(2000);
	    rp.clickonReport().click();
		Thread.sleep(4000);
		
		//Repository
		
		rp.Reportrepository().click();
		
		rp.Rcategory().click();
		rp.Rcategoryselect().click();
		rp.Rcategory().click();
		
		rp.Rvendor().click();
		rp.Rvendordropdown().click();
		rp.Rvendor().click();
		
		Thread.sleep(2000);
		if(rp.verifyDownload(vCategory,vendor,wreport).size()>0){
			rp.clickDownload(vCategory,vendor,wreport).click();;
		}
//		rp.Rdownloadword().click();
		Thread.sleep(3000);
		
		if(rp.verifyDownload(vCategory,vendor,preport).size()>0){
			rp.clickDownload(vCategory,vendor,preport).click();;
		}
//		rp.Rdownloadpdf().click();
		Thread.sleep(2000);
		
		rp.clickSearchfield().sendKeys(validData);
		Thread.sleep(2000);
		if(rp.verify_Data().size()>0) {
			Assert.assertTrue(rp.verifyVDataReportRepository(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		Thread.sleep(2000);
		rp.clickSearchfield().clear();
		Thread.sleep(2000);
		rp.clickSearchfield().sendKeys(invalidData);
		Thread.sleep(2000);
		if(rp.verify_Data().size()>0) {
			Assert.fail();
		}else {
		Assert.assertTrue(rp.verify_NoDataText().isDisplayed());
		}	
		
	}
}
