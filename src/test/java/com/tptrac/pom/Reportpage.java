package com.tptrac.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reportpage {

	WebDriver driver;
	
	public Reportpage(WebDriver driver) {
		PageFactory.initElements(driver, this); 
		this.driver = driver;
	}

	@FindBy(xpath="//a[normalize-space()='Reports']")
	private WebElement clickonReport;
	
	public WebElement clickonReport()
	{
		return clickonReport;
	}

	@FindBy(xpath="//td[normalize-space()='General Reports']")
	private WebElement clickonGeneralReport;
	
	public WebElement clickonGeneralReport()
	{
		return clickonGeneralReport;
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategory']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")              
	private WebElement clickvendorcategory;
	
	public WebElement clickvendorcategory()
	{
		return clickvendorcategory; 
	}
	
	//@FindBy(xpath="//div[normalize-space()='IT Category']")
//	@FindBy(xpath="//div[contains(text(),'IT Category')]")
//	private WebElement selectvendorcategory;
	
	public WebElement selectvendorcategory(String category)
	{
		WebElement selectvendorcategory = driver.findElement(By.xpath("//div[normalize-space()='"+category+"']"));
		return selectvendorcategory;
	}
	

	@FindBy(xpath="//span[@class='slider round']")
	private WebElement selectpreonboard;
	
	public WebElement selectpreonboard()
	{
		return selectpreonboard;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickvendorstatus;
	
	public WebElement clickvendorstatus()
	{
		return clickvendorstatus;
	}
	
//	@FindBy(xpath="//div[normalize-space()='Being Assessed']")
//	private WebElement selectvendorstatusdropdown;
	
	public WebElement selectvendorstatusdropdown(String status)
	{
		WebElement selectvendorstatusdropdown = driver.findElement(By.xpath("//div[normalize-space()='"+status+"']"));
		return selectvendorstatusdropdown;
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendor']")
	//@FindBy(xpath="//label[normalize-space()='Vendor']")
	private WebElement clickvendor;
	
	public WebElement clickvendor()
	{
		return clickvendor;
	}

//	@FindBy(xpath="//div[contains(text(),'BSNL')]")
//	private WebElement selectvendordropdown;
	
	public WebElement selectvendordropdown(String name)
	{
		WebElement selectvendordropdown = driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]"));
		return selectvendordropdown;
	}
	

	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentYear']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Clickyear;
	
	public WebElement Clickyear()
	{
		return Clickyear;
	}
	

//	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentYear']//div[contains(text(),'Select All')]")
//	private WebElement selectYear;
	
	public WebElement selectYear(String SelectYear)
	{
		WebElement selectYear = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='assessmentYear']//div[contains(text(),'"+SelectYear+"')]"));
		return selectYear;
	}
	
	

	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentQuarter']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickquarter;
	
	public WebElement clickquarter()
	{
		return clickquarter;
	}
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentQuarter']//div[contains(text(),'Select All')]")
//	private WebElement selectquarter;
	
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
	
//	@FindBy(xpath="//div[normalize-space()='Select All']")
//	private WebElement selectassessmentstatus;
	
	public WebElement selectassessmentstatus(String status)
	{
		WebElement selectassessmentstatus = driver.findElement(By.xpath("//div[normalize-space()='"+status+"']"));
		return selectassessmentstatus;
	}
	
//	@FindBy(xpath="//input[@id='rd1']")
//	private WebElement selectFrmework;
	
	public WebElement selectFrmework(String framework)
	{
		WebElement selectFrmework = driver.findElement(By.xpath("//span[contains(text(),'"+framework+"')]//input[@id='rd1']"));
		return selectFrmework;
	}
	
	//@FindBy(xpath="//div[@class='exportbtn excelbtn']")
	@FindBy(xpath="//div[@class='exportbtn excelbtn exportToExcel me-3 mr-2']")
	private WebElement exporttoexcel;
	
	public WebElement exporttoexcel()
	{
		return exporttoexcel;
	}
	
	//@FindBy(xpath="//div[@class='exportbtn pdfbtn']")
	@FindBy(xpath="//div[@class='exportbtn pdfbtn me-3 mr-2']")
	private WebElement exporttopdf;
	
	public WebElement exporttopdf()
	{
		return exporttopdf;
	}
	
	
	//@FindBy(xpath="//h6[contains(text(),'Action Not Allowed')]/../following-sibling::div//span[@class='alrt-msg']")
	//private WebElement pfderrormessage;
	
	//public WebElement pfderrormessage()
	//{
		//return pfderrormessage;
	//}

	
	//@FindBy(xpath="//h6[contains(text(),'Action Not Allowed')]/../following-sibling::div//button[normalize-space()='OK']")
	//private WebElement clickOK;
	
	//public WebElement clickOK()
	//{
		//return clickOK;
	//}
	
	
	@FindBy(xpath="//img[@src='assets/images/icon-report-menu.svg']")
	private WebElement clickpdfmenu;
	
	public WebElement clickpdfmenu()
	{
	    return clickpdfmenu;
	}
	
	

	@FindBy(xpath="//div[@class='position-absolute menubox']")
	private WebElement selectmenu;
	
	public WebElement selectmenu()
	{
		return selectmenu;
	}
	
	
	@FindBy(xpath="//img[@class='d-inline-block align-top']")
	private WebElement disableoption;
	
	public WebElement disableoption ()
	{
		return disableoption;
	}
	
	
	//Framework
	
	@FindBy(xpath="//div[normalize-space()='Framework']")
	private WebElement clickonframework;
	
	public WebElement clickonframework()
	{
		return clickonframework;
	}
	
			
	@FindBy(xpath="//ng-multiselect-dropdown[@id='framework']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement selecttheframework;
	
	public WebElement selecttheframework()
	{
		return selecttheframework;
	}
			
	//@FindBy(xpath="//div[normalize-space()='CS Framework']")
//	@FindBy(xpath="//div[contains(text(),'CS Framework')]")
//	private WebElement frameworkdropdown;
	
	public WebElement frameworkdropdown(String name)
	{
		WebElement frameworkdropdown = driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]"));
		return frameworkdropdown;
	}
			
	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Fassessmentstatus;
	
	public WebElement Fassessmentstatus()
	{
		return Fassessmentstatus;
	}		
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentStatus']//div[contains(text(),'Select All')]")
//	private WebElement Fassessmentstatusdropdown;
	
	public WebElement Fassessmentstatusdropdown(String status)
	{
		WebElement Fassessmentstatusdropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='assessmentStatus']//div[contains(text(),'"+status+"')]"));
		return Fassessmentstatusdropdown;
	}
			
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategory']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Fvendorcategory;
	
	public WebElement Fvendorcategory()
	{
		return Fvendorcategory;
	}
			
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategory']//div[contains(text(),'Select All')]")
//	private WebElement Fvendorcategorydropdown;
	
	public WebElement Fvendorcategorydropdown(String category)
	{
		WebElement Fvendorcategorydropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorCategory']//div[contains(text(),'"+category+"')]"));
		return Fvendorcategorydropdown;
	}
			
	
			
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Fvendorstatus;
	
	public WebElement Fvendorstatus()
	{
		return Fvendorstatus;
	}
			
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorStatus']//div[contains(text(),'Select All')]")
//	private WebElement Fvendorstatusdropdwn;
	
	public WebElement Fvendorstatusdropdwn(String status)
	{
		WebElement Fvendorstatusdropdwn = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorStatus']//div[contains(text(),'"+status+"')]"));
		return Fvendorstatusdropdwn;
	}

	
			
//	@FindBy(xpath="//div[@class='btnarea-chkbox pl-2']//input[@type='checkbox']")
//	private WebElement selectFvenoders;
	
	public WebElement selectFvenoders(String vendorName)
	{
		WebElement selectFvenoders = driver.findElement(By.xpath("//div[contains(text(),'"+vendorName+"')]/..//div//input[@type='checkbox']"));		
		return selectFvenoders;
	}
		//Questionnaire
	
	
	@FindBy(xpath="//div[text()='Questionnaire Template']")
	private WebElement selectquestionnaire;
	
	public WebElement selectquestionnaire()
	{
		return selectquestionnaire;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='questionnaireTemplate']")
	private WebElement questionnairetemplate;
	
	public WebElement questionnairetemplate()
	{
		return questionnairetemplate;
	}
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='questionnaireTemplate']//div[contains(text(),'Select All')]")
//	private WebElement questionnairetemplatedropdown;
	
	public WebElement questionnairetemplatedropdown(String Qtemplate)
	{
		WebElement questionnairetemplatedropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='questionnaireTemplate']//div[contains(text(),'"+Qtemplate+"')]"));		
		return questionnairetemplatedropdown;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement QAssessmentstatus;
	
	public WebElement QAssessmentstatus()
	{
		return QAssessmentstatus;
	}

