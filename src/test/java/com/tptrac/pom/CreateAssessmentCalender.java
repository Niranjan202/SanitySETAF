package com.tptrac.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAssessmentCalender {

	@FindBy(xpath="//p[contains(text(),'Assessment')]/..")
	private WebElement LabelAssessment;

	@FindBy(xpath="//span[contains(text(),'Select Framework')]")
	private WebElement dpdFrameworkList;

	@FindBy(xpath="//div[contains(text(),'TPTrac partial Framework')]")
	private WebElement listValueFramework;

	@FindBy(xpath="//span[contains(text(),'Select Assessment Type')]")
	private WebElement dpdAssessmentType;

	@FindBy(xpath="//div[contains(text(),'Operational Risk')]")
	private WebElement listValueAssessmentType;

	@FindBy(xpath="//span[contains(text(),'Select Vendor Category')]")
	private WebElement dpdVendorCategory;

	@FindBy(xpath="//div[contains(text(),'Information Technology')]")
	private WebElement listValueVendorCategory;

	@FindBy(xpath="//span[contains(text(),'Pre-Onboarding')]/input[@name='onbstatusframework']")
	private WebElement optionPreOnboarding;

	@FindBy(xpath="(//span[contains(text(),'Select Vendor Status')])[1]")
	private WebElement dpdVendorStatus;

	@FindBy(xpath="(//div[contains(text(),'Unassessed')])[1]")
	private WebElement chkUnassed;

	@FindBy(xpath="(//span[contains(text(),'Select Vendor')])[1]")
	private WebElement dpdSelectVendor;

	@FindBy(xpath="(//div[contains(text(),'TCS')])[1]")
	private WebElement chkVendor;

	@FindBy(xpath="( //li[contains(text(),' Onetime')])[1]")
	private WebElement selectPeriodicity;

	@FindBy(xpath="(//input[@id='startDate'])[1]")
	private WebElement selectStartDate;

	@FindBy(xpath="(//input[@id='endDate'])[1]")
	private WebElement selectEndDate;

	@FindBy(xpath="(//input[@id='numberOfAssessments'])[1]")
	private WebElement numberOfAssessments;

	@FindBy(xpath="//button[contains(text(),' Generate Calendar Schedule')]")
	private WebElement btnGenerateSchedule;

	@FindBy(xpath="//button[contains(text(),'Plan Assessment')]")
	private WebElement btnPlanAssessment;



	public CreateAssessmentCalender(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

		public WebElement getLabelAssessment() {
			return LabelAssessment;
			}
		public WebElement getFrameworkList() {
			return dpdFrameworkList;
			}
		public void getFrameworkListValue() {
			listValueFramework.click();
			}
		public WebElement getdpdAssessmentType() {
			return dpdAssessmentType;
			}
		public void getlistValueAssessmentType() {
			listValueAssessmentType.click();
			}
		public WebElement getdpdVendorCategory() {
			return dpdVendorCategory;
			}
		public void getlistValueVendorCategory() {
			listValueVendorCategory.click();
			}
		public WebElement getoptionPreOnboarding() {
			return optionPreOnboarding;
			}
		public WebElement getdpdVendorStatus() {
			return dpdVendorStatus;
			}
		public void getlistValuecheckboxUnassesd() {
			chkUnassed.click();
			}
		public void getldpdSelectVendor() {
			dpdSelectVendor.click();
			}

		public void getVendorValue() {
			chkVendor.click();
			}
		public void getselectPeriodicityValue() {
			selectPeriodicity.click();
			}
		public WebElement getStartDatePopup() {
			return selectStartDate;
			}
		public WebElement getselectEndDate() {
			return selectEndDate;
			}
		public WebElement setnumberofAssessments() {
			return numberOfAssessments;
			}
		public void setbtnGenerateSchedule() {
			btnGenerateSchedule.click();
			}

		public void setbtnPlanAssessment() throws InterruptedException {
			btnPlanAssessment.click();
			}
}
