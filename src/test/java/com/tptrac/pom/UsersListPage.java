package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tptrac.generic.BaseClass1;

public class UsersListPage {
	BaseClass1 b = new BaseClass1();

	WebDriver driver; // created global variable

	@FindBy(xpath = "//button[normalize-space()='Add New User']")
	private WebElement AddNewUser;

	// @FindBy(id="userMangement-02")
	@FindBy(css = "[data-automation-id='userMangement-02']")
	private WebElement ClickDepart;

	public WebElement ClickDepart() {
		return ClickDepart;
	}

	@FindBy(xpath="//input[@formcontrolname='UserName']")
	//@FindBy(css = "[data-automation-id='userMangement-036']")
	private WebElement UserName;

	@FindBy(xpath="//input[@formcontrolname='contactNo']")
	//@FindBy(css = "[data-automation-id='userMangement-041']")
	private WebElement ContactNo;

	// @FindBy(id="uRole")
	// private WebElement UserRole;

	// @FindBy(xpath="//span[contains(text(),'Select User Role')] |
	// //label[contains(text(),'User Role')]/..//span[contains(@class,'dropdown')]")
	@FindBy(xpath = "//span[contains(text(),'Select User Role')] |//span[text()='Role']/..//span[contains(@class,'dropdown')]")
	private WebElement ClickUserRole;

	@FindBy(xpath = "//td[contains(text(),'bhuban')]")
	private WebElement actualUserCreated;

	@FindBy(xpath = "//a[contains(text(),'Next')]")
	private WebElement nextBtn;

	// @FindBy(xpath="(//button[contains(text(),'Add')])[2]")
	//@FindBy(xpath = "//div[@id='localAuthentication']//button[@type='submit'][normalize-space()='Add']")
	@FindBy(xpath="//div[@id='adAuthentication']//button[@type='submit'][normalize-space()='Add']")
	private WebElement addBtn;

	// for view the list of user
	@FindBy(xpath = "//div[@class='col-8']//div[@class='dashboardgraphbody p-3']")
	private List<WebElement> allUserList;

	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement clickNextpage;

	@FindBy(xpath = "//div[@class='col-md-12']//div[contains(text(),'Super User')]")
	private WebElement rolecheckbox;

