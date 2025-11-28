package com.tptrac.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteUser {

	WebDriver driver; //created global variable

	@FindBy(xpath="//td[contains(text(),'bhuban')]")
	private WebElement clickUsertoSelect;

	@FindBy(xpath="//tr[@class='ng-star-inserted']//img[@alt='Delete']")
	//@FindBy(css="tr[class='active'] img[alt='Delete']")
	private WebElement clickUsertoDelete;

	//@FindBy(xpath="//div[@class='modal-body2 deletemodalbody']//button[@class='modalconfirmbutton'][normalize-space()='Yes']")
	@FindBy(xpath="//div[@class='ng-star-inserted']//button[@class='alrt-btn'][normalize-space()='Yes']")
	private WebElement Delete;


	public DeleteUser(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;  // newly added line

	}

       public WebElement ClickUsertoSelect(String user) {
    	   WebElement clickUsertoSelect = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]"));
    	   return clickUsertoSelect;
       }


		public WebElement ClickUserDeleteButton(String userId) {

			WebElement deleteUser = driver.findElement(By.xpath("//td[contains(text(),'"+userId+"')]/..//a[@id='delete']"));
			return deleteUser;

		}

		public WebElement clickonYesButton() {
			return Delete;
		}
}