//	@FindBy(xpath="//ng-multiselect-dropdown[@id='assessmentStatus']//div[contains(text(),'Select All')]")
//	private WebElement QAssessmentstatusdropdown;
	
	public WebElement QAssessmentstatusdropdown(String qStatus)
	{
		WebElement QAssessmentstatusdropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='assessmentStatus']//div[contains(text(),'"+qStatus+"')]"));		
		return QAssessmentstatusdropdown;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategory']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Qvendorcategory;
	
	public WebElement Qvendorcategory()
	{
		return Qvendorcategory;
	}
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorCategory']//div[contains(text(),'Select All')]")
//	private WebElement Qvendorcategorydropdwon;
	
	public WebElement Qvendorcategorydropdwon(String qCategory)
	{
		WebElement Qvendorcategorydropdwon = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorCategory']//div[contains(text(),'"+qCategory+"')]"));		
		return Qvendorcategorydropdwon;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Qvendorstatus;
	
	public WebElement Qvendorstatus()
	{
		return Qvendorstatus;
	}
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@id='vendorStatus']//div[contains(text(),'Select All')]")
//	private WebElement Qvendorstatusdropdown;
	
	public WebElement Qvendorstatusdropdown(String qStatus)
	{
		WebElement Qvendorstatusdropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='vendorStatus']//div[contains(text(),'"+qStatus+"')]"));		
		return Qvendorstatusdropdown;
	}
	
