package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VendorCategoryManagementPage {

	WebDriver driver;  //created global variable
	//add vendor caterory
	
	   @FindBy(xpath="//button[normalize-space()='Vendor Category Management']")
	   //@FindBy(css = "[data-automation-id='member-comp-01']")
	   private WebElement clickVendorCategoryManagement;
	 
	   @FindBy(xpath="//button[normalize-space()='Add New Vendor Category']")
	   //@FindBy(css = "[data-automation-id='sector-data-02']")
	   private WebElement AddVendorCategory;
	   
	                   
	   @FindBy(xpath="//div[@id='frameworkModal']//div[@class='row']//div[1]//div[1]//input[1]")
	   //@FindBy(css = "[data-automation-id='sector-data-011']")
	   private WebElement AddVendorCategoryName;
	   
	   
	   @FindBy(xpath="//input[@formcontrolname='SectorCode']")
	   //@FindBy(css = "[data-automation-id='sector-data-012']")
	   private WebElement AddCategorycode;
	   
	   
	  @FindBy(xpath="//button[@class='modalbutton']")
	  // @FindBy(css = "[data-automation-id='sector-data-013']")
	   private WebElement clickAdd;
	   
	   @FindBy(xpath="//td[@title='operation']")
	   private WebElement getActualUserCreated;
	   
	   //update vendor category management
	   
	   @FindBy(css="a[aria-label='Next page']")
		private WebElement NxtButton;
	   
	   @FindBy(xpath="//td[contains(text(),'operation')]")
	   private WebElement Title;
	   
	   @FindBy(xpath="//input[@id='SectorName']")
	   //@FindBy(css = "[data-automation-id='sector-data-CategoryName-09-1']")
	   private WebElement Sectorname;
	   
	  @FindBy(xpath="//input[@id='SectorCode1']")
	   //@FindBy(css = "[data-automation-id='sector-data-CategoryCode-09-1']")
	   private WebElement Sectorcode;
	   
	   
	   @FindBy(xpath="//button[contains(text(),'Save')]")
	   //@FindBy(css = "[data-automation-id='sector-data-save-09-1']")
	   private  WebElement editVendorSave;
	   
	   @FindBy(xpath="//div[@class='dashboardgraph h-100']//div[@class='dashboardgraphbody p-3']")
	   private List<WebElement> veiwvendorcdeatils;

	   @FindBy(xpath="//a[@aria-label='Next page']")
	   private WebElement clickNextpage;
	   
	   @FindBy(xpath="//td[@title='Computer']")
		private WebElement getActualUserUpdated;
	   
       //delete the vendor category management
	   
	   
	   @FindBy(xpath="//img[@alt='Delete']")
	   //@FindBy(xpath="//button[@title='Delete']")
	   private WebElement VDelete;
	   
	   public WebElement selectdelete()
	   {
		  return VDelete;
	   }
	  
	   
	   //@FindBy(xpath="(//button[contains(text(),'Yes')])[last()]") 
	     @FindBy(xpath="//div[@class='ng-star-inserted']//button[@class='alrt-btn'][normalize-space()='Yes']")
	  // @FindBy(xpath="//div[@class='ng-star-inserted']//button[@class='alrt-btn'][normalize-space()='Yes']")
	   private WebElement ConfirmD;
	   
	   
	   
	   public VendorCategoryManagementPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;  // newly added line
		}
	   
	   public WebElement clickvcmanagement() 
	   {
		   
		   return clickVendorCategoryManagement;
	   }
	   

	
	   public WebElement AddNewvcManagement()
	   {
		   return AddVendorCategory;
	   }
	   
	   public WebElement addvendorcateogryname() 
	   {
		   
		   return  AddVendorCategoryName;
	   }
	   
	   public WebElement addvendorcateogrycode() 
	   {
		   
		   return  AddCategorycode;
	   }
	   
	   public WebElement ClickOnAdd()
	   {
		  return clickAdd;
		  
	   }
	   
	   public WebElement GetActualUserCreated(String vendorCategory)
	   {
		   
		  WebElement getActualUserCreated = driver.findElement(By.xpath("//td[@title='"+vendorCategory+"']")); // newly added line
		  return getActualUserCreated; //changed variable name
		   
	   }
	   
	   
	  //update for vcm
	   public WebElement getNxtButton()
	   {
		   return NxtButton;
	   }
	   
	   public void ClikOnNextButton() 
	 	{
		   NxtButton.click();
	 	}
	  
	   public WebElement vctitle(String vendorCategory) 
	   {
		 WebElement Title = driver.findElement(By.xpath("//td[@title='"+vendorCategory+"']")); // newly added line
		 return Title; //changed variable name
	   }
	   
	   
	   public WebElement SectorcName() 
	   {
		return Sectorname;
	   }
		  
	   public WebElement Sectorccode() 
	   {
		   
		   return Sectorcode;
	   }
	   
		  public WebElement editVSave() 
		  {
			 
			 return editVendorSave;
		  }
		  
		  
		  public List<WebElement>VeiwVendorcDeatils()
		  {
			  return veiwvendorcdeatils;
			  }

		  public WebElement ClickNextPage()
		  {
			  return clickNextpage;
			  }
		  
		 

		  public WebElement GetActualUserUpdated(String vendorCategory)
		  {
			  WebElement getActualUserUpdated = driver.findElement(By.xpath("//td[@title='"+vendorCategory+"']")); // newly added line
			  return getActualUserUpdated; //changed variable name
		  }
		  
	 //delete the vendor category management
		 
		  
	   public WebElement Vdelete(String vendorCategory)
	   {
		   
		   WebElement VDelete = driver.findElement(By.xpath("//td[@title='"+vendorCategory+"']/..//button")); // newly added line
		   return  VDelete; //changed variable name
	   }
	   
	   
	 
	   public WebElement cdelete()
	   {
		   return ConfirmD;
	   }
	   
	   public List<WebElement> verifyCategory(String vendorCategory)
	   {
		   
		   List<WebElement> verifyCategoryName = driver.findElements(By.xpath("//td[@title='"+vendorCategory+"']"));
		   if(verifyCategoryName.size()>=1) {
			   Assert.fail("Vendor Category exist");
		   }else {
			   System.out.println("Vendor Category doesnot exist");
		   }
		   return  verifyCategoryName;
	   }
	   
	   @FindBy(xpath="//p[contains(text(),'No Data Found')]")
		private WebElement verify_noData;
		
		public WebElement verify_NoDataText()
		{
			return verify_noData;
		}
		
		//serch vendor category
		
		@FindBy(xpath="//input[@class='form-control searchText mr-2']")
		private WebElement searchcg;
		
		public WebElement CategorySearch()
		{
			return searchcg;
		}
		
		
		@FindBy(xpath="//span[contains(text(),'Vendor Category already exist in the application')]")
		private WebElement warningMsgforDuplicate;
		
		public WebElement verifyWarningMesForDuplicateVendorCategory()
		{
			return warningMsgforDuplicate;
		}
		
		@FindBy(xpath="//button[contains(text(),'Add')]/..//button[contains(text(),'Cancel')]")
		//@FindBy(css = "[data-automation-id='sector-data-014']")
		private WebElement clickCancel;
		
		public WebElement clickancel()
		{
			return clickCancel;
		}
		
		@FindBy(xpath="//td[@title='Service']")
		private WebElement rowselected;
		
		public WebElement rowselected()
		{
			return rowselected;
		}
		
		@FindBy(xpath="//td[@title='Marketing']")
		private WebElement rowselected1;
		
		public WebElement rowselected1()
		{
			return rowselected1;
		}

	}
	   

