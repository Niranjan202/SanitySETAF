package com.tptrac.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VendorUpload {

	@FindBy(xpath="//a[normalize-space()='Upload']")
	private WebElement upload;

	@FindBy(css="a[href='/vendor-data-upload']")
	private WebElement clickVendor;

	@FindBy(css="input[value='Browse...']")
	private WebElement clickonBrowser;

	@FindBy(xpath="//button[normalize-space()='Upload']")
	private WebElement UploadButton;

	@FindBy(xpath="//button[normalize-space()='OK']")
	private WebElement ClickOk;

	//for No radio option
	@FindBy(xpath="(//input[@value='0'])[1]")
	private WebElement NoRadio;

	@FindBy(id="vendorCategory")
	private WebElement selectvc;





	public VendorUpload(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 }

	public WebElement ClickonUpload()
	{
		return upload;
	}

	public WebElement ClickVendor()
	{
		return clickVendor;
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




}
