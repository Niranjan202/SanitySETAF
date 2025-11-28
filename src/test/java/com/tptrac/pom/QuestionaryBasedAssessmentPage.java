package com.tptrac.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

public class QuestionaryBasedAssessmentPage {
	WebDriver driver;
	
	public QuestionaryBasedAssessmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
    
	@FindBy(xpath="//a[normalize-space()='Assessment']")
	private WebElement ClickAssessment;
	
	public WebElement ClickAssessment()
	{
		return ClickAssessment;
	}
	
	@FindBy(xpath="//td[normalize-space()='Assessment Calendar']")
	private WebElement ClickAssessmentCal;
	
	public WebElement ClickAssessmentCal()
	{
		return ClickAssessmentCal;
	}
	
	@FindBy(xpath="//span[contains(text(),'Create New Assessment Calendar')]")
	private WebElement Createnewassessment;
	
	public WebElement Createnewassessment()
	{
		return Createnewassessment;
	}
	
	
	@FindBy(xpath="//a[@id='pills-profile-tab']")
	private WebElement clickQuestionnairLib;
	
	public WebElement clickQuestionnairLib()
	{
		return clickQuestionnairLib;
	}
	
	@FindBy(xpath="//div[@class='row mx-0']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='assessmentType']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement SelectAssessmentType;
	
	public WebElement SelectAssessmentType()
	{
		return SelectAssessmentType;
	}
	
	
//	@FindBy(xpath="//div[@class='row mx-0']//div[contains(text(),'Operational Risk')]")
//	private WebElement AssessmentTypedropdown;
	
	public WebElement AssessmentTypedropdown(String type)
	{
		WebElement AssessmentTypedropdown = driver.findElement(By.xpath("//div[@class='row mx-0']//div[contains(text(),'"+type+"')]"));
		return AssessmentTypedropdown;
	}
	
	
	
	@FindBy(xpath="//div[@id='pills-profile']//div[@class='row mx-0 mt-3']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='vendorCategory']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement Clickonvendorcategory;
	
	public WebElement Clickonvendorcategory()
	{
		return Clickonvendorcategory;
	}
	
	
//	@FindBy(xpath="//div[@id='pills-profile']//div[contains(text(),'automation-1')]")
//	private WebElement selectvendorcategorydropdown;
	
	public WebElement selectvendorcategorydropdown(String category)
	{
		WebElement selectvendorcategorydropdown = driver.findElement(By.xpath("//div[@id='pills-profile']//div[contains(text(),'"+category+"')]"));
		return selectvendorcategorydropdown;
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Pre-Onboarding']//input[@name='onbstatus']")
	private WebElement selectonboardingstatus;
	
	public WebElement selectonboardingstatus()
	{
		return selectonboardingstatus;
	}
	
	
	@FindBy(xpath="//div[@id='pills-profile']//div[@class='row mx-0']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='vendorStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickonvendorstatus;
	
	public WebElement clickonvendorstatus()
	{
		return clickonvendorstatus;
	}
	
	
	@FindBy(xpath="//div[@id='pills-profile']//div[contains(text(),'Being Assessed')]")
	private WebElement selectBeingAssessed;
	
	public WebElement selectBeingAssessed()
	{
		return selectBeingAssessed;
	}
	
	
	@FindBy(xpath="//div[@id='pills-profile']//div[@class='row mx-0 mt-3']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='member']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickonvendor;
	
	public WebElement clickonvendor()
	{
		return clickonvendor;
		
	}

	@FindBy(xpath="//div[@id='pills-profile']//div[contains(text(),'automation vendor')]")
	private WebElement selectVendordropdown;
	
	public WebElement selectVendordropdown()
	{
		return selectVendordropdown;
		
	}
	

	@FindBy(xpath="//ng-multiselect-dropdown[@name='qtemplate']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickonquestionnire;
	
	public WebElement clickonquestionnire()
	{
		return clickonquestionnire;
		
	}
	
	

//	@FindBy(xpath="//div[normalize-space()='New Automation']")
//	private WebElement selectquestionniredropdown;
	
	public WebElement selectquestionniredropdown(String template)
	{
		WebElement selectquestionniredropdown = driver.findElement(By.xpath("//div[contains(text(),'"+template+"')]"));
		return selectquestionniredropdown;
		
	}
	
	
	@FindBy(xpath="//div[@id='pills-profile']//li[contains(text(),'Onetime')]")
	private WebElement selectonetime;
	
	public WebElement selectonetime()
	{
		return selectonetime;
		
	}
	
	

	@FindBy(xpath="//div[@id='pills-profile']//input[@id='startDate']")
	private WebElement selectstartdate;
	
	public WebElement selectstartdate()
	{
		return selectstartdate;
		
	}
	
	

	@FindBy(xpath="//div[@id='pills-profile']//input[@id='endDate']")
	private WebElement selectenddate;
	
	public WebElement selectenddate()
	{
		return selectenddate;
		
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Generate Calendar Schedule']")
	private WebElement GeneratecalenderSchedule;
	
	public WebElement GeneratecalenderSchedule()
	{
		return GeneratecalenderSchedule;
		
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Plan Assessment']")
	private WebElement planAssessment;
	
	public WebElement planAssessment()
	{
		return planAssessment;
		
	}
	
	
	//@FindBy(xpath="//td[contains(text(),'New Automation')]/..//span[contains(text(),'Planned')]/../following-sibling::td//img[@title='Update Status']")
//	@FindBy(xpath="//tbody/tr[1]/td[9]/div[1]/span[1]")
//	private WebElement clickAction;
	
	public WebElement clickAction(String assessmentType)
	{
		WebElement clickAction = driver.findElement(By.xpath("//td[contains(text(),'"+assessmentType+"')]/..//span[contains(text(),'Planned')]/../following-sibling::td//img[@title='Update Status']"));
		return clickAction;
		
	}
	
	@FindBy(id="staticEmail")
	private WebElement Actionstatus;
	

	 public WebElement clickActionstatus() {
			return Actionstatus ;
		}
	public void Actionstatus(String status)
	{
		Select obj = new Select(Actionstatus);
		obj.selectByVisibleText(status);
	}
	
	
	@FindBy(id="comments")
	private WebElement actioncomment;
	
	public WebElement actioncomment()
	{
		return actioncomment;
		
	}
	
	@FindBy(xpath="//button[normalize-space()='Ok']")
	private WebElement Actionok;
	
	public WebElement Actionok()
	{
		return Actionok;
	}
	
	
	
//	@FindBy(xpath="//td[contains(text(),'New Automation')]/..//td[contains(text(),'automation vendor')]/..//td[contains(text(),'Onetime')]/..//span[contains(text(),'Scheduled')]")
//	private WebElement Assertforschedule;
	
	public WebElement Assertforschedule(String templateName, String assessmentType)
	{
		//WebElement Assertforschedule = driver.findElement(By.xpath("//label[contains(text(),'"+templateName+"')]/../..//td[contains(text(),'"+assessmentType+"')]/..//td[contains(text(),'Onetime')]/..//span[contains(text(),'Scheduled')]"));
		  WebElement Assertforschedule = driver.findElement(By.xpath("//label[contains(text(),'"+templateName+"')]/../../..//td[contains(text(),'"+assessmentType+"')]/..//td[contains(text(),'Onetime')]/..//span[contains(text(),'Scheduled')]"));
		return Assertforschedule;
	}
	
	
	//vendor login
	
	
	@FindBy(xpath="//input[@id='UserName']")
	private WebElement vendorusername;
	
	public WebElement vendorusername()
	{
		return vendorusername;
	}
	
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement vendorpassword;
	
	public WebElement vendorpassword()
	{
		return vendorpassword;
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement VLogin;
	
	public WebElement VLogin()
	{
		return VLogin;
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Assessment']")
	private WebElement VClickAssessment;
	
	public WebElement VClickAssessment()
	{
		return VClickAssessment;
	}
	
	
//	@FindBy(xpath="//td[contains(text(),'New Automation')]/..//td[contains(text(),'Pending')]/..//img")
//	private WebElement Vclickviewicon;
	
	public WebElement Vclickviewicon(String assessment)
	{
		WebElement Vclickviewicon = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'Pending')]/..//img[contains(@src,'eye')]"));
		return Vclickviewicon;
	}
	
	@FindBy(xpath="//td[contains(text(),'New Automation')]/..//td[contains(text(),'Submitted')]/..//img")
	private WebElement Vclickviewicon1;
	
	public WebElement Vclickviewicon1()
	{
		return Vclickviewicon1;
	}
	
	@FindBy(xpath="//textarea[@id='vendorresponse']")
	private WebElement vendorresponse;
	
	public WebElement vendorresponse()
	{
		return vendorresponse;
	}
	
	@FindBy(xpath="//textarea[@id='vendorcomments']")
	private WebElement vendorcomments;
	
	public WebElement vendorcomments()
	{
		return vendorcomments;
	}
	
	@FindBy(xpath="//input[@id='UploadFile']")
	private WebElement selectfile;
	
	public WebElement FileSelect()
	{
		return selectfile;
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Upload Document']")
	private WebElement uploaddocument;
	
	public WebElement uploaddocument()
	{
		return uploaddocument;
	}
	
	public void document()
	{
		Robot rb= null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rb.delay(3000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement Vdescription;
	
	public WebElement Vdescription()
	{
		return Vdescription;
	}
	
	@FindBy(xpath="//button[normalize-space()='Save & Next']")
	private WebElement save_next;
	
	public WebElement save_next()
	{
		return save_next;
	}
	
	
//	@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submit;
	
	public WebElement submit()
	{
		return submit;
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	private WebElement submityes;
	
	public WebElement submityes()
	{
		return submityes;
	}
	
	
	@FindBy(xpath="//td[contains(text(),'New Automation')]/..//td[contains(text(),'Onetime')]/..//td[contains(text(),'Submitted')]")
	private WebElement Vsubmitassert;
	
	public WebElement Vsubmitassert()
	{
		return Vsubmitassert;
	}
	
	
	@FindBy(xpath="//td[contains(text(),'automation-1')]/..//td[contains(text(),'New Automation')]/..//td[contains(text(),'Reviewed')]")
	private WebElement Areviewedassert;
	
	public WebElement Areviewedassert()
	{
		return Areviewedassert;
	}
	
	// assessment Review
	
	
	@FindBy(xpath="//td[normalize-space()='Assessment Review']")
	private WebElement Assessmentreview;
	
	public WebElement Assessmentreview()
	{
		return Assessmentreview;
	}
	
	@FindBy(xpath="//td[normalize-space()='automation-1']/..//td[contains(text(),'Review pending')]/..//img[@class='d-inline-block align-middle cursor-pointer headicon mr-2']")
	private WebElement assessmentreviewicon;
	
	public WebElement assessmentreviewicon()
	{
		return assessmentreviewicon;
	}
	//auditor comment
	                           
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-default[1]/app-asssessment-reports[1]/div[1]/div[1]/div[2]/div[1]/div[2]/app-assessment-report-questionnaire-details[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/textarea[1]")
	private WebElement auditorcomment;
	
	public WebElement auditorcomment()
	{
		return auditorcomment;
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Add']")
	private WebElement addobservation;
	
	public WebElement addobservation()
	{
		return addobservation;
	}

	
	@FindBy(xpath="//input[@id='obsTitle']")
	private WebElement obstitle;
	
	public WebElement obstitle()
	{
		return obstitle;
	}
	
	@FindBy(xpath="//input[@id='obsDate']")
	private WebElement obsdate;
	
	public WebElement obsdate()
	{
		return obsdate;
	}
	
	//@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Observation Type']//div[contains(@class,'multiselect-dropdown')]//div//span[contains(@class,'dropdown-btn')]")
	@FindBy(xpath="//span[contains(text(),'Observation Type')]")
	private WebElement observationtype;
	
	public WebElement observationtype()
	{
		return observationtype;
	}
	
	
	@FindBy(xpath="//div[normalize-space()='Technical']")
	private WebElement observationtypedropdown;
	
	public WebElement observationtypedropdown()
	{
		return observationtypedropdown;
	}
	
	//@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Vulnerability Category']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	@FindBy(xpath="//span[contains(text(),'Vulnerability Category')]")
	private WebElement Vulnerabilitycategory;
	
	public WebElement Vulnerabilitycategory()
	{
		return Vulnerabilitycategory;
	}
	
	@FindBy(xpath="//div[normalize-space()='Broken Access Control']")
	private WebElement Vulnerabilitycategorydropdown;
	
	public WebElement Vulnerabilitycategorydropdown()
	{
		return Vulnerabilitycategorydropdown;
	}
	
	
	@FindBy(xpath="//div[@class='col-4 px-0']//label[contains(text(),'Critical')]")
	private WebElement RiskprobabilityCritical;
	
	public WebElement RiskprobabilityCritical()
	{
		return RiskprobabilityCritical;
	}
	
	@FindBy(xpath="//div[@class='col-4 pl-3 pr-0']//label[contains(text(),'Critical')]")
	private WebElement Riskimpactcritical;
	
	public WebElement Riskimpactcritical()
	{
		return Riskimpactcritical;
	}
	
	@FindBy(xpath="//textarea[@id='obsDescription']")
	private WebElement obsdescription;
	
	public WebElement obsdescription()
	{
		return obsdescription;
	}
	
	@FindBy(xpath="//textarea[@id='impact']")
	private WebElement impact;
	
	public WebElement impact()
	{
		return impact;
	}
	
	
	
	@FindBy(xpath="//textarea[@id='recommendation']")
	private WebElement recommendation;
	
	public WebElement recommendation()
	{
		return recommendation;
	}
	
	@FindBy(xpath="//input[@id='closureDate']")
	private WebElement closureDate;
	
	public WebElement closureDate()
	{
		return closureDate;
	}
	
	@FindBy(xpath="//input[@id='followUpDate']")
	private WebElement followUpDate;
	
	public WebElement followUpDate()
	{
		return followUpDate;
	}
	
	@FindBy(xpath="//textarea[@id='comments']")
	private WebElement comments;
	
	public WebElement comments()
	{
		return comments;
	}
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement assessmentreviewsave;
	
	public WebElement assessmentreviewsave()
	{
		return assessmentreviewsave;
	}
	
	@FindBy(xpath="//input[@id='review']")
	private WebElement assessmentreview;
	
	public WebElement assessmentreview()
	{
		return assessmentreview;
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submitassessmentobservation;
	
	public WebElement submitassessmentobservation()
	{
		return submitassessmentobservation;
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Yes ')]")
	private WebElement Submityes;
	
	public WebElement Submityes()
	{
		return Submityes;
	}
	
	
	@FindBy(xpath="//span[normalize-space()='2 Sevice now is required for the customer ?']")
	private WebElement Aquestion2;
	
	public WebElement Aquestion2()
	{
		return Aquestion2;
	}
	
	@FindBy(xpath="//span[contains(text(),'3 Test cycle might be have issue but need clarific')]")
	private WebElement Aquestion3;
	
	public WebElement Aquestion3()
	{
		return Aquestion3;
	}
	
	@FindBy(xpath="//span[normalize-space()='4 Planned one ytresting this week ?']")
	private WebElement Aquestion4;
	
	public WebElement Aquestion4()
	{
		return Aquestion4;
	}
	
	@FindBy(xpath="//span[normalize-space()='5 Latest report did you sent to me ?']")
	private WebElement Aquestion5;
	
	public WebElement Aquestion5()
	{
		return Aquestion5;
	}
	
	//Auditor view icon
	
//	@FindBy(xpath="//i[@class='fa fa-chevron-circle-left cursor-pointer']")
	@FindBy(xpath="//i[contains(@class,'circle-left cursor-pointer')]")
	private WebElement Aclickback;
	
	public WebElement Aclickback()
	{
		return Aclickback;
	}
	
	@FindBy(xpath="//td[contains(text(),'New Automation')]/..//td[contains(text(),'In Progress')]/..//img[@data-target='#myModal']")
	private WebElement Aclickicon;
	
	public WebElement Aclickicon()
	{
		return Aclickicon;
	}
	
	@FindBy(xpath="//div[contains(@class,'lefttabhead w-100 pl-3')][normalize-space()='Observation Closure Percentage']")
	private WebElement ClickonOCPercentage;
	
	public WebElement ClickonOCPercentage()
	{
		return ClickonOCPercentage;
	}
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	private WebElement Clickoncancel;
	
	public WebElement Clickoncancel()
	{
		return Clickoncancel;
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Observation Planning']")
	private WebElement observationplanning;
	
	public WebElement observationplanning()
	{
		return observationplanning;
	}
	
	@FindBy(xpath="//a[normalize-space()='Response']")
	private WebElement clickonResponse;
	
	public WebElement clickonResponse()
	{
		return clickonResponse;
	}
	
//	@FindBy(xpath="//select[@class='form-control-plaintext fldcolor bdrfield bg-color ng-untouched ng-pristine ng-invalid']")
	@FindBy(xpath="//select[@formcontrolname='IsVendorAccepted']")
	private WebElement observationacceptance;
	
	public WebElement observationaccpt()
	{
		return observationacceptance;
	}
	
	@FindBy(xpath="//label[text()='Observation Acceptance']/..//div[contains(@class,'multiselect-dropdown')]")
	private WebElement click_observationacceptance;
	
	public WebElement observationacceptance(String accept) throws InterruptedException
	{
//		Select obj = new Select(observationacceptance);
//		obj.selectByVisibleText(accept);
		click_observationacceptance.click();
		Thread.sleep(2000);
		WebElement selectAccept = driver.findElement(By.xpath("//input[@aria-label='"+accept+"']/.."));
		return selectAccept;
	}
	
	@FindBy(xpath="//input[@id='TargetDate']")
	private WebElement Vtargetdate;
	
	public WebElement Vtargetdate()
	{
		return Vtargetdate;
	}
	
//	@FindBy(xpath="//span[contains(text(),'observationtitle-2')]")
//	private WebElement question2;
	
	public WebElement question2(String question)
	{
		WebElement question2 = driver.findElement(By.xpath("//span[contains(text(),'"+question+"')]"));
		return question2;
	}
	

//	@FindBy(xpath="//span[contains(text(),'observationtitle-3')]")
//	private WebElement question3;
	
	public WebElement question3(String question)
	{
		WebElement question3 = driver.findElement(By.xpath("//span[contains(text(),'"+question+"')]"));
		return question3;
	}
	
//	@FindBy(xpath="//span[contains(text(),'observationtitle-4')]")
//	private WebElement question4;
	
	public WebElement question4(String question)
	{
		WebElement question4 = driver.findElement(By.xpath("//span[contains(text(),'"+question+"')]"));
		return question4;
	}
	
//	@FindBy(xpath="//span[contains(text(),'observationtitle-5')]")
//	private WebElement question5;
	
	public WebElement question5(String question)
	{
		WebElement question5 = driver.findElement(By.xpath("//span[contains(text(),'"+question+"')]"));
		return question5;
	}
	
	@FindBy(xpath="//textarea[@placeholder='Remarks']")
	private WebElement Vremarks;
	
	public WebElement Vremarks()
	{
		return Vremarks;
	}
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement Vsave;
	
	public WebElement Vsave()
	{
		return Vsave;
	}
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	private List<WebElement> Verifysave;
	
	public List<WebElement> Verifysave()
	{
		return Verifysave;
	}
	
//auditor observation planning
	

	@FindBy(xpath="//a[@id='pills-profile-tab']")
	private WebElement clickVendorResponse;
	
	public WebElement clickVendorResponse()
	{
		return clickVendorResponse;
	}
	

	@FindBy(xpath="	//textarea[@id='currentObservation.AuditorComments']")
	private WebElement Areviewcomm;
	
	public WebElement Areviewcomm()
	{
		return Areviewcomm;
	}
	
	@FindBy(xpath="//button[normalize-space()='Approve']")
	private WebElement Aapprove;
	
	public WebElement Aapprove()
	{
		return Aapprove;
	}
	

//	@FindBy(xpath="//div[@id='12']")
//	private WebElement observationtitle2;
	
	public WebElement observationtitle2(String oName1)
	{
		WebElement observationtitle2 = driver.findElement(By.xpath("//span[contains(text(),'"+oName1+"')]"));
		return observationtitle2;
	}

//	@FindBy(xpath="//div[@id='13']")
//	private WebElement observationtitle3;
	
	public WebElement observationtitle3(String oName2)
	{
		WebElement observationtitle3 = driver.findElement(By.xpath("//span[contains(text(),'"+oName2+"')]"));
		return observationtitle3;
	}

//	@FindBy(xpath="//div[@id='14']")
//	private WebElement observationtitle4;
	
	public WebElement observationtitle4(String oName3)
	{
		WebElement observationtitle4 = driver.findElement(By.xpath("//span[contains(text(),'"+oName3+"')]"));
		return observationtitle4;
	}

//	@FindBy(xpath="//div[@id='15']")
//	private WebElement observationtitle5;
	
	public WebElement observationtitle5(String oName4)
	{
		WebElement observationtitle5 = driver.findElement(By.xpath("//span[contains(text(),'"+oName4+"')]"));
		return observationtitle5;
	}
	
	@FindBy(xpath="(//button[@class='modalconfirmbutton'])[2]")
	private WebElement Asubmityes;
			
	public WebElement Asubmityes()
	{
	return Asubmityes;
	}		
	
	
	@FindBy(xpath="//td[text()='New Automation']/..//td[text()='Approved']/..//td[text()='In Progress']/..//img")
	private WebElement Vviewicon;
			
	public WebElement Vviewicon()
	{
	return Vviewicon;
	}	
	
	
	@FindBy(xpath="//span[normalize-space()='Observations']")
	private WebElement clickonobservation;
			
	public WebElement clickonobservation()
	{
	return clickonobservation;
	}	
	
	@FindBy(xpath="//input[@id='Claim Closed']")
	private WebElement Claimclosed;
			
	public WebElement Claimclosed()
	{
	return Claimclosed;
	}	
	
	
	@FindBy(xpath="//textarea[@placeholder='Vendor Comments']")
	private WebElement vendorcomment;
			
	public WebElement vendorcomment()
	{
	return vendorcomment;
	}	
	
	//div[@class='w-100 d-flex justify-content-start statusfilterbox claimclosed active']//div/..//span[normalize-space()='Claim']
	@FindBy(xpath="//span[normalize-space()='Claim']")
	private WebElement Vclaimclosed;
			
	public WebElement Vclaimclosed()
	{
	return Vclaimclosed;
	}	
	
	@FindBy(xpath="//button[normalize-space()='Submit Observation']")
	private WebElement submitobservation;
			
	public WebElement submitobservation()
	{
	return submitobservation;
	}	
	
	
//	@FindBy(xpath="//div[@class='px-2 w-25 vrtext ng-star-inserted']/..//span[contains(text(),'2')]/following::div//span[text()='Observation Title*']")
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])[2]")
	private WebElement VQUESTION2;
			
	public WebElement VQUESTION2()
	{
	return VQUESTION2;
	}	
	
//	@FindBy(xpath="//div[@class='px-2 w-25 vrtext ng-star-inserted']/..//span[contains(text(),'3')]/following::div//span[text()='Observation Title*']")
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])[3]")
	private WebElement VQUESTION3;
			
	public WebElement VQUESTION3()
	{
	return VQUESTION3;
	}	
	
//	@FindBy(xpath="//div[@class='px-2 w-25 vrtext ng-star-inserted']/..//span[contains(text(),'4')]/following::div//span[text()='Observation Title*']")
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])[4]")
	private WebElement VQUESTION4;
			
	public WebElement VQUESTION4()
	{
	return VQUESTION4;
	}
	
//	@FindBy(xpath="//div[@class='px-2 w-25 vrtext ng-star-inserted']/..//span[contains(text(),'5')]/following::div//span[text()='Observation Title*']")
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])[5]")
	private WebElement VQUESTION5;
			
	public WebElement VQUESTION5()
	{
	return VQUESTION5;
	}	
	
	
	//Auditor observation
	
	
	@FindBy(xpath="//td[contains(text(),'New Automation')]/..//td[contains(text(),'Completed')]/..//td[contains(text(),'In Progress')]/..//img")
	private WebElement Observationviewicon;
			
	public WebElement Observationviewicon()
	{
	return Observationviewicon;
	}	
	
	
	@FindBy(xpath="//span[normalize-space()='Observations']")
	private WebElement Aobservation;
			
	public WebElement Aobservation()
	{
	return Aobservation;
	}	
	
	
	@FindBy(xpath="//span[normalize-space()='Claim']")
	private WebElement Aclaim;
			
	public WebElement Aclaim()
	{
	return Aclaim;
	}
	
	
	@FindBy(xpath="//a[@id='pills-profile-tab']")
	private WebElement AResponse;
			
	public WebElement AResponse()
	{
	return AResponse;
	}	
	
	
	@FindBy(xpath="//textarea[@id='currentObservation.AuditorComments']")
	private WebElement AuditorComments;
			
	public WebElement AuditorComments()
	{
	return AuditorComments;
	}	
	
	
	@FindBy(xpath="//button[normalize-space()='Approve']")
	private WebElement Aclickonapprove;
			
	public WebElement Aclickonapprove()
	{
	return Aclickonapprove;
	}	
	
	
	
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])")
	private WebElement Observationquestion2;
			
	public WebElement Observationquestion2()
	{
	return Observationquestion2;
	}	
	
	
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])")
	private WebElement Observationquestion3;
			
	public WebElement Observationquestion3()
	{
	return Observationquestion3;
	}	
	
	
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])")
	private WebElement Observationquestion4;
			
	public WebElement Observationquestion4()
	{
	return Observationquestion4;
	}	
	
	
	@FindBy(xpath="(//div[contains(@class,'content-start listrow')])")
	private WebElement Observationquestion5;
			
	public WebElement Observationquestion5()
	{
	return Observationquestion5;
	}	
	
	@FindBy(xpath="//div[contains(text(),'Approved')]//span[contains(text(),'Claim Closed')]")
	private WebElement claimclosedapprove;
			
	public WebElement claimclosedapprove()
	{
	return claimclosedapprove;
	}	
	
	@FindBy(xpath="//button[contains(text(),'Yes ')]")
	private WebElement submityes1;
			
	public WebElement submityes1()
	{
	return submityes1;
	}	
	
//	@FindBy(xpath="//div[@class='px-1 py-3 w-100 d-flex justify-content-start listrow active']//span[@class='pl-2 w-86'][normalize-space()='Observation Title*']")
	@FindBy(xpath="//div[contains(@class,'content-start listrow')]")
	private WebElement clickobserQ;
			
	public WebElement clickobserQ()
	{
	return clickobserQ;
	}	
	

	@FindBy(xpath="(//td[text()='New Automation']/..//td[text()='Closed']/..//td[text()='Completed']/..//img)[2]")
	private WebElement Viewandicon;
					
	public WebElement Viewandicon()
	{
	return Viewandicon;
	}	
	
	@FindBy(xpath="//span[normalize-space()='Pre-Onboarding']//input[@name='onbstatus']")
	private WebElement selectPreonboardingstatus;
	
	
	@FindBy(xpath="//div[@id='pills-profile']//div[contains(text(),'Unassessed')]")
	private WebElement selectUnassessedStatus;
	
	@FindBy(xpath="//span[normalize-space()='Onboarded']//input[@name='onbstatus']")
	private WebElement selectOnboardingStatus;
	
	@FindBy(xpath="(//h5[contains(text(),'No data available')])[2]")
	private List<WebElement> verifyNoData;
	
	@FindBy(xpath="//div[@id='pills-profile']//div[contains(text(),'Active')]")
	private WebElement selectActiveStatus;
	
	
	public void verifyVendor(String vendor) throws InterruptedException
	{
		
		selectPreonboardingstatus.click();
		if(selectPreonboardingstatus.isSelected())
		{
			clickonvendorstatus().click();
			Thread.sleep(2000);
			selectUnassessedStatus.click();
			Thread.sleep(2000);
			clickonvendorstatus().click();
			Thread.sleep(2000);
			clickonvendor().click();
			Thread.sleep(2000);
			if(verifyNoData.size()>=1)
			{
				System.out.println("No Data Available text is displayed");
				clickonvendorstatus().click();
				Thread.sleep(2000);
				selectBeingAssessed().click();
				Thread.sleep(2000);
				clickonvendorstatus().click();
				Thread.sleep(2000);
				clickonvendor().click();
				Thread.sleep(2000);
				if(verifyNoData.size()>=1) {
					verifyOnboardedVendor(vendor);
				}else {
					WebElement selectVendor = driver.findElement(By.xpath("//div[@id='pills-profile']//div[contains(text(),'"+vendor+"')]"));
					selectVendor.click();
					clickonvendor().click();
				}
				
			}else {
				WebElement selectVendor = driver.findElement(By.xpath("//div[@id='pills-profile']//div[contains(text(),'"+vendor+"')]"));
				selectVendor.click();
				clickonvendor().click();
			}
		}
	}
	
	public void verifyOnboardedVendor(String vendor) {

		selectOnboardingStatus.click();
		clickonvendorstatus().click();
		selectActiveStatus.click();
		clickonvendorstatus().click();
		clickonvendor().click();
		
		WebElement selectVendor = driver.findElement(By.xpath("//div[@id='pills-profile']//div[contains(text(),'"+vendor+"')]"));

		selectVendor.click();
		clickonvendor().click();
	}
		
	public void selectAssessmentStartDate() {
		selectstartdate.click();
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
	
	public void selectAssessmentEndDate() {
		selectenddate.click();
		String date = getDays();
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
	
	public String getDays() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 10); // Adding 10 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
		return output;
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
	
	@FindBy(xpath="//td[normalize-space()='Assessment Review']")
	private WebElement ClickAssessmentRev;
	
	public WebElement ClickAssessmentRev()
	{
		return ClickAssessmentRev;
	}
	
	@FindBy(xpath="//button[contains(text(),'Submit') and @disabled]")
	private List<WebElement> vendor_DisabledSubmit;
	
	public List<WebElement> vDisableSubmit()
	{
		return vendor_DisabledSubmit;
	}
	
	@FindBy(xpath="//div[contains(text(),'Not Started')]/..")
	private WebElement notStarted_button;
	
	public WebElement clickNotStartedBtn()
	{
		return notStarted_button;
	}
	
	@FindBy(xpath="//div[contains(@class,'leftlist cardscroll')]//div[contains(@id,'question')]")
	private List<WebElement> vQuestions;
	
	public List<WebElement> verifyQuestions()
	{
		return vQuestions;
	}

	
	public WebElement vAssessmentStatus(String template, String aStatus)
	{
		WebElement vAssessmentStatus = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]"));
		return vAssessmentStatus;
	}
	
	public WebElement vAssessmentStatusForVendor(String template, String aStatus)
	{
		WebElement vAssessmentStatus = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'Onetime')]/..//td[contains(text(),'"+aStatus+"')]"));
		return vAssessmentStatus;
	}
	
	@FindBy(xpath="//input[@id='obsDate']")
	private WebElement selectobsdate;
	
	public void clickObsDate()
	{
		selectobsdate.click();
	}
	
	public void selectCurrentDate() {
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
	
	public String getDaysBasedOnCount(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, days); // Adding no of days
		String output = sdf.format(c.getTime());
		System.out.println(output);
		return output;
	}
	
	@FindBy(xpath="//input[@id='closureDate']")
	private WebElement selectclosuredate;
	
	public void clickClosureDate()
	{
		selectclosuredate.click();
	}
	
	@FindBy(xpath="//input[@id='followUpDate']")
	private WebElement selectfollowdate;
	
	public void clickFollowDate()
	{
		selectfollowdate.click();
	}
	
	//blocked below code from 1322 to 1343
		public void selectFutureDate(int days) {
		String date = getDaysBasedOnCount(days);
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
	
	
	
	@FindBy(xpath="//div[contains(text(),'Review Pending')]/..")
	private WebElement reviewPending_button;
	
	public WebElement clickReviewPendingBtn()
	{
		return reviewPending_button;
	}
	
	public WebElement clickEyeIcon(String template, String aStatus)
	{
		WebElement clkEyeicon = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]/..//img[contains(@src,'eye')]"));
		return clkEyeicon;
	}
	
	@FindBy(xpath="(//button[contains(text(),'Yes')])[2]")
	private WebElement submitYesAuditor;
	
	public WebElement asubmityes()
	{
		return submitYesAuditor;
	}
	
	public WebElement clickInfoIcon(String template, String aStatus)
	{
		WebElement clkInfoicon = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]/..//img[contains(@src,'info')]"));
		return clkInfoicon;
	}
	
