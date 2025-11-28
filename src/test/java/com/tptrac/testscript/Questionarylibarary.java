package com.tptrac.testscript;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.questionnairLibraryandTemplatePage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class Questionarylibarary extends BaseClass1 {
	
	@Test(priority=1,testName="I",enabled= false)
	public void addsectionManagement() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("addsectionManagement",false);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String sectionname = f.getExcelData("QestiontionnairUpload",1, 6);
		String sectioncode=f.getExcelData("QestiontionnairUpload", 1, 7);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.clicksectionmanagement().click();
		Thread.sleep(2000);
		ql.clickaddnewsection().click();
		Thread.sleep(2000);
		ql.addSectionname().sendKeys(sectionname);
		ql.addSectioncode().sendKeys(sectioncode);
		Thread.sleep(2000);
		ql.clickadd().click();
		Thread.sleep(4000);
		UsersListPage au=new UsersListPage(driver);
		au.searchUser().sendKeys(sectionname);
		Thread.sleep(3000);
//		String save = f.getExcelData("AssertMessage",8, 3);
//		String save1 = ql.saveSuccessfullyassert().getText();
//    	Assert.assertEquals(save1,save);
		String actualText = ql.verifyCreatedSection(sectionname).getText();
		Assert.assertEquals(actualText,sectionname);
		Reporter.log("assertTrue",true);
	}
	
	
	@Test(priority=2,testName="I", enabled = false)
	public void QMblankadd() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("addsectionManagement-QMblankadd",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		
		String sectionname = f.getExcelData("QestiontionnairUpload",1, 6);
		String sectioncode=f.getExcelData("QestiontionnairUpload", 1, 7);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.clicksectionmanagement().click();
		Thread.sleep(2000);
		ql.clickaddnewsection().click();
		Thread.sleep(2000);
		ql.clickadd().click();
		Thread.sleep(2000);
		String name = f.getExcelData("AssertMessage",12, 3);
		String name1 = ql.assertsectionname().getText();
		Thread.sleep(2000);
		Assert.assertEquals(name1,name);
		Reporter.log("assertTrue",true);
		String code = f.getExcelData("AssertMessage",13, 3);
		String code1 = ql.assertsectioncode().getText();
		Thread.sleep(2000);
		Assert.assertEquals(code1,code);
		Reporter.log("assertTrue",true);
		ql.clickancel().click();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,testName="I", enabled = false)
	public void addduplicate() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("addsectionManagement-addduplicate",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		
		String sectionname = f.getExcelData("QestiontionnairUpload",1, 6);
		String sectioncode=f.getExcelData("QestiontionnairUpload", 1, 7);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.clicksectionmanagement().click();
		Thread.sleep(2000);
		ql.clickaddnewsection().click();
		Thread.sleep(2000);
		ql.addSectionname().sendKeys(sectionname);
		ql.addSectioncode().sendKeys(sectioncode);
		Thread.sleep(2000);
		ql.clickadd().click();
		String save = f.getExcelData("AssertMessage",11, 3);
//		String save1 = ql.saveSuccessfullyassert().getText();
		String actualValue = ql.verifyWarningMesForDuplicateSectionName().getText();
		Thread.sleep(2000);
		Assert.assertEquals(actualValue,save);
		Reporter.log("assertTrue",true);
		Thread.sleep(4000);
		ql.clickancel().click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=4,testName="I", enabled = false)
	public void QMupdateanddelete() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("addsectionManagement--QMupdateanddelete",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String sectionname1 = f.getExcelData("QestiontionnairUpload",1, 6);
		String sectionname = f.getExcelData("QestiontionnairUpload",2, 6);
		String sectioncode=f.getExcelData("QestiontionnairUpload", 2, 7);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.clicksectionmanagement().click();
		Thread.sleep(2000);
		ql.searchsection().sendKeys(sectionname1);
		Thread.sleep(2000);
		ql.clickSectionname().click();
		Thread.sleep(2000);
		ql.updateSectionname().clear();
		ql.updateSectionname().sendKeys(sectionname);
		Thread.sleep(2000);
		ql.updateSectioncode().clear();
		ql.updateSectioncode().sendKeys(sectioncode);
		Thread.sleep(2000);
		ql.updatesave().click();
		Thread.sleep(4000);
		ql.searchsection().clear();
		Thread.sleep(2000);
//		String save = f.getExcelData("AssertMessage",8, 3);
//		String save1 = ql.saveSuccessfullyassert().getText();
//		Thread.sleep(2000);
//		Assert.assertEquals(save1,save);
//		Reporter.log("assertTrue",true);
		UsersListPage au=new UsersListPage(driver);
		au.searchUser().sendKeys(sectionname);
		Thread.sleep(4000);
		String actualText = ql.verifyCreatedSection(sectionname).getText();
		Assert.assertEquals(actualText,sectionname);
		Reporter.log("assertTrue",true);
		ql.clickdelete(sectionname).click();
		Thread.sleep(2000);
	    ql.deleteyes().click();
	    String delete = f.getExcelData("AssertMessage",10, 3);
		String delete1= ql.deleteassert().getText();
		Thread.sleep(3000);
		Assert.assertEquals(delete1,delete);
		Reporter.log("assertTrue",true);
	}
	
	
		
	@Test(priority=5,testName="I", enabled = false)
	public void addsectionManagement2() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("addsectionManagement",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String sectionname = f.getExcelData("QestiontionnairUpload",3, 6);
		String sectioncode=f.getExcelData("QestiontionnairUpload", 3, 7);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.clicksectionmanagement().click();
		Thread.sleep(2000);
		ql.clickaddnewsection().click();
		Thread.sleep(2000);
		ql.addSectionname().sendKeys(sectionname);
		ql.addSectioncode().sendKeys(sectioncode);
		Thread.sleep(2000);
		ql.clickadd().click();
		Thread.sleep(2000);
//		String add = f.getExcelData("AssertMessage",9, 3);
//		String add1 = ql.addSuccessfullyassert().getText();
//		Thread.sleep(2000);
//    	Assert.assertEquals(add1,add);
//		Reporter.log("assertTrue",true);
		UsersListPage au=new UsersListPage(driver);
		au.searchUser().sendKeys(sectionname);
		Thread.sleep(4000);
		String actualText = ql.verifyCreatedSection(sectionname).getText();
		Assert.assertEquals(actualText,sectionname);
		Reporter.log("assertTrue",true);
	}	
	
	//add question

	@Test(priority=6,testName="I", enabled = false)
	public void addquestion() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("addquestion",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String Addquestion = f.getExcelData("QestiontionnairUpload",1, 9);
		String sectionName = f.getExcelData("QestiontionnairUpload",3, 6);
		String vendorCategory = f.getExcelData("QestiontionnairUpload",3, 3);
		String vendorType = f.getExcelData("QestiontionnairUpload",4, 4);
		String vendorName = f.getExcelData("QestiontionnairUpload",2, 8);
		String frameworkName = f.getExcelData("QestiontionnairUpload",1, 12);
		String domainName = f.getExcelData("QestiontionnairUpload",1, 14);
		String controlName = f.getExcelData("QestiontionnairUpload",1, 15);
		String associationType = f.getExcelData("QestiontionnairUpload",6, 5);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(3000);
		ql.clickaddquestions().click();
		Thread.sleep(3000);
		ql.clickQLsection().click();
		Thread.sleep(2000);
		ql.clickQLaddsectionname(sectionName).click();
		Thread.sleep(3000);
		ql.clickQLsection().click();
		Thread.sleep(3000);
		ql.clickQLaddquestion().sendKeys(Addquestion);
		Thread.sleep(3000);
		ql.clickvendorcategory().click();
		Thread.sleep(3000);
		ql.selectQLvVendorcategory(vendorCategory).click();
		Thread.sleep(2000);
		ql.clickvendorcategory().click();
		Thread.sleep(2000);
		
		ql.clickVendorType().click();
		Thread.sleep(2000);
		ql.selectQLVendortype(vendorType).click();
		Thread.sleep(2000);
		ql.clickvendortype1().click();
		Thread.sleep(4000);
		
		//ql.clickvendorassociatetype().click();
		//Thread.sleep(3000);
		//ql.selectQLVendorassociate(associationType).click();
		//Thread.sleep(3000);
		//ql.clickvendorassociatetype1().click();
		Thread.sleep(3000);
		
		
		ql.SelectVendor().click();
		Thread.sleep(2000);
		ql.selectVendorOP(vendorName).click();
    	Thread.sleep(2000);
		ql.SelectVendor().click();
		Thread.sleep(2000);
		
		ql.clickQLframework().click();
		Thread.sleep(2000);
		ql.selectQLframework(frameworkName).click();
		Thread.sleep(2000);
		ql.clickQLframework().click();
		
		ql.clickQLdomain().click();
		ql.selectQLdomain(domainName).click();
		Thread.sleep(2000);
		ql.clickQLdomain().click();
		ql.clickQLcontrol().click();
		ql.selectQLcontrol(controlName).click();
		Thread.sleep(2000);
		ql.clickQLcontrol().click();
		
		ql.clickQLadd().click();                  //add
		
		
		ql.clickQLdeleteframework(frameworkName).click();      //delete
		
		ql.clickQLframework().click();
		Thread.sleep(2000);
		ql.selectQLframework(frameworkName).click();
		Thread.sleep(2000);
		ql.clickQLframework().click();
		
		ql.clickQLdomain().click();
		ql.selectQLdomain(domainName).click();
		Thread.sleep(2000);
		ql.clickQLdomain().click();
		
		ql.clickQLcontrol().click();
		ql.selectQLcontrol(controlName).click();
		Thread.sleep(2000);
		ql.clickQLcontrol().click();
		
		ql.clickQLadd().click();                   //add
		
		ql.clickQLeditframework(frameworkName).click();       //edit
		
		ql.clickQLdomain().click();
		ql.updateQLdomain().click();
		Thread.sleep(2000);
		ql.clickQLdomain().click();
		
		ql.clickQLcontrol().click();
		ql.updateQLcontrol().click();
		Thread.sleep(2000);
		ql.clickQLcontrol().click();
		
		ql.clickQLadd().click();
		
		ql.clickQLsaveframework().click();
//		Assert.assertTrue(ql.verifyAddMsg().isDisplayed(),"Question added successfully");
		Thread.sleep(2000);
		String actualText = ql.verifyCreatedQuestion(Addquestion).getText();
		Assert.assertEquals(actualText,Addquestion);
		Reporter.log("assertTrue",true);

	}
	
	
	@Test(priority=7,testName="I", enabled = false)
	public void addnewquestionnairtemplate() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("addnewquestionnairtemplate",true);
		
	

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		
		FileLib f=new FileLib();
		String Addtemplatename1= f.getExcelData("QestiontionnairUpload",2, 10);
		String sectionName = f.getExcelData("QestiontionnairUpload",3, 6);
		String templateName = f.getExcelData("QestiontionnairUpload",1, 13);
		
		  	Thread.sleep(4000);
		    ql.clickQuestionlib().click();
	        Thread.sleep(2000);
	        ql.clickNext().click();
	        Thread.sleep(2000);
			ql.Selectsection(sectionName).click();
	    	Thread.sleep(2000);
	    	ql.ClickQtemplate().click();
	    	Thread.sleep(2000);
			ql.addnewtemplate().click();
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.moveToElement(ql.Entertemplatename(templateName)).click();
			act.sendKeys(templateName).perform();
