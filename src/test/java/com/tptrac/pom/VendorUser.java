package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VendorUser {
	
	WebDriver driver;
	
	 @FindBy(xpath="//button[normalize-space()='Vendor User Management']")
	 private WebElement ClickonVendorUserManagement;
	 
	 @FindBy(xpath="//button[normalize-space()='Add New Vendor User']")
	 private WebElement ClickonVendorUserBtn;
	 
	 @FindBy(xpath="//select[@id='uSector']")
	 private WebElement vendorCategory;
	 
	 @FindBy(id="uMember") 
	 private WebElement vendorName;
	 
	 @FindBy(xpath="//input[@formcontrolname='UserName']") 
	 private WebElement vendorUserID;
	 
	 @FindBy(xpath="//input[@formcontrolname='contactNo']") 
	 private WebElement vendorContactNum;
	 
	 @FindBy(xpath="//button[normalize-space()='Add']")
	 private WebElement Clickonadd;
	 

	 
	 //for view the list of vendor user
	 
	 @FindBy(xpath="//div[@class='col-8']//div[@class='dashboardgraphbody p-3']")
	   private List<WebElement> veiwvendoruserdetails;

	 @FindBy(xpath="//a[@aria-label='Next page']")
	   private WebElement clickNextpage;
	 
	 @FindBy(xpath="//label[contains(text(),'mo_bank_10@secureyesdev.com')]")
	 private WebElement actualVendorUserCreated;
	  
//	 @FindBy(xpath="//input[@formcontrolname='firstName']")
	 @FindBy(xpath="//div[@class='row mt-2']//input[@formcontrolname='firstName']")
	 private WebElement firstName;
	 
//	 @FindBy(xpath="//input[@formcontrolname='lastName']")
	 @FindBy(xpath="//div[@class='col-6']//input[@formcontrolname='lastName']")
	 private WebElement lastName;
	 
//	 @FindBy(xpath="//input[@formcontrolname='EmailID']")
	 @FindBy(xpath="//div[@class='col-6']//input[@formcontrolname='EmailID']")
	 private WebElement email;
	 
	 public VendorUser(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 this.driver = driver;
	 }
	 
	     public WebElement clickonVendorUserMBtn() 
	     {
	    	 return ClickonVendorUserManagement;
	     }
	     
	     public WebElement clickonVendorUser() {
	    	 return ClickonVendorUserBtn;
	     }
	     
	     @FindBy(xpath="//label[contains(text(),'Vendor Category')]/..//span[contains(@class,'dropdown-btn')]")
		 private WebElement vendorCategory_dropdown;
	     
	     public WebElement selectVendorcategory(String category) throws InterruptedException
	     {
//	    	 Select obj = new Select(vendorCategory);
//	   	  	 obj.selectByVisibleText(Category);	
	    	 vendorCategory_dropdown.click();
	    	 Thread.sleep(2000);
	    	 //WebElement selectCategory = driver.findElement(By.xpath("(//div[contains(text(),'"+category+"')])[last()]"));
	    	 WebElement selectCategory = driver.findElement(By.xpath("//ng-multiselect-dropdown[@name='selectedMemberCategory']//div[contains(text(),'Cyber')]"));
	    	 
			return selectCategory;
			
	     }
	     
	     @FindBy(xpath="//label[text()='Vendor']/..//span[contains(@class,'dropdown-btn')]")
		 private WebElement vendorName_dropdown;
	     
	     public WebElement selectVendorName(String vendorname) throws InterruptedException 
	     {
//	    	 	Select obj = new Select(vendorName); 
//	    	 	obj.selectByVisibleText(vendorname);
	    	 vendorName_dropdown.click();
	    	 Thread.sleep(2000);
	    	 //WebElement selectName = driver.findElement(By.xpath("(//div[contains(text(),'"+vendorname+"')])[last()]"));
	    	 WebElement selectName = driver.findElement(By.xpath("//div[contains(text(),'SE Vendor 2')]"));
	    	 
			 return selectName;
			 
	     }
	     
	     public WebElement enterVendorUserID() 
	     {
	    	return vendorUserID; 
	     }
	     
	     public WebElement enterVendorContactNum() 
	     {
	    	return  vendorContactNum;
	     }
	     
	     public WebElement clickonAddButton() 
		  { 
			  return Clickonadd;
		  }
	     
	     
	     public List<WebElement>VeiwVendorUserDetails()
		  {
			  return veiwvendoruserdetails;
			  }

		  public WebElement ClickNextPage()
		  {
			  return clickNextpage;
			
		  }
		  
		  public WebElement getActualVendorUserCreated() {
			     return actualVendorUserCreated;
			    	}
		  
		  public WebElement getFirstName() {
			     return firstName;
			    	}
		  
		  public WebElement getLastName() {
			     return lastName;
			    	}
		  
		  public WebElement getEmail() {
			     return email;
			    	}
		  
		  public WebElement verifyUser(String userId) {
				WebElement createdUser = driver.findElement(By.xpath("//label[contains(text(),'"+userId+"')]"));
				return createdUser;
			}
		  
		  public WebElement verifyVendorUser(String userId) {
				WebElement createdUser = driver.findElement(By.xpath("//td[contains(text(),'"+userId+"')]"));
				return createdUser;
			}
		  
		  public List<WebElement> verifyCategory(String userId)
		   {
			   
			   List<WebElement> verifyUser = driver.findElements(By.xpath("//td[contains(text(),'"+userId+"')]"));
			   if(verifyUser.size()>=1) {
				   Assert.fail("Vendor User exist");
			   }else {
				   System.out.println("Vendor User doesnot exist");
			   }
			   return  verifyUser;
		   }
		  
		//selecting newly added vendoruserid checkbox
			
			@FindBy(xpath="//*[@type='checkbox' and @class='ng-untouched ng-pristine ng-valid']")
			private WebElement selectCBox;
			
			public WebElement ClickCheckbox()
			{
				return selectCBox;
			}
			
			//clicking deactivate button
			@FindBy(xpath="//button[normalize-space()='Deactivate Users']")
			private WebElement deactivate;
			
			public WebElement ClickDeactive()
			{
				return deactivate;
			}
			
			@FindBy(xpath="//div[@class='DeactiveStatus-container']//button[@class='alrt-btn'][normalize-space()='Yes']")
			private WebElement clickYes;
			
			public WebElement Yes()
			{
				return clickYes;
			}
			
			
			// user disabled to active script
			
			@FindBy(xpath="//ng-multiselect-dropdown[@placeholder='Active']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
			private WebElement DropdownSelect;
						
			public WebElement DRselect()
			{
					return DropdownSelect;
			}
			
			// user to export excel file script
			
			@FindBy(xpath="//button[normalize-space()='Export to Excel']")
			private WebElement ExcelClick;
			
			public WebElement ClickExportExcel()
			{
				return ExcelClick;
			}
			
			//selecting All checkbox from the dropdown list
			//@FindBy(xpath="//div[@class='dropdown-list']//li[@class=\"multiselect-item-checkbox ng-star-inserted\"]/div[text()=\"All\"]")
			@FindBy(xpath="//div[normalize-space()='All']")
			private WebElement selectAllcheckbox;
			 
			 public WebElement Allcheckbox()
			 {
				 return selectAllcheckbox;
			 }
         
			 //window header click
			 
			 @FindBy(xpath="//div[@class='modal-header']")
			 private WebElement CilckWindow;
			 
			 public WebElement HeaderClick()
			 {
				 return CilckWindow;
			 }
			 
			 //@FindBy(xpath="//input[@placeholder='Search']")
			 @FindBy(css="input.float-right")
			 private WebElement VuserS;
			 
			 public WebElement VendorUserSearch()
			 {
				 return VuserS;
			 }
			 
			 @FindBy(xpath="//label[contains(text(),'Vendor Category')]/..//span[contains(@class,'dropdown-btn')]")
			 private WebElement vendorCategory_dropdown1;
		     
		     public WebElement selectVendorcategory1(String category) throws InterruptedException
		     {
//		    	 Select obj = new Select(vendorCategory);
//		   	  	 obj.selectByVisibleText(Category);	
		    	 vendorCategory_dropdown.click();
		    	 Thread.sleep(2000);
		    	 //WebElement selectCategory = driver.findElement(By.xpath("(//div[contains(text(),'"+category+"')])[last()]"));
		    	 WebElement selectCategory = driver.findElement(By.xpath("//ng-multiselect-dropdown[@name='selectedMemberCategory']//div[contains(text(),'IT Category')]"));
		    	 
				return selectCategory;
				
		     }
		     
		     @FindBy(xpath="//label[text()='Vendor']/..//span[contains(@class,'dropdown-btn')]")
			 private WebElement vendorName_dropdown1;
		     
		     public WebElement selectVendorName1(String vendorname) throws InterruptedException 
		     {
//		    	 	Select obj = new Select(vendorName); 
//		    	 	obj.selectByVisibleText(vendorname);
		    	 vendorName_dropdown.click();
		    	 Thread.sleep(2000);
		    	 //WebElement selectName = driver.findElement(By.xpath("(//div[contains(text(),'"+vendorname+"')])[last()]"));
		    	 WebElement selectName = driver.findElement(By.xpath("//div[contains(text(),'OLX')]"));
		    	 
				 return selectName;
				 
		     }
		     
		     @FindBy(xpath="//div[@class='user-mgnt-status ms-3']//ng-multiselect-dropdown[@class='drp-down multi-fit-content singleitemSelect vendor-form ng-untouched ng-valid ng-dirty']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']")
		 	//@FindBy(xpath = "//ng-multiselect-dropdown[@placeholder='Active']//div[@class='multiselect-dropdown']//div//span[@class='dropdown-btn']//span//span[@class='dropdown-multiselect__caret']")
		 	private WebElement DropdownSelect1;

		 	public WebElement DRselect1() {
		 		return DropdownSelect1;
		 	}
			
			
	 }
	


