package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorreportsPage {
	WebDriver driver;
	public VendorreportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Reports')]") 
	private WebElement clickReports;
	
	public WebElement clickVReports()
	{
		return clickReports;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='selectedAssessmentYear']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Clickyear;
	
	public WebElement Clickyear()
	{
		return Clickyear;
	}
	
	public WebElement selectYear(String SelectYear)
	{
		WebElement selectYear = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='selectedAssessmentYear']//div[contains(text(),'"+SelectYear+"')]"));
		return selectYear;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentQuarter']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickquarter;
	
	public WebElement clickquarter()
	{
		return clickquarter;
	}
	
	
	public WebElement selectquarter(String selectQuarter)
	{
		WebElement selectquarter = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='assessmentQuarter']//div[contains(text(),'"+selectQuarter+"')]"));
		return selectquarter;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickassessmentstatus;
	
	public WebElement clickassessmentstatus()
	{
		return clickassessmentstatus;
	}
	
	
	public WebElement selectassessmentstatus(String status)
	{
		WebElement selectassessmentstatus = driver.findElement(By.xpath("//div[normalize-space()='"+status+"']"));
		return selectassessmentstatus;
	}
	
	public WebElement selectFrmework(String framework)
	{
		WebElement selectFrmework = driver.findElement(By.xpath("//span[contains(text(),'"+framework+"')]//input[@id='rd1']"));
		return selectFrmework;
	}
	
	public WebElement verifyVendor(String vendor)
	{
		WebElement vendorName = driver.findElement(By.xpath("//h5[text()='Report']/../following-sibling::div//td[contains(text(),'"+vendor+"')]"));
		return vendorName;	
	}
	
	@FindBy(xpath="//div[contains(@class,'exportbtn excelbtn')]")
	private WebElement exporttoexcel;
	
	public WebElement exporttoexcel()
	{
		return exporttoexcel;
	}
	
	@FindBy(xpath="//div[contains(@class,'exportbtn pdfbtn')]")
	private WebElement exporttopdf;
	
	public WebElement exporttopdf()
	{
		return exporttopdf;
	}
	
	@FindBy(xpath="//h5[contains(text(),'Action Not Allowed')]/../following-sibling::div//h3")
	private WebElement pfderrormessage;
	
	public WebElement pfderrormessage()
	{
		return pfderrormessage;
	}
	
	@FindBy(xpath="//h5[contains(text(),'Action Not Allowed')]/../following-sibling::div//button[normalize-space()='OK']")
	private WebElement clickOK;
	
	public WebElement clickOK()
	{
		return clickOK;
	}
	
	@FindBy(xpath="//th[contains(text(),'Frameworks')]/../../../../../following-sibling::div//button[contains(text(),'Reset')]")
	private WebElement fReset_btn;
	
	public WebElement clickFReset()
	{
		return fReset_btn;	
	}
	
	public WebElement selectTemplate(String template)
	{
		WebElement selecttemplate = driver.findElement(By.xpath("//div[contains(text(),'"+template+"')]/..//input[@type='checkbox']"));
		return selecttemplate;
	}
	
	public WebElement verifyVendorAndtemplate(String vendor, String template)
	{
		WebElement verifyData = driver.findElement(By.xpath("//td[contains(text(),'"+vendor+"')]/..//td[contains(text(),'"+template+"')]"));
		return verifyData;	
	}
	
	@FindBy(xpath="//th[contains(text(),'Frameworks')]/../../../../../..//input[@placeholder='Search' and @id]")
	private WebElement search_txtbox;
	
	public WebElement clickSearchfield()
	{
		return search_txtbox;
	}
	
//	@FindBy(xpath="//tbody//tr[contains(@class,'active')]")
	@FindBy(xpath="//th[contains(text(),'Frameworks')]/../../..//tbody//tr")
	private List<WebElement> verify_Data;
	
	public List<WebElement> verify_FData()
	{
		return verify_Data;
	}
	
	@FindBy(xpath="//th[contains(text(),'Questionnaire Template')]/../../..//tbody//tr")
	private List<WebElement> verify_QData;
	
	public List<WebElement> verify_QData()
	{
		return verify_QData;
	}
	
//	@FindBy(xpath="//p[contains(text(),'No Data Found')]")
	@FindBy(xpath="//p[contains(text(),'No Record Found')]")
	private WebElement verify_noData;
	
	public WebElement verify_NoDataText()
	{
		return verify_noData;
	}
	
//	@FindBy(xpath="(//input[@placeholder='Search' and @id])[last()]")
//	@FindBy(xpath="//input[@placeholder='Search' and @id and not(contains(@class,'dirty')) and contains(@class,'untouched')]")
	@FindBy(xpath="//th[contains(text(),'Questionnaire')]/../../../../../..//input[@placeholder='Search' and @id]")
	private WebElement Qsearch_txtbox;
	
	public WebElement clickQSearchfield()
	{
		return Qsearch_txtbox;
	}
	
	public WebElement verifyFrmeworkData(String framework)
	{
		WebElement verifyFrmework = driver.findElement(By.xpath("//span[contains(text(),'"+framework+"')]"));
		return verifyFrmework;
	}
	
	public WebElement verifyTemplateData(String template)
	{
		WebElement verifytemplate = driver.findElement(By.xpath("//div[contains(text(),'"+template+"')]"));
		return verifytemplate;
	}
}
