package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentStatisticsPage {
	WebDriver driver;

	public AssessmentStatisticsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Assessment']")
	private WebElement ClickAssessment;

	public WebElement ClickAssessment()
	{
		return ClickAssessment;
	}
	
	//@FindBy(xpath="//a[normalize-space()='Assessment']/parent::li//tr[normalize-space()='Assessment Statistics']")
	@FindBy(xpath="//td[normalize-space()='Assessment Statistics']")
	private WebElement ClickAssessmentStatistics;
	
	public WebElement ClickAssessmentStatistics()
	{
		return ClickAssessmentStatistics;
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Download Report')]") private WebElement DownloadReport;
	public WebElement DownloadReport()
	{
		return DownloadReport;
	}
	
	@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Onboarding Status')]") 
	private WebElement OnBoradingStatusDropDown;
	
	public WebElement OnBoradingStatusDropDown()
	{
		return OnBoradingStatusDropDown;
	}
	
	
	@FindBy(xpath="//*[@placeholder='Onboarding Status']//input[@placeholder='Search']") private WebElement OnBoradingDropdownSearch;
	public WebElement OnBoradingDropdownSearch()
	{
		return OnBoradingDropdownSearch;
	}
	
//	@FindBy(xpath="//div[contains(text(),'Pre-Onboarding')]//parent::li//input") private WebElement SelectOnboardingStatus;
	public WebElement SelectOnboardingStatus(String onboardingStatus)
	{
		
		WebElement selectOnboardingStatus = driver.findElement(By.xpath("//div[contains(text(),'"+onboardingStatus+"')]/../input"));
		return selectOnboardingStatus;
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Vendor Category')]") private WebElement VendorCategoryDropDown;
	
	public WebElement VendorCategoryDropDown()
	{
		return VendorCategoryDropDown;
	}
	
	@FindBy(xpath="//*[@placeholder='Vendor Category']//input[@placeholder='Search']") private WebElement VendorcategorySearch;
	public WebElement VendorcategorySearch()
	{
		return VendorcategorySearch;
	}
	
//	@FindBy(xpath="(//*[@placeholder='Vendor Category']//input[@type='checkbox'])[2]") private WebElement SelectVendorCategory;
	public WebElement SelectVendorCategory(String vendorCategory)
	{
		WebElement selectVendorCategory = driver.findElement(By.xpath("//div[contains(text(),'"+vendorCategory+"')]/../input"));
		return selectVendorCategory;
	}
	
/////////////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath="//span[contains(text(),'Vendor')]") private WebElement VendorDropDown;
	public WebElement VendorDropDown()
	{
		return VendorDropDown;
	}	
	
	@FindBy(xpath="//span[contains(text(),'Vendor')]//ancestor::div[@class='multiselect-dropdown']//input[@type='text']") private WebElement VendorSearch;
	public WebElement VendorSearch()
	{
		return VendorSearch;
	}
	
//	@FindBy(xpath="//span[contains(text(),'Vendor')]//ancestor::div[@class='multiselect-dropdown']//input[@aria-label='multiselect-item']") private WebElement SelectVendor;
	public WebElement SelectVendor(String vendorName)
	{
		WebElement selectVendorName = driver.findElement(By.xpath("//div[contains(text(),'"+vendorName+"')]/../input"));
		return selectVendorName;
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////	
	@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment')]") private WebElement AssessmentDropDown;
	public WebElement AssessmentDropDown()
	{
		return AssessmentDropDown;
	}
	
	@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment')]//ancestor::div[@class='multiselect-dropdown']//input[@placeholder='Search']") private WebElement AssessmentSearch;
	public WebElement AssessmentSearch()
	{
		return AssessmentSearch;
	}
	
//	@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment')]//ancestor::div[@class='multiselect-dropdown']//input[@aria-label='multiselect-item']") private WebElement SelectAssessment;
	public WebElement SelectAssessment(String Assessment)
	{
		WebElement selectAssessment = driver.findElement(By.xpath("//div[contains(text(),'"+Assessment+"')]/../input"));
		return selectAssessment;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////	
	@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Onboarding Status')]/ancestor::div[@class='multiselect-dropdown']//input[@placeholder='Search']")
	private WebElement SearchonboardingStatus;
	
	public WebElement SearchonboardingStatus()
	{
		return SearchonboardingStatus;
	}
	
	public WebElement verifyAssessment(String vendor, String assessment)
	{
		WebElement selectAssessment = driver.findElement(By.xpath("//label[contains(text(),'"+vendor+"')]/../../following-sibling::td/label[contains(text(),'"+assessment+"')]"));
		return selectAssessment;
	}
	
	@FindBy(xpath="//input[@type='text' and contains(@class,'search')]")
	private WebElement search_txtbox;
	
	public WebElement clickSearchfield()
	{
		return search_txtbox;
	}
	
	@FindBy(xpath="//div[contains(text(),'No Data Found')]")
	private WebElement verify_noData;
	
	public WebElement verify_NoDataText()
	{
		return verify_noData;
	}
	
	@FindBy(xpath="//tbody[@class='membersector-name']//tr[contains(@class,'tracker-table-row')]")
	private List<WebElement> verify_Data;
	
	public List<WebElement> verify_Data()
	{
		return verify_Data;
	}
	
	
	public WebElement verify_VDataText(String vendor)
	{
		WebElement verify_VendorData = driver.findElement(By.xpath("//span[contains(text(),'"+vendor+"')]"));
		return verify_VendorData;
	}
}