//	@FindBy(xpath="//div[@class='btnarea-chkbox pl-2']//input[@type='checkbox']")
//	private WebElement Qvendor;
	
	//public WebElement Qvendor(String qVendor)
	//{
		//WebElement Qvendor = driver.findElement(By.xpath("//div[contains(text(),'"+qVendor+"')]//input[@type='checkbox']"));
		//return Qvendor;
	//}
	
	public WebElement Qvendor(String qVendor)
	{
		WebElement Qvendor = driver.findElement(By.xpath("//div[contains(text(),'"+qVendor+"')]/../..//input[@type='checkbox']"));
		return Qvendor;
	}
	
	
	//custom Report
	
	@FindBy(xpath="//td[normalize-space()='Custom Reports']")
	private WebElement clickocustomreport;
	
	public WebElement clickocustomreport()
	{
		return clickocustomreport;
	}
	
	@FindBy(xpath="//input[@id='reportName']")
	private WebElement reportername;
	
	public WebElement reportername()
	{
		return reportername;
	}
		
		
	@FindBy(xpath="//input[@id='reportType']")
	private WebElement reportType;
		
	public WebElement reportType()
	{
		return reportType;
	
	}
	
	@FindBy(xpath="//input[@id='reportVersion']")
	private WebElement reportVersion;
		
	public WebElement reportVersion()
	{
		return reportVersion;
	
	}
	
	@FindBy(xpath="//input[@id='reportDate']")
	private WebElement reportDate;
		
	public WebElement reportDate()
	{
		return reportDate;
	
	}
	
	
	@FindBy(xpath="//input[@id='preparedBy']")
	private WebElement preparedBy;
		
	public WebElement preparedBy()
	{
		return preparedBy;
	
	}
	
	
	@FindBy(xpath="//input[@id='reviewedBy']")
	private WebElement reviewedBy;
		
	public WebElement reviewedBy()
	{
		return reviewedBy;
	
	}

	@FindBy(xpath="//textarea[@id='reportDescription']")
	private WebElement reportDescription;
		
	public WebElement reportDescription()
	{
		return reportDescription;
	
	}

	@FindBy(xpath="//div[@class='btnarea-chkbox']//input[@type='checkbox']")
	private WebElement clickcheckbox;
		
	public WebElement clickcheckbox()
	{
		return clickcheckbox;
	
	}
	
	//save
	@FindBy(xpath="//button[text()='Save & Next']")
	private WebElement savenext;
		
	public WebElement savenext()
	{
		return savenext;
	
	}
	//save
	@FindBy(xpath="//div[@class='vendor h-100']//button[@type='button'][normalize-space()='Save & Next']")
	private WebElement savenext1;
		
	public WebElement savenext1()
	{
		return savenext1;
	
	}
	
	//save
	
	@FindBy(xpath="//div[@class='h-100']//button[@type='button'][normalize-space()='Save & Next']")
	private WebElement savenextassessment;
		
	public WebElement savenextassessment()
	{
		return savenextassessment;
	
	}
	
	@FindBy(xpath="//button[normalize-space()='Generate Report']")
	private WebElement Generatereport;
		
	public WebElement Generatereport()
	{
		return Generatereport;
	
	}
	
	
