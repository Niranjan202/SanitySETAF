package com.tptrac.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditTrailPage 
{
	WebDriver driver;

	public AuditTrailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Audit Trail']")
	private WebElement ClickAuditTrail;

	public WebElement audittrail()
	{
		return ClickAuditTrail;
	}
	
	
	//@FindBy(xpath="//button[normalize-space()='Export to Excel']")
	@FindBy(css=".btn.audit-trail-export-btn.exportToExcel")
	private WebElement exporttoexcel;
	
	public WebElement exporttoexcel()
	{
		return exporttoexcel;
	}
	
	@FindBy(xpath="//button[normalize-space()='Success']")
	private WebElement success;
	
	public WebElement ClickSuccess() 
	{
		return success;
	}
	

	@FindBy(css=".btn.failure-btn-default")
	private WebElement failure;
	
	public WebElement ClickFailure() 
	{
		return failure;
	}
	
	@FindBy(xpath="//button[normalize-space()='Reset']")
	private WebElement Reset;
	
	public WebElement ResetClick() {
		return Reset;
	}
	
	
}
