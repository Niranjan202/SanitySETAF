package com.tptrac.testscript;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.FrameworkandQuestionsUploadPage;
import com.tptrac.pom.FrameworksPage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorCategoryManagementPage;
import com.tptrac.pom.VendorManagementPage;
import com.tptrac.pom.questionnairLibraryandTemplatePage;


@Listeners(com.tptrac.generic.ExtentListener.class)
public class QuestionnairLibraryandTemplateUploadModule extends BaseClass1
{
	public static FluentWait<WebDriver> fWait;
	
	@Test(priority=1, testName="S",enabled= true)
	public void QestiontionnairUpload() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("QestiontionnairUpload",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();

		String sectionname = f.getExcelData("Upload",2, 4);
		String sectioncode=f.getExcelData("Upload", 2, 5);
		
		ql.clickQuestionlib().click();
		// Wait for section management to be visible
	    fWait.until(ExpectedConditions.visibilityOf(ql.clicksectionmanagement()));
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clicksectionmanagement()));
	    ql.clicksectionmanagement().click();

	    // Wait for the add new section button to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickaddnewsection()));
	    ql.clickaddnewsection().click();

	    // Wait for the section name input to be visible
	    fWait.until(ExpectedConditions.visibilityOf(ql.addSectionname()));
	    ql.addSectionname().sendKeys(sectionname);

	    // Wait for the section code input to be visible
	    fWait.until(ExpectedConditions.visibilityOf(ql.addSectioncode()));
	    ql.addSectioncode().sendKeys(sectioncode);

	    // Wait for the add button to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickadd()));
	    ql.clickadd().click();
	    
		Assert.assertTrue(ql.addSuccessfullyassert().isDisplayed());
		
		Reporter.log("assertTrue",true);
	}

	@Test(priority=2, testName="S",enabled= true)
	public void addNewSection() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("QestiontionnairUpload",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();

		String sectionname = f.getExcelData("Upload",1, 4);
		String sectioncode=f.getExcelData("Upload", 1, 5);
		
		//ql.QusLibBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-automation-id='question-section-2']")));
		button.click();
		
		 // Wait for section management to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clicksectionmanagement()));
	    
	    ql.clicksectionmanagement().click();

	    // Wait for the add new section button to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickaddnewsection()));
	    ql.clickaddnewsection().click();

	    // Wait for the section name input to be visible
	    fWait.until(ExpectedConditions.visibilityOf(ql.addSectionname()));
	    Thread.sleep(4000);
	    ql.addSectionname().sendKeys(sectionname);

	    // Wait for the section code input to be visible
	    fWait.until(ExpectedConditions.visibilityOf(ql.addSectioncode()));
	    Thread.sleep(4000);
	    ql.addSectioncode().sendKeys(sectioncode);

	    // Wait for the add button to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickadd()));
	    ql.clickadd().click();
	    Assert.assertTrue(ql.addSuccessfullyassert().isDisplayed());
		Reporter.log("assertTrue",true);
	}

	@Test(priority=3, testName="S",enabled= true)
	public void QMblankadd() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("QMblankadd",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();

		String sectionname = f.getExcelData("Upload",1, 4);
		String sectioncode=f.getExcelData("Upload", 1, 5);
		
		ql.clickQuestionlib().click();
		
		// Wait for section management to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clicksectionmanagement()));
	    ql.clicksectionmanagement().click();

	    // Wait for the add new section button to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickaddnewsection()));
	    ql.clickaddnewsection().click();

	    // Wait for the add button to be clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickadd()));
	    ql.clickadd().click();
		
		String name = f.getExcelData("AssertMessage",12, 3);
		String name1 = ql.assertsectionname().getText();
		Assert.assertEquals(name1,name);
		Reporter.log("assertTrue",true);
		String code = f.getExcelData("AssertMessage",13, 3);
		String code1 = ql.assertsectioncode().getText();
		Assert.assertEquals(code1,code);
		Reporter.log("assertTrue",true);
		
		fWait.until(ExpectedConditions.elementToBeClickable(ql.clickancel())).click();
		//ql.clickancel().click();
	}
	
	//upload
	
	@Test(priority=4,testName="S",enabled= true)
	public void Questionnaircancel() throws EncryptedDocumentException, IOException, InterruptedException
	{

			Reporter.log("Questionnaircancel",true);
			fWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(2000))
					.ignoring(NoSuchElementException.class, TimeoutException.class);

			questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
			FrameworkandQuestionsUploadPage qf=new FrameworkandQuestionsUploadPage(driver);
			
			
			FileLib f=new FileLib();
			String category = f.getExcelData("QestiontionnairUpload",1, 3);
			String type = f.getExcelData("QestiontionnairUpload",4, 4);
			//String atype = f.getExcelData("QestiontionnairUpload",6, 5);
			String vendor = f.getExcelData("QestiontionnairUpload",3, 8);
			
			ql.ClickonUpload().click();
			fWait.until(ExpectedConditions.visibilityOf(ql.ClickQuestionnaire())).click();
			ql.clickvendorcategory().click();
			fWait.until(ExpectedConditions.visibilityOf(ql.selectItCategory(category))).click();
			fWait.until(ExpectedConditions.elementToBeClickable(ql.selectItCategory(category))).click();
		
			// Click on vendor category again to ensure it is selected
			fWait.until(ExpectedConditions.visibilityOf(ql.clickvendorcategory())).click();
		    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickvendorcategory())).click();
		    Thread.sleep(2000);
		    // Click on Vendor Type
		    ql.clickVendorType().click();
		    Thread.sleep(2000);
		    ql.selectType1(type).click();
		    Thread.sleep(2000);
		    ql.clickvendortype1().click();
			Thread.sleep(2000);
			// Click on Vendor Type
			
		
		    ql.SelectVendor().click();
		    Thread.sleep(2000);
		    ql.selectVendorOP(vendor).click();
		   // fWait.until(ExpectedConditions.elementToBeClickable(ql.SelectVendor())).click();
			Thread.sleep(2000);
			ql.SelectVendor().click();
			Thread.sleep(2000);
			ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Questionnaire Upload Template.xlsx");
			Thread.sleep(2000);
			ql.clickCancel().click();

