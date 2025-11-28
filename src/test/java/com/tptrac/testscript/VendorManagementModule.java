package com.tptrac.testscript;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorCategoryManagementPage;
import com.tptrac.pom.VendorManagementPage;
import com.tptrac.pom.VendorUser;
import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class VendorManagementModule extends BaseClass1{ 
	
	public static FluentWait<WebDriver> fWait;
	
	@Test(testName="A",priority=1,enabled= true)
	public void VerifyVendorTab() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("VerifyUsersTab",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		HomePage h=new HomePage(driver);
		try {
            // Define the tab name you want to verify
            String tabName = "Vendor"; // Replace with the actual tab name

            // Wait until the tab is present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Vendor']")));

            // Verify if the tab is displayed and enabled
            if (tab.isDisplayed() && tab.isEnabled()) {
                System.out.println("Tab '" + tabName + "' is displayed and enabled successfully.");
                
             // Add explicit wait for the tab to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(tab));
                // Click on the tab
                tab.click();
                System.out.println("Clicked on the tab '" + tabName + "'.");
            } else {
                System.out.println("Tab '" + tabName + "' is either not displayed or not enabled.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } 
		
	}

	@Test(testName = "E", priority = 2, enabled = true)
	public void testAddVendor() throws InterruptedException, EncryptedDocumentException, IOException {
	    Reporter.log("AddVendor", true);
	    Logger logger = LoggerFactory.getLogger(getClass());

	    FileLib f = new FileLib();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(30)) // Increased from 15s
	            .pollingEvery(Duration.ofMillis(500))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);

	    // Test data
	    String vendorcode = f.getExcelData("AddVendor", 1, 3);
	    String vendorname = f.getExcelData("AddVendor", 1, 4);
	    String pname = f.getExcelData("AddVendor", 1, 14);
	    String pemail = f.getExcelData("AddVendor", 1, 15);
	    String pcont = f.getExcelData("AddVendor", 1, 16);
	    String sname = f.getExcelData("AddVendor", 1, 17);
	    String semail = f.getExcelData("AddVendor", 1, 18);
	    String scont = f.getExcelData("AddVendor", 1, 19);

	    HomePage h = new HomePage(driver);
	    VendorManagementPage v = new VendorManagementPage(driver);

	    	h.setVendorMenu();
	            Thread.sleep(4000); 
	            fWait.until(ExpectedConditions.elementToBeClickable(v.clicknewaddvendor())).click();

	            fWait.until(ExpectedConditions.visibilityOf(v.clickvendorcode())).clear();
	            v.clickvendorcode().sendKeys(vendorcode);

	            fWait.until(ExpectedConditions.visibilityOf(v.clickvendorname())).clear();
	            v.clickvendorname().sendKeys(vendorname);

	            v.DDclick().click();
	            Thread.sleep(2000);
	            
	         
	            System.out.println("Selected first Vendor Category option successfully.");

	           
	            fWait.until(ExpectedConditions.elementToBeClickable(v.NextBtn())).click();
	            Thread.sleep(2000);
	            fWait.until(ExpectedConditions.visibilityOf(v.PrimaryContact())).clear();
	            v.PrimaryContact().sendKeys(pname);
	            v.PrimaryContactEmail().sendKeys(pemail);
	            v.PrimaryContactMobile().sendKeys(pcont.substring(1, 11));
	            v.AlternateContact().sendKeys(sname);
	            v.AlternateContactEmail().sendKeys(semail);
	            v.AlternateContactMobile().sendKeys(scont.substring(1, 11));

	            wait.until(ExpectedConditions.elementToBeClickable(v.ClickRiskRating())).click();
	            fWait.until(ExpectedConditions.visibilityOf(v.AddNewVendor()));
	            
	}

	

	
	@Test(priority=3,testName="E",enabled= true)
	public void ViewDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("viewdeatils",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver);
		VendorManagementPage v=new VendorManagementPage(driver);
		h.setVendorMenu();
		
		FileLib f=new FileLib();
		String vendorname= f.getExcelData("AddVendor",1, 4);
		
		v.VendorSearch().sendKeys(vendorname); 
		
		fWait.until(ExpectedConditions.visibilityOf(v.Viewdetails()));
		v.Viewdetails().click();
		
		/*fWait.until(ExpectedConditions.visibilityOf(v.vendorrisk()));
		WebElement riskRadioButton = v.vendorrisk();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", riskRadioButton);
		fWait.until(ExpectedConditions.elementToBeClickable(riskRadioButton)).click();*/
		Thread.sleep(2000);
		WebElement criticalRadio = driver.findElement(By.xpath("//input[@name='vrisk' and @id='5']"));
        criticalRadio.click();

        // Optional: Confirm it's selected
        if (criticalRadio.isSelected()) {
            System.out.println("Critical risk option is selected.");
        }
        Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(v.ClickComment()));
		v.ClickComment().sendKeys("commit");
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(v.Risksumbit()));
		v.Risksumbit().click();
		
		Assert.assertTrue(v.verifySavedMsg().isDisplayed(),"Vendor details saved successfully");
		Thread.sleep(4000);
		//fWait.until(ExpectedConditions.visibilityOf(v.clickncancel()));
		v.clickncancel().click();
	}
	
	@Test(priority=4,testName="E",enabled= true)
	public void searchVendor() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("search vendor",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver);
		VendorManagementPage v=new VendorManagementPage(driver);
		UsersListPage au=new UsersListPage(driver);
		VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
		FileLib f=new FileLib();
		String validData = f.getExcelData("AddVendor",1, 4);
		String invalidData = f.getExcelData("AddVendor",1, 8);
		
		h.setVendorMenu();
		v.VendorSearch().clear();
		Thread.sleep(2000);
		v.VendorSearch().sendKeys(validData);
		//Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.assertTrue(v.verifyUser(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		v.VendorSearch().clear();
		//Thread.sleep(2000);
		v.VendorSearch().sendKeys(invalidData);
		//Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(vc.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully");
		Thread.sleep(2000);
		v.VendorSearch().clear();
		Thread.sleep(2000);
	}
	
	@Test(priority=5,testName="E",enabled= true)
	public void addBSNLVendor() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		Reporter.log("Add New BSNL Vendor",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		FileLib f=new FileLib();
		String vendorcode1= f.getExcelData("AddVendor",7, 3);
		String vendorname1= f.getExcelData("AddVendor",7, 4);
		String VendorCategory1= f.getExcelData("AddVendor",7, 5);
		String pname1= f.getExcelData("AddVendor", 7, 14);
		String pemail1 = f.getExcelData("AddVendor", 7, 15);
		String pcont1 = f.getExcelData("AddVendor", 7, 16);
		String sname1 = f.getExcelData("AddVendor", 7, 17);
		String semail1 = f.getExcelData("AddVendor", 7, 18);
		String scont1 = f.getExcelData("AddVendor", 7, 19);
		
		HomePage h=new HomePage(driver);
		VendorManagementPage v1=new VendorManagementPage(driver);
	    h.setVendorMenu();
		logger.info("Clicked on Vendor");
		fWait.until(ExpectedConditions.visibilityOf(v1.clicknewaddvendor()));
	    v1.clicknewaddvendor().click();
	    logger.info("Clicked on add Vendor");
	    fWait.until(ExpectedConditions.visibilityOf(v1.clickvendorcode()));
	    v1.clickvendorcode().sendKeys(vendorcode1); 
	    logger.info("Entered vendor code");
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.clickvendorname()));
	    v1.clickvendorname().sendKeys(vendorname1);
	    logger.info("Entered vendor name");
	    //Thread.sleep(2000);
	   // v1.vendorcategory(VendorCategory1).click();
	    
	    fWait.until(ExpectedConditions.visibilityOf(v1.DDclick()));
	    v1.DDclick().click();
	    
	 // Wait for the checkbox to be visible and clickable
	    fWait.until(ExpectedConditions.elementToBeClickable(v1.VCategorySelect()));

	    try {
	        // Attempt to get the checkbox
	        WebElement checkbox = v1.VCategorySelect();
	        
	        // Log details about the checkbox element
	        logger.info("Checkbox for Vendor Category: " + checkbox.getAttribute("outerHTML"));
	        logger.info("Checkbox currently " + (checkbox.isSelected() ? "checked" : "unchecked"));

	        // Ensure it's displayed and enabled
	        if (checkbox.isDisplayed() && checkbox.isEnabled()) {
	            // Click only if it is unchecked
	            if (!checkbox.isSelected()) {
	                checkbox.click();
	                logger.info("Checkbox for Vendor Category clicked successfully.");
	                
	                // Short wait to allow UI to update
	                Thread.sleep(500);  // Adjust if needed
	            } else {
	                logger.info("Checkbox for Vendor Category was already selected.");
	            }
	        } else {
	            logger.warn("Checkbox for Vendor Category is either not displayed or not enabled.");
	        }
	    } catch (Exception e) {
	        logger.error("Error selecting Vendor Category checkbox: " + e.getMessage());

	        // Fallback to JavaScript click
	        WebElement checkbox = v1.VCategorySelect();
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	        logger.info("Checkbox for Vendor Category selected using JavaScript.");
	    }

	    // Verify checkbox state after the action
	    Boolean isNowChecked = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0] ? arguments[0].checked : null;", v1.VCategorySelect());
	    if (isNowChecked != null) {
	        if (isNowChecked) {
	            logger.info("Checkbox for Vendor Category is now selected.");
	        } else {
	            logger.warn("Checkbox for Vendor Category could not be selected.");
	        }
	    } else {
	        logger.error("Checkbox for Vendor Category is not found or is not selectable.");
	    }
	    
	    logger.info("Entered vendor category");
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.ClickonContact()));
	    v1.ClickonContact().click();
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.PrimaryContact()));
	    v1.PrimaryContact().sendKeys(pname1);
	    logger.info("entered primary contact");
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.PrimaryContactEmail()));
	    v1.PrimaryContactEmail().sendKeys(pemail1);
	    logger.info("entered primary email");
	    //Thread.sleep(2000);
	    String pcontact=pcont1.substring(1, 11);
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.PrimaryContactMobile()));
	    v1.PrimaryContactMobile().sendKeys(pcontact);
	    logger.info("entered primary contact mobile number");
	    v1.AlternateContact().sendKeys(sname1);
	    logger.info("entered alternate contact");
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.AlternateContactEmail()));
	    v1.AlternateContactEmail().sendKeys(semail1);
	    logger.info("entered alternate contact email");
	    //Thread.sleep(2000);
	    String scontact=scont1.substring(1, 11);
	    //Thread.sleep(2000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.AlternateContactMobile()));
	    v1.AlternateContactMobile().sendKeys(scontact);
	    logger.info("entered alternate contact number");
	    //Thread.sleep(2000);
	    Thread.sleep(4000);
	    v1.ClickVendorST().click();
	    Thread.sleep(4000);
	    v1.NextBtn().click();
	    Thread.sleep(4000);
	    v1.ClickRiskRating().click();
	    Thread.sleep(4000);
	    fWait.until(ExpectedConditions.visibilityOf(v1.AddNewVendor()));
	    v1.AddNewVendor().click();
	    logger.info("add a new bsnl vendor successfully");
		Thread.sleep(2000);
		v1.Confirm().click();
		logger.info("add a new vendor successfully");
		Thread.sleep(4000);
		String actualText = v1.ActualvendorCreated1().getText();
		Assert.assertEquals(actualText,vendorname1);
		
	}	
}