package com.tptrac.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteVendorUser {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@aria-label='Next page']")
	private WebElement NxtButton;

	 @FindBy(xpath="//label[contains(text(),'mo_bank_6@secureyesdev.com')]")
	 private WebElement actualVendorUserCreated;
	 
	 @FindBy(xpath="//label[contains(text(),'mo_bank_6@secureyesdev.com')]/../following-sibling::td[3]//img[@alt='Delete']")
	 private WebElement clickVendorUsertoDelete;
	 
	 @FindBy(xpath="//app-alert//div[contains(@class,'delete-container')]//button[contains(text(),'Yes') and @class='alrt-btn']")
		private WebElement DeleteVendorUser;
	 
	 @FindBy(xpath="//span[contains(text(),'Deleted successfully.')]")
	 private WebElement validateDeletemsg;
	 
	 public DeleteVendorUser(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
			
		}
	 
	 	public WebElement ClikOnNextButton() 
	 	{
	 		return NxtButton;
	 	}
		
		  public WebElement ClickVendorUsertoSelect(String user) 
		  {
			  WebElement actualVendorUserCreated = driver.findElement(By.xpath("//label[contains(text(),'"+user+"')]"));
	   	   	  return actualVendorUserCreated;
	      }
		  
		  public WebElement selectVendorUserDeleteButton(String user) {
			  WebElement clickVendorUsertoDelete = driver.findElement(By.xpath("//label[contains(text(),'"+user+"')]/../following-sibling::td[3]//img[@alt='Delete']"));
			  return clickVendorUsertoDelete;
			
			}
		  
		  public WebElement clickonYesButton() {
				return DeleteVendorUser;
			}
		  
		  public WebElement verifyDeleteMsg() {
			   return validateDeletemsg;
		  }

}
