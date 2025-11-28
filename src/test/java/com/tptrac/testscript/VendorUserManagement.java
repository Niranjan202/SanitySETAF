package com.tptrac.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.DeleteVendorUser;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UpdateUser;
import com.tptrac.pom.UpdateVendorUser;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorUser;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class VendorUserManagement extends BaseClass1 {
	
	public static FluentWait<WebDriver> fWait;

	@Test(testName="G",priority=1,enabled= true)
	public void testAddVendorUser() throws EncryptedDocumentException, IOException, InterruptedException {
		Reporter.log("AddVendorUser",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver);
		h.setUserMenu();
		logger.info("select user tab");
		VendorUser vu = new VendorUser(driver);
		UsersListPage au=new UsersListPage(driver);
		fWait.until(ExpectedConditions.visibilityOf(vu.clickonVendorUserMBtn()));
		vu.clickonVendorUserMBtn().click();
		logger.info("open vendor user management tab");
		fWait.until(ExpectedConditions.visibilityOf(vu.clickonVendorUser()));
		vu.clickonVendorUser().click();
		logger.info("open vendor user page");
		FileLib f=new FileLib();
//		String vendorCategory = f.getExcelData("AddVendorUser",1, 3);
		String vendorCategory = f.getExcelData("AddVendorUser",2, 3);
		logger.info("Read vendor category from the excel successfully");
//		String vendorName=f.getExcelData("AddVendorUser", 1, 4);
		String vendorName=f.getExcelData("AddVendorUser", 2, 4);
		logger.info("Read vendor name from the excel successfully");
		String vendorUserID = f.getExcelData("AddVendorUser", 1, 5);
		logger.info("Read vendor user id from the excel successfully");
		String vendorContactNum = f.getExcelData("AddVendorUser", 1, 6);
		logger.info("Read vendor contact from the excel successfully");
		String firstName = f.getExcelData("AddVendorUser", 2, 7);
		logger.info("Read first name from the excel successfully");
		String lastName = f.getExcelData("AddVendorUser", 2, 8);
		logger.info("Read last name from the excel successfully");
		String email = f.getExcelData("AddVendorUser", 2, 9);
		logger.info("Read email from the excel successfully");
		
		fWait.until(ExpectedConditions.elementToBeClickable(vu.selectVendorcategory(vendorCategory))).click();
		vu.HeaderClick().click();
		logger.info("Select Vendor category ");
		fWait.until(ExpectedConditions.elementToBeClickable(vu.selectVendorName(vendorName))).click();
		logger.info("Select Vendor Name ");
		vu.HeaderClick().click();
		fWait.until(ExpectedConditions.elementToBeClickable(vu.enterVendorUserID())).sendKeys(vendorUserID);
		String cont=vendorContactNum.substring(1, 11);
		logger.info("Read contact number from the excel ");
		fWait.until(ExpectedConditions.elementToBeClickable(vu.getFirstName())).sendKeys(firstName);
		fWait.until(ExpectedConditions.elementToBeClickable(vu.getLastName())).sendKeys(lastName);
		fWait.until(ExpectedConditions.elementToBeClickable(vu.getEmail())).sendKeys(email);
		fWait.until(ExpectedConditions.elementToBeClickable(vu.enterVendorContactNum())).sendKeys(cont);
		logger.info("Entered Vendor Contact Number ");
		fWait.until(ExpectedConditions.elementToBeClickable(vu.clickonAddButton())).click();
		//fWait.until(ExpectedConditions.elementToBeClickable(vu.VendorUserSearch())).sendKeys(vendorUserID);
		//for searching the vendor user
				try {
				    fWait.until(ExpectedConditions.elementToBeClickable(vu.VendorUserSearch()));
				    logger.info("Search user field is clickable");
				    
				    // Focus and enter the value using JavaScript
				    JavascriptExecutor js = (JavascriptExecutor) driver;
				    js.executeScript("arguments[0].focus();", vu.VendorUserSearch());
				    js.executeScript("arguments[0].value='" + vendorUserID + "';", vu.VendorUserSearch());
				    logger.info("Sent keys to search user using JavaScript");
				} catch (ElementNotInteractableException e) {
				    logger.error("Element not interactable, trying to set value via fallback");
				    // Optional: Implement fallback logic if necessary
				}

		logger.info("Click on Add button successfully ");
		String actualText = vu.getActualVendorUserCreated().getText();
		Assert.assertEquals(actualText,vendorUserID);
		logger.info("Verified added vendor user successfully ");
		
		}
	
	@Test(priority= 2,testName="G",enabled= true)
	public void verifyVendorUserDetails() throws InterruptedException {
		Reporter.log("VerifyVendorUserDetails",true);
		FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(10))
	            .pollingEvery(Duration.ofMillis(2000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);
	    
		
	 //To view vendor user list details
		HomePage h=new HomePage(driver);
		h.setUserMenu();
		logger.info("User menu selected ");
		VendorUser vu=new VendorUser(driver);
		
		vu.clickonVendorUserMBtn().click();
		logger.info("Vendor User Management clicked ");
		
		List<WebElement> list =vu.VeiwVendorUserDetails();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
		System.out.println(list.get(i).getText());
		logger.info("Get Vendor user list details ");
		vu.ClickNextPage().click();
		logger.info("Clicked on Next Button successfully");
		System.out.println(list.get(i).getText());
		logger.info("Get Vendor user list details ");
		}
	}
	
	@Test(priority= 3,testName="G",enabled= true)
	public void testUpdateVendorUser() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Reporter.log("UpdateVendorUser",true);
		FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(10))
	            .pollingEvery(Duration.ofMillis(2000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);
		
		FileLib v=new FileLib();
		String phoneNum= v.getExcelData("UpdateVendorUser",1, 6);
		String firstName= v.getExcelData("UpdateVendorUser",1, 7);
		String lastName= v.getExcelData("UpdateVendorUser",1, 8);
		String emailid= v.getExcelData("UpdateVendorUser",1, 9);
		String vendorUserID = v.getExcelData("AddVendorUser", 1, 5);
		String validata= v.getExcelData("UpdateVendorUser",1,10);
		
		HomePage h=new HomePage(driver);
		h.setUserMenu();
		VendorUser vu = new VendorUser(driver);
		fWait.until(ExpectedConditions.visibilityOf(vu.clickonVendorUserMBtn()));
		vu.clickonVendorUserMBtn().click();
		UpdateVendorUser vu1=new UpdateVendorUser(driver);
		UsersListPage au=new UsersListPage(driver);
		
		
		vu1.serachvendoruser().sendKeys(vendorUserID);
		
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.ClickVendorUsertoSelect(vendorUserID))).click();
		//vu1.ClickVendorUsertoSelect(vendorUserID).click();// click on the element if found
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorFirstnameUpdate())).clear();
		//fWait.until(ExpectedConditions.visibilityOf(vu1.VendorFirstnameUpdate()));
		//vu1.VendorFirstnameUpdate().clear();
		logger.info("clearing the data");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorFirstnameUpdate())).sendKeys(firstName);
		//vu1.VendorFirstnameUpdate().sendKeys(firstName);
		logger.info("updated first name ");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorLastnameUpdate())).clear();
		//vu1.VendorLastnameUpdate().clear();
		logger.info("clearing the data");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorLastnameUpdate())).sendKeys(lastName);
		//vu1.VendorLastnameUpdate().sendKeys(lastName);
		logger.info("Updated last name");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorEmailUpdate())).clear();
		//vu1.VendorEmailUpdate().clear();
		logger.info("clearing the data");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorEmailUpdate())).sendKeys(emailid);
		//vu1.VendorEmailUpdate().sendKeys(emailid);
		logger.info("entered new emailid");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.clickonSave())).click();
		//vu1.clickonSave().click();
		logger.info("Click on Save");
