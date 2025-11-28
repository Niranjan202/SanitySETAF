package com.tptrac.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tptrac.generic.FileLib;

public class questionnairLibraryandTemplatePage 
{
	WebDriver driver;
	
	public questionnairLibraryandTemplatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[normalize-space()='Upload']")
	private WebElement upload;
	
	public WebElement ClickonUpload()
	{
		return upload;
	}
	
	
	//@FindBy(xpath="//a[normalize-space()='Questionnaire']")
	@FindBy(xpath="//a[normalize-space()='Assessment Questionnaire']")
	private WebElement clickQuestionnaire;
	
	public WebElement ClickQuestionnaire()
	{
		return clickQuestionnaire;
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategoryType']")
	private WebElement clickvendorcategory;
	
	public WebElement clickvendorcategory()
	{
		return clickvendorcategory;
	}
	
	
		@FindBy(xpath="//span[contains(text(),'Select vendor type')]")
		private WebElement clickvendorType;
		
		public WebElement clickVendorType()
		{
			return clickvendorType;
		}
	
	
	   
	
	   @FindBy(xpath="//span[contains(text(),'Select vendor association type')]")
	   private WebElement ClickVendorAssociateType;
	  
	   public WebElement clickvendorassociatetype() {
			return ClickVendorAssociateType ;
		}
	   
	               
	   @FindBy(xpath="//ng-multiselect-dropdown[@id='vendorAssociationType']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	   private WebElement ClickVendorAssociateType1;
	  
	   public WebElement clickvendorassociatetype1() {
			return ClickVendorAssociateType1 ;
		}

//	   @FindBy(xpath="//div[normalize-space()='IT Category']")
//	   private WebElement selectItcategory;
	  
	   public WebElement selectItCategory(String category) {
		   WebElement selectItcategory = driver.findElement(By.xpath("//div[normalize-space()='"+category+"']"));
			return selectItcategory ;
		}
	   
//	   @FindBy(xpath="//div[normalize-space()='Type 1']")
//	   private WebElement selecttype1;
	  
	   public WebElement selectType1(String type) {
		   WebElement selectType = driver.findElement(By.xpath("//div[normalize-space()='"+type+"']"));		   
			return selectType ;
		}


	 
//	   @FindBy(xpath="//div[normalize-space()='Association type 1']")
//	   private WebElement selectAssociationtype1;
	  
	   public WebElement selectAssociationType1(String aType) {
		   WebElement selectAType = driver.findElement(By.xpath("//div[normalize-space()='"+aType+"']"));		   	   
			return selectAType ;
		}
		   
		@FindBy(xpath="//ng-multiselect-dropdown[@id='vendor']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement selectVendor;
		
		public WebElement SelectVendor()
		{
			return selectVendor;
		}
		
//		@FindBy(xpath="//div[normalize-space()='Santosh Verma']")
//		private WebElement selectVendorOP;
		
		public WebElement selectVendorOP(String vendor)
		{
			WebElement selectVendorOP = driver.findElement(By.xpath("//div[contains(text(),'"+vendor+"')]"));
			return selectVendorOP;
		}
		
		@FindBy(xpath="//input[@id='UploadFile']")
		private WebElement selectfile;
		
		public WebElement FileSelect()
		{
			return selectfile;
		}
		
		
		
		@FindBy(css="input[value='Browse...']")
		private WebElement clickonBrowser;
		
		public WebElement ClickonBrowser()
		{
			return clickonBrowser;
		}
		
		public void fileSelectandupload() throws IOException
		{
			FileLib f=new FileLib();
			String path = f.getPropertyData("path5");
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
			Robot rb= null;
			try {
				rb = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		
		public void InvalidfileSelectandupload() throws IOException
		{
			FileLib f=new FileLib();
			String path = f.getPropertyData("path2");
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Robot rb= null;
			try {
				rb = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}

		public void blankfileupload() throws IOException
		{
			FileLib f=new FileLib();
			String path = f.getPropertyData("path3");
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Robot rb= null;
			try {
				rb = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		
		public void SectionUpload() throws IOException
		{
			FileLib f=new FileLib();
			String path = f.getPropertyData("path6");
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
			Robot rb= null;
			try {
				rb = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		
		public void SectionwithoutUpload() throws IOException
		{
			FileLib f=new FileLib();
			String path = f.getPropertyData("path7");
			StringSelection ss = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
			Robot rb= null;
			try {
				rb = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		
//		@FindBy(xpath="//button[normalize-space()='Cancel']")
		@FindBy(xpath="//button[normalize-space()='Cancel' and not(contains(@class,'btn-login'))]")
		private WebElement clickcancel;
		
		public WebElement clickCancel()
		{
			return clickcancel;
		}
		
		@FindBy(xpath="//button[normalize-space()='OK']")
		private WebElement Clickok;
		
		
		public WebElement Clickok()
		 {
			 return Clickok;
		 }
		
		@FindBy(xpath="//button[normalize-space()='Upload to Library']")
		private WebElement uploadlibrary;
		
		public WebElement uploadLibrary()
		{
			return uploadlibrary;
		}
		
		@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorType']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement clickvendortype1;
		
		public WebElement clickvendortype1()
		{
			return clickvendortype1;
		}
		
		
		
	//questionlibrary
		
		@FindBy(xpath="//a[normalize-space()='Questionnaire Library']")
		private WebElement clickquestionlib;
		
		public WebElement clickQuestionlib()
		{
			return clickquestionlib;
		}
		
		@FindBy(xpath="//button[normalize-space()='Section Management']")
		private WebElement clicksectionmanagement;
		
		public WebElement clicksectionmanagement()
		{
			return clicksectionmanagement;
		}
		
		//@FindBy(xpath="//button[normalize-space()='+ Add New Section']")
		@FindBy(xpath="//button[normalize-space()='Add New Section']")
		private WebElement clickaddnewsection;
		
		public WebElement clickaddnewsection()
		{
			return clickaddnewsection;
		}
		
		
		@FindBy(xpath="//div[@class='modal-body modalheight']//input[@id='nameID']")
		private WebElement addsectionname;
		
		public WebElement addSectionname()
		{
			return addsectionname;
		}
		
		
		

		@FindBy(xpath="//div[@class='modal-body modalheight']//input[@id='codeID']")
		private WebElement addsectioncode;
		
		public WebElement addSectioncode()
		{
			return addsectioncode;
		}
		
		@FindBy(xpath="//button[text()=' Add ']")
		private WebElement clickadd;
		
		public WebElement clickadd()
		{
			return clickadd;
		}
		
		@FindBy(xpath="//button[contains(text(),'Add')]/..//button[contains(text(),'Cancel')]")
		private WebElement clickCancel;
		
		public WebElement clickancel()
		{
			return clickCancel;
		}
		
		
		
		
		@FindBy(id="nameID")
		private WebElement updatesectionname;
		
		public WebElement updateSectionname()
		{
			return updatesectionname;
		}
		
		
		@FindBy(id="codeID")
		private WebElement updatesectioncode;
		
		public WebElement updateSectioncode()
		{
			return updatesectioncode;
		}
		
		@FindBy(xpath="//button[normalize-space()='Save']")
		private WebElement updatesave;
		
		public WebElement updatesave()
		{
			return updatesave;
		}
		
//		@FindBy(xpath="//td[normalize-space()='updatesection']/following::img[@alt='delete']")
//		private WebElement clickdelete;
		
		public WebElement clickdelete(String sectionName)
		{
			WebElement clickdelete = driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following::img[@alt='delete']"));
			return clickdelete;
		}
		
		
	
		
		@FindBy(xpath="//td[normalize-space()='testsection']")
		private WebElement clicksectionname;
		
		public WebElement clickSectionname()
		{
			return clicksectionname;
		}
		
		@FindBy(xpath="//td[normalize-space()='testsection1']")
		private WebElement clicksectionname1;
		
		public WebElement clickSectionname1()
		{
			return clicksectionname1;
		}
		
		@FindBy(xpath="//span[contains(text(),'Do you still want to delete?')]/../../../../following-sibling::div//button[contains(text(),'Yes')]")
		private WebElement deleteyes;
		
		public WebElement deleteyes()
		{
			return deleteyes;
		}
		
		@FindBy(xpath="//div[@class='modal-body2 deletemodalbody']//button[@class='modalbuttoncancel'][normalize-space()='No']")
		private WebElement deleteno;
		
		public WebElement deleteno()
		{
			return deleteno;
		}
		
		@FindBy(xpath="//span[contains(text(),'Saved successfully.')]")
		private WebElement savesuccessfullyassert;
		
		public WebElement saveSuccessfullyassert()
		{
			return savesuccessfullyassert;
		}
		
		@FindBy(xpath="//span[contains(text(),'Added successfully.')]")
		private WebElement addsuccessfullyassert;
		
		public WebElement addSuccessfullyassert()
		{
			return addsuccessfullyassert;
		}
		
		
		@FindBy(xpath="//span[contains(text(),'Deleted successfully.')]")
		private WebElement deleteassert;
		
		public WebElement deleteassert()
		{
			return deleteassert;
		}
		
		
		@FindBy(xpath="//span[contains(text(),'Questionnaire Section already exists')]")
		private WebElement alreadyexitassert;
		
		public WebElement alreadyExitassert()
		{
			return alreadyexitassert;
		}
		
		@FindBy(xpath="//div[text()='Section Name is required']")
		private WebElement assertsectionname;
		
		public WebElement assertsectionname()
		{
			return assertsectionname;
		}
		
		@FindBy(xpath="//div[text()='Section Code is required']")
		private WebElement assertsectioncode;
		
		public WebElement assertsectioncode()
		{
			return assertsectioncode;
		}
		
	
		
		@FindBy(xpath="//div[contains(text(),'Vendor Category is required')]")
		private WebElement assertvcrequired;
		
		public WebElement assertvcrequired()
		{
			return assertvcrequired;
		}
		
		
		
		@FindBy(xpath="//div[contains(text(),'Vendor is required')]")
		private WebElement assertvrequired;
		
		public WebElement assertvrequired()
		{
			return assertvrequired;
		}
		
		@FindBy(xpath="//span[@class='noerror']")
		private WebElement assertnofile;
		
		public WebElement assertNofile()
		{
			return assertnofile;
		}
		
		
		@FindBy(xpath="//span[normalize-space()='Please enter valid data in excel']")
		private WebElement assertentervaliddata;
		
		public WebElement assertentervaliddata()
		{
			return assertentervaliddata;
		}
		
		
		@FindBy(xpath="//button[normalize-space()='OK']")
		private WebElement clickok;
		
		public WebElement clickok()
		{
			return clickok;
		}
		
		
		@FindBy(xpath="//div[@class='error']")
		private WebElement assertinvalidextension;
		
		public WebElement assertInvalidextension()
		{
			return assertinvalidextension;
		}
		
		
				@FindBy(xpath="(//div[@class='txtoverflow'][normalize-space()='Questionnaire Upload Template.xlsx'])[1]/following::td[contains(text(),'Pass')]")
				private WebElement assertpass;
				
				public WebElement assertPass()
				{
					return assertpass;
				}
				
				//@FindBy(xpath="//span[normalize-space()='File uploaded successfully']")
				@FindBy(xpath="//span[normalize-space()='File uploaded successfully with row data = 5']")
				private WebElement assertSuccess;
				
				public WebElement assertSuccess()
				{
					return assertSuccess;
				}
				
				//SECTION UPLOAD
				
				
				
				@FindBy(xpath="//label[normalize-space()='Section']")
				private WebElement clicksection;
				
				public WebElement clickSection()
				{
					return clicksection;
				}
				
				
				@FindBy(xpath="//input[@value='1']")
				private WebElement clicksectionyes;
				
				public WebElement clicksectionyes()
				{
					return clicksectionyes;
				}
				
				@FindBy(xpath="//input[@value='0']")
				private WebElement clicksectionNo;
				
				public WebElement clickSectionNo()
				{
					return clicksectionNo;
				}
				
				@FindBy(xpath="//span[@class='dropdown-btn']")
				private WebElement clicksectiondropdown;
				
				public WebElement clicksectiondropdown()
				{
					return clicksectiondropdown;
				}
				
				
//				@FindBy(xpath="//div[normalize-space()='sectionname']")
//				private WebElement selectsectiondropdown;
				
				public WebElement selectsectiondropdown(String section)
				{
					WebElement selectsectiondropdown = driver.findElement(By.xpath("//div[normalize-space()='"+section+"']"));
					return selectsectiondropdown;
				}
				
				
				
				@FindBy(xpath="//button[normalize-space()='Add Question']")
				private WebElement clickaddquestions;
				
				public WebElement clickaddquestions()
				{
					return clickaddquestions;
				}
				
				//QUESTION
				
				
				@FindBy(xpath="//ng-multiselect-dropdown[@id='section']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement clickquessection;
				
				public WebElement clickQLsection()
				{
					return clickquessection;
				}
				
				
		//		@FindBy(xpath="//div[text()='New section for Automation']")
		//		private WebElement clickaddsectionname;
				
				public WebElement clickQLaddsectionname(String sectionName)
				{
					WebElement clickaddsectionname = driver.findElement(By.xpath("//div[contains(text(),'"+sectionName+"')]"));
					return clickaddsectionname;
				}
				
				@FindBy(xpath="//textarea[@id='question']")
				private WebElement clickaddquestion;
				
				public WebElement clickQLaddquestion()
				{
					return clickaddquestion;
				}
				
				@FindBy(xpath="//ng-multiselect-dropdown[@id='framework']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement clickframework;
				
				public WebElement clickQLframework()
				{
					return clickframework;
				}
				
//				@FindBy(xpath="//div[normalize-space()='TPTrac partial Framework']")
//				private WebElement selectframework;
				
				public WebElement selectQLframework(String framework)
				{
					WebElement selectframework = driver.findElement(By.xpath("//div[contains(text(),'"+framework+"')]"));
					return selectframework;
				}
				              
				@FindBy(xpath="//ng-multiselect-dropdown[@id='domain']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement clickdomain;
				
				public WebElement clickQLdomain()
				{
					return clickdomain;
				}
				
//				@FindBy(xpath="//div[normalize-space()='Access Control (A)']")
//				private WebElement selectdomain;
				
				public WebElement selectQLdomain(String domain)
				{
					WebElement selectdomain = driver.findElement(By.xpath("//div[normalize-space()='"+domain+"']"));
					return selectdomain;
				}
				

				
				           
				@FindBy(xpath="//ng-multiselect-dropdown[@id='control']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement clickcontrol;
				
				public WebElement clickQLcontrol()
				{
					return clickcontrol;
				}
				
//				@FindBy(xpath="//div[contains(text(),'Does your organization have a formal (documented, ')]")
//				private WebElement selectcontrol;
				
				public WebElement selectQLcontrol(String control)
				{
					WebElement selectcontrol = driver.findElement(By.xpath("//div[contains(text(),'"+control+"')]"));
					return selectcontrol;
				}
				
				@FindBy(xpath="//span[contains(text(),'Add')]")
				private WebElement clickaddq;
				
				public WebElement clickQLadd()
				{
					return clickaddq;
				}
				
//				@FindBy(xpath="//td[normalize-space()='TPTrac partial Framework']/following::img[@class='d-inline-block align-middle cursor-pointer']")
//				private WebElement clickeditframework;
				
				public WebElement clickQLeditframework(String framework)
				{
					WebElement clickeditframework = driver.findElement(By.xpath("//td[contains(text(),'"+framework+"')]/following::img[contains(@src,'edit')]"));
					return clickeditframework;
				}
				
//				@FindBy(xpath="//td[normalize-space()='TPTrac partial Framework']/following::img[@src='assets/images/icon-delete.svg']")
//				private WebElement clickdeleteframework;

				public WebElement clickQLdeleteframework(String framework)
				{
					WebElement clickdeleteframework = driver.findElement(By.xpath("//td[contains(text(),'"+framework+"')]/following::img[contains(@src,'delete')]"));
					return clickdeleteframework;
				}
				
				@FindBy(xpath="//button[normalize-space()='Save']")
				private WebElement clicksaveframework;

				public WebElement clickQLsaveframework()
				{
					return clicksaveframework;
				}

				@FindBy(xpath="//button[@id='question-dismiss']")
				private WebElement clickcancelframework;

				public WebElement clickQLcancelframework()
				{
					return clickcancelframework;
				}

				
//				@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategoryType']//div[contains(text(),'IT Category')]")
//				private WebElement selectQLvendorcategory;

				public WebElement selectQLvVendorcategory(String category)
				{
					WebElement selectQLvendorcategory = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorCategoryType']//div[contains(text(),'"+category+"')]"));
					return selectQLvendorcategory;
				}

				
				
				
//				@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorType']//div[contains(text(),'Type 1')]")
//				private WebElement selectQLvendortype;

				public WebElement selectQLVendortype(String vendorType)
				{
					WebElement selectQLvendortype = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorType']//div[contains(text(),'"+vendorType+"')]"));
					return selectQLvendortype;
				}

				
				
				
//				@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorAssociationType']//div[contains(text(),'Association type 1')]")
//				private WebElement selectQLvendorassociate;

				public WebElement selectQLVendorassociate(String type)
				{
					WebElement selectQLvendorassociate = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorAssociationType']//div[contains(text(),'"+type+"')]"));
					return selectQLvendorassociate;
				}
				
				
				
				@FindBy(xpath="//div[normalize-space()='Second Party Data Processing (B)']")
				private WebElement updateQLdomain;

				public WebElement updateQLdomain()
				{
					return updateQLdomain;
				}
				

				@FindBy(xpath="//div[contains(text(),'access to Ujjivan')]")
				private WebElement updateQLcontrol;

				public WebElement updateQLcontrol()
				{
					return updateQLcontrol;
				}
				
				
				//questionnair library home page
				
				
				@FindBy(xpath="//span[normalize-space()='question 25th april']/following::img[@class='d-inline-block align-middle cursor-pointer']")
				private WebElement editquestion;

				public WebElement editQuestion()
				{
					return editquestion;
				}
				
				
				@FindBy(xpath="//a[@aria-label='Next page']")
				private WebElement clicknextpage;

				public WebElement clickNextpage()
				{
					return clicknextpage;
				}
				
//add tempalete
				
				
				
				@FindBy(xpath="//a[@aria-label='Next page']")
				private WebElement clicknext;

				public WebElement Clicknext()
				{
					return clicknext;
				}
				
				
				
				@FindBy(xpath="//button[normalize-space()='Add to Questionnaire Template']")
				private WebElement clickQtemplate;

				public WebElement ClickQtemplate()
				{
					return clickQtemplate;
				}
				
			
				@FindBy(xpath="//input[@id='rd2']")
				private WebElement addnewtemplate;

				public WebElement addnewtemplate()
				{
					return addnewtemplate;
				}
				
				
				@FindBy(xpath="//input[@id='newName']")
				private WebElement entertemplatename;

				public WebElement Entertemplatename(String name)
				{
					return entertemplatename;
				}
				
				
				@FindBy(xpath="//button[normalize-space()='Add']")
				private WebElement clickadd1;

				public WebElement Clickadd1()
				{
					return clickadd1;
				}
				
//				@FindBy(xpath="//td[@class='position-relative'][normalize-space()='New section for Automation']/following::img[@class='d-inline-block align-middle cursor-pointer']")
//				private WebElement clickonedit;

				public WebElement Clickonedit(String sectionName)
				{
					WebElement clickonedit = driver.findElement(By.xpath("//label[contains(text(),'"+sectionName+"')]/../following-sibling::td//img[@title='Edit']"));
					return clickonedit;
				}
				
				

//				@FindBy(xpath="//div[normalize-space()='Cyber Security Framework']")
//				private WebElement selectframework2;

				public WebElement selectframework2(String framework)
				{
					WebElement selectframework2 = driver.findElement(By.xpath("//div[contains(text(),'"+framework+"')]"));
					return selectframework2;
				}
				

//				@FindBy(xpath="//div[normalize-space()='Preventing execution of unauthorised software (2)']")
//				private WebElement selectdomain2;

				public WebElement selectdomain2(String domain)
				{
					WebElement selectdomain2 = driver.findElement(By.xpath("//div[normalize-space()='"+domain+"']"));
					return selectdomain2;
				}
			

//				@FindBy(xpath="//div[contains(text(),'Organization shall maintain an up-to-date inventor')]")
//				private WebElement selectcontrol2;

				public WebElement selectcontrol2(String control)
				{
					WebElement selectcontrol2 = driver.findElement(By.xpath("//div[contains(text(),'"+control+"')]"));
					return selectcontrol2;
				}
				

				@FindBy(xpath="//button[normalize-space()='Save']")
				private WebElement clicksave;

				public WebElement clicksave()
				{
					return clicksave;
				}
				
			
				//add question template
				
//				@FindBy(xpath="(//td[contains(text(),'New section for Automation')])[last()]/..//input[@type='checkbox']")
//				private WebElement selectsection;
				
				@FindBy(xpath="//li[@class='pagination-next ng-star-inserted']//a[@class='ng-star-inserted']")
				private WebElement clickNext;
				
				public WebElement clickNext()
				{
					return clickNext;
				} 

				public WebElement Selectsection(String sectionName)
				{
					WebElement selectsection = driver.findElement(By.xpath("//label[contains(text(),'"+sectionName+"')]/../..//input[@type='checkbox']"));
					return selectsection;
				}
				
				@FindBy(xpath="//input[@id='rd1']")
				private WebElement clickexistingnotpublishedtemplate;

				public WebElement clickexistingnotpublishedtemplate()
				{
					return clickexistingnotpublishedtemplate;
				}
				
				             
				@FindBy(xpath="//ng-multiselect-dropdown[@id='exstTemplateName']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement SelectQuestionnaireTemplate;

				public WebElement SelectQuestionnaireTemplate()
				{
					return SelectQuestionnaireTemplate;
				}
				
				
//				@FindBy(xpath="//ng-multiselect-dropdown[@id='exstTemplateName']//div[contains(text(),'test template 19th jun')]")
//				private WebElement SelectQTemplate;

				public WebElement SelectQTemplate(String templateName)
				{
					WebElement SelectQTemplate = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='exstTemplateName']//div[contains(text(),'"+templateName+"')]"));
					return SelectQTemplate;
				}
				
				
				@FindBy(id="template-dismiss")
				private WebElement cancelTemplate;

				public WebElement cancelTemplate()
				{
					return cancelTemplate;
				}
				
				//button[@class='close']
				@FindBy(xpath="//label[contains(text(),'Questionnaire Template Name')]/../../../../../following-sibling::div//button[contains(text(),'Cancel')]")
				private WebElement closeTemplate;

				public WebElement closeTemplate()
				{
					return closeTemplate;
				}
				
				@FindBy(xpath="//button[normalize-space()='Add']")
				private WebElement addTemplate;

				public WebElement addTemplate()
				{
					return addTemplate;
				}
				
				
				@FindBy(xpath="//label[contains(text(),'New section for Automation')]/following::img[@title='View']")
				private WebElement clickview;

				public WebElement clickview()
				{
					return clickview;
				}	
				
				
				@FindBy(xpath="//div[normalize-space()='Section']")
				private WebElement ViewQuestion;

				public WebElement ViewQuestion()
				{
					return ViewQuestion;
			
				}	
				
				@FindBy(xpath="//img[@src='assets/images/icon-delete.svg']")
				private WebElement deleteQuestion;

				public WebElement deleteQuestion()
				{
					return deleteQuestion;
			
				}	
				
//				@FindBy(xpath="//td[contains(text(),'Organization shall maintain an up-to-date inventor')]/following::img[@class='d-inline-block align-middle cursor-pointer']")
//				private WebElement clickoneditquestion;

				public WebElement clickoneditquestion(String framework)
				{
					WebElement clickoneditquestion = driver.findElement(By.xpath("//td[contains(text(),'"+framework+"')]/following::img[contains(@src,'edit')]"));
					return clickoneditquestion;
			
				}	
				
				
				@FindBy(xpath="//ng-multiselect-dropdown[@id='control']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement clickdropdowncontrol;

				public WebElement clickdropdowncontrol()
				{
					return clickdropdowncontrol;
			
				}
				
//				@FindBy(xpath="//div[contains(text(),'Organization shall have controls in place to restr')]")
//				private WebElement selectcontrol3;

				public WebElement selectcontrol3(String control)
				{
					WebElement selectcontrol3 = driver.findElement(By.xpath("//div[contains(text(),'"+control+"')]"));
					return selectcontrol3;
				}
				
				@FindBy(xpath="//button[normalize-space()='Questionnaire Templates']")
				private WebElement Questiontemplates;
				
				public WebElement Questiontemplates()
				{
					return Questiontemplates;
				}
				
				
				
//				@FindBy(xpath="//td[normalize-space()='test template 19th jun']/following::img[@class='d-inline-block align-middle cursor-pointer headicon mr-2']")
//				private WebElement clickviewicon;
				
				public WebElement clickviewicon(String templateName)
				{
					WebElement clickviewicon = driver.findElement(By.xpath("//td[contains(text(),'"+templateName+"')]/..//img[@title='View']"));
					return clickviewicon;
				}
				
				@FindBy(xpath="//a[@class='btn btn-header-link collapsed']")
				private WebElement clickonplusicon;
				
				public WebElement Clickonplusicon()
				{
					return clickonplusicon;
				}
				
//				@FindBy(xpath="//td[text()='Question -1 for Automation']/following::img")
//				private WebElement deletequestions;
				
				public WebElement deletequestions(String question)
				{
					WebElement deletequestions = driver.findElement(By.xpath("(//div[contains(text(),'"+question+"')])[2]/../following-sibling::td//img[contains(@src,'delete')]"));
					return deletequestions;
				}
				
				@FindBy(id="view-dismiss")
				private WebElement clickoncancel1;
				
				public WebElement clickoncancel1()
				{
					return clickoncancel1;
				}
				
//				@FindBy(xpath="//div[@class='modal-dialog modal-lg modal-dialog-centered']//button[@type='button'][normalize-space()='Save']")
				@FindBy(xpath="//div[@id='viewModal']//button[@type='button'][normalize-space()='Save']")
				private WebElement clickonsave;
				
				public WebElement clickonsave()
				{
					return clickonsave;
				}
				
				
//				@FindBy(xpath="//td[normalize-space()='New template--1']/following::img[@data-target='#cloneModal']")
//				private WebElement addclone;
				
				public WebElement addclone(String templateName)
				{
					WebElement addclone = driver.findElement(By.xpath("//td[normalize-space()='"+templateName+"']/..//span[contains(text(),'Not Published')]/../following-sibling::td//img[@title='Clone']"));
					return addclone;
				}
				
				@FindBy(id="cloneTemplateName")
				private WebElement addclonetemname;
				
				public WebElement addclonetemname()
				{
					return addclonetemname;
				}
				
				@FindBy(id="clone-dismiss")
				private WebElement clonecancel;
				
				public WebElement clonecancel()
				{
					return clonecancel;
				}
				@FindBy(xpath="//div[@class='modal-dialog modal-lg modal-dialog-centered addtemplate']//button[@type='button'][normalize-space()='Save']")
				private WebElement clonesave;
				
				public WebElement clonesave()
				{
					return clonesave;
				}
				
			
//				@FindBy(xpath="//td[normalize-space()='New template--1']/following::span[text()='Publish ']")
//				private WebElement clickonpublish;
				
				public WebElement clickonpublish(String templateName)
				{
					WebElement clickonpublish = driver.findElement(By.xpath("//td[normalize-space()='"+templateName+"']/..//span[@data-bs-backdrop='static' and contains(text(),'Publish')]"));
					return clickonpublish;
				}
				
				
				@FindBy(xpath="//ng-multiselect-dropdown[@id='selectedPublishVendorCategory']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement selectvendorcategory;
				
				public WebElement selectvendorcategory()
				{
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", selectvendorcategory);
					return selectvendorcategory;
				}
				
				
//				@FindBy(xpath="//ng-multiselect-dropdown[@id='selectedPublishVendorCategory']//div[contains(text(),'HR Category')]")
//				private WebElement selectVCoption;
				
				public WebElement selectVCoption(String category)
				{
					WebElement selectVCoption = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='selectedPublishVendorCategory']//div[contains(text(),'"+category+"')]/.."));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", selectVCoption);
					return selectVCoption;
				}
				
				@FindBy(xpath="//input[@id='rd2']")
				private WebElement selectvendor;
				
				public WebElement selectvendor()
				{
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", selectvendor);
					return selectvendor;
				}
				
				@FindBy(xpath="//ng-multiselect-dropdown[@id='selectedPublishVendor']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
				private WebElement selectvendoroption;
				
				public WebElement selectvendoroption()
				{
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", selectvendoroption);
					return selectvendoroption;
				}
				
//				@FindBy(xpath="//div[normalize-space()='vendor 3rd']")
//				private WebElement selectvendorname;
				
				public WebElement selectvendorname(String name)
				{
					WebElement selectvendorname = driver.findElement(By.xpath("//span[contains(text(),'Select vendor')]/../../following-sibling::div//div[normalize-space()='"+name+"']/.."));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", selectvendorname);
					return selectvendorname;
				}
				
				@FindBy(xpath="//button[normalize-space()='Publish']")
				private WebElement clickpublish;
				
				public WebElement publish()
				{
					return clickpublish;
				}
				
				@FindBy(id="publish-dismiss")
				private WebElement publishcancel;
				
				public WebElement publishcancel()
				{
//					JavascriptExecutor executor = (JavascriptExecutor)driver;
//					executor.executeScript("arguments[0].click();", publishcancel);
					return publishcancel;
				}
				
				public WebElement verifyCreatedSection(String sectionName)
				{
					WebElement verifySectionName = driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]"));
					return verifySectionName;
				}
				
				@FindBy(xpath="//span[contains(text(),'Questionnaire Section already exists')]")
				private WebElement warningMsgforDuplicate;
				
				public WebElement verifyWarningMesForDuplicateSectionName()
				{
					return warningMsgforDuplicate;
				}
				
				@FindBy(xpath="//span[contains(text(),'Added successfully.')]")
				 private WebElement validateAddmsg;
				
				public WebElement verifyAddMsg() {
					   return validateAddmsg;
				  }
				
				
				@FindBy(xpath="//span[contains(text(),'Questionnaire Template Name Already Exists')]")
				 private WebElement validateWarningmsg;
				
				public WebElement verifywarningMsg() {
					   return validateWarningmsg;
				  }
				
				@FindBy(xpath="//span[contains(text(),'Saved successfully.')]")
				 private WebElement validatesavemsg;
				
				public WebElement verifySaveMsg() {
					   return validatesavemsg;
				  }
				
				@FindBy(xpath="//span[contains(text(),'Template published successfully')]")
				 private WebElement validatepublishmsg;
				
				public WebElement verifyPublishMsg() {
					   return validatepublishmsg;
				  }
				
				public void uploadFile()
				{
					Robot rb= null;
					try {
						rb = new Robot();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rb.delay(3000);
					rb.keyPress(KeyEvent.VK_CONTROL);
					rb.keyPress(KeyEvent.VK_V);
					
					rb.keyRelease(KeyEvent.VK_CONTROL);
					rb.keyRelease(KeyEvent.VK_V);
					rb.delay(2000);
					
					rb.keyPress(KeyEvent.VK_ENTER);
					rb.keyRelease(KeyEvent.VK_ENTER);
					
				}
				
				//@FindBy(xpath="//span[contains(text(),'Please upload file with valid data')]")
				@FindBy(xpath="//span[contains(text(),'File Data can not be empty on row no. = 2')]")
				private WebElement invalidtext;
				
				
				public WebElement validateinvalidtext()
				 {
					 return invalidtext;
				 }
				
				public WebElement quetionnaireUploadpass(String fileName, String status)
				 {
					WebElement frameworkuploadpass = driver.findElement(By.xpath("//td[contains(text(),'"+fileName+"')]/../..//td[contains(text(),'"+status+"')]"));
					 return frameworkuploadpass;
				 }
				
				public WebElement Uploadedfiledownload(String frameworkName)
				 {
					WebElement Uploadedfiledownload = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/..//td//img[contains(@src,'download')]"));
					 return Uploadedfiledownload;
				 }
				
				@FindBy(xpath="//td[contains(text(),'No Data Found')]")
				private WebElement verify_noData;
				
				public WebElement verify_NoDataText()
				{
					return verify_noData;
				}
				
				public WebElement verifyDataInQuestionnaire(String question)
				{
					WebElement verifyQuestionnaire = driver.findElement(By.xpath("//label[contains(text(),'"+question+"')]"));
					return verifyQuestionnaire;
				}
				
				@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr[contains(@class,'library-table')]")
				private List<WebElement> verify_QData;
				
				public List<WebElement> verify_QData()
				{
					return verify_QData;
				}
				
				@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr")
				private List<WebElement> verify_SData;
				
				public List<WebElement> verify_SData()
				{
					return verify_SData;
				}
				
				public WebElement verifyDataInSectionPage(String section)
				{
					WebElement verifySection = driver.findElement(By.xpath("//td[contains(text(),'"+section+"')]"));
					return verifySection;
				}
				
				@FindBy(xpath="//button[contains(text(),'Questionnaire Library')]")
				private WebElement clk_QLibrary;
				
				public WebElement qLibrary_clk()
				{
					return clk_QLibrary;
				}
				
				@FindBy(xpath="//div[@class='mr-0']//input[@placeholder='Search' and contains(@class,'search')]")
				 private WebElement search_field;
					
				public WebElement searchTemplate()
				{
					return search_field;
				}
				
				@FindBy(xpath="//table//tbody//tr")
				private List<WebElement> verify_Data;
				
				public List<WebElement> verify_Data()
				{
					return verify_Data;
				}
				
				public WebElement verifyCreatedQuestion(String quesName)
				{
					WebElement verifySectionName = driver.findElement(By.xpath("//label[contains(text(),'"+quesName+"')]"));
					return verifySectionName;
				}
				
				
				public WebElement verifyCreatedTemplate(String quesName)
				{
					WebElement verifySectionName = driver.findElement(By.xpath("//td[contains(text(),'"+quesName+"')]"));
					return verifySectionName;
				}
				
				public List<WebElement> verifySizeCreatedTemplate(String quesName)
				{
					List<WebElement> verifySectionName = driver.findElements(By.xpath("//td[contains(text(),'"+quesName+"')]"));
					return verifySectionName;
				}
				
				public WebElement verifyTemplateStatus(String tName, String status)
				{
					WebElement verifyStatus = driver.findElement(By.xpath("//td[contains(text(),'"+tName+"')]/..//span[contains(text(),'"+status+"')]"));
					return verifyStatus;
				}
				
				public void selectSectionForUpload(String sectionName)
				{
					for(int i=1; i<=5; i++) {
					WebElement selectsection = driver.findElement(By.xpath("(//label[contains(text(),'"+sectionName+"')]/../..//input[@type='checkbox'])["+i+"]"));
					selectsection.click();
					}
				}
				
				//search section
				
				@FindBy(xpath="//input[@placeholder='Search' and contains(@class,'form')]") 
				 private WebElement search;
					
				public WebElement searchsection()
				{
					return search;
				}
				
				
				
				@FindBy(xpath="//input[@class='form-control-plaintext fldcolor tblfilter searchText ng-untouched ng-pristine ng-valid']")
				private WebElement uploadsearch;
				
				public WebElement UploadSearch() 
				{
					return uploadsearch;
				}
				
				@FindBy(xpath="//input[contains(@class, 'form-control') and contains(@class, 'tblfilter') and contains(@class, 'searchText')]")
				private WebElement Qsearch;
				
				public WebElement QuestionSearch()
				
				{
					return Qsearch;
				}
				
				@FindBy(css = "[data-automation-id='question-section-2']")
				private WebElement QusLibBtn;

				public WebElement QusLibBtn() {
					return QusLibBtn;

				}
				
				
}