//			FileLib f=new FileLib();
			String Nofile = f.getExcelData("AssertMessage",16, 3);
			String nofile = ql.assertNofile().getText();
			Assert.assertEquals(nofile,Nofile);
			Reporter.log("assertTrue",true);
	}
	
	@Test(priority=5,testName="S",enabled= true)
	public void QuestionnairInvalidfileupload() throws EncryptedDocumentException, IOException, InterruptedException
	{

			Reporter.log("QuestionnairInvalidfileupload",true);
			fWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(2000))
					.ignoring(NoSuchElementException.class, TimeoutException.class);
			

			questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
			FrameworkandQuestionsUploadPage qf=new FrameworkandQuestionsUploadPage(driver);

			
			FileLib f=new FileLib();
			String category = f.getExcelData("QestiontionnairUpload",1, 3);
			String type = f.getExcelData("QestiontionnairUpload",4, 4);
			//String atype = f.getExcelData("QestiontionnairUpload",6, 5);
			String vendor = f.getExcelData("QestiontionnairUpload",3, 8);
			
			ql.ClickonUpload().click();
			fWait.until(ExpectedConditions.visibilityOf(ql.ClickQuestionnaire())).click();
			ql.clickvendorcategory().click();
			fWait.until(ExpectedConditions.visibilityOf(ql.selectItCategory(category))).click();
			fWait.until(ExpectedConditions.elementToBeClickable(ql.selectItCategory(category))).click();
			//Thread.sleep(2000);
			//ql.selectItCategory(category).click();
			//Thread.sleep(2000);
			// Click on vendor category again to ensure it is selected
			fWait.until(ExpectedConditions.visibilityOf(ql.clickvendorcategory())).click();
		    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickvendorcategory())).click();
			//ql.clickvendorcategory().click();
			Thread.sleep(4000);

		    // Click on Vendor Type
		    ql.clickVendorType().click();
		    Thread.sleep(2000);
		    ql.selectType1(type).click();
		    Thread.sleep(2000);
		    ql.clickvendortype1().click();
			Thread.sleep(2000);
			// Click on Vendor Type
			
		    ql.SelectVendor().click();
		    Thread.sleep(2000);
		    ql.selectVendorOP(vendor).click();
		   // fWait.until(ExpectedConditions.elementToBeClickable(ql.SelectVendor())).click();
			Thread.sleep(2000);
			ql.SelectVendor().click();
			Thread.sleep(2000);
			
			ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx");
			Thread.sleep(3000);
			ql.uploadLibrary().click();
			Thread.sleep(3000);