//	        ql.Entertemplatename(templateName).sendkeys(templateName);
	    	Thread.sleep(2000);
			ql.Clickadd1().click();
//			Assert.assertTrue(ql.verifyAddMsg().isDisplayed(),"Template added successfully");
			Thread.sleep(2000);
			UsersListPage au=new UsersListPage(driver);
			Thread.sleep(2000);
			au.searchUser().sendKeys(templateName);
			Thread.sleep(2000);
			String actualText = ql.verifyCreatedQuestion(templateName).getText();
			Assert.assertEquals(actualText,templateName);
			Reporter.log("assertTrue",true);
	}
	
	@Test(priority=8,testName="I", enabled = false)
	public void existingquestionnairtemplate() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("existingquestionnairtemplate",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		
			FileLib f=new FileLib();
			String sectionName = f.getExcelData("QestiontionnairUpload",3, 6);
			String templateName = f.getExcelData("QestiontionnairUpload",1, 13);
			Thread.sleep(4000);
			ql.clickQuestionlib().click();
			 Thread.sleep(2000);
		     ql.clickNext().click();
	    	ql.Selectsection(sectionName).click();
	    	ql.ClickQtemplate().click();
	    	Thread.sleep(2000);
	    	ql.clickexistingnotpublishedtemplate().click();
	    	Thread.sleep(2000);
	    	ql.SelectQuestionnaireTemplate().click();
	    	Thread.sleep(2000);
	    	ql.SelectQTemplate(templateName).click();
	    	ql.addTemplate().click();
//	    	Assert.assertTrue(ql.verifyAddMsg().isDisplayed(),"Template added successfully");
	    	Thread.sleep(2000);
	    	UsersListPage au=new UsersListPage(driver);
			Thread.sleep(2000);
			au.searchUser().sendKeys(templateName);
			Thread.sleep(2000);
			String actualText = ql.verifyCreatedQuestion(templateName).getText();
			Assert.assertEquals(actualText,templateName);
			Reporter.log("assertTrue",true);
	    	
	}

	@Test(priority=9,testName="I", enabled = false)
	public void addnewquestionnairtemplate1() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("addnewquestionnairtemplate1",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String Addtemplatename= f.getExcelData("QestiontionnairUpload",1, 10);
		String sectionName = f.getExcelData("QestiontionnairUpload",3, 6);
		String vtemplatename= f.getExcelData("QestiontionnairUpload",1, 18);
			Thread.sleep(4000);
		    ql.clickQuestionlib().click();
	        //cancel
		    Thread.sleep(4000);
		     ql.clickNext().click();
		     Thread.sleep(4000);
	    	ql.Selectsection(sectionName).click();
	    	Thread.sleep(2000);
	    	ql.ClickQtemplate().click();
	    	Thread.sleep(2000);
			ql.addnewtemplate().click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById('newName').value='"+Addtemplatename+"'");
//			ql.Entertemplatename(Addtemplatename).sendKeys(Addtemplatename;
			ql.cancelTemplate().click();
			//add new tempalte
			ql.Selectsection(sectionName).click();
	    	Thread.sleep(2000);
	    	ql.ClickQtemplate().click();
	    	Thread.sleep(2000);
			ql.addnewtemplate().click();
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.moveToElement(ql.Entertemplatename(Addtemplatename)).click();
			act.sendKeys(Addtemplatename).perform();
//			ql.Entertemplatename(Addtemplatename).sendKeys(Addtemplatename;
			Thread.sleep(2000);
			ql.Clickadd1().click();
//			Assert.assertTrue(ql.verifyAddMsg().isDisplayed(),"Template added successfully");
			Thread.sleep(2000);
			UsersListPage au=new UsersListPage(driver);
			Thread.sleep(2000);
			au.searchUser().sendKeys(vtemplatename);
			Thread.sleep(2000);
			String actualText = ql.verifyCreatedQuestion(vtemplatename).getText();
			Assert.assertEquals(actualText,vtemplatename);
			Reporter.log("assertTrue",true);
			
			//duplicate
			Thread.sleep(2000);
			ql.Selectsection(sectionName).click();
	    	Thread.sleep(2000);
	    	ql.ClickQtemplate().click();
			ql.addnewtemplate().click();
			Thread.sleep(2000);	
			ql.Entertemplatename(Addtemplatename).sendKeys(Addtemplatename);
			ql.Clickadd1().click();
//			Assert.assertTrue(ql.verifywarningMsg().isDisplayed(),"Template already exist");
			Thread.sleep(4000);	
			ql.closeTemplate().click();
			ql.Questiontemplates().click();
			Thread.sleep(2000);
			String actualText1 = ql.verifyCreatedTemplate(Addtemplatename).getText();
			if(ql.verifySizeCreatedTemplate(Addtemplatename).size()>1) {
				Assert.fail("Duplicate templates are displayed");
			}else {
			Assert.assertEquals(actualText1,Addtemplatename);
			Reporter.log("assertTrue",true);
			}
	}
	    
        
	
	@Test(priority=10,testName="I", enabled = true)
	public void editQuestion() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("editQuestion",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		
		FileLib f=new FileLib();
		String sectionName = f.getExcelData("QestiontionnairUpload",3, 6);
		String frameworkName = f.getExcelData("QestiontionnairUpload",2, 12);
		String domainName = f.getExcelData("QestiontionnairUpload",2, 14);
		String controlName = f.getExcelData("QestiontionnairUpload",2, 15);
		String controlName1 = f.getExcelData("QestiontionnairUpload",3, 15);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
	     ql.clickNext().click();//Add search code instead of next
			ql.Clickonedit(sectionName).click();
			Thread.sleep(2000);
			ql.clickQLframework().click();
			Thread.sleep(2000);
			ql.selectframework2(frameworkName).click();
			Thread.sleep(2000);
			ql.clickQLframework().click();
	
			ql.clickQLdomain().click();
			ql.selectdomain2(domainName).click();
			Thread.sleep(2000);
			ql.clickQLdomain().click();
			
			ql.clickQLcontrol().click();
			ql.selectcontrol2(controlName).click();
			Thread.sleep(2000);
			ql.clickQLcontrol().click();
	
			ql.clickQLadd().click(); 
			
			//delete framework
			Thread.sleep(2000);
     		ql.deleteQuestion().click();
    		//edit framework
     		ql.clickQLframework().click();
			Thread.sleep(2000);
			ql.selectframework2(frameworkName).click();
			Thread.sleep(2000);
			ql.clickQLframework().click();
	
			ql.clickQLdomain().click();
			ql.selectdomain2(domainName).click();
			Thread.sleep(2000);
			ql.clickQLdomain().click();
			
			ql.clickQLcontrol().click();
			ql.selectcontrol2(controlName).click();
			Thread.sleep(2000);
			ql.clickQLcontrol().click();
	
			ql.clickQLadd().click(); 
			
			//edit
			ql.clickoneditquestion(frameworkName).click();
			Thread.sleep(2000);
			
			ql.clickdropdowncontrol().click();
			Thread.sleep(2000);
			ql.selectcontrol3(controlName1).click();
			ql.clickdropdowncontrol().click();
			
			Thread.sleep(2000);
			ql.clickQLadd().click(); 
			ql.clicksave().click();
//			Assert.assertTrue(ql.verifySaveMsg().isDisplayed(),"Question saved successfully");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Saved successfully.')]"));
			String elementText = (String) js.executeScript("return arguments[0].innerText;", element);
	    	Assert.assertTrue(elementText.contains("Saved successfully."));
			Thread.sleep(2000);
			
			//view icon-------------
			ql.clickview().click();
			Thread.sleep(2000);
			ql.clickoncancel1().click();
			Thread.sleep(2000);
		}
  

	

	@Test(priority=11,testName="I", enabled = true)
	public void AddQuestiontemplates() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("AddQuestiontemplates",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String template = f.getExcelData("QestiontionnairUpload",2, 13);
		String questions = f.getExcelData("QestiontionnairUpload",1, 16);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.Questiontemplates().click();
		Thread.sleep(2000);
//		boolean elementFound = false;
//        while (!elementFound) {
//	    try {
	    	//view
	    	
	    	ql.clickviewicon(template).click();
	    	Thread.sleep(2000);
	    	ql.Clickonplusicon().click();
	    	Thread.sleep(2000);
	    	ql.deletequestions(questions).click();
	    	Thread.sleep(2000);
	    	ql.clickoncancel1().click();
	    	Thread.sleep(2000);
	    	//delete
	    	ql.clickviewicon(template).click();
	    	Thread.sleep(2000);
	    	ql.Clickonplusicon().click();
	    	Thread.sleep(2000);
	    	ql.deletequestions(questions).click();
	    	Thread.sleep(2000);
	    	ql.clickonsave().click();
//	    	Assert.assertTrue(ql.verifyAddMsg().isDisplayed());
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Added successfully.')]"));
			String elementText = (String) js.executeScript("return arguments[0].innerText;", element);
	    	Assert.assertTrue(elementText.contains("Added successfully."));
	    	Thread.sleep(2000);
//             }
//	    catch (NoSuchElementException e) 
//	    {
//	    	ql.Clicknext().click();
//	    	Thread.sleep(2000);
//	    }
//	   }  
	} 



	@Test(priority=12,testName="I", enabled = true)
	public void Addclone() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Addclone",true);
		
