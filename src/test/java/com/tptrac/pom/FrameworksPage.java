package com.tptrac.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FrameworksPage 
{
	
	WebDriver driver;
	
	public FrameworksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Clicking on Add New Framework Button
	
	@FindBy(xpath="//button[normalize-space()='Add New Framework']")
	//@FindBy(css = "[data-automation-id='framework-1']")
	WebElement ClickonAddNF;
	
	public WebElement ClickonNewFramework()
	{
		return ClickonAddNF;
	}
	
	//Enter Framework Name in the dialogbox 
	
	@FindBy(xpath="//input[@formcontrolname='FrameworkName']")
	//@FindBy(css = "[data-automation-id='framework-24']")
	WebElement enterFrameworkName;
	
	public WebElement EnteredFrameworkName()
	{
		return enterFrameworkName;
	}
		
	//Enter Description details in the dialogbox 
	
	 @FindBy(xpath="//textarea[@id='description2']")
	//@FindBy(css = "[data-automation-id='framework-25']")
	 WebElement enterDescriptions;
	
	public  WebElement EnteredDescription()
	{
		return enterDescriptions;
	}
	
	//Select Hierarchy Level from the dropdown 
	
	@FindBy(xpath="//select[@id='HierarchyLevel']")
	WebElement HierarchyLevel;
	
	public  WebElement selectHierarchy()
	{
		return HierarchyLevel;
	}
	
	public void SelectHierarchy(String string)
	{
		 Select obj = new Select(HierarchyLevel);
		  obj.selectByVisibleText(string);
	}
	
	
	//Click on Add button
	
	@FindBy(xpath="//button[@class='modalbutton btn-default deepwhite submit']")
	//@FindBy(css = "[data-automation-id='framework-27']")
	WebElement clickAdd;
	
	public WebElement Add()
	{
		return clickAdd;
	}
	
	
	//statuscode
	
	
//	@FindBy(xpath="//td[contains(text(),'April 10th New Framework')]/following::td[text()='Initiated']")
//    private WebElement statuscodeInitiated;
					
	public WebElement statusCodeInitiated(String frameworkName)
	{
		WebElement statuscodeInitiated = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::td[text()='Initiated']"));	
		return  statuscodeInitiated;
	}
	
//	@FindBy(xpath="//td[contains(text(),'April 10th New Framework')]/following::td[text()='Submitted']")
//    private WebElement statuscodeSubmitted;
					
	public WebElement statusCodeSubmitted(String frameworkName)
	{
		WebElement statuscodeSubmitted = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::td[text()='Submitted']"));
		return  statuscodeSubmitted;
	}
	
//	@FindBy(xpath="//td[contains(text(),'April 10th New Framework')]/following::td[text()='Modification']")
//   private WebElement statuscodeModification;
					
	public WebElement statusCodeModification(String frameworkName)
	{
		WebElement statuscodeModification = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::td[text()='Modification']"));
		return  statuscodeModification;
	}
	
//	@FindBy(xpath="//td[contains(text(),'April 10th New Framework')]/following::td[text()='Approved']")
 //   private WebElement statuscodeApproved;
					
	public WebElement statusCodeApproved(String frameworkName)
	{
		WebElement statuscodeApproved = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::td[text()='Approved']"));	
		return  statuscodeApproved;
	}
	 
	
	
	@FindBy(xpath="//td[text()='April 10th New Framework']")
	   private WebElement getframeworkUserCreated;
	
	
	 public WebElement GetActualFrameworkCreated(String frameworkName)
	   {
		   WebElement verifyFrameworkName = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]"));
		   return verifyFrameworkName;
	   }
	