//			FileLib f=new FileLib();
//			String invalidextension = f.getExcelData("AssertMessage",17, 3);
//			String invalidExtension= ql.assertInvalidextension().getText();
//			Assert.assertEquals(invalidExtension,invalidextension);
			String invalidfile1 = f.getExcelData("AssertMessage",26, 3);
			String Invalidfile1 = ql.validateinvalidtext().getText().trim();
			Assert.assertEquals(Invalidfile1,invalidfile1);
			Reporter.log("assertTrue",true);
			Thread.sleep(2000);
			qf.Clickok().click();
			Thread.sleep(2000);
			Reporter.log("assertTrue",true);
			}

	@Test(priority=6,testName="S",enabled= true)
	public void QuestionnairUpload() throws EncryptedDocumentException, IOException, InterruptedException
	{

			Reporter.log("QestiontionnairUpload",true);
			fWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(2000))
					.ignoring(NoSuchElementException.class, TimeoutException.class);

			questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
			FrameworkandQuestionsUploadPage qf=new FrameworkandQuestionsUploadPage(driver);
			
			
			FileLib f=new FileLib();
			String category = f.getExcelData("QestiontionnairUpload",1, 3);
			String type = f.getExcelData("QestiontionnairUpload",4, 4);
			//String atype = f.getExcelData("QestiontionnairUpload",6, 5);
			String vendor = f.getExcelData("QestiontionnairUpload",3, 8);
			String file = f.getExcelData("Upload",4,1);
			String status = f.getExcelData("Upload",1,2);
			Thread.sleep(2000);
			ql.ClickonUpload().click();
			fWait.until(ExpectedConditions.visibilityOf(ql.ClickQuestionnaire())).click();
			ql.clickvendorcategory().click();
			fWait.until(ExpectedConditions.visibilityOf(ql.selectItCategory(category))).click();
			fWait.until(ExpectedConditions.elementToBeClickable(ql.selectItCategory(category))).click();
			//Thread.sleep(2000);
			//ql.selectItCategory(category).click();
			//Thread.sleep(2000);
			// Click on vendor category again to ensure it is selected
			fWait.until(ExpectedConditions.visibilityOf(ql.clickvendorcategory())).click();
		    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickvendorcategory())).click();
			//ql.clickvendorcategory().click();
			Thread.sleep(2000);

		    // Click on Vendor Type
		    ql.clickVendorType().click();
		    Thread.sleep(2000);
		    ql.selectType1(type).click();
		    Thread.sleep(2000);
		    ql.clickvendortype1().click();
			Thread.sleep(2000);
			// Click on Vendor Type
			
		    ql.SelectVendor().click();
		    Thread.sleep(2000);
		    ql.selectVendorOP(vendor).click();
		   // fWait.until(ExpectedConditions.elementToBeClickable(ql.SelectVendor())).click();
			Thread.sleep(2000);
			ql.SelectVendor().click();
			Thread.sleep(2000);

		
			ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Questionnaire Upload Template.xlsx");
			Thread.sleep(2000);
			ql.uploadLibrary().click();
			Thread.sleep(4000);