//		FileLib f=new FileLib();
//		String Addclone= f.getExcelData("QestiontionnairUpload",1, 11);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String template = f.getExcelData("QestiontionnairUpload",1, 13);
	
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(4000);
		ql.Questiontemplates().click();
    	//cancel clone
    	ql.addclone(template).click();
    	Thread.sleep(2000);
    	ql.addclonetemname().sendKeys("added-clone");
    	Thread.sleep(2000);
    	ql.clonecancel().click();
    	Thread.sleep(2000);
    	
		
		//add clone
    	ql.addclone(template).click();
    	Thread.sleep(2000);
    	ql.addclonetemname().sendKeys("added-clone");
    	ql.clonesave().click();
//    	Assert.assertTrue(ql.verifyAddMsg().isDisplayed(),"Template cloned successfully");
    	Thread.sleep(2000);
		String actualText = ql.verifyCreatedTemplate("added-clone").getText();
		Assert.assertEquals(actualText,"added-clone");
		Reporter.log("assertTrue",true);
   // 	ql.clonecancel().click();
    	

	    	
	}  
	
	
	//publish questionaire template
	
	
	@Test(priority=13,testName="I",enabled= true)
	public void publishQuestiontemplate() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("publishQuestiontemplate",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		FileLib f=new FileLib();
		String template = f.getExcelData("QestiontionnairUpload",1, 13);
		String vendorCategory = f.getExcelData("QestiontionnairUpload",3, 3);
		String vendor = f.getExcelData("QestiontionnairUpload",2, 8);
		String status = f.getExcelData("QestiontionnairUpload",2, 17);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		ql.Questiontemplates().click();
		Thread.sleep(2000);
//		boolean elementFound = false;
//        while (!elementFound) {
//	    try {
	    	//add  vendorcategory
	    	ql.clickonpublish(template).click();
	    	Thread.sleep(2000);
	    	ql.selectvendorcategory().click();
	    	Thread.sleep(2000);
	    	ql.selectVCoption(vendorCategory);
	    	Thread.sleep(4000);
	    	
	    	//add vendor
	    	ql.selectvendor().click();
	    	Thread.sleep(2000);
	    	ql.selectvendoroption().click();
	    	ql.selectvendorname(vendor);
	    	Thread.sleep(2000);
	    	
	    	//cancel
	    	ql.publishcancel().click();
	    	Thread.sleep(2000);
	    //again add
	    	//add  vendorcategory
	    	ql.clickonpublish(template).click();
	    	Thread.sleep(2000);
	    	ql.selectvendorcategory().click();
	    	Thread.sleep(2000);
	    	ql.selectVCoption(vendorCategory);
	    	Thread.sleep(2000);
	    	
	    	//add vendor
	    	ql.selectvendor().click();
	    	Thread.sleep(2000);
	    	ql.selectvendoroption().click();
	    	ql.selectvendorname(vendor);
	    	Thread.sleep(2000);
	    	//save
	    	ql.publish().click();
//	    	Assert.assertTrue(ql.verifyPublishMsg().isDisplayed(),"Template published successfully");
	    	Thread.sleep(2000);
			Assert.assertTrue(ql.verifyTemplateStatus(template,status).getAttribute("textContent").contains(status));
			Reporter.log("assertTrue",true);
	    	
//             }
//	    catch (NoSuchElementException e) 
//	    {
//	    	ql.Clicknext().click();
//	    	Thread.sleep(2000);
//	    }
//	   }  
	} 
	
	@Test(priority=14,testName="I",enabled= true)
	public void searchSectionTemplateAndQuestion() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("searchSectionTemplateAndQuestion",true);

		questionnairLibraryandTemplatePage ql=new questionnairLibraryandTemplatePage(driver);
		UsersListPage au=new UsersListPage(driver);
		
		FileLib f=new FileLib();
		String validData = f.getExcelData("QestiontionnairUpload",4, 15);
		String invalidData = f.getExcelData("QestiontionnairUpload",1, 4);
		Thread.sleep(4000);
		ql.clickQuestionlib().click();
		Thread.sleep(2000);
		au.searchUser().sendKeys(validData);
		Thread.sleep(2000);
		if(ql.verify_QData().size()>0) {
			Assert.assertTrue(ql.verifyDataInQuestionnaire(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		au.searchUser().clear();
		Thread.sleep(2000);
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully in Questionnaire page");
		
		String validData1 = f.getExcelData("QestiontionnairUpload",3, 6);
		
		ql.clicksectionmanagement().click();
		Thread.sleep(2000);
		au.searchUser().sendKeys("Security One");
		Thread.sleep(2000);
		if(ql.verify_SData().size()>0) {
			Assert.assertTrue(ql.verifyDataInSectionPage("Security One").isDisplayed());
		}else {
			Assert.fail();
		}
		au.searchUser().clear();
		Thread.sleep(2000);
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully in section page");
		
		String validData2 = f.getExcelData("QestiontionnairUpload",1, 10);
		
		ql.qLibrary_clk().click();
		Thread.sleep(2000);
		ql.Questiontemplates().click();
    	Thread.sleep(2000);
    	ql.searchTemplate().sendKeys(validData2);
		Thread.sleep(2000);
		if(ql.verify_QData().size()>0) {
			Assert.assertTrue(ql.verifyDataInSectionPage(validData2).isDisplayed());
		}else {
			Assert.fail();
		}
		au.searchUser().clear();
		Thread.sleep(2000);
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully in template page");
	}
}