//	 @FindBy(xpath="//td[text()='April 16th new Framework']")
//	   private WebElement getframeworkUserCreated1;
	

	 public WebElement GetActualFrameworkCreated1(String frameworkName)
	   {
		   WebElement getframeworkUserCreated1 = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]"));
		   return getframeworkUserCreated1;
	   }

		@FindBy(css="select[name='CategoryName']")
		   private WebElement vendorcategory;
		
		public WebElement Vendorcategory()
		   {
			   return vendorcategory;
		   }
	
		@FindBy(xpath="//label[@for='Vendor Category']/..//span[contains(text(),'Vendor Category')]/..")
		   private WebElement clickvendorcategory;
		
		public WebElement VendorCategory(String category)
		{
//			 Select obj = new Select(vendorcategory);
//			  obj.selectByVisibleText(string);
			clickvendorcategory.click();
			WebElement selectCategory = driver.findElement(By.xpath("//label[@for='Vendor Category']/..//input[@aria-label='"+category+"']/.."));
			   return selectCategory;
			   
		}
		
		
		@FindBy(xpath="//textarea[@id='Comments2']")
		   private WebElement comment;
		
		public WebElement clickcomment()
		   {
			   return comment;
		   }
		
		@FindBy(xpath="//button[normalize-space()='Save']")
		   private WebElement Updatesave;
		
		public WebElement updatesave()
		   {
			   return Updatesave;
		   }
		
		
		//@FindBy(xpath="//option[text()=' IT Category']")
		  // private WebElement actualcategoryupdate;
		@FindBy(xpath="//span[contains(text(),'IT Category')]")
		   private WebElement actualcategoryupdate;
		
		public WebElement actualCategoryupdate()
		   {
			   return actualcategoryupdate;
		   }
		
		@FindBy(xpath="//div[@class='col-9']//div[@class='dashboardgraphbody p-3']")
		   private List<WebElement> Veiwframeworklist;
		
		public List<WebElement> veiwframeworklist()
		   {
			   return Veiwframeworklist;
		   }
		
		@FindBy(xpath="//li[contains(@class,'pagination-next')]//a[@aria-label='> page']") //xpath change
		   private WebElement clickNext;
		
		public WebElement ClickNext()
		   {
			   return clickNext;
		   }
		
        //delete framework