//		 Assert.assertTrue(vu1.verifySavedMsg().isDisplayed(),"Vendor user saved successfully");
		String actualText = vu.verifyVendorUser(validata).getText();
		Assert.assertEquals(actualText,validata);
		logger.info("Verified updated vendor user successfully ");
	}
		
	
	@Test(priority= 4,testName="G",enabled= true)
	public void searchVendorUser() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		
		Reporter.log("search updated VendorUser",true);
		FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(10))
	            .pollingEvery(Duration.ofMillis(2000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver);
		h.setUserMenu();
		VendorUser del = new VendorUser(driver);
		VendorUser vu = new VendorUser(driver);
		
		UsersListPage au=new UsersListPage(driver);
		
		FileLib f=new FileLib();
		String validData = f.getExcelData("AddVendorUser",3, 4);
		String invalidData = f.getExcelData("AddVendorUser",1, 10);
		String vendor = f.getExcelData("AddVendorUser",2, 4);
		
		del.clickonVendorUserMBtn().click();
		DeleteVendorUser del1=new DeleteVendorUser(driver);
		fWait.until(ExpectedConditions.visibilityOf(au.searchUser()));
		au.searchUser().sendKeys(validData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.assertTrue(vu.verifyUser(vendor).isDisplayed());
		}else {
			Assert.fail();
		}
		au.searchUser().clear();
		Thread.sleep(2000);
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully");
	}
	
	@Test(priority=5,testName="G",enabled= true)
	public void DisabledVendorUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Add & Disabled Vendor User",true);
		FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(10))
	            .pollingEvery(Duration.ofMillis(2000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver);
		
		h.setUserMenu();
		logger.info("select user tab");
		
		VendorUser vu1 = new VendorUser(driver);
		UsersListPage au=new UsersListPage(driver);
		UpdateVendorUser u1=new UpdateVendorUser(driver);
		vu1.clickonVendorUserMBtn().click();
		logger.info("open vendor user management tab");
	
		vu1.clickonVendorUser().click();
		logger.info("open vendor user page");
		FileLib f=new FileLib();
//		String vendorCategory = f.getExcelData("AddVendorUser",1, 3);
		String vendorCategory = f.getExcelData("AddVendorUser",4, 3);
		logger.info("Read vendor category from the excel successfully");
//		String vendorName=f.getExcelData("AddVendorUser", 1, 4);
		String vendorName=f.getExcelData("AddVendorUser", 4, 4);
		logger.info("Read vendor name from the excel successfully");
		String vendorUserID1 = f.getExcelData("AddVendorUser", 4, 5);
		logger.info("Read vendor user id from the excel successfully");
		String vendorContactNum = f.getExcelData("AddVendorUser", 4, 6);
		logger.info("Read vendor contact from the excel successfully");
		String firstName = f.getExcelData("AddVendorUser", 5, 7);
		logger.info("Read first name from the excel successfully");
		String lastName = f.getExcelData("AddVendorUser", 5, 8);
		logger.info("Read last name from the excel successfully");
		String email = f.getExcelData("AddVendorUser", 5, 9);
		logger.info("Read email from the excel successfully");

		
		//vu1.selectVendorcategory(vendorCategory).click();
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.selectVendorcategory1(vendorCategory))).click();
		vu1.HeaderClick().click();
		logger.info("Select Vendor category ");
		
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.selectVendorName1(vendorName))).click();
		vu1.HeaderClick().click();
		//vu1.selectVendorName(vendorName).click();
		logger.info("Select Vendor Name ");
		
		fWait.until(ExpectedConditions.visibilityOf(vu1.enterVendorUserID())).sendKeys(vendorUserID1);
		//vu1.enterVendorUserID().sendKeys(vendorUserID1);
		String cont=vendorContactNum.substring(1, 11);
		logger.info("Read contact number from the excel ");


		fWait.until(ExpectedConditions.visibilityOf(vu1.getFirstName())).sendKeys(firstName);
		fWait.until(ExpectedConditions.visibilityOf(vu1.getLastName())).sendKeys(lastName);
		fWait.until(ExpectedConditions.visibilityOf(vu1.getEmail())).sendKeys(email);
		fWait.until(ExpectedConditions.visibilityOf(vu1.enterVendorContactNum())).sendKeys(cont);
		
		logger.info("Entered Vendor Contact Number ");
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.clickonAddButton())).click();
		//vu1.clickonAddButton().click();
		//fWait.until(ExpectedConditions.elementToBeClickable(vu.VendorUserSearch())).sendKeys(vendorUserID);
				//for searching the vendor user
		
						/*try {
						    fWait.until(ExpectedConditions.elementToBeClickable(vu1.VendorUserSearch()));
						    logger.info("Search user field is clickable");
						    
						    // Focus and enter the value using JavaScript
						    JavascriptExecutor js = (JavascriptExecutor) driver;
						    js.executeScript("arguments[0].focus();", vu1.VendorUserSearch());
						    js.executeScript("arguments[0].value='" + vendorUserID1 + "';", vu1.VendorUserSearch());
						    logger.info("Sent keys to search user using JavaScript");
						} catch (ElementNotInteractableException e) {
						    logger.error("Element not interactable, trying to set value via fallback");
						    // Optional: Implement fallback logic if necessary
						}*/
		
		//fWait.until(ExpectedConditions.visibilityOf(au.searchUser())).sendKeys(vendorUserID1);
		Thread.sleep(2000);
		au.searchUser().sendKeys(vendorUserID1);
						
		Thread.sleep(2000);	
		fWait.until(ExpectedConditions.elementToBeClickable(u1.ClickVendorUsertoSelect(vendorUserID1))).click();
		Thread.sleep(2000);	
		//u1.ClickVendorUsertoSelect(vendorUserID1).click();
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.ClickCheckbox())).click();
		//vu1.ClickCheckbox().click();
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.ClickDeactive())).click();
		//vu1.ClickDeactive().click();
		fWait.until(ExpectedConditions.visibilityOf(vu1.Yes()));
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.elementToBeClickable(vu1.Yes())).click();
		//vu1.Yes().click();
		
		String invalidData = f.getExcelData("AddVendorUser",4, 5);
		Thread.sleep(2000);
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("Verified successfully");
		
		
		}
	
	@Test(priority=6,testName="G",enabled= true)
	public void ChangeVendorUserStatus() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Reporter.log("ChangeVendorUserStatus",true);
		HomePage h=new HomePage(driver);
		Thread.sleep(4000); 
		h.setUserMenu();
		logger.info("select user tab");
		Thread.sleep(4000);
		VendorUser vu1 = new VendorUser(driver);
		UsersListPage au=new UsersListPage(driver);
		UpdateVendorUser u1=new UpdateVendorUser(driver);
		vu1.clickonVendorUserMBtn().click();
		logger.info("open vendor user management tab");
		Thread.sleep(4000);
		FileLib f=new FileLib();
		Thread.sleep(2000);
		vu1.DRselect1().click();
		Thread.sleep(2000);
		au.checkbox().click();
		Thread.sleep(2000);
		vu1.DRselect1().click();
		Thread.sleep(2000);
		vu1.ClickCheckbox().click();
		Thread.sleep(2000);
		au.ClickActive().click();
		Thread.sleep(2000);
		au.Yes().click();
		Thread.sleep(2000);
		String invalidData = f.getExcelData("AddVendorUser",4, 5);
		logger.info("Get invalid data");
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("User activate successfully");
		}
	
	@Test(priority = 7, testName = "G", enabled = true)
	public void ExportExcel() throws InterruptedException {
	    Reporter.log("Export to Excel test started", true);
	    logger.info("Export to Excel test started");

	    FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(20))
	        .pollingEvery(Duration.ofMillis(1000))
	        .ignoring(NoSuchElementException.class, TimeoutException.class);

	    HomePage homePage = new HomePage(driver);
	    homePage.setUserMenu();
	    logger.info("User menu opened");

	    VendorUser vendorUserPage = new VendorUser(driver);

	    // Open Vendor User Management tab
	    WebElement vendorUserBtn = fWait.until(ExpectedConditions.elementToBeClickable(vendorUserPage.clickonVendorUserMBtn()));
	    vendorUserBtn.click();
	    logger.info("Vendor User Management tab opened");

	    // Click dropdown using JavaScript
	    WebElement dropdown = fWait.until(ExpectedConditions.visibilityOf(vendorUserPage.DRselect1()));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
	    logger.info("Dropdown clicked");

	    // Click "All" checkbox using JavaScript
	    WebElement allCheckbox = fWait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//div[normalize-space()='All']"))); // Update XPath if needed
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allCheckbox);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allCheckbox);
	    logger.info("All checkbox selected");

	    // Wait for Export button, scroll into view, and click using JS
	    WebElement exportBtn = fWait.until(ExpectedConditions.visibilityOf(vendorUserPage.ClickExportExcel()));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exportBtn);
	    Thread.sleep(500); // Let overlays disappear
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exportBtn);
	    logger.info("Export to Excel button clicked");

	    Thread.sleep(2000); // Wait for export to complete
	    logger.info("Export to Excel test completed");
	}
 }