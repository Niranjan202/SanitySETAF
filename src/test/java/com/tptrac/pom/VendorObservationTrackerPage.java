package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorObservationTrackerPage {
	 WebDriver driver;
	public VendorObservationTrackerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Observation Tracker')]") private WebElement ClickVendorObservtaionTracker;
	public WebElement ClickVendorObservtaionTracker()
	{
		return ClickVendorObservtaionTracker;
	}

	@FindBy(xpath="//div[contains(text(),'Download Report')]") private WebElement DownloadReport;
	public WebElement DownloadReport()
	{
		return DownloadReport;
	}
	
////////////////////////////////////////////////////////////////////////////////
//BY top Filters

//@FindBy(xpath="//div//span[contains(text(),'Overdue')]") 
@FindBy(xpath="//div[contains(text(),'Overdue')]") 
private WebElement FilterOverdue ;

public WebElement FilterOverdue()
{
return FilterOverdue;
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

//@FindBy(xpath="//div//span[contains(text(),'Low')]") 
@FindBy(xpath="//div[contains(text(),'Low')]")
private WebElement FilterLow ;

public WebElement FilterLow()
{
return FilterLow;
}

///////////////////////////////////////////////////////////////////////////////////
//ResetAll
@FindBy(xpath="//div[contains(text(),'Reset All')]") private WebElement ResetAll;

public WebElement ResetAll()
{
return ResetAll;
}

///////////////////////////////////////////////////////////////////////////////////


@FindBy(xpath="//div[contains(text(),'Open')]")
private WebElement OpenFilter;

public WebElement OpenFilter()
{
return OpenFilter;
}		


@FindBy(xpath="(//div[contains(text(),'Closed')])[2]")
private WebElement CloseFilter;

public WebElement CloseFilter()
{
return CloseFilter;
}


@FindBy(xpath="//div[contains(text(),'Claim Closed')]")
private WebElement ClaimClosedFilter;

public WebElement ClaimClosedFilter()
{
return ClaimClosedFilter;
}


@FindBy(xpath="//div[contains(text(),'Waiver Request')]")
private WebElement WaiverRequestFilter;

public WebElement WaiverRequestFilter()
{
return WaiverRequestFilter;
}


@FindBy(xpath="//div[contains(text(),'Waiver Request Approved')]")
private WebElement WaiverRequestApproved;

public WebElement WaiverRequestApproved()
{
return WaiverRequestApproved;
}

@FindBy(xpath="//div[contains(text(),'Waiver Request Rejected')]") private WebElement WaiverRequestRejected;
public WebElement WaiverRequestRejected()
{
return WaiverRequestRejected;
}

//////////////////////////////////////////////////////////////////////////////

@FindBy(xpath="//div[contains(text(),'Extension Request Approved')]") private WebElement ExtensionRequestRejected;
public WebElement ExtensionRequestRejected()
{
return ExtensionRequestRejected;
}

@FindBy(xpath="//div[contains(text(),'Extension Request Rejected')]") private WebElement ExtensionRequestApproved;
public WebElement ExtensionRequestApproved()
{
return ExtensionRequestApproved;
}

@FindBy(xpath="//div[contains(text(),'Extension Request')]") private WebElement ExtensionRequest;
public WebElement ExtensionRequest()
{
return ExtensionRequest;
}

@FindBy(xpath="//div[contains(text(),'Claim Closed Rejected')]") private WebElement ClaimClosedRejected;
public WebElement ClaimClosedRejected()
{
return ClaimClosedRejected;
}

public WebElement verifyAssessmentData(String assessment,String obs, String risk)
{
	WebElement verifyAssessment = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../following-sibling::td//label[contains(text(),'"+obs+"')]/../..//td[contains(text(),'"+risk+"')]"));
	return verifyAssessment;
}

public WebElement verifyAssessmentDatawithStatus(String assessment,String obs, String risk, String status)
{
	WebElement verifyAssessment = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../following-sibling::td//label[contains(text(),'"+obs+"')]/../..//td[contains(text(),'"+risk+"')]/..//td[contains(text(),'"+status+"')]"));
	return verifyAssessment;
}

@FindBy(xpath="//td[contains(@class,'text-left')]/..")
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

@FindBy(xpath="//div[contains(text(),'No Data Found')]")
private WebElement verify_noData;

public WebElement verify_NoDataText()
{
	return verify_noData;
}

@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment')]") 
private WebElement AssessmentDropDown;

public WebElement AssessmentDropDown()
{
return AssessmentDropDown;
}

@FindBy(xpath="//div[@class='multiselect-dropdown']//span[contains(text(),'Assessment')]//ancestor::div[@class='multiselect-dropdown']//input[@placeholder='Search']") 
private WebElement AssessmentSearch;

public WebElement AssessmentSearch()
{
return AssessmentSearch;
}

public WebElement SelectAssessment(String Assessment)
{
	WebElement selectAssessment = driver.findElement(By.xpath("//div[contains(text(),'"+Assessment+"')]/../input"));
	return selectAssessment;
}


@FindBy(xpath="//div[@class='mr-0']//input[@type='text' and @placeholder=\"Search\"]")
private WebElement search_txtbox;

public WebElement clickSearchfield()
{
	return search_txtbox;
}

public WebElement verify_VDataText(String assessment)
{
	WebElement verifyAssessment = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]"));
	return verifyAssessment;
}
}