//			FileLib f=new FileLib();
			String successmess = f.getExcelData("AssertMessage",4, 3);
			String Successmess = ql.assertSuccess().getText();
			Assert.assertEquals(Successmess,successmess);

			qf.Clickok().click();
			Thread.sleep(3000);
			
			Reporter.log("assertTrueADDED",true);
			String pass = f.getExcelData("AssertMessage",5, 3);
			String FPass =ql.quetionnaireUploadpass(file,status).getText();
			Assert.assertEquals(FPass,pass);
			Reporter.log("assertTruePASS",true);
			Thread.sleep(2000);
			ql.Uploadedfiledownload(file).click();
			Thread.sleep(2000);
		}

	//Questionary section upload

	@Test(priority=7,testName="S",enabled= true)
	public void sectionuploadcancel() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("sectionuploadcancel",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		
		FileLib f=new FileLib();
		String sectionName = f.getExcelData("Upload",2, 4);
		// Click on Upload
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickonUpload())).click();

	    // Click on Questionnaire
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickQuestionnaire())).click();

	    // Click on Section
	    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickSection())).click();
		Thread.sleep(2000);
		ql.clicksectionyes().click();
		
		ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\QuestionnaireUploadSample.xlsx");
		Thread.sleep(2000);
		ql.clickCancel().click();
		Thread.sleep(2000);

		String Nofile = f.getExcelData("AssertMessage",16, 3);
		String nofile = ql.assertNofile().getText();
		Assert.assertEquals(nofile,Nofile);
		Reporter.log("assertTrue",true);

		Thread.sleep(2000);
		
		ql.clickSectionNo().click();
		Thread.sleep(2000);
		ql.clicksectiondropdown().click();
		Thread.sleep(2000);
		ql.selectsectiondropdown(sectionName).click();
		Thread.sleep(2000);
		ql.clicksectiondropdown().click();
		Thread.sleep(2000);
		ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\QuestionnaireUploadSample.xlsx");
		Thread.sleep(2000);
		ql.clickCancel().click();
		Thread.sleep(2000);
		
		Assert.assertEquals(nofile,Nofile);
		Reporter.log("assertTrue",true);
		
	}

	
	@Test(priority=8, testName="S", enabled= true)
	public void invalidFileSectionUpload() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("invalidFileSectionUpload",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FrameworkandQuestionsUploadPage qf=new FrameworkandQuestionsUploadPage(driver);
		FileLib f=new FileLib();
		String sectionName = f.getExcelData("Upload",2, 4);
		
		 fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickonUpload())).click();

		  // Click on Questionnaire
		   fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickQuestionnaire())).click();

		    // Click on Section
		    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickSection())).click();
			Thread.sleep(2000);
			ql.clicksectionyes().click();
		
		Thread.sleep(3000);
		ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx");
		Thread.sleep(2000);
		ql.uploadLibrary().click();
		Thread.sleep(3000);
		String invalidfile1 = f.getExcelData("AssertMessage",26, 3);
		String Invalidfile1 = ql.validateinvalidtext().getText().trim();
		Assert.assertEquals(Invalidfile1,invalidfile1);
		Reporter.log("assertTrue",true);
		qf.Clickok().click();
		Thread.sleep(2000);
		Reporter.log("assertTrue",true);

		
		ql.clickSectionNo().click();
		Thread.sleep(2000);
		ql.clicksectiondropdown().click();
		Thread.sleep(2000);
		ql.selectsectiondropdown(sectionName).click();
		Thread.sleep(2000);
		ql.clicksectiondropdown().click();
		Thread.sleep(2000);
		ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\Invalid file.xlsx");
		Thread.sleep(3000);
		ql.uploadLibrary().click();
		Thread.sleep(3000);;
		
		Assert.assertEquals(Invalidfile1,invalidfile1);
		Reporter.log("assertTrue",true);
		//Thread.sleep(2000);
		//qf.Clickok().click();
		Thread.sleep(2000);
		Reporter.log("assertTrue",true);
		
	}	
	
	@Test(priority=9, testName="S",enabled= true)
	public void sectionUpload() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("invalidFileSectionUpload",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FrameworkandQuestionsUploadPage qf=new FrameworkandQuestionsUploadPage(driver);
		FileLib f=new FileLib();
		String sectionName = f.getExcelData("Upload",2, 4);
		String file = f.getExcelData("Upload",10,1);
		String file1 = f.getExcelData("Upload",10,1);
		String status = f.getExcelData("Upload",1,2);
		Thread.sleep(2000);
		 fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickonUpload())).click();

		  // Click on Questionnaire
		   fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickQuestionnaire())).click();

		    // Click on Section
		    fWait.until(ExpectedConditions.elementToBeClickable(ql.clickSection())).click();
			Thread.sleep(2000);
			ql.clicksectionyes().click();
			Thread.sleep(3000);
		ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\QuestionnaireUploadSample.xlsx");
		Thread.sleep(3000);
		ql.uploadLibrary().click();
