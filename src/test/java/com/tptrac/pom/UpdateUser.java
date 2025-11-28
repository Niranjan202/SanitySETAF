package com.tptrac.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateUser {

	WebDriver driver;
	
	@FindBy(xpath="//td[contains(text(),'bhuban')]")
	private WebElement clickUsertoSelect;

	@FindBy(xpath="//input[@id='lastName2']")
	//@FindBy(css = "[data-automation-id='userMangement-017-edit-mNum-1']")
	private WebElement phoneNumberUpdate;

	//@FindBy(xpath="//button[contains(text(),'Save')]") //changed xpath
	//@FindBy(css = "[data-automation-id='userMangement-017-edit-Save-1']")
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement savebuttonClick;
	
	@FindBy(xpath="//input[@id='firstName']")
	//@FindBy(css = "[data-automation-id='userMangement-017-edit-firstName-1']")
	private WebElement editFirstName;

	@FindBy(xpath="//input[@id='lastName1']")
	private WebElement editLastName;
	
	public WebElement editLastName() {
		  return editLastName;
	  }

	public UpdateUser(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}

	  public WebElement ClickUsertoSelect(String user) {
		  WebElement clickUsertoSelect = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]"));
   	   	  return clickUsertoSelect;
      }


	  public WebElement phoneNumberUpdate() {
		  return phoneNumberUpdate;
	  }

	  public WebElement clickonSave() {
		  return savebuttonClick;
	  }

	  public WebElement editFirstName() {
   	   	  return editFirstName;
      }


}
