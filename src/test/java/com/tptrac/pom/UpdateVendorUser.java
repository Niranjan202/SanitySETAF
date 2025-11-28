package com.tptrac.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateVendorUser {
	
	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Next page']")
	private WebElement NxtButton;

	 @FindBy(xpath="//label[contains(text(),'mo_bank_6@secureyesdev.com')]")
	 private WebElement actualVendorUserCreated;
	 
	 @FindBy(xpath="//input[@id='lastName2']")
	 private WebElement vendorPhNumUpdate;
	 
	 @FindBy(id="firstName")
	  private WebElement updatefname;
	 
	 @FindBy(id="lastName1")
	 private  WebElement updatelname;
	 
	 @FindBy(id="lastName3")
	  private WebElement updateemail;
	
	 @FindBy(xpath="//button[normalize-space()='Save']")
	 private WebElement savebuttonClick;
	 
	 @FindBy(xpath="//span[contains(text(),'Saved successfully.')]")
	 private WebElement validateSavemsg;
	 
	 
	 public UpdateVendorUser(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
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
		  
		  
		  public WebElement VendorphoneNumberUpdate() 
		  {
			  return vendorPhNumUpdate;
		  }
		  
		  public WebElement VendorFirstnameUpdate() 
		  {
			  return updatefname;
		  }
		  
		  public WebElement VendorLastnameUpdate() 
		  {
			  return updatelname;
		  }
		  
		  public WebElement VendorEmailUpdate() 
		  {
			  return updateemail;
		  }
		  
		  public WebElement clickonSave() {
			  return savebuttonClick;
		  }
		   
		   public WebElement verifySavedMsg() {
			   return validateSavemsg;
		  }
		   
		   @FindBy(xpath="//input[@class='form-control searchText float-right ml-2 mb-2 ng-untouched ng-pristine ng-valid'] ")
		   private WebElement vendorusersearch;
		   
		   public WebElement serachvendoruser() {
			   return vendorusersearch;
		   }
		   
	
}
