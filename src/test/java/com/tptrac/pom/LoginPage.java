package com.tptrac.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="UserName")
	//@FindBy(css = "[data-automation-id='login-inp-username-05']")
	private WebElement untbx;

	@FindBy(id="password")
	//@FindBy(css = "[data-automation-id='login-inp-pswd-06']")
	private WebElement pwtbx;
	
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	private WebElement Dpclk;
	
	//@FindBy(xpath="//div[normalize-space()='Ujjivan']")
	//@FindBy(xpath="//div[normalize-space()='BSF']")
	@FindBy(xpath="//div[normalize-space()='BOB']")
	//@FindBy(xpath="//input[@type='checkbox' and @aria-label='Ujjivan']")
	private WebElement SelectV;

	@FindBy(xpath="//button[@id='logingSmt']")
	//@FindBy(css = "[data-automation-id='login-btn-07']")
	private WebElement lgBtn;
	
	public void tenantdropdown()
	{
		Dpclk.click();
	}
	
	public void SelectTenant()
	{
		SelectV.click();
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setLogin(String un,String pw) throws InterruptedException {
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		//Thread.sleep(4000);
		lgBtn.click();
	}


}