//		@FindBy(xpath="//td[text()='April 16th new Framework']/following::img[@alt='Delete']")
//		   private WebElement clickDelete;
		
		public WebElement clickDelete(String frameworkName)
		   {
			   WebElement clickDelete = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::img[@alt='Delete']"));
			   return clickDelete;
		   }
		@FindBy(css="div[class='modal-body2 deletemodalbody'] button[class='modalconfirmbutton']")
		   private WebElement yesDelete;
		
		public WebElement YesDelete()
		   {
			   return yesDelete;
		   }
		
		//node meta
		
		
		@FindBy(xpath="//td[text()='April 10th New Framework']/following::span[@title='Node Meta']")
		   private WebElement clicknodeMeta;
		
		public WebElement ClicknodeMeta(String frameworkName)
		   {
			WebElement clicknodeMeta = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::span[@title='Node Meta']"));
			   return clicknodeMeta;
		   }
		
		@FindBy(xpath="//button[normalize-space()='Add Node Meta']")
		   private WebElement AddnodeMeta;
		
		public WebElement AddNodeMeta()
		   {
			   return AddnodeMeta;
		   }
		
		@FindBy(xpath="//td[normalize-space()='Domain code']")
		   private WebElement actualnodemetaadd;
		
		public WebElement actualNodemetaadd()
		   {
			   return actualnodemetaadd;
		   }
		
		@FindBy(xpath="//td[normalize-space()='Control code']")
		   private WebElement actualnodemetaadd1;
		
		public WebElement actualNodemetaadd1()
		   {
			   return actualnodemetaadd1;
		   }
		@FindBy(xpath="//td[normalize-space()='Domain1 code']")
		   private WebElement actualnodemetaupdate;
		
		public WebElement actualNodemetaupdate()
		   {
			   return actualnodemetaupdate;
		   }
		
		@FindBy(xpath="//td[normalize-space()='Control1 code']")
		   private WebElement actualnodemetaupdate1;
		
		public WebElement actualNodemetaupdate1()
		   {
			   return actualnodemetaupdate1;
		   }
		//add meta asset
		
		
		@FindBy(xpath="//a[text()='Test A']")
		   private WebElement actualnodedataadd1;
		
		public WebElement actualNodedataadd1()
		   {
			   return actualnodedataadd1;
		   }
		
		
		@FindBy(xpath="//a[text()='Test B']")
		   private WebElement actualnodedataadd2;
		
		public WebElement actualNodedataadd2()
		   {
			   return actualnodedataadd2;
		   }
		
		//ADDNODE META
		@FindBy(xpath="//div[@id='frameworkModal']//div[@class='row']//div[1]//div[1]//input[1]")
		   private WebElement AddnodeMetacode;
		
		public WebElement AddnodeMetaCode()
		   {
			   return AddnodeMetacode;
		   }
		
		@FindBy(xpath="//input[@formcontrolname='nodemetaCaption']")
		   private WebElement AddnodeMetacaption;
		
		public WebElement AddnodeMetaCaption()
		   {
			   return AddnodeMetacaption;
		   }
	
	    @FindBy(id="NodemetaDescription2")
		   private WebElement AddnodeMetadescription;
		
		public WebElement AddnodeMetaDescription()
		   {
			   return AddnodeMetadescription;
		   }
				
				
		@FindBy(xpath="//div[contains(text(),'Add Node Meta')]/../following-sibling::div//button[contains(text(),'Add')]")
		   private WebElement AddnodeMetasubmit;
		
		public WebElement  AddnodeMetaSubmit()
		   {
			   return  AddnodeMetasubmit;
		   }
		
		//add node child
		
		@FindBy(xpath="//a[@title='Add Node Child']")
		   private WebElement Addnodechild;
		
		public WebElement  AddNodechild()
		   {
			   return  Addnodechild;
		   }
		
		@FindBy(xpath="//div[contains(text(),'Add Node Child Meta')]/../following-sibling::div//input[@formcontrolname='nodemetacode']")
		   private WebElement Addnodechildcode;
		
		public WebElement AddNodechildcode()
		   {
			   return Addnodechildcode;
		   }
		
		@FindBy(xpath="(//label[contains(text(),'Caption')]/..//input[@formcontrolname='nodemetaCaption'])[last()]") //- changed xpath
		   private WebElement Addnodechildcaption;
		
		public WebElement AddNodechildcaption()
		   {
			   return Addnodechildcaption;
		   }
	
	    @FindBy(css="#NodemetaDescription1")
		   private WebElement Addnodechilddescription;
		
		public WebElement AddNodechilddescription()
		   {
			   return Addnodechilddescription;
		   }
		
		@FindBy(xpath="//div[contains(text(),'Add Node Child Meta')]/../following-sibling::div//button[contains(text(),'Add') and @class='modalbutton']")
		   private WebElement addchildsave ;
		
		public WebElement addChildsave()
		   {
			   return addchildsave;
		   }
		
		//Update domain code
		
		@FindBy(xpath="//td[text()='Domain code']/following::img[@class='icons svg123']")
		   private WebElement updatedomaincode;
		
		public WebElement updateDomaincode()
		   {
			   return updatedomaincode;
		   }
		
		@FindBy(xpath="//div[@class='col-md-12']//input[@id='Code']")
		   private WebElement updatecode;
		
		public WebElement Updatecode()
		   {
			   return updatecode;
		   }
		
		
		@FindBy(xpath="//textarea[@id='Description']")
		   private WebElement updatedescription;
		
		public WebElement Updatedescription()
		   {
			   return updatedescription;
		   }
		
		@FindBy(xpath="//div[@class='col-md-12']//input[@id='Caption']")
		   private WebElement updateCation;
		
		public WebElement UpdateCation()
		   {
			   return updateCation;
		   }
		
		//update control code
		
		@FindBy(xpath="//td[text()='Control code']/following::img[@class='icons svg123']")
		   private WebElement updatecontrolcode;
		
		public WebElement updateControlcode()
		   {
			   return updatecontrolcode;
		   }
		
		//Node data
		