//		FileLib f=new FileLib();
		/*String successmess = f.getExcelData("AssertMessage",4, 3);
		String Successmess = ql.assertSuccess().getText();
		Assert.assertEquals(Successmess,successmess);
		Thread.sleep(2000);*/
		qf.Clickok().click();
		Thread.sleep(3000);
		
		Reporter.log("assertTrueADDED",true);
		String pass = f.getExcelData("AssertMessage",5, 3);
		String FPass =ql.quetionnaireUploadpass(file,status).getText();
		Assert.assertEquals(FPass,pass);
		Reporter.log("assertTruePASS",true);
		Thread.sleep(2000);
		ql.Uploadedfiledownload(file).click();
		Thread.sleep(2000);
		
		ql.clickSectionNo().click();
		Thread.sleep(2000);
		ql.clicksectiondropdown().click();
		Thread.sleep(2000);
		ql.selectsectiondropdown(sectionName).click();
		Thread.sleep(2000);
		ql.clicksectiondropdown().click();
		Thread.sleep(2000);
		ql.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\QuestionnaireUploadSample.xlsx");
		Thread.sleep(3000);
		ql.uploadLibrary().click();
		
		//Assert.assertEquals(Successmess,successmess);

		//qf.Clickok().click();
		Thread.sleep(3000);
		
		Reporter.log("assertTrueADDED",true);
		Assert.assertEquals(FPass,pass);
		Reporter.log("assertTruePASS",true);
		Thread.sleep(2000);
		ql.Uploadedfiledownload(file1).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=10, testName="S",enabled= true)
	public void searchQUpload() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("invalidFileSectionUpload",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FrameworkandQuestionsUploadPage qf=new FrameworkandQuestionsUploadPage(driver);
		FrameworksPage fp=new FrameworksPage(driver);
    	VendorManagementPage v=new VendorManagementPage(driver);
	    UsersListPage au=new UsersListPage(driver);
		VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
		Thread.sleep(2000);
		FileLib f=new FileLib();
		String validData = f.getExcelData("Upload",10, 1);
		String invalidData = f.getExcelData("Upload",1,5);
		
		 fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickonUpload())).click();

		// Click on Questionnaire
		fWait.until(ExpectedConditions.elementToBeClickable(ql.ClickQuestionnaire())).click();
		 ql.UploadSearch().sendKeys(validData);
		Thread.sleep(2000);
		if(ql.verify_Data().size()>0) {
			Assert.assertTrue(fp.verifyFramework(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		
	    ql.UploadSearch().click();
		Thread.sleep(2000);
		ql.UploadSearch().sendKeys(invalidData);
		Thread.sleep(2000);
		if(ql.verify_Data().size()>1) {
			Assert.fail();
		}else {
			Assert.assertTrue(ql.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully");
    	}
	
	@Test(priority=10, testName="S",enabled= true)
	public void addQuestionnaireTemplate() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("addQuestionnaireTemplate",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		UsersListPage au=new UsersListPage(driver);
		
		FileLib f=new FileLib();
		String Addtemplatename1= f.getExcelData("QestiontionnairUpload",2, 10);
		String sectionName = f.getExcelData("QestiontionnairUpload",4, 6);
		String templateName = f.getExcelData("QestiontionnairUpload",3, 13);
		
		  Thread.sleep(2000);
		    ql.clickQuestionlib().click();
	        Thread.sleep(2000);
			//ql.Selectsection(sectionName).click();
	        ql.QuestionSearch().sendKeys(sectionName);
	        Thread.sleep(2000);
	        ql.selectSectionForUpload(sectionName);
	    	Thread.sleep(2000);
	    	ql.ClickQtemplate().click();
	    	Thread.sleep(2000);
			ql.addnewtemplate().click();
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.moveToElement(ql.Entertemplatename(templateName)).click();
			act.sendKeys(templateName).perform();
	    	Thread.sleep(2000);
			ql.Clickadd1().click();
			Thread.sleep(2000);
			String actualText = ql.verifyCreatedQuestion(templateName).getText();
			Assert.assertEquals(actualText,templateName);
			Reporter.log("assertTrue",true);
	}
	
	@Test(priority=11, testName="S",enabled= true)
	public void publishQuestionnairetemplate() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("publishQuestionnairetemplate",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String template = f.getExcelData("QestiontionnairUpload",3, 13);
		String vendorCategory = f.getExcelData("QestiontionnairUpload",5, 3);
		String status = f.getExcelData("QestiontionnairUpload",1, 17);
		Thread.sleep(2000);
		ql.clickQuestionlib().click();
		Thread.sleep(4000);
		ql.Questiontemplates().click();
		Thread.sleep(2000);
	    	//add  vendorcategory
	    	ql.clickonpublish(template).click();
	    	Thread.sleep(2000);
	    	ql.selectvendorcategory().click();
	    	Thread.sleep(2000);
	    	ql.selectVCoption(vendorCategory);
	    	Thread.sleep(4000);
	    	
	    	//save
	    	ql.publish().click();
	    	Thread.sleep(2000);
			Assert.assertTrue(ql.verifyTemplateStatus(template,status).getAttribute("textContent").contains(status));
			Reporter.log("assertTrue",true);
	} 
}


	