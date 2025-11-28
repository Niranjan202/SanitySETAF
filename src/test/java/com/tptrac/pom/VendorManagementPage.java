package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VendorManagementPage {

	WebDriver driver; // created global variable

	 @FindBy(xpath="//button[contains(text(),'Add New Vendor')]")
	//@FindBy(css = "[data-automation-id='member-comp-02']")
	private WebElement ClickAddNewVendor;

	@FindBy(xpath="//input[@formcontrolname='memberCode']")
	//@FindBy(css = "[data-automation-id='member-comp-011']")
	private WebElement ClickVendorCode;

	@FindBy(xpath="//input[@formcontrolname='MemberName1']")
	//@FindBy(css = "[data-automation-id='member-comp-012']")
	private WebElement ClickVendorName;

//	   @FindBy(id="vendorCategoryType")
	// @FindBy(xpath="//span[contains(text(),'Select Category Name')] |
	// //label[contains(text(),'Vendor
	// Category')]/..//span[contains(@class,'dropdown')]")
	@FindBy(xpath = "//ng-multiselect-dropdown[@name='vendorCategoryType']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement ClickVendorCategory;

//	   @FindBy(id="vendorAssociateType")
	@FindBy(xpath = "//span[contains(text(),'Select Associate Type')]")
	private WebElement ClickVendorAssociateType;

//	   @FindBy(id="VendorCriticalityRating")
	@FindBy(xpath = "//span[contains(text(),'Select Vendor Criticality Rating')]")
	private WebElement ClickVendorCriticalityRating;

	@FindBy(id = "RMUserID")
	private WebElement RMUserID;

//	  @FindBy(xpath="//select[@id='vendorType']")
	@FindBy(xpath = "//span[contains(text(),'Select Vendor Type')]")
	private WebElement vendorType;

	@FindBy(xpath = "(//label[@for='vendorRiskRating']/..//span[contains(@class,'selected-item')])[2]")
	private WebElement riskRating;

	@FindBy(xpath = "//textarea[@name='vendorActivity']")
	private WebElement vendorActivity;

	@FindBy(xpath="//div[contains(text(),'Contact')]")
	//@FindBy(css = "[data-automation-id='member-comp-09']")
	private WebElement ClickonContact;

	@FindBy(xpath = "//label[contains(text(),'OLX')]")
	private WebElement actualvendorCreated;

	@FindBy(xpath="//input[@formcontrolname='ContactName1']")
	//@FindBy(css = "[data-automation-id='member-comp-020']")
	private WebElement PrimaryContact;

	@FindBy(xpath="//input[@formcontrolname='ContactEmailID1']")
	//@FindBy(css = "[data-automation-id='member-comp-021']")
	private WebElement PrimaryContactEmail;

	@FindBy(xpath="//input[@formcontrolname='ContactMobile1']")
	//@FindBy(css = "[data-automation-id='member-comp-022']")
	private WebElement PrimaryContactMobile;

	@FindBy(xpath="//input[@formcontrolname='AltContactName1']")
	//@FindBy(css = "[data-automation-id='member-comp-023']")
	private WebElement AlternateContact;

	@FindBy(xpath="//input[@formcontrolname='AltContactEmailID1']")
	//@FindBy(css = "[data-automation-id='member-comp-024']")
	private WebElement AlternateContactEmail;

	@FindBy(xpath="//input[@formcontrolname='AltContactMobile1']")
	//@FindBy(css = "[data-automation-id='member-comp-025']")
	private WebElement AlternateContactMobile;

	@FindBy(xpath = "//input[@placeholder='Search' and contains(@class,'form')]")
	private WebElement SearchVendor;

	public WebElement VendorSearch() {
		return SearchVendor;
	}

	@FindBy(xpath="//button[normalize-space()='Add']")
	//@FindBy(css = "[data-automation-id='member-comp-030']")
	private WebElement AddVendor;

	public WebElement ActualvendorCreated() {
		return actualvendorCreated;

	}

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saving;

	@FindBy(xpath = "//div[@class='dashboardgraphbody p-3']")
	private List<WebElement> veiwvendordeatils;

	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement clickNextpage;

	// click on view vendor history
	// @FindBy(xpath="//td[text()=' Nitin kumar ']/following::img[@class='icons']")
	@FindBy(xpath = "//label[contains(text(),'OLX')]/following::img[@class='icons']")
	private WebElement viewdetails;
	@FindBy(xpath = "///input[@id='5']")
	// @FindBy(xpath="//span[normalize-space()='Critical']//input[@id='4']")
	private WebElement Vendorrisk;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement risksubmit;
	@FindBy(xpath = "//textarea[@id='comment']")
	private WebElement Comment;
	@FindBy(xpath = "//ngb-modal-window[@role='dialog']//button[2]")
	private WebElement Cancel;

	// update vendor
	@FindBy(xpath = "//td[text()=' Kumar Birla ']/following::img[@class='icons svg123']")
	private WebElement usereditclick;;

	@FindBy(xpath = "//td[contains(text(),'Suraj sam')]")
	private WebElement actualvendorupdated;

	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement ClickNext;

	public VendorManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver; // newly added line
	}

	public WebElement clicknewaddvendor() {
		return ClickAddNewVendor;
	}

	public WebElement clickvendorcode() {
		return ClickVendorCode;
	}

	public WebElement clickvendorname() {
		return ClickVendorName;
	}

	public WebElement clickvendorCategory() {
		return ClickVendorCategory;
	}

	public WebElement vendorcategory(String categoryName) {
//			  Select select = new Select(ClickVendorCategory);
//			  select.selectByVisibleText(string);
		ClickVendorCategory.click();
		WebElement webElement = driver.findElement(By.xpath("//div[contains(text(),'" + categoryName + "')]"));
		return webElement;
	}

	public WebElement clickvendorassociatetype() {
		return ClickVendorAssociateType;
	}

	public WebElement vendorassociatetype(String associateType) {
//			  Select select = new Select(ClickVendorAssociateType);
//			  select.selectByVisibleText(string);
		ClickVendorAssociateType.click();
		WebElement webElement = driver
				.findElement(By.xpath("(//div[contains(text(),'" + associateType + "')])[last()]"));
		return webElement;
	}

	public WebElement clickvendortype() {
		return vendorType;
	}

	public WebElement vendortype(String vendorTypeName) {
//			  Select select = new Select(vendorType);
//			  select.selectByVisibleText(string);
		vendorType.click();
		WebElement webElement = driver.findElement(By.xpath("//div[contains(text(),'" + vendorTypeName + "')]"));
		return webElement;
	}

	public WebElement RiskRating() {
		return riskRating;
	}

	public WebElement riskrating(String riskRatingType) {
//			  Select select = new Select(riskRating);
//			  select.selectByVisibleText(string);
		riskRating.click();
		WebElement webElement = driver.findElement(By.xpath("//div[contains(text(),'" + riskRatingType + "')]"));
		return webElement;
	}

	public WebElement clickvendorcriticalityRating() {
		return ClickVendorCriticalityRating;
	}

	public WebElement vendorcriticalityRating(String criticalityRating) {
//			  Select select = new Select(ClickVendorCriticalityRating);
//			  select.selectByVisibleText(string);
		scrollUpToElement(ClickVendorCriticalityRating);
		ClickVendorCriticalityRating.click();
		WebElement vendorcriticalityRatingDropdown = driver.findElement(By.xpath(
				"//span[contains(text(),'Select Vendor Criticality Rating')]/../../following-sibling::div//div[contains(text(),'"
						+ criticalityRating + "')]"));
		scrollUpToElement(vendorcriticalityRatingDropdown);
		return vendorcriticalityRatingDropdown;
	}

	public WebElement RelationshipManager() {
		return RMUserID;
	}

	public void relationshipmanager(String string) {
		Select select = new Select(RMUserID);
		select.selectByVisibleText(string);
	}

	public WebElement vendoractivity() {
		return vendorActivity;
	}

	public WebElement ClickonContact() {
		return ClickonContact;
	}

	public WebElement PrimaryContact() {
		return PrimaryContact;
	}

	public WebElement PrimaryContactEmail() {
		return PrimaryContactEmail;
	}

	public WebElement PrimaryContactMobile() {
		return PrimaryContactMobile;
	}

	public WebElement AlternateContact() {
		return AlternateContact;
	}

	public WebElement AlternateContactEmail() {
		return AlternateContactEmail;
	}

	public WebElement AlternateContactMobile() {
		return AlternateContactMobile;
	}

	public WebElement AddNewVendor() {

		return AddVendor;

	}

	public WebElement vendoruseredit(String vendorName) {
		try {
			WebElement getActualUserCreated = driver.findElement(
					By.xpath("//label[contains(text(),'" + vendorName + "')]/following::img[contains(@alt,'Edit')]")); // newly
																														// added
																														// line
																														// along
																														// with
																														// try
																														// catch
																														// block
			return getActualUserCreated; // changed variable name
		} catch (Exception e) {
			e.printStackTrace(); // newly added line
			return null; // newly added line
		}

	}

	public WebElement Editsave() {
		return saving;
	}

	public List<WebElement> VeiwVendorDeatils() {
		return veiwvendordeatils;
	}

	public WebElement ClickNextPage() {
		return clickNextpage;
	}

	public WebElement Actualvendorupdated(String vendorName) {

		WebElement actualvendorupdated = driver.findElement(By.xpath("//label[contains(text(),'" + vendorName + "')]"));
		return actualvendorupdated;
	}

	// click on view History

	public WebElement Viewdetails() {
		return viewdetails;
	}

	public WebElement vendorrisk() {
		return Vendorrisk;
	}

	public WebElement Risksumbit() {
		return risksubmit;
	}

	public WebElement ClickComment() {
		return Comment;
	}

	public WebElement clicknextbutton() {
		return ClickNext;
	}

	public WebElement clickncancel() {
		return Cancel;

	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollUpToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	@FindBy(xpath = "//span[contains(text(),'Saved successfully.')]")
	private WebElement validatemsg;

	public WebElement verifySavedMsg() {
		return validatemsg;
	}

	public WebElement verifyUser(String vendor) {
		WebElement createdUser = driver.findElement(By.xpath("//label[contains(text(),'" + vendor + "')]"));
		return createdUser;
	}

	@FindBy(xpath = "//input[@placeholder='Search' and contains(@class,'form')]")
	private WebElement search_field;

	public WebElement searchUser1() {
		return search_field;
	}

	@FindBy(xpath = "//ng-multiselect-dropdown[@name='vendorCategoryType']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement DD;

	public WebElement DDclick() {
		return DD;
	}

	// @FindBy(xpath="//div[contains(text(),'IT Category')]")
	@FindBy(xpath = "/html/body/app-root/app-default/app-member/div/div[2]/div/div/form/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/ng-multiselect-dropdown/div/div[2]/ul[2]/li/input")
	private WebElement VCS;

	public WebElement VCategorySelect() {
		return VCS;
	}

	@FindBy(xpath = "//ng-multiselect-dropdown[@placeholder='Select Vendor Type']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']//span//span[@class='dropdown-multiselect__caret']")
	private WebElement DD1;

	public WebElement DD1click() {
		return DD1;
	}

	@FindBy(xpath = "//input[@class='form-control searchText mr-2 ng-untouched ng-pristine ng-valid']")
	private WebElement VSearch;

	public WebElement VendorSearch1() {
		return VSearch;
	}

	@FindBy(css = "//div[@class='modal-footer modalbody pb-5']//button[@class='modalbutton ng-star-inserted'][normalize-space()='Next']")
	private WebElement NextBtn;

	public WebElement NextBtn() 
	{
		return NextBtn;
	}

	@FindBy(css = "//div[@class='form-option lefttab'][normalize-space()='Vendor Risk Rating']")
	private WebElement ClickRiskRating;

	public WebElement ClickRiskRating() {
		return ClickRiskRating;
	}

	@FindBy(xpath = "//div[@class='DeactiveStatus-container']//button[@class='alrt-btn'][normalize-space()='Yes']")
	private WebElement ConfirmationYes;

	public WebElement Confirm() {
		return ConfirmationYes;
	}

	@FindBy(css = "[data-automation-id='member-comp-08']")
	private WebElement ClickVendorST;

	public WebElement ClickVendorST() {
		return ClickVendorST;
	}

	@FindBy(xpath = "//label[contains(text(),'BSNL')]")
	private WebElement actualvendorCreated1;

	public WebElement ActualvendorCreated1() {
		return actualvendorCreated1;

	}
	
	@FindBy(xpath = "//div[@class='modal-footer modalbody pb-5']//button[@type='button'][normalize-space()='Cancel']")
	private WebElement CancelBtn;

	public WebElement CancelBtn() {
		return CancelBtn;

	}
	
	
}
