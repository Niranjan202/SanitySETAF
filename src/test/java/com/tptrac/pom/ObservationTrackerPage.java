package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class ObservationTrackerPage {
	
	
    WebDriver driver;

	public ObservationTrackerPage(WebDriver driver) 
	 {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	  }

	@FindBy(xpath="//div[contains(text(),'Download Report')]") private WebElement DownloadReport;
	public WebElement DownloadReport()
	{
		return DownloadReport;
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Assessment']")
	private WebElement ClickAssessment;

	public WebElement ClickAssessment()
	{
		return ClickAssessment;
	}
	
	@FindBy(xpath="//a[normalize-space()='Assessment']/parent::li//tr[normalize-space()='Observation Tracker']")
	//@FindBy(xpath="//td[normalize-space()='Observation Tracker']")
	private WebElement ObservationTracker ;
	
	public WebElement ObservationTracker()
	{
		return ObservationTracker;
	}
	
//onboarding status
@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Onboarding Status')]") private WebElement OnBoradingStatusDropDown;
public WebElement OnBoradingStatusDropDown()
{
return OnBoradingStatusDropDown;
}


@FindBy(xpath="//*[@placeholder='Onboarding Status']//input[@placeholder='Search']") private WebElement OnBoradingDropdownSearch;
public WebElement OnBoradingDropdownSearch()
{
return OnBoradingDropdownSearch;
}

@FindBy(xpath="//div[contains(text(),'Pre-Onboarding')]//parent::li//input") private WebElement SelectOnboardingStatus;
public WebElement SelectOnboardingStatus()
{
return SelectOnboardingStatus;
}

//
@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Vendor Category')]") private  WebElement VendorCategoryDropDown;

public WebElement VendorCategoryDropDown()
{
return VendorCategoryDropDown;
}

@FindBy(xpath="//*[@placeholder='Vendor Category']//input[@placeholder='Search']")  WebElement VendorcategorySearch;
public WebElement VendorcategorySearch()
{
return VendorcategorySearch;
}

@FindBy(xpath="(//*[@placeholder='Vendor Category']//input[@type='checkbox'])[2]")  WebElement SelectVendorCategory;
public WebElement SelectVendorCategory()
{
return SelectVendorCategory;
}

/////////////////////////////////////////////////////////////////////////////////////

@FindBy(xpath="//span[contains(text(),'Vendor')]") WebElement VendorDropDown;

public WebElement VendorDropDown()
{
return VendorDropDown;
}	

@FindBy(xpath="//span[contains(text(),'Vendor')]//ancestor::div[@class='multiselect-dropdown']//input[@type='text']") WebElement VendorSearch;
public WebElement VendorSearch()
{
return VendorSearch;
}

//@FindBy(xpath="//span[contains(text(),'Vendor')]//ancestor::div[@class='multiselect-dropdown']//input[@aria-label='multiselect-item']") WebElement SelectVendor;
@FindBy(xpath="//span[text()='Vendor']/../../following-sibling::div//input[@type='checkbox' and not(contains(@aria-label,'multiselect-select-all'))]/..//div") 
WebElement SelectVendor;

public WebElement SelectVendor()
{
return SelectVendor;
}

/////////////////////////////////////////////////////////////////////////////////////	


@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment Status')]") private WebElement AssessmentStatusDropDown;
public WebElement AssessmentStatusDropDown()
{
return AssessmentStatusDropDown;
}

@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment Status')]//ancestor::div[@class='multiselect-dropdown']//input[@placeholder='Search']") private WebElement AssessmentStatusSearch;
public WebElement AssessmentStatusSearch()
{
return AssessmentStatusSearch;
}

//@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment Status')]//ancestor::div[@class='multiselect-dropdown']//input[@aria-label='multiselect-item']") private WebElement SelectAssessmentStatus;
@FindBy(xpath="//span[text()='Assessment Status']/../../following-sibling::div//input[@type='checkbox' and not(contains(@aria-label,'multiselect-select-all'))]/..//div") private WebElement SelectAssessmentStatus;

public WebElement SelectAssessmentStatus()
{
return SelectAssessmentStatus;
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

//@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment')]//ancestor::div[@class='multiselect-dropdown']//input[@aria-label='multiselect-item']") private WebElement SelectAssessment;
@FindBy(xpath="//span[text()='Assessment']/../../following-sibling::div//input[@type='checkbox' and not(contains(@aria-label,'multiselect-select-all'))]/..//div") private WebElement SelectAssessment;

public WebElement SelectAssessment()
{
return SelectAssessment;
}

public WebElement verifyAssessmentData(String assessment,String status, String vendor)
{
	WebElement verifyAssessment = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../../..//td[contains(text(),'"+status+"')]/following-sibling::td//label[contains(text(),'"+vendor+"')]"));
	return verifyAssessment;
}

@FindBy(xpath="//tbody[@class='membersector-name']//tr[contains(@class,'tracker-table-row')]")
private List<WebElement> verify_Data;

public List<WebElement> verify_Data()
{
	return verify_Data;
}

@FindBy(xpath="//div[contains(text(),'Reset All')]") 
private WebElement clickReset;

public WebElement clickResetBtn()
{
return clickReset;
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

//@FindBy(xpath="//div//span[contains(text(),'Critical')]") 
@FindBy(xpath="//div[contains(text(),'Critical')]")
private WebElement FilterCritical ;

public WebElement FilterCritical()
{
return FilterCritical;
}

//@FindBy(xpath="//div//span[contains(text(),'High')]") 
@FindBy(xpath="//div[contains(text(),'High')]")
private WebElement FilterHigh ;

public WebElement FilterHigh()
{
return FilterHigh;
}

//@FindBy(xpath="//div//span[contains(text(),'Medium')]")
@FindBy(xpath="//div[contains(text(),'Medium')]")
private WebElement FilterMedium ;

public WebElement FilterMedium()
{
return FilterMedium;
}

public WebElement verifyAssessmentDatawithRisk(String assessment,String status, String vendor, String risk)
{
	WebElement verifyAssessment = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../../..//td[contains(text(),'"+status+"')]/following-sibling::td//label[contains(text(),'"+vendor+"')]/../following-sibling::td[contains(text(),'"+risk+"')]"));
	return verifyAssessment;
}

public WebElement verify_VDataText(String vendor)
{
	WebElement verify_VendorData = driver.findElement(By.xpath("//label[contains(text(),'"+vendor+"')]"));
	return verify_VendorData;
}
}
