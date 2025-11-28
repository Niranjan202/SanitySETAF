package com.tptrac.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkBasedAssessmentPage {
	WebDriver driver;
	
	public FrameworkBasedAssessmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
		
//		//vendor login
//		
//		@FindBy(xpath="//input[@id='UserName']")
//		private WebElement VendorUserName;
//		
//		public WebElement VendorUserName()
//		{
//			return VendorUserName;
//		}
//		
//		@FindBy(xpath="//input[@id='password']")
//		private WebElement Vendorpassword;
//		
//		public WebElement Vendorpassword()
//		{
//			return Vendorpassword;
//		}
//		
//		
//		@FindBy(xpath="//button[normalize-space()='Login']")
//		private WebElement VLogin;
//		
//		public WebElement VLogin()
//		{
//			return VLogin;
//		}
		

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
		
		
		@FindBy(xpath="//a[@id='pills-home-tab']")
		private WebElement clickFrameworkLib;
		
		public WebElement clickFrameworkLib()
		{
			return clickFrameworkLib;
		}

		@FindBy(xpath="//div[@class='row mx-0']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='framework']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement clickFramework;
		
		public WebElement clickFramework()
		{
			return clickFramework;
		}
		
		public WebElement selectFramework(String framework)
		{
			WebElement selectFrameworkName = driver.findElement(By.xpath("//div[@class='row mx-0']//div[contains(text(),'"+framework+"')]"));
			return selectFrameworkName;
		}
		
		
		@FindBy(xpath="//div[@class='row mx-0 mt-3']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='assessmentType']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement SelectAssessmentType;
		
		public WebElement SelectAssessmentType()
		{
			return SelectAssessmentType;
		}
		
		
		public WebElement AssessmentTypedropdown(String type)
		{
			WebElement AssessmentTypedropdown = driver.findElement(By.xpath("//div[@class='row mx-0 mt-3']//div[contains(text(),'"+type+"')]"));
			return AssessmentTypedropdown;
		}
		
		@FindBy(xpath="//div[@id='pills-home']//div[@class='row mx-0 mt-3']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='vendorCategory']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement Clickonvendorcategory;
		
		public WebElement Clickonvendorcategory()
		{
			return Clickonvendorcategory;
		}
		
		public WebElement selectvendorcategorydropdown(String category)
		{
			WebElement selectvendorcategorydropdown = driver.findElement(By.xpath("//div[@id='pills-home']//div[text()='"+category+"']"));
			return selectvendorcategorydropdown;
		}
		
		@FindBy(xpath="//div[@id='pills-home']//div[@class='row mx-0']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='vendorStatus']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement clickonvendorstatus;
		
		public WebElement clickonvendorstatus()
		{
			return clickonvendorstatus;
		}
		
		@FindBy(xpath="//div[@id='pills-home']//div[@class='row mx-0 mt-3']//div[@class='col-12 px-0']//ng-multiselect-dropdown[@name='member']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		private WebElement clickonvendor;
		
		public WebElement clickonvendor()
		{
			return clickonvendor;
			
		}
		
		@FindBy(xpath="//div[@id='pills-home']//div[contains(text(),'Being Assessed')]")
		private WebElement selectBeingAssessed;
		
		public WebElement selectBeingAssessed()
		{
			return selectBeingAssessed;
		}
		
		@FindBy(xpath="//span[normalize-space()='Pre-Onboarding']//input[@name='onbstatusframework']")
		private WebElement selectPreonboardingstatus;
		
		
		@FindBy(xpath="//div[@id='pills-home']//div[contains(text(),'Unassessed')]")
		private WebElement selectUnassessedStatus;
		
		@FindBy(xpath="//span[normalize-space()='Onboarded']//input[@name='onbstatusframework']")
		private WebElement selectOnboardingStatus;
		
		@FindBy(xpath="//div[@id='pills-home']//h5[contains(text(),'No data available')]")
		private List<WebElement> verifyNoData;
		
		@FindBy(xpath="//div[@id='pills-home']//div[contains(text(),'Active')]")
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
					clickonvendor().click();
					Thread.sleep(2000);
					if(verifyNoData.size()>=1) {
						verifyOnboardedVendor(vendor);
					}else {
						WebElement selectVendor = driver.findElement(By.xpath("//div[@id='pills-home']//div[contains(text(),'"+vendor+"')]"));
						selectVendor.click();
						clickonvendor().click();
					}
					
				}else {
					WebElement selectVendor = driver.findElement(By.xpath("//div[@id='pills-home']//div[contains(text(),'"+vendor+"')]"));
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
			
			WebElement selectVendor = driver.findElement(By.xpath("//div[@id='pills-home']//div[contains(text(),'"+vendor+"')]"));

			selectVendor.click();
			clickonvendor().click();
		}
		
		
		@FindBy(xpath="//div[@id='pills-home']//li[contains(text(),'Onetime')]")
		private WebElement selectonetime;
		
		public WebElement selectonetime()
		{
			return selectonetime;
			
		}
		
		@FindBy(xpath="//div[@id='pills-home']//input[@id='startDate']")
		private WebElement selectstartdate;
		
		public WebElement selectstartdate()
		{
			return selectstartdate;
			
		}
		

		@FindBy(xpath="//div[@id='pills-home']//input[@id='endDate']")
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
		

		@FindBy(xpath="//input[@placeholder='Search' and contains(@class,'search')]")
		 private WebElement search_field;
			
		public WebElement searchUser()
		{
			return search_field;
		}
		
		
		public WebElement clickAction(String assessmentType)
		{
			WebElement clickAction = driver.findElement(By.xpath("//td[contains(text(),'"+assessmentType+"')]/..//span[contains(text(),'Planned')]/../following-sibling::td//img[@title='Update Status']"));
			return clickAction;
			
		}
		
		@FindBy(id="staticEmail")
		private WebElement Actionstatus;
		
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
		

		public WebElement Assertforschedule(String templateName, String assessmentType)
		{
			//WebElement Assertforschedule = driver.findElement(By.xpath("//label[contains(text(),'"+templateName+"')]/../..//td[contains(text(),'"+assessmentType+"')]/..//td[contains(text(),'Onetime')]/..//span[contains(text(),'Scheduled')]"));
			  WebElement Assertforschedule = driver.findElement(By.xpath("//label[contains(text(),'"+templateName+"')]/../../..//td[contains(text(),'"+assessmentType+"')]/..//td[contains(text(),'Onetime')]/..//span[contains(text(),'Scheduled')]"));
			return Assertforschedule;
		}
		
		public void selectAssessmentStartDate() throws InterruptedException {
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
			Thread.sleep(2000);
			WebElement selectcurrentYear = driver.findElement(By.xpath("//td//span[contains(text(),'"+overallDate[2]+"')] and not(contains(@class,'disabled'))]"));
			selectcurrentYear.click();
			Thread.sleep(2000);
			WebElement selectMonth = driver.findElement(By.xpath("//td//span[contains(text(),'"+overallDate[1]+"')] and not(contains(@class,'disabled'))]"));
			selectMonth.click();
			Thread.sleep(2000);
			WebElement selectDate = driver.findElement(By.xpath("//td//span[contains(text(),'"+sortedDate+"') and not(contains(@class,'disabled'))]"));
			selectDate.click();
			Thread.sleep(2000);
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
//			WebElement selectDate = driver.findElement(By.xpath("//td//span[contains(text(),'"+sortedDate+"') and not(contains(@class,'disabled'))]"));
			WebElement selectDate = driver.findElement(By.xpath("//td//span[contains(text(),'"+sortedDate+"') and not(contains(@class,'disabled')) and not(contains(@class,'is-other-month'))]"));
			selectDate.click();
		}
		
		public String getDays() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/Mmm/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Using today's date
			c.add(Calendar.DATE, 10); // Adding 10 days
			String output = sdf.format(c.getTime());
			System.out.println(output);
			return output;
		}
		
		public String getCurrentDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/Mmm/yyyy");
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
		
		public WebElement vAssessmentStatus(String framework, String aStatus)
		{
			WebElement vAssessmentStatus = driver.findElement(By.xpath("//label[contains(text(),'"+framework+"')]/../..//td[contains(text(),'"+aStatus+"')]"));
			return vAssessmentStatus;
		}
		
		public WebElement verifyStatusWithObs(String template, String aStatus, String oStatus)
		{
			WebElement verifyStatus = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]/../..//td[contains(text(),'"+oStatus+"')]"));
			return verifyStatus;
		}
		
		@FindBy(xpath="//td[normalize-space()='Assessment Review']")
		private WebElement Assessmentreview;
		
		public WebElement Assessmentreview()
		{
			return Assessmentreview;
		}
		
		public WebElement clickEyeIcon(String framework, String aStatus, String obsStatus)
		{
			WebElement clkEyeicon = driver.findElement(By.xpath("//label[contains(text(),'"+framework+"')]/../..//td[contains(text(),'"+aStatus+"')]/..//td[contains(text(),'"+obsStatus+"')]/..//img[contains(@src,'eye')]"));
			return clkEyeicon;
		}
		
		@FindBy(xpath="//textarea[@id='auditorComments']")
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
		
		
		@FindBy(xpath="//div[@class='col-4 px-0']//label[contains(text(),'High')]")
		private WebElement RiskprobabilityCritical;
		
		public WebElement RiskprobabilityCritical()
		{
			return RiskprobabilityCritical;
		}
		
		@FindBy(xpath="//div[@class='col-4 pl-3 pr-0']//label[contains(text(),'High')]")
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
		
		@FindBy(xpath="//input[@id='rd2']")
		private WebElement assessmentreview;
		
		public WebElement assessmentreview()
		{
			return assessmentreview;
		}
		
		@FindBy(xpath="//div[contains(text(),'Review Pending')]/..")
		private WebElement reviewPending_button;
		
		public WebElement clickReviewPendingBtn()
		{
			return reviewPending_button;
		}
		
		public WebElement clickInfoIconWithObs(String template, String aStatus, String oStatus)
		{
			WebElement clkInfoicon = driver.findElement(By.xpath("//label[contains(text(),'"+template+"')]/../..//td[contains(text(),'"+aStatus+"')]/../..//td[contains(text(),'"+oStatus+"')]/..//img[contains(@src,'info')]"));
			return clkInfoicon;
		}

		@FindBy(xpath="(//button[contains(text(),'Yes')])[2]")
		private WebElement submitYesAuditor;
		
		public WebElement asubmityes()
		{
			return submitYesAuditor;
		}
		
		@FindBy(xpath="//div[contains(@class,'lefttabhead w-100 pl-3')][normalize-space()='Observation Closure Percentage']")
		private WebElement ClickonOCPercentage;
		
		public WebElement ClickonOCPercentage()
		{
			return ClickonOCPercentage;
		}
		
		@FindBy(xpath="(//button[normalize-space()='Cancel'])[2]")
		private WebElement ClickoncancelAuditor;
		
		public WebElement ClickoncancelAuditor()
		{
			return ClickoncancelAuditor;
		}
		
		@FindBy(xpath="//a[@id='pills-profile-tab']")
		private WebElement clickVendorResponse;
		
		public WebElement clickVendorResponse()
		{
			return clickVendorResponse;
		}
		
		@FindBy(xpath="//textarea[@id='currentObservation.AuditorComments']")
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
		
		public WebElement observationtitle2(String oName1)
		{
			WebElement observationtitle2 = driver.findElement(By.xpath("//span[contains(text(),'"+oName1+"')]"));
			return observationtitle2;
		}
		
		@FindBy(xpath="(//button[contains(text(),'Yes')])[2]")
		private WebElement AsubmityesObsPlanning;
				
		public WebElement AsubmityesObsPlanning()
		{
		return AsubmityesObsPlanning;
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
		//@FindBy(xpath="(//div[contains(@class,'content-start listrow')][2])")
		private WebElement Observationquestion2;
				
		public WebElement Observationquestion2()
		{
		return Observationquestion2;
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
		
		@FindBy(xpath="//div[contains(@class,'content-start listrow')]")
		private WebElement clickobserQ;
				
		public WebElement clickobserQ()
		{
		return clickobserQ;
		}	
		
		// vendor
		
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
		
		public WebElement Vclickviewicon(String assessment)
		{
			WebElement Vclickviewicon = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'Pending')]/..//img[contains(@src,'eye')]"));
			return Vclickviewicon;
		}
		
		
		@FindBy(xpath="//select[@formcontrolname='MLevel']")
		private WebElement vendorMaturityOptions;
		
		public void selectVendorMaturity(String value)
		{
			Select select = new Select(vendorMaturityOptions);
			  select.selectByVisibleText(value);
		}
		
		@FindBy(xpath="//textarea[@id='ststus']")
		private WebElement description_text;
		
		public WebElement enterDescription()
		{
			return description_text;
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
		
		@FindBy(xpath="//th[contains(text(),'Description')]/../../following-sibling::tbody//input[@type='text']")
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
		
		
//		@FindBy(xpath="(//button[contains(text(),'Submit')])[2]")
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
		
		@FindBy(xpath="//i[contains(@class,'circle-left cursor-pointer')]")
		private WebElement Aclickback;
		
		public WebElement Aclickback()
		{
			return Aclickback;
		}
		
		public WebElement verifyObsStatusVendor(String assessment, String astatus, String oStatus)
		{
			WebElement verifyObsStatus = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'"+astatus+"')]/..//td[contains(text(),'"+oStatus+"')]"));
			return verifyObsStatus;
		}
		
		@FindBy(xpath="//button[normalize-space()='Save']")
		private List<WebElement> Verifysave;
		
		public List<WebElement> Verifysave()
		{
			return Verifysave;
		}
		
		@FindBy(xpath="//button[normalize-space()='Save']")
		private WebElement Vsave;
		
		public WebElement Vsave()
		{
			return Vsave;
		}
		
		public WebElement clickviewiconVendor(String assessment, String astatus, String oStatus)
		{
			WebElement Vclickviewicon = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'"+astatus+"')]/..//td[contains(text(),'"+oStatus+"')]/..//img[contains(@src,'eye')]"));
			return Vclickviewicon;
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
//			Select obj = new Select(observationacceptance);
//			obj.selectByVisibleText(accept);
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
		
		@FindBy(xpath="//textarea[@placeholder='Remarks']")
		private WebElement Vremarks;
		
		public WebElement Vremarks()
		{
			return Vremarks;
		}
		
		
		public WebElement question(String question)
		{
			WebElement questions = driver.findElement(By.xpath("//span[contains(text(),'"+question+"')]"));
			return questions;
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
		
		@FindBy(xpath="(//div[contains(@class,'content-start listrow')])[2]")
		private WebElement VQUESTION2;
				
		public WebElement VQUESTION2()
		{
		return VQUESTION2;
		}	
		
		@FindBy(xpath="//table[contains(@class,'table')]//tbody//tr")
		private List<WebElement> verify_Data;
		
		public List<WebElement> verify_Data()
		{
			return verify_Data;
		}
		
		public WebElement verifyFramework(String framework) {
			WebElement fName = driver.findElement(By.xpath("//label[contains(text(),'"+framework+"')]"));
			return fName;
		}
		
		@FindBy(xpath="//p[contains(text(),'No Data Found')]")
		private WebElement verify_noData;
		
		public WebElement verify_NoDataText()
		{
			return verify_noData;
		}
		
		public WebElement clkInfoIconVendor(String assessment, String astatus, String oStatus)
		{
			WebElement verifyObsStatus = driver.findElement(By.xpath("//label[contains(text(),'"+assessment+"')]/../..//td[contains(text(),'"+astatus+"')]/..//td[contains(text(),'"+oStatus+"')]/..//img[contains(@src,'info')]"));
			return verifyObsStatus;
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
		
}