	public UsersListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getAddNew() {
		return AddNewUser;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getContactNo() {
		return ContactNo;
	}
	// public WebElement getUserRole() {
	// return UserRole;
	// }

	public WebElement Rolecheckbox() {

		return rolecheckbox;

	}

	public WebElement clickUserRole() {
		return ClickUserRole;
	}

	public WebElement selectuserrole(String userrole) {

		// ClickUserRole.click();
		// WebElement selectuserrole =
		// driver.findElement(By.xpath("//div[normalize-space()='"+userrole+"')]"));
		WebElement selectuserrole = driver
				.findElement(By.xpath("//div[@class='col-md-12']//div[contains(text(),'" + userrole + "')]"));
		return selectuserrole;
	}

	// public void selectUserRole(String role)
	// {
	// Select obj = new Select(UserRole);
	// obj.selectByVisibleText(role);
	// }

	public WebElement getActualUserCreated(String userId) {
		WebElement createdUser = driver.findElement(By.xpath("//td[contains(text(),'" + userId + "')]"));
		return createdUser;
	}

	public WebElement getNextButton() {
		return nextBtn;
	}

	public WebElement getAddButton() {
		return addBtn;
	}

	public List<WebElement> ViewUserDetails() {
		return allUserList;
	}

	public WebElement ClickNextPage() {
		return clickNextpage;
	}

	public List<WebElement> getActualUserCreatedData(String userId) {
		List<WebElement> createdUser = driver.findElements(By.xpath("//td[contains(text(),'" + userId + "')]"));
		if (createdUser.size() >= 1) {
			Assert.fail("User exist");
		} else {
			System.out.println("User doesnot exist");
		}
		return createdUser;
	}

	// @FindBy(xpath="//input[@placeholder='Search' and contains(@class,'search')]")
	// @FindBy(xpath="//input[@class='form-control float-right ng-untouched
	// ng-pristine ng-valid']")
	// @FindBy(xpath="//input[@placeholder='Search' and contains(@class,'form')]")

	@FindBy(css = "input.float-right")
	private WebElement search_field;

	public WebElement searchUser() {
		return search_field;
	}

	@FindBy(xpath = "//table[@id='dataTable']//tbody//tr")
	private List<WebElement> verify_Data;

	public List<WebElement> verify_Data() {
		return verify_Data;
	}

	public WebElement verifyUser(String userId) {
		WebElement createdUser = driver.findElement(By.xpath("//td[contains(text(),'" + userId + "')]"));
		return createdUser;
	}

	@FindBy(xpath = "//div[contains(text(),'No Data Found')]")
	private WebElement verify_noData;

	public WebElement verify_NoDataText() {
		return verify_noData;
	}

	public WebElement getActualUserCreatedForEdit(String userId) {
		WebElement createdUser = driver.findElement(By.xpath("//td[text()='" + userId + "']"));
		return createdUser;
	}

	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> verify_AData;

	public List<WebElement> verify_AData() {
		return verify_AData;
	}

	// new code for select the user role field click

	@FindBy(xpath = "//div[@class='col-md-12']//div[@class='form-group ng-star-inserted']//ng-multiselect-dropdown[@placeholder='Role']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement clickborder;

	public WebElement BorderClick() {
		return clickborder;
	}

	// selecting newly added userid checkbox

	@FindBy(css = "input.ng-star-inserted")
	private WebElement selectCBox;

	public WebElement ClickCheckbox() {
		return selectCBox;
	}

	// clicking deactivate button
	@FindBy(xpath = "//button[normalize-space()='Deactivate Users']")
	private WebElement deactivate;

	public WebElement ClickDeactive() {
		return deactivate;
	}

	@FindBy(xpath = "//div[@class='DeactiveStatus-container']//button[@class='alrt-btn'][normalize-space()='Yes']")
	private WebElement clickYes;

	public WebElement Yes() {
		return clickYes;
	}

	// user disabled to active script for auditor user management

	// @FindBy(xpath="//ng-multiselect-dropdown[@class='drp-down multi-fit-content
	// singleitemSelect vendor-form ng-untouched ng-valid
	// ng-dirty']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	@FindBy(xpath = "//ng-multiselect-dropdown[@class='drp-down multi-fit-content singleitemSelect vendor-form ng-untouched ng-valid ng-dirty']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']//span//span[@class='dropdown-multiselect__caret']")
	private WebElement DropdownSelect;

	public WebElement DRselect() {
		return DropdownSelect;
	}

	// disabled to active script for vendor user management

	//@FindBy(xpath="//div[@class='user-mgnt-status ms-3']//ng-multiselect-dropdown[@class='drp-down multi-fit-content singleitemSelect vendor-form ng-untouched ng-valid ng-dirty']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	@FindBy(xpath = "//ng-multiselect-dropdown[@placeholder='Active']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']//span//span[@class='dropdown-multiselect__caret']")
	private WebElement DropdownSelect1;

	public WebElement DRselect1() {
		return DropdownSelect1;
	}

	// @FindBy(xpath="//div[@class='dropdown-list']//li[@class=\"multiselect-item-checkbox
	// ng-star-inserted\"]/div[text()=\"Disabled\"]")
	@FindBy(xpath = "//div[normalize-space()='Disabled']")
	private WebElement selectcheckbox;

	public WebElement checkbox() {
		return selectcheckbox;
	}

	// clicking activate button
	@FindBy(xpath = "//button[normalize-space()='Activate Users']")
	private WebElement activate;

	public WebElement ClickActive() {
		return activate;
	}

	// user to export excel file script

	@FindBy(xpath = "//button[normalize-space()='Export to Excel']")
	private WebElement ExcelClick;

	public WebElement ClickExportExcel() {
		return ExcelClick;
	}

	@FindBy(xpath = "//div[@class='dropdown-list']//li[@class=\"multiselect-item-checkbox ng-star-inserted\"]/div[text()=\"All\"]")
	private WebElement selectAllcheckbox;

	public WebElement Allcheckbox() {
		return selectAllcheckbox;
	}

	// Assert related

	@FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid ng-star-inserted ng-submitted']//div[@class='error ng-star-inserted'][normalize-space()='User ID is required']")
	private WebElement useridfield;

	public WebElement useridfield() {
		return useridfield;
	}

	@FindBy(xpath = "//div[contains(text(),'First Name is required')]")
	private WebElement firstnamefield;

	public WebElement firstnamefield() {
		return firstnamefield;

	}

	@FindBy(xpath = "//div[contains(text(),'Last Name is required')]")
	private WebElement lastnamefield;

	public WebElement lastnamefield() {
		return lastnamefield;

	}

	@FindBy(xpath = "//div[contains(text(),'Email Id is required')]")
	private WebElement Emailfield;

	public WebElement Emailfield() {
		return Emailfield;

	}

	@FindBy(xpath = "//div[@class='col-md-6']//div[@class='error ng-star-inserted'][normalize-space()='Contact Number is required']")
	private WebElement contactnumberfield;

	public WebElement contactnumberfield() {
		return contactnumberfield;

	}

	@FindBy(xpath = "//div[@class='col-md-6']//div[@class='error ng-star-inserted'][normalize-space()='User Role is required']")
	private WebElement userrolefield;

	public WebElement userrolefield() {
		return userrolefield;

	}

	@FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid ng-star-inserted ng-submitted']//button[@type='button'][normalize-space()='Cancel']")
	private WebElement clickCancel;

	public WebElement clickCancel() {
		return clickCancel;

	}

	@FindBy(css = "[data-automation-id='department-02']")
	private WebElement AddNewDeptBtn;

	public WebElement AddNewDeptBtn() {
		return AddNewDeptBtn;

	}

	@FindBy(xpath = "//div[contains(text(),'Name is required')]")
	private WebElement deptnamefield;

	public WebElement deptnamefield() {
		return deptnamefield;
	}

	@FindBy(css = "[data-automation-id='department-015']")
	private WebElement EnterDeptName;

	public WebElement EnterDeptName() {
		return EnterDeptName;

	}

	@FindBy(css = "[data-automation-id='department-016']")
	private WebElement EnterDeptCode;

	public WebElement EnterDeptCode() {
		return EnterDeptCode;

	}

	@FindBy(css = "[data-automation-id='department-018']")
	private WebElement EnterDeptDesc;

	public WebElement EnterDeptDesc() {
		return EnterDeptDesc;

	}

	@FindBy(css = "[data-automation-id='department-020']")
	private WebElement AddDept;

	public WebElement AddDept() {
		return AddDept;

	}

	// @FindBy(xpath="//div[@class='row
	// mt-2']//div[@class='col-md-6']//input[@placeholder='Range: 1-25, Allowed:
	// (A-Z,a-z,0-9,-,_)']")
	// @FindBy(xpath="//div[@class='row
	// mt-2']//div[@class='col-md-6']//input[@placeholder=\"Range: 1-25, Allowed:
	// ('A-Z','a-z','0-9','-,_')\"]")
	@FindBy(css = "[data-automation-id='userMangement-037']")
	private WebElement FirstName;

	public WebElement EnterFirstname() {
		return FirstName;
	}

	// @FindBy(xpath="//div[@class='col-6']//input[@placeholder='Range: 1-25,
	// Allowed: (A-Z,a-z,0-9,-,_)']")
	// @FindBy(xpath="//div[@class='col-6']//input[@placeholder=\"Range: 1-25,
	// Allowed: ('A-Z','a-z','0-9','-,_')\"]")
	@FindBy(css = "[data-automation-id='userMangement-038']")
	private WebElement LastName;

	public WebElement EnterLastname() {
		return LastName;
	}

	@FindBy(xpath="//input[@formcontrolname='emailID']")
	//@FindBy(css = "[data-automation-id='userMangement-039']")
	private WebElement emailID;

	public WebElement EnterEmailID() {
		return emailID;
	}

	//@FindBy(xpath = "//div[@class='col-md-6']//div[@class='form-group ng-star-inserted']//ng-multiselect-dropdown[@name='uRole']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	  @FindBy(xpath="//div[@class='col-md-12']//div[@class='form-group ng-star-inserted']//ng-multiselect-dropdown[@name='uRole']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
	private WebElement UserRoleClick;

	public WebElement ClickUserRoleField() {
		return UserRoleClick;
	}

	//@FindBy(xpath = "(//div[contains(text(),'Super User')])[3]")
	@FindBy(xpath="//div[@class='col-md-12']//div[contains(text(),'Super User')]")
	private WebElement SelectRole;
	
	public WebElement RoleSelected() {
		return SelectRole;
	}

	@FindBy(css = "[data-automation-id='userMangement-040']")
	private WebElement ClickDepartmentField;

	public WebElement ClickDepartmentField() {
		return ClickDepartmentField;
	}

	@FindBy(xpath = "//div[@class='col-md-6']//div[contains(text(),'HM')]")
	private WebElement DeptSelected;

	public WebElement DeptSelected() {
		return DeptSelected;
	}
	
	@FindBy(css = "[data-automation-id='department-02']")
	private WebElement ClickAddNewDepartment;

	public WebElement ClickAddNewDepartment() {
		return ClickAddNewDepartment;
	}
	
	@FindBy(css = "[data-automation-id='department-020']")
	private WebElement ClickAddDepartmentBtn;

	public WebElement ClickAddDepartmentBtn() {
		return ClickAddDepartmentBtn;
	}
	

}