//	@FindBy(xpath="//button[normalize-space()='OK']")
	@FindBy(xpath="//h6[contains(text(),'Action Not Allowed')]/../following-sibling::div//button[normalize-space()='OK']")
	private WebElement OK;
		
	public WebElement OK()
	{
		return OK;
	}
	
	
	@FindBy(xpath="//a[@id='vendor-details-tab active']")
	private WebElement addvendordetails;
		
	public WebElement addvendordetails()
	{
		return addvendordetails;
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vendor Category']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Cvendorcategory;
		
	public WebElement Cvendorcategory()
	{
		return Cvendorcategory;
	}
	
//	@FindBy(xpath="//div[normalize-space()='automation-1']")
//	private WebElement Cvendorcategorydropdown;
		
	public WebElement Cvendorcategorydropdown(String category)
	{
		WebElement Cvendorcategorydropdown = driver.findElement(By.xpath("//div[normalize-space()='"+category+"']"));
		return Cvendorcategorydropdown;
		
	}
	
	@FindBy(xpath="//label[normalize-space()='Being Assessed']")
	private WebElement Cbeingassessed;
		
	public WebElement Cbeingassessed()
	{
		return Cbeingassessed;
		
	}


	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vendor Name']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Cvendor;
		
	public WebElement Cvendor()
	{
		return Cvendor;
		
	}

//	@FindBy(xpath="//div[normalize-space()='Select All']")
//	private WebElement Cvendordropdown;
		
	public WebElement Cvendordropdown(String vendor)
	{
		WebElement Cvendordropdown = driver.findElement(By.xpath("//label[text()='Select Vendor']/..//div[contains(text(),'"+vendor+"')]"));
		return Cvendordropdown;
		
	}
	
	@FindBy(xpath="//div[@class='btnarea-chkbox d-inline-block ml-3']//input[@type='checkbox']")
	private WebElement checkbox1;
		
	public WebElement checkbox1()
	{
		return checkbox1;
		
	}
	
	
	@FindBy(xpath="//div[@class='btnarea-chkbox d-inline-block ml-2']//input[@type='checkbox']")
	private WebElement checkbox2;
		
	public WebElement checkbox2()
	{
		return checkbox2;
		
	}
	
	
//	@FindBy(xpath="//input[@placeholder='Report name max-length 110 characters']")
	@FindBy(xpath="//input[contains(@name,'ReportName')]")
	private WebElement GReportname;
		
	public WebElement GReportname()
	{
		return GReportname;
		
	}

	
//	@FindBy(xpath="//textarea[@class='form-control-plaintext fldcolor ng-untouched ng-pristine ng-valid']")
	@FindBy(xpath="//label[contains(text(),'Report File Description')]/..//textarea")
	private WebElement Reportfiledescription;
		
	public WebElement Reportfiledescription()
	{
		return Reportfiledescription;
		
	}
	
//	@FindBy(xpath="//textarea[@class='form-control-plaintext fldcolor ng-valid ng-dirty ng-touched']")
	@FindBy(xpath="//label[contains(text(),'Report File Description')]/..//textarea")
	private WebElement Reportfiledescription2;
		
	public WebElement Reportfiledescription2()
	{
		return Reportfiledescription2;
		
	}
	
	@FindBy(xpath="//input[@id='rd1']")
	private WebElement downloadword;
		
	public WebElement downloadword()
	{
		return downloadword;
		
	}
	

//	@FindBy(xpath="//textarea[@class='form-control-plaintext fldcolor ng-valid ng-dirty ng-touched']")
	@FindBy(xpath="//label[contains(text(),'Report File Description')]/..//textarea")
	private WebElement Reportfiledescription3;
		
	public WebElement Reportfiledescription3()
	{
		return Reportfiledescription3;
		
	}
	
	@FindBy(xpath="//input[@id='rd2']")
	private WebElement downloadpdf;
		
	public WebElement downloadpdf()
	{
		return downloadpdf;
		
	}
	
	
	@FindBy(xpath="//button[@type='button'][normalize-space()='Generate']")
	private WebElement customGeneratereport;
		
	public WebElement customGeneratereport()
	{
		return customGeneratereport;
		
	}
	
	
	
	
	@FindBy(xpath="//a[@id='assessment-details-tab']")
	private WebElement assessmentdetailstab;
		
	public WebElement assessmentdetailstab()
	{
		return assessmentdetailstab;
		
	}
	
	@FindBy(xpath="//div[@class='d-flex justify-content-between']//ng-multiselect-dropdown[@name='vendor']")
	private WebElement assessmentvendor;
		
	public WebElement assessmentvendor()
	{
		return assessmentvendor;
		
	}
	
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@name='vendor']//div[contains(text(),'Select All')]")
//	private WebElement assessmentvendordropdown;
		
	public WebElement assessmentvendordropdown(String vendor)
	{
		WebElement assessmentvendordropdown = driver.findElement(By.xpath("//span[text()='Select Vendor']/../../following-sibling::div//li//div[contains(text(),'"+vendor+"')]"));
		return assessmentvendordropdown;
		
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@name='assessmentStatus']")
	private WebElement assessmentstatus;
		
	public WebElement assessmentstatus()
	{
		return assessmentstatus;
		
	}
	
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@name='assessmentStatus']//div[contains(text(),'Select All')]")
//	private WebElement assessmentstatusselectall;
		
	public WebElement assessmentstatusselectall(String assessment)
	{
		WebElement assessmentstatusselectall = driver.findElement(By.xpath("//span[text()='Assessment Status']/../../following-sibling::div//li//div[contains(text(),'"+assessment+"')]"));
		return assessmentstatusselectall;
		
	}
	
	@FindBy(xpath="//input[@placeholder='From']")
	private WebElement selectFrom;
		
	public WebElement selectFrom()
	{
		return selectFrom;
		
	}
	
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement selectTO;
		
	public WebElement selectTO()
	{
		return selectTO;
		
	}
	
	

	@FindBy(xpath="//th[@class='text-center']//input[@type='checkbox']")
	private WebElement selectvendorofassessment;
		
	public WebElement selectvendorofassessment()
	{
		return selectvendorofassessment;
		
	}
	
	