//		@FindBy(xpath="//td[text()='April 10th New Framework']/following::span[@title='Node Data']")
//		   private WebElement addnodedata;
		
		public WebElement addNodedata(String frameworkName)
		   {
			  WebElement addnodedata = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::span[@title='Node Data']"));
			   return addnodedata;
		   }
		
		@FindBy(xpath="//button[normalize-space()='Add Domain1 caption']")
		   private WebElement addDomain;
		
		public WebElement addNodedataDomain()
		   {
			   return addDomain;
		   }
		
		
		@FindBy(xpath="//input[@formcontrolname='DomainName']")
		   private WebElement nodedatacaption;
		
		public WebElement nodeDatacaption()
		   {
			   return nodedatacaption;
		   }
		              
		@FindBy(xpath="//input[@class='form-control ng-untouched ng-pristine ng-valid']")
		   private WebElement nodedatacode;
		
		public WebElement nodeDatacode()
		   {
			   return nodedatacode;
		   }
		
		
		@FindBy(xpath="//input[@formcontrolname='weightAge']")
		   private WebElement nodedataweightage;
		
		public WebElement nodeDataweightage()
		   {
			   return nodedataweightage;
		   }
		
		@FindBy(id="domainDescription")
        private WebElement nodedatadescription;
		
		public WebElement nodeDatadescription()
		   {
			   return nodedatadescription;
		   }
		
		@FindBy(xpath="//button[contains(text(),'Add') and contains(@class,'btn-primary')]")
        private WebElement nodedatasave;
		
		public WebElement nodeDatasave()
		   {
			   return  nodedatasave;
		   }
		
		
		
		//edit add delete
		
		
		//edit nodedata
		
		@FindBy(xpath="//a[text()='Test B']/following::img[@alt='Edit']")
        private WebElement nodedataedit;
		
		public WebElement nodeDataedit()
		   {
			   return  nodedataedit;
		   }
		
		@FindBy(xpath="//input[@id='Weightage']")
        private WebElement updateweightagenodedata;
		
		public WebElement updateWeightageNodedata()
		   {
			   return  updateweightagenodedata;
		   }
		
		@FindBy(xpath="//button[normalize-space()='Save']")
        private WebElement editsavenodedata;
		
		public WebElement editSavenodedata()
		   {
			   return  editsavenodedata;
		   }


		
		@FindBy(xpath="//a[text()='Test C']/following::img[@alt='Delete']")
        private WebElement deletenodedata;
		
		public WebElement deleteNodedata()
		   {
			   return  deletenodedata;
		   }
		@FindBy(xpath="//button[text()='Yes ']")
        private WebElement deleteyesnodedata;
		
		public WebElement deleteyesnodedata()
		   {
			   return  deleteyesnodedata;
		   }
		
		@FindBy(xpath="//a[text()='Test B']/following::a[text()='50']")
        private WebElement actualweightageupdated;
		
		public WebElement actualweightageupdated()
		   {
			   return actualweightageupdated;
		   }

		
		

		
		
		
		
		
		//add domain control
		
		@FindBy(xpath="//a[text()='Test A']/following::a[@title='Add Control1 caption']")
        private WebElement adddomaincontrol;
		
		public WebElement adddDomaincontrol()
		   {
			   return  adddomaincontrol;
		   }
	
	//	
		@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-default[1]/app-nodedata[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
        private WebElement addcontrol1caption;
		
		public WebElement addControl1caption()
		   {
			   return addcontrol1caption;
		   }
		
		@FindBy(xpath="//input[@formcontrolname='domainCode']")
        private WebElement addControl1code;
		
		public WebElement addControl1Code()
		   {
			   return  addControl1code;
		   }
		
		@FindBy(xpath="//input[@formcontrolname='weightAge']")
        private WebElement addControl1weightage;
		
		public WebElement addControl1Weightage()
		   {
			   return  addControl1weightage;
		   }
		
		@FindBy(id="domainDescription")
        private WebElement addControl1description;
		
		public WebElement addControl1Description()
		   {
			   return  addControl1description;
		   }
		
		@FindBy(xpath="//button[contains(text(),'Add') and contains(@class,'btn-primary')]")
        private WebElement addControl1save;
		
		public WebElement addControl1Save()
		   {
			   return  addControl1save;
		   }
		
		//ADD control for domain 1
		
		@FindBy(xpath="//a[text()='Test B']/following::a[@title='Add Control1 caption']")
        private WebElement addDomaincontrol1;
		
		public WebElement addDomaincontrol1()
		   {
			   return  addDomaincontrol1;
		   }
		
		//@FindBy(xpath="//div[contains(@class,'col-md-12')]//button[contains(text(),'Submit')]")
		@FindBy(css = "[data-automation-id='framework-nodedata-30']")
        private WebElement Nodedatasubmit;
		
		public WebElement NodeDatasubmit()
		   {
			   return  Nodedatasubmit;
		   }
		
		
		//approve,send back,Reject
		
		
//		@FindBy(xpath="//td[text()='April 10th New Framework']/following::img[@alt='Approve']")
//        private WebElement ApproveNotification;
		
		public WebElement approveNotification(String frameworkName)
		   {
			   WebElement ApproveNotification = driver.findElement(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::img[@alt='Approve']"));
			   return  ApproveNotification;
		   }
		                               
		@FindBy(css=".dashboardthemebutton.btn.btn-success.float-right.border-0")
		//@FindBy(css = "[data-automation-id='framework-nodedata-33']")
        private WebElement NodedataApprove;
		
		public WebElement NodeDataApprove()
		   {
			   return  NodedataApprove;
		   }
		
		@FindBy(xpath="//div[@id='Approve']//textarea[@id='controlMaturity']")
		//@FindBy(css = "[data-automation-id='framework-nodedata-54']")
        private WebElement approvecomment;
		
		public WebElement approveComment()
		   {
			   return  approvecomment;
		   }
		
		@FindBy(xpath="//button[@class='modalbutton'][normalize-space()='Approve']")
		//@FindBy(css = "[data-automation-id='framework-nodedata-55']")
        private WebElement approvesend;
		
		public WebElement approveSend()
		   {
			   return  approvesend;
		   }
		
		
		@FindBy(xpath="//button[contains(text(),'Send Back') and contains(@class,'dashboardthemebutton')]")
        private WebElement Nodedatasendback;
		
		public WebElement  NodeDatasendback()
		   {
			   return   Nodedatasendback;
		   }
		
		
		@FindBy(xpath="//button[@class='dashboardthemebutton float-right ml-2 border-0']")
        private WebElement NodedataReject;
		
		public WebElement NodeDataReject()
		   {
			   return  NodedataReject;
		   }
		
		//sendback commment
		
		
		@FindBy(xpath="//label[contains(text(),'Comments')]/..//textarea[@formcontrolname='SendBackDescription']")
        private WebElement sendbackcomment;
		
		public WebElement sendBackcomment()
		   {
			   return  sendbackcomment;
		   }
		
		//click send back
		
		@FindBy(xpath="//button[@class='modalbutton'][normalize-space()='Send Back']")
        private WebElement clicksendback;
		
		public WebElement clickSendBack()
		   {
			   return  clicksendback;
		   }
		
//		@FindBy(xpath="(//i[@class='more-less fa fa-plus nodedataplusminusicon'])[1]")
//        private WebElement clickplusbutton1;
		
		public WebElement clickPlusbutton1(String domainCaption)
		   {
			WebElement clickplusbutton1 = driver.findElement(By.xpath("//a[contains(text(),'"+domainCaption+"')]/../../..//div[contains(@class,'plusminus')]/a"));
			   return  clickplusbutton1;
		   }
		
		
		@FindBy(xpath="(//i[@class='more-less fa fa-plus nodedataplusminusicon'])[2]")
	    private WebElement clickplusbutton2;
				
		public WebElement clickPlusbutton2()
		{
		return  clickplusbutton2;
		}
		
		//DOMAIN EDIT
		@FindBy(xpath="(//img[@alt='Edit'])[1]")
	    private WebElement clicknodedatadomain1edit;
				
		public WebElement clickNodedatadomainedit()
		{
		return  clicknodedatadomain1edit;
		}
		
		@FindBy(xpath="//input[@id='Code']")
	    private WebElement editnodedatacodeedit;
				
		public WebElement editnodedatacodeedit()
		{
		return  editnodedatacodeedit;
		}
		
		@FindBy(xpath="//input[@id='Weightage']")
	    private WebElement editnodedataweightageedit;
				
		public WebElement editnodedataweightageedit()
		{
		return  editnodedataweightageedit;
		}
		
		@FindBy(xpath="//textarea[@id='editDescription']")
	    private WebElement editnodedatadescriptionedit;
				
		public WebElement editNodedatadescriptionedit()
		{
		return  editnodedatadescriptionedit;
		}
		
		@FindBy(xpath="//textarea[@id='Name']")
	    private WebElement editnodedatacaptionedit;
				
		public WebElement editNodedatacaptionedit()
		{
		return  editnodedatacaptionedit;
		}
		
		
		@FindBy(xpath="//textarea[@id='questions']")
	    private WebElement editnodedataquestionedit;
				
		public WebElement editnodedataquestionedit()
		{
		return  editnodedataquestionedit;
		}
		
		
//		@FindBy(xpath="(//img[@alt='Edit'])[2]")
//	    private WebElement clicknodedatacontrol1edit;
				
		public WebElement clickNodedatacontrol1edit(String controlCaption)
		{
			WebElement clicknodedatacontrol1edit = driver.findElement(By.xpath("//a[contains(text(),'"+controlCaption+"')]/../../following-sibling::div//img[@alt='Edit']"));
			return  clicknodedatacontrol1edit;
		}
		
//		@FindBy(xpath="(//img[@alt='Edit'])[3]")
//	    private WebElement clicknodedatacontrol2edit;
				
		public WebElement clickNodedatacontrol2edit(String controlCaption)
		{
			WebElement clicknodedatacontrol2edit = driver.findElement(By.xpath("//a[contains(text(),'"+controlCaption+"')]/../../following-sibling::div//img[@alt='Edit']"));
			return  clicknodedatacontrol2edit;
		}
		
		@FindBy(xpath="(//img[@alt='Edit'])[4]")
	    private WebElement clicknodedatadomain2edit;
				
		public WebElement clickNodedatadomain2edit()
		{
		return  clicknodedatadomain2edit;
		}
		
//		@FindBy(xpath="(//img[@alt='Edit'])[5]")
//	     private WebElement clickNodedatacontrol3edit;
						
		public WebElement clickNodedatacontrol3edit(String controlCaption)
		{
			WebElement clicknodedatacontrol3edit = driver.findElement(By.xpath("//a[contains(text(),'"+controlCaption+"')]/../../following-sibling::div//img[@alt='Edit']"));
			return  clicknodedatacontrol3edit;
		}
		
		@FindBy(xpath="(//img[@alt='Edit'])[6]")
	     private WebElement clickNodedatacontrol4edit;
						
		public WebElement clickNodedatacontrol4edit()
		{
		return  clickNodedatacontrol4edit;
		}
		
		
		@FindBy(xpath="//button[normalize-space()='Save']")
	     private WebElement clickNodedatasaveedit;
						
		public WebElement clickNodeDatasaveedit()
		{
		return  clickNodedatasaveedit;
		}
		
	
		
		@FindBy(xpath="//a[@class='btn dashboardthemebutton card-arrow-l']")
	     private WebElement notificationclickback;
						
		public WebElement notificationClickback()
		{
		return  notificationclickback;
		}
		
		//@FindBy(xpath="//i[contains(@class,'left cursor-pointer')]/..")
		//@FindBy(xpath="//i[@class='fa fa-chevron-circle-left cursor-pointer']")
		@FindBy(css = "[data-automation-id='framework-nodedata-2']")
	     private WebElement nodedataclickback;
						
		public WebElement nodeDataclickback()
		{
		return  nodedataclickback;
		}
		
		@FindBy(xpath="//span[contains(text(),'Do you still want to delete?')]/../../../../following-sibling::div//button[contains(text(),'Yes')]")
		   private WebElement yesDeleteFramework;
		
		public WebElement YesDelete1()
		   {
			   return yesDeleteFramework;
		   }
	
		@FindBy(xpath="//div[contains(text(),'The total weightage should not exceed 100. Please check and re-enter')]")
		   private WebElement warningmsg;
		
		public WebElement warningMessage()
		{
			return  warningmsg;
		}
		
		@FindBy(xpath="//div[contains(text(),'Add Control1 caption')]/..//span[contains(text(),'×')]")
		   private WebElement closeIcon;
		
		public WebElement closeAddCaptionPopup()
		{
			return  closeIcon;
		}
		
		@FindBy(xpath="//span[contains(text(),'Deleted successfully.')]")
		 private WebElement validateDeletemsg;
		 
		
		public WebElement verifyDeleteMsg() {
			   return validateDeletemsg;
		  }
		
		public WebElement verifyFramework(String fName) {
			WebElement createdUser = driver.findElement(By.xpath("//td[contains(text(),'"+fName+"')]"));
			return createdUser;
		}
		
		public List<WebElement> verifyframework(String frameworkName)
		   {
			   
			   List<WebElement> verifyFramework = driver.findElements(By.xpath("//td[contains(text(),'"+frameworkName+"')]/following::td[text()='Initiated']"));
			   if(verifyFramework.size()>=1) {
				   Assert.fail("Framework exist");
			   }else {
				   System.out.println("Framework doesnot exist");
			   }
			   return  verifyFramework;
		   }
		
		@FindBy(xpath="//input[@class='form-control searchText mr-2']")
		//@FindBy(css = "[data-automation-id='framework-4']")
		private WebElement searchFramework;
		
		public WebElement FrameworkSearch() {
			   return searchFramework;
		  }
		
		//Assertion Related
		
		//Assert related
		 
	 	@FindBy(xpath="//div[contains(text(),'Framework Name is required')]")
		private WebElement FrameworkNameField;
		
		public WebElement FrameworkNameField()
		{
			return FrameworkNameField;
		}
		
		@FindBy(xpath="//button[contains(text(),'Add')]/..//button[contains(text(),'Cancel')]")
		private WebElement clickCancel;
		
		public WebElement clickancel()
		{
			return clickCancel;
		}
		
		
		
}

