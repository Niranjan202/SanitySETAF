package com.tptrac.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VendorUploadPage {
	
	@FindBy(xpath="//a[normalize-space()='Upload']")
	private WebElement upload;
	
	@FindBy(css="a[href='/vendor-data-upload']")
	private WebElement clickVendor;
	
	@FindBy(css="input[value='Browse...']")
	private WebElement clickonBrowser;
	
	@FindBy(xpath="//button[normalize-space()='Upload']")
	private WebElement UploadButton;
	
//	@FindBy(xpath="//button[normalize-space()='OK']")
	//@FindBy(xpath="//button[contains(@class,'modalconfirmbutton') and contains(text(),'OK')]")
	@FindBy(xpath="//button[@class='alrt-btn'][normalize-space()='OK']")
	private WebElement ClickOk;
	
	//for No radio option
	@FindBy(xpath="//input[@value='0']")
	private WebElement NoRadio;
	
//	@FindBy(id="vendorCategory")
	@FindBy(xpath="//span[contains(text(),'Vendor Category')]")
	private WebElement selectvc;
	
	
	
	WebDriver driver;
	
	public VendorUploadPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
		 }
	
	public WebElement ClickonUpload()
	{
		return upload;
	}
	
	public WebElement ClickVendor()
	{
		return clickVendor;
	}
	
	
	@FindBy(xpath="//input[@id='UploadFile']")
	private WebElement selectfile;
	
	public WebElement FileSelect()
	{
		return selectfile;
	}
	
	public WebElement ClickonBrowser()
	{
		return clickonBrowser;
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
	
	public WebElement uploadDone()
	 {
		 return UploadButton;
	 }
	
	public WebElement alertOk()
	 {
		 return ClickOk;
	 }
	
	public WebElement SelectNo() 
	{
		return NoRadio;
	}
	
	public  WebElement selectvc()
	{
		Select obj = new Select(selectvc);
		obj.selectByIndex(1);
		return selectvc;
	}
	
	
	//@FindBy(xpath="//button[normalize-space()='Cancel' and contains(@class,'btn-cancel')]")
	@FindBy(xpath="//input[@value='0']")
	private WebElement uploadframeworkcancel;

	public WebElement uploadFilecancel()
	 {
		 return uploadframeworkcancel;
	 }

	@FindBy(xpath="//div[contains(text(),'Invalid file extension. Please attach file with \".xlsx\" extension only')]")
	private WebElement invalidextension;
	
	
	public WebElement invalidextension()
	 {
		 return invalidextension;
	 }
	
    @FindBy(xpath="//span[@class='noerror']")
	//@FindBy(xpath="//span[contains(text(),'No file chosen')]")
	private WebElement nofilechoosenerrormessage;
	
	
	public WebElement nofileChoosenerrormessage()
	 {
		 return nofilechoosenerrormessage;
	 }
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategory']/div")
	private WebElement clickvc;
	
	public  WebElement clickVCdropdown()
	{
		return clickvc;
	}
	
	public  WebElement selectVendorCategory(String category)
	{
		WebElement selectvc = driver.findElement(By.xpath("//div[contains(text(),'"+category+"')]"));
		return selectvc;
	}
	
	@FindBy(xpath="//a[normalize-space()='Framework-Questions']")
	private WebElement clickframeworkquestion;

    public WebElement  clickFrameworkquestion()
   {
	 return  clickframeworkquestion;
   }
    
    public WebElement frameworkUploadpass(String fileName, String status)
	 {
		WebElement frameworkuploadpass = driver.findElement(By.xpath("//label[contains(text(),'"+fileName+"')]/../..//td[contains(text(),'"+status+"')]"));
		 return frameworkuploadpass;
	 }
    
    public WebElement Uploadedfiledownload(String frameworkName)
	 {
		WebElement Uploadedfiledownload = driver.findElement(By.xpath("//label[contains(text(),'"+frameworkName+"')]/../following-sibling::td[3]//img[contains(@src,'download')]"));
		 return Uploadedfiledownload;
	 }
    
    //@FindBy(xpath="//span[contains(text(),'Please upload file with valid data')]")
    @FindBy(xpath="//span[contains(text(),'Invalid headers. Please upload a file with valid headers.')]")
	private WebElement invalidtext;
	
	
	public WebElement validateinvalidtext()
	 {
		 return invalidtext;
	 }
}
