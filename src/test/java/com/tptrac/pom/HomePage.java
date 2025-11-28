package com.tptrac.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tptrac.generic.BaseClass1;

public class HomePage {
	
	BaseClass1 b = new BaseClass1();
	
	             
	//@FindBy(xpath="//a[@role='button']")
	
//	@FindBy(xpath="/html/body/app-root/app-default/app-dashboard/div/div[1]/app-navbar/nav/div/ul/li[11]/a/img")
	@FindBy(xpath="//a[@data-bs-toggle='dropdown' and contains(@class,'nav-link')]//img")
	private WebElement userName;
	
	@FindBy(xpath="//td[normalize-space()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	private WebElement YesBtn;
	
	@FindBy(xpath="//a[normalize-space()='Users']")
	private WebElement Users;
	
	@FindBy(xpath="//a[normalize-space()='Vendor']")
	private WebElement Vendor;
	
//	@FindBy(xpath="//a[normalize-space()='Dashboard']")
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	private WebElement dashboardMenu;
	
	@FindBy(xpath="//a[normalize-space()='Frameworks']")
	private WebElement FrameworkMenu;
	
	/**21-06-2023**/
	@FindBy(xpath="//a[normalize-space()='Assessment']")
	private WebElement Assessment;
	
	@FindBy(xpath="//td[contains(text(),'Assessment Calendar')]")
	private WebElement AssessmentCalendar;
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getDashboardMenu() {
		return dashboardMenu;
	}

	public void setLogout() throws InterruptedException 
	{
		Thread.sleep(5000);
		dashboardMenu.click();
		Thread.sleep(5000);
		userName.click();
		Thread.sleep(5000);
		Logout.click();
		Thread.sleep(5000);
		YesBtn.click();
		Thread.sleep(6000);
		
	}
	

	public void setUserMenu() throws InterruptedException {
		Thread.sleep(3000);		
		Users.click();
	}
	public void setVendorMenu() throws InterruptedException
	{
		Thread.sleep(3000);
		Vendor.click();
	}
	
	public void setFrameworkMenu() throws InterruptedException
	{
	Thread.sleep(3000);
	FrameworkMenu.click();
	}
	
	public void setAssessmentMenu() throws InterruptedException {
		Thread.sleep(3000);
		Assessment.click();
	}
	
	public void setAssessmentSubMenu() throws InterruptedException {
		Thread.sleep(3000);
		AssessmentCalendar.click();
	}
	
	//@FindBy(xpath="//img[@class='filter-white']")
	@FindBy(xpath="(//img[contains(@src,'logout')])[last()]")
	private WebElement VClicklogout;
	
	public WebElement VClicklogout() throws InterruptedException
	{
		Thread.sleep(3000);
		return VClicklogout;
	}
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	private WebElement VClicklogoutok;
	
	public WebElement VClicklogoutok()
	{
		return VClicklogoutok;
	}
	
	@FindBy(xpath="//span[text()='×']")
	private WebElement clickclose;
	
	public WebElement clickclose()
	{
		return clickclose;
	}
	
	@FindBy(xpath="//td[contains(text(),'Logout')]")
	private WebElement VClicklogoutbtn;
	
	public WebElement VClicklogoutbtn()
	{
		return VClicklogoutbtn;
	}
}

	
	