//	@FindBy(xpath="//div[@class='btnarea-chkbox d-inline-block']//input[@type='checkbox']")
	@FindBy(xpath="//div[contains(text(),'Include Assessment Table')]//input[@type='checkbox']")
	private WebElement checkboxassessment;
		
	public WebElement checkboxassessment1()
	{
		return checkboxassessment;
		
	}
	
//	@FindBy(xpath="//div[@id='assessment-details']//div[@class='footerfildposition']//div[1][1]//input[1]")
	@FindBy(xpath="//div[contains(text(),'Include Assessment Detailed Score')]//input[@type='checkbox']")
	private WebElement checkboxassessment2;
		
	public WebElement checkboxassessment2()
	{
		return checkboxassessment2;
		
	}
	
	//Evidence Details
	
	@FindBy(xpath="//a[@id='evidence-details-tab']")
	private WebElement evidencedetails;
		
	public WebElement evidencedetails()
	{
		return evidencedetails;	
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Select Vendor']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement evidencevendor;
		
	public WebElement evidencevendor()
	{
		return evidencevendor;	
	}
	
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Select Vendor']//div[contains(text(),'Select All')]")
//	private WebElement evidencevendordropdown;
		
	public WebElement evidencevendordropdown(String vendor)
	{
		WebElement evidencevendordropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@placeholder='Select Vendor']//div[contains(text(),'"+vendor+"')]"));	
		return evidencevendordropdown;	
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Include Evidence Details')]//input[@type='checkbox']")
	private WebElement checkboxforevidence;
		
	public WebElement checkboxforevidence()
	{
		return checkboxforevidence;	
	}
	
	
	@FindBy(xpath="//div[@class='w-100 tab-content tab-content-or h-100']//button[@type='button'][normalize-space()='Save & Next']")
	private WebElement evidencesaveandnext;
		
	public WebElement evidencesaveandnext()
	{
		return evidencesaveandnext;	
	}
	
	//observation
	
	
	@FindBy(xpath="//a[@id='observation-details-tab']")
	private WebElement observationtab;
		
	public WebElement observationtab()
	{
		return observationtab;	
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vendor']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement observationvendor;
		
	public WebElement observationvendor()
	{
		return observationvendor;	
	}
	
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vendor']//div[contains(text(),'Select All')]")
//	private WebElement observationvendordropdown;
		
	public WebElement observationvendordropdown(String vendor)
	{
		WebElement observationvendordropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@placeholder='Vendor']//div[contains(text(),'"+vendor+"')]"));	
		return observationvendordropdown;	
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Observation Status']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement observationstatus;
		
	public WebElement observationstatus()
	{
		return observationstatus;	
	}
	
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Observation Status']//div[contains(text(),'Select All')]")
//	private WebElement observationstatusdropdown;
		
	public WebElement observationstatusdropdown(String obs)
	{
		WebElement observationstatusdropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@placeholder='Observation Status']//div[contains(text(),'"+obs+"')]"));	
		return observationstatusdropdown;	
	}
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Risk']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement observationrisk;
		
	public WebElement observationrisk()
	{
		return observationrisk;	
	}
	
	
//	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Risk']//div[contains(text(),'Select All')]")
//	private WebElement observationriskdropdown;
		
	public WebElement observationriskdropdown(String risk)
	{
		WebElement observationriskdropdown = driver.findElement(By.xpath("//ng-multiselect-dropdown[@placeholder='Risk']//div[contains(text(),'"+risk+"')]"));	
		return observationriskdropdown;	
	}
	
	
	
	@FindBy(xpath="//div[normalize-space()='Include Observation Summary Graph']//input[@type='checkbox']")
	private WebElement observationcheckbox1;
		
	public WebElement observationcheckbox1()
	{
		return observationcheckbox1;	
	}
	
	@FindBy(xpath="//div[normalize-space()= 'Include Observation Table']//input[@type='checkbox']")
	private WebElement observationcheckbox2;
		
	public WebElement observationcheckbox2()
	{
		return observationcheckbox2;	
	}
	
	@FindBy(xpath="//div[normalize-space()= 'Include Observation Impact']//input[@type='checkbox']")
	private WebElement observationcheckbox3;
		
	public WebElement observationcheckbox3()
	{
		return observationcheckbox3;	
	}
	
	@FindBy(xpath="//div[normalize-space()='Include Observation Recommendations']//input[@type='checkbox']")
	private WebElement observationcheckbox4;
		
	public WebElement observationcheckbox4()
	{
		return observationcheckbox4;	
	}

	
	
	@FindBy(xpath="//div[@class='d-flex justify-content-end align-items-center h-100 position-absolute vlignmiddle']//button[@type='button'][normalize-space()='Save & Next']")
	private WebElement observationsave;
		
	public WebElement observationsave()
	{
		return observationsave;	
	}
	
	//additional details
	
	
	@FindBy(xpath="//div[@class='addnotes']")
	private WebElement addnote;
		
	public WebElement addnote()
	{
		return addnote;	
	}
	
	//@FindBy(xpath="//input[@placeholder='Notes Header']")
	@FindBy(xpath="//input[contains(@placeholder,'Notes Header')]")
	private WebElement notesheader;
		
	public WebElement notesheader()
	{
		return notesheader;	
	}
	

	@FindBy(xpath="//textarea[@placeholder='Notes text']")
	private WebElement notestext;
		
	public WebElement notestext()
	{
		return notestext;	
	}
	

	@FindBy(xpath="//div[normalize-space()= 'Include Notes to Report']//input[@type='checkbox']")
	private WebElement addtionalcheckbox;
		
	public WebElement addtionalcheckbox()
	{
		return addtionalcheckbox;	
	}
	

	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement additionalsave;
		
	public WebElement additionalsave()
	{
		return additionalsave;	
	}
	
	//Report repository
	
	
	@FindBy(xpath="//td[normalize-space()='Report Repository']")
	private WebElement Reportrepository;
		
	public WebElement Reportrepository()
	{
		return Reportrepository;	
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vendor Category']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Rcategory;
		
	public WebElement Rcategory()
	{
		return Rcategory;	
	}
	
	
	@FindBy(xpath="//div[normalize-space()='Select All']")
	private WebElement Rcategoryselect;
		
	public WebElement Rcategoryselect()
	{
		return Rcategoryselect;	
	}
	
	
	@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vendor Name']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Rvendor;
		
	public WebElement Rvendor()
	{
		return Rvendor;	
	}
	
	
	@FindBy(xpath="//div[normalize-space()='Select All']")
	private WebElement Rvendordropdown;
		
	public WebElement Rvendordropdown()
	{
		return Rvendordropdown;	
	}
	
	
	@FindBy(xpath="//td[normalize-space()='test word file']/following::img[@class='d-inline-block align-middle cursor-pointer headicon mr-2']")
	private WebElement Rdownload;
		
	public WebElement Rdownloadword()
	{
		return Rdownload;	
	}
	

	@FindBy(xpath="//td[normalize-space()='test pdf file']/following::img[@class='d-inline-block align-middle cursor-pointer headicon mr-2']")
	private WebElement Rdownloadpdf;
		
	public WebElement Rdownloadpdf()
	{
		return Rdownloadpdf;	
	}
	
	public WebElement verifyVendor(String vendor)
	{
		WebElement vendorName = driver.findElement(By.xpath("//h5[text()='Report']/../following-sibling::div//td[contains(text(),'"+vendor+"')]"));
		return vendorName;	
	}
	
	@FindBy(xpath="//th[contains(text(),'Frameworks')]/../../../../..//div//button[contains(text(),'Reset')]")
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
	
	public void selectReportDate() {
		reportDate.click();
		String date = getCurrentDate();
		String[] overallDate = date.split("/");
		String sortedDate;
		if(Integer.parseInt(overallDate[0])<=9)
		{
			sortedDate = overallDate[0].replaceFirst("^0+(?!$)", "");
		}else {
			sortedDate = overallDate[0];
		}
		WebElement currentYear = driver.findElement(By.xpath("//button[@class='current']"));
		currentYear.click();
		WebElement selectcurrentYear = driver.findElement(By.xpath("//td//span[contains(text(),'"+overallDate[2]+"')]"));
		selectcurrentYear.click();
		WebElement selectMonth = driver.findElement(By.xpath("//td//span[contains(text(),'"+overallDate[1]+"')]"));
		selectMonth.click();
		WebElement selectDate = driver.findElement(By.xpath("//td//span[contains(text(),'"+sortedDate+"') and not(contains(@class,'disabled'))]"));
		selectDate.click();
	}
	
	public String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 0);
		String output = sdf.format(c.getTime());
		System.out.println(output);
		return output;
	}
	
		
	public WebElement selectVendorStatus(String status)
	{
		WebElement clk_status = driver.findElement(By.xpath("//label[normalize-space()='"+status+"']"));
		return clk_status;
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Report Generated Successfully.')]")
	   private WebElement validatemsg;
	   
	   public WebElement verifySavedMsg() {
		   return validatemsg;
		   }
	   
	   public List<WebElement> verifyDownload(String category, String vendor, String report)
		{
			List<WebElement> downloadicon = driver.findElements(By.xpath("//label[contains(text(),'"+category+"')]/../following-sibling::td//label[contains(text(),'"+vendor+"')]/../following-sibling::td//label[contains(text(),'"+report+"')]/../following-sibling::td//img[contains(@src,'download.svg')]"));
			return downloadicon;
			
		}
	   
	   public WebElement clickDownload(String category, String vendor, String report)
		{
			WebElement downloadicon = driver.findElement(By.xpath("//label[contains(text(),'"+category+"')]/../following-sibling::td//label[contains(text(),'"+vendor+"')]/../following-sibling::td//label[contains(text(),'"+report+"')]/../following-sibling::td//img[contains(@src,'download.svg')]"));
			return downloadicon;
			
		}
	   
	   @FindBy(xpath="//input[@placeholder='Search' and contains(@class,'searchText')]")
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
		
		@FindBy(xpath="//tbody//tr")
		private List<WebElement> verify_Data;
		
		public List<WebElement> verify_Data()
		{
			return verify_Data;
		}
		
		public WebElement verifyVData(String vendor)
		{
			WebElement verifyData = driver.findElement(By.xpath("//h5[contains(text(),'"+vendor+"')]"));
			return verifyData;
			
		}
		
		//@FindBy(xpath="//input[@placeholder='Search Vendor' and contains(@class,'tpdb-vd-search w-25 float-right searchText')]")
		@FindBy(xpath="(//input[@class='tpdb-vd-search w-25 float-right searchText ng-untouched ng-pristine ng-valid'])[1]")
		private WebElement vendorsearch_txtbox;
		
		public WebElement vendorSearchfield()
		{
			return vendorsearch_txtbox;
		}
		
		public WebElement verifyVendorData(String vendor)
		{
			WebElement verifyData = driver.findElement(By.xpath("//h5[contains(text(),'"+vendor+"')]"));
			return verifyData;
			
		}
		
		@FindBy(xpath="//div[@id='vendor']/div")
		private List<WebElement> verify_VSize;
		
		public List<WebElement> verify_vize()
		{
			return verify_VSize;
		}
		
		@FindBy(xpath="//div[@id='vendor']/..//div[contains(text(),'No Data Found')]")
		private WebElement verify_noDataTxt;
		
		public WebElement verify_vnoDataText()
		{
			return verify_noDataTxt;
		}
		
//		@FindBy(xpath="//div[contains(text(),'No Data Found')]")
		@FindBy(xpath="//div[contains(@class,'text-center mt-1')]")
		private WebElement verify_anoData;
		
		public WebElement verify_ANoDataText()
		{
			return verify_anoData;
		}
		
		@FindBy(xpath="//div[contains(@class,'col-8')]/../..//div[contains(text(),'No Data Found')]")
		private WebElement verify_enoData;
		
		public WebElement verify_ENoDataText()
		{
			return verify_enoData;
		}
		
		@FindBy(xpath="(//table[contains(@class,'table')])[1]//tbody//tr")
		private List<WebElement> verify_ASize;
		
		public List<WebElement> verify_Asize()
		{
			return verify_ASize;
		}
		
		public WebElement verifyVInAssessment(String vendor)
		{
			WebElement verifyData = driver.findElement(By.xpath("//table[contains(@class,'table')]/..//h5[contains(text(),'"+vendor+"')]"));
			return verifyData;
			
		}
		
		@FindBy(xpath="//div[contains(@class,'col-8')]//input[contains(@class,'tpdb-vd-search')]")
		private WebElement vendorsearch_txtboxinEvidence;
		
		public WebElement vendorSearchfieldinEvidence()
		{
			return vendorsearch_txtboxinEvidence;
		}
		
//		@FindBy(xpath="(//table[contains(@class,'table')])[2]//tbody//tr")
		@FindBy(xpath="//app-evidence-details//table[contains(@class,'table')]//tbody//tr")
		private List<WebElement> verify_VSizeInEvidence;
		
		public List<WebElement> verify_vizeInEvidence()
		{
			return verify_VSizeInEvidence;
		}
		
		public WebElement verifyVDataInEvidence(String vendor)
		{
			WebElement verifyData = driver.findElement(By.xpath("(//table[contains(@class,'table')])[2]/..//h5[contains(text(),'"+vendor+"')]"));
			return verifyData;
			
		}
		
		@FindBy(xpath="(//input[@placeholder='Search' and contains(@class,'tpdb-vd-search searchText')])[1]")
		private WebElement avendorsearch_txtbox;
		
		public WebElement avendorSearchfield()
		{
			return avendorsearch_txtbox;
		}
		
		public WebElement verifyVDataReportRepository(String vendor)
		{
			WebElement verifyData = driver.findElement(By.xpath("//label[contains(text(),'"+vendor+"')]"));
			return verifyData;	
		}
}

