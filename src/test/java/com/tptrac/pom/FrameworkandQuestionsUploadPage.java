package com.tptrac.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tptrac.generic.FileLib;


public class FrameworkandQuestionsUploadPage {
	WebDriver driver;

	public FrameworkandQuestionsUploadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Clicking on Add New Framework Button
	
	@FindBy(xpath="//a[normalize-space()='Upload']")
	//@FindBy(css = "[data-automation-id='nav-011']")
	private WebElement upload;
	
	@FindBy(xpath="//input[@id='selectedFile']")
	private WebElement selectfile;
	
	public WebElement FileSelect()
	{
		return selectfile;
	}
	
	
	
	public WebElement ClickonUpload()
	{
		try {    // added code from 34-40
			Thread.sleep(4000);
		return upload;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	 
	
	@FindBy(xpath="//a[normalize-space()='Framework']")
	//@FindBy(css = "[data-automation-id='fm-upload-02']")
	private WebElement clickframework;
	
	public WebElement clickFramework()
	{
		return clickframework;
	}
	

	@FindBy(xpath="//span[@class='dropdown-btn']")
	//@FindBy(css = "[data-automation-id='fm-upload-010']")
	private WebElement dropdownframework;
	
	public WebElement dropdownFramework()
	{
		return dropdownframework;
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement search_field;
	
	public WebElement searchFramework()
	{
		return search_field;
	}

//	@FindBy(xpath="//div[text()='testing-1.0']")
//	private WebElement selectframework;
	
	public WebElement selectFramework(String framework)
	{
		WebElement selectframework = driver.findElement(By.xpath("//div[contains(text(),'"+framework+"')]"));
		return selectframework;
	}
	
	
	@FindBy(xpath="//div[text()='Framework New One-1.0']")
	private WebElement selectframework1;
	
	public WebElement selectFramework1()
	{
		return selectframework1;
	}
	
	
	@FindBy(css="input[value='Browse...']")
	private WebElement clickonBrowser;
	
	public WebElement ClickonBrowser()
	{
		return clickonBrowser;
	}
	
	@FindBy(xpath="//input[@id='selectedFile']") //added new code from 81 to 92
	private WebElement browse_btn;
	
	public void uploadBrowser() {
		try {
			File f = new File("\\SETAF\\src\\test\\resources\\data\\Questionnaire Upload Template.xlsx");
			String path = f.getAbsolutePath();
		browse_btn.sendKeys(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileSelectandupload() throws IOException
	{
		FileLib f=new FileLib();
		String path = f.getPropertyData("path1");
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
	
	//added new code from 144-152
	public void uploadInvalidFile() {
		try {
			File f = new File("\\SETAF\\src\\test\\resources\\data\\Partial Framework.pdf");
			String path = f.getAbsolutePath();
		browse_btn.sendKeys(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
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

	public void uploadblankFile() {
		try {
			File f = new File("\\SETAF\\src\\test\\resources\\data\\testblankupload.xlsx");
			String path = f.getAbsolutePath();
		browse_btn.sendKeys(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
		@FindBy(xpath="//button[normalize-space()='Upload Framework']")
		private WebElement uploadFramework;
		
	
		public WebElement uploadFramework()
		 {
			 return uploadFramework;
		 }
		
		
		@FindBy(xpath="//button[@class='btn btn-cancel ml-1']")
		//@FindBy(css = "[data-automation-id='fm-upload-014']")
		private WebElement uploadframeworkcancel;
	
		public WebElement uploadFrameworkcancel()
		 {
			 return uploadframeworkcancel;
		 }

	
	
	
		//assert for framework
		
		
		
		@FindBy(xpath="//span[contains(text(),'No')]")
		private WebElement nofilechoosenerrormessage1;
		
		
		public WebElement nofileChoosenerrormessage1()
		 {
			 return nofilechoosenerrormessage1;
		 }
			           
		@FindBy(xpath="//span[normalize-space()='No file chosen']")
		private WebElement nofilechoosenerrormessage;
		
		
		public WebElement nofileChoosenerrormessage()
		 {
			 return nofilechoosenerrormessage;
		 }
		
		
		
		//@FindBy(xpath="//div[text()='  is required']")
		@FindBy(xpath="//div[text()='  is required'] | //div[contains(text(),'is required')]")
		private WebElement frameworkrequirederrormessage;
		
		
		public WebElement frameworkRequiredErrormessage()
		 {
			 return frameworkrequirederrormessage;
		 }
		
		
//		@FindBy(xpath="(//span[contains(text(),\"Invalid file extension, Please upload only '.xls' \")])[1]")
		@FindBy(xpath="//div[contains(text(),'Invalid file extension. Please attach file with \".xlsx\" extension only')]")
		private WebElement invalidextension;
		
		
		public WebElement invalidextension()
		 {
			 return invalidextension;
		 }
		
//		@FindBy(xpath="//button[normalize-space()='OK']")
		//@FindBy(xpath="//button[contains(@class,'modalconfirmbutton') and contains(text(),'OK')]")
		@FindBy(xpath="//button[@class='alrt-btn'][normalize-space()='OK']")
		private WebElement Clickok;
		
		
		public WebElement Clickok()
		 {
			 return Clickok;
		 }
		
		               
		@FindBy(xpath="//span[text()='File uploaded successfully']")
		private WebElement successmessage;
		
		
		public WebElement successMessage()
		 {
			 return successmessage;
		 }

		

//		@FindBy(xpath="(//div[contains(text(),'Partial Framework.xlsx')])[1]/following::td[text()='Pass']")
//		private WebElement frameworkuploadpass;


		public WebElement frameworkUploadpass(String fileName, String status)
		 {
			WebElement frameworkuploadpass = driver.findElement(By.xpath("//label[contains(text(),'"+fileName+"')]/../..//td[contains(text(),'"+status+"')]"));
			 return frameworkuploadpass;
		 }
 
//		@FindBy(xpath="(//div[contains(text(),'Partial Framework.xlsx')])[1]/following::img[@class='d-inline-block align-middle cursor-pointer headicon']")
//		private WebElement Uploadedfiledownload;


		public WebElement Uploadedfiledownload(String fileName)
		 {
			WebElement Uploadedfiledownload = driver.findElement(By.xpath("//label[contains(text(),'"+fileName+"')]/../following-sibling::td[3]//img[contains(@src,'download')]"));
			 return Uploadedfiledownload;
		 }

		
		@FindBy(xpath="(//div[normalize-space()='testblankupload.xlsx'])[1]/following::td[text()='Fail']")
		private WebElement frameworkuploadfail;


		public WebElement frameworkUploadfail()
		{
		 return frameworkuploadfail;
		 }
		               
		@FindBy(xpath="(//div[normalize-space()='testblankupload.xlsx'])[1]/following::img[@class='d-inline-block align-middle cursor-pointer headicon']")
		private WebElement Uploadedblankfiledownload;

        public WebElement  UploadedBlankfiledownload()
	   {
		 return  Uploadedblankfiledownload;
	   }	
        @FindBy(xpath="(//div[contains(text(),'testblankupload.xlsx')])[1]/following::img[@class='d-inline-block align-middle cursor-pointer headicon']")
		private WebElement Uploadedblankfiledownloadfq;

        public WebElement  UploadedBlankfiledownloadfq()
	   {
		 return  Uploadedblankfiledownloadfq;
	   }	
        
       //frameworkquestions
        
      

		@FindBy(xpath="//a[normalize-space()='Framework-Questions']")
		//@FindBy(css = "[data-automation-id='fm-upload-03']")
		private WebElement clickframeworkquestion;

        public WebElement  clickFrameworkquestion()
	   {
		 return  clickframeworkquestion;
	   }	
        
        public void Frameworkquestionupload() throws IOException
    	{
    		FileLib f=new FileLib();
    		String path = f.getPropertyData("path4");
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
        
        //assert framework-question
   
        @FindBy(xpath="//div[normalize-space()='New test.xlsx']/following::td[contains(text(),'Added')]")
		private WebElement assertfqadded;

        public WebElement  assertFqadded()
	   {
		 return  assertfqadded;
	   }
        @FindBy(xpath="(//div[contains(text(),'New test.xlsx')])[1]/following::td[text()='Pass']")
		private WebElement frameworkquploadpass;


		public WebElement frameworkqUploadpass()
		 {
			 return frameworkquploadpass;
		 }

 
		@FindBy(xpath="(//div[contains(text(),'New test.xlsx')])[1]/following::img[@class='d-inline-block align-middle cursor-pointer headicon']")
		private WebElement UploadedfiledownloadFQ;


		public WebElement UploadedfiledownloadFQ()
		 {
			 return UploadedfiledownloadFQ;
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
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
		}
		
		@FindBy(xpath="//span[@class='dropdown-btn']")
		//@FindBy(css = "[data-automation-id='fm-quest-upload-09']")
		private WebElement dropdownframework1;
		
		public WebElement dropdownFramework1()
		{
			return dropdownframework1;
		}
		
		@FindBy(css = "[data-automation-id='fm-quest-upload-013']")
		private WebElement uploadframeworkcancel1;
	
		public WebElement uploadFrameworkcancel1()
		 {
			 return uploadframeworkcancel1;
		 }
		
		public WebElement failureMessage() {
		    return driver.findElement(By.xpath("//span[contains(text(),'Invalid')]")); // Adjust to match actual failure message text
		}

	
}