	@FindBy(xpath="(//button[normalize-space()='Cancel'])[2]")
	private WebElement ClickoncancelAuditor;
	
	public WebElement ClickoncancelAuditor()
	{
		return ClickoncancelAuditor;
	}
	
	public WebElement clickviewiconVendor(String assessment, String astatus, String oStatus)
	{
		WebElement Vclickviewicon = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'"+astatus+"')]/..//td[contains(text(),'"+oStatus+"')]/..//img[contains(@src,'eye')]"));
		return Vclickviewicon;
	}
	
	@FindBy(xpath="//div[contains(text(),'Plan Awaited')]/..")
	private WebElement planAwaited_button;
	
	public WebElement clickplanAwaitedBtn()
	{
		return planAwaited_button;
	}
	
	@FindBy(xpath="//div[contains(@class,'leftlist cardscroll')]/div/div")
	private List<WebElement> vObservations;
	
	public List<WebElement> verifyObservations()
	{
		return vObservations;
	}
	
	public WebElement verifyObsStatusVendor(String assessment, String astatus, String oStatus)
	{
		WebElement verifyObsStatus = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'"+astatus+"')]/..//td[contains(text(),'"+oStatus+"')]"));
		return verifyObsStatus;
	}
	
	public WebElement clickInfoIconWithObs(String template, String aStatus, String oStatus)
	{
		WebElement clkInfoicon = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]/../..//td[contains(text(),'"+oStatus+"')]/..//img[contains(@src,'eye')]"));
		return clkInfoicon;
	}
	
	@FindBy(xpath="(//button[contains(text(),'Yes')])[2]")
	private WebElement AsubmityesObsPlanning;
			
	public WebElement AsubmityesObsPlanning()
	{
	return AsubmityesObsPlanning;
	}	
	
	public WebElement verifyStatusWithObs(String template, String aStatus, String oStatus)
	{
		WebElement verifyStatus = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]/../..//td[contains(text(),'"+oStatus+"')]"));
		return verifyStatus;
	}
	
	public WebElement clkInfoIconVendor(String assessment, String astatus, String oStatus)
	{
		WebElement verifyObsStatus = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'"+astatus+"')]/..//td[contains(text(),'"+oStatus+"')]/..//img[contains(@src,'info')]"));
		return verifyObsStatus;
	}
	
	@FindBy(xpath="(//button[normalize-space()='Cancel'])[last()]")
	private WebElement Clickoncancelvendor;
	
	public WebElement Clickoncancelvendoror()
	{
		return Clickoncancelvendor;
	}
	
	@FindBy(xpath="//input[@class='form-control fldcolor tblfilter searchText ng-untouched ng-pristine ng-valid']")
	private WebElement verifySearch;
	
	public WebElement FrameworkSearch()
	{
		return verifySearch;
	}
	
	@FindBy(xpath= "//button[@id='disableClick']//span[@aria-hidden='true'][normalize-space()='×']")
	private WebElement claimclosedcross;
	
	public WebElement CrossCC()
	{
		return claimclosedcross;
	}
	
	@FindBy(xpath= "//button[@id='disableClick']//span[@aria-hidden='true'][normalize-space()='×']")
	private WebElement submitcross;
	
	public WebElement CrossSubmit()
	{
		return submitcross;
	}
	
	@FindBy(xpath="//table//tbody//tr")
	private List<WebElement> verify_AData;
	
	public List<WebElement> verify_AData()
	{
		return verify_AData;
	}
}
