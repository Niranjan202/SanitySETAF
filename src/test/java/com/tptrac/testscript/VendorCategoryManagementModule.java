package com.tptrac.testscript;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorCategoryManagementPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class VendorCategoryManagementModule extends BaseClass1 {

	public static FluentWait<WebDriver> fWait;

	@Test(testName="B",priority=1,enabled= true)
	public void AddVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {

	Reporter.log("AddVendorCategory",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	FileLib f=new FileLib();
	String vendorcategoryname= f.getExcelData("AddVendorCategory",1, 3);
	String vendorcategorycode= f.getExcelData("AddVendorCategory",1, 4);
	HomePage h=new HomePage(driver);
	
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	Thread.sleep(4000);
    h.setVendorMenu();
    logger.info("Click on vendor menu");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
    Thread.sleep(2000);
    vc.clickvcmanagement().click();
    logger.info("Click on vendor category management ");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.AddNewvcManagement()));
    Thread.sleep(2000);
    vc.AddNewvcManagement().click();
    logger.info("Click on add new vendor category management ");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogryname()));
    vc.addvendorcateogryname().sendKeys(vendorcategoryname);
    logger.info("entered vendor category name ");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogrycode()));
    vc.addvendorcateogrycode().sendKeys(vendorcategorycode);
    logger.info("entered vendor category code ");
    vc.ClickOnAdd().click();
    logger.info("Added a new vendor category management successfully ");
    String actualText = vc.GetActualUserCreated(vendorcategoryname).getText(); //added parameters
    Assert.assertEquals(actualText,vendorcategoryname);

    }
	
	@Test(testName="B",priority=2,enabled= true)
	public void AddDuplicateVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {

	Reporter.log("AddDuplicateVendorCateory",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	FileLib f=new FileLib();
	String vendorcategoryname= f.getExcelData("AddVendorCategory",1, 3);
	String vendorcategorycode= f.getExcelData("AddVendorCategory",1, 4);
	HomePage h=new HomePage(driver);
	
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	
    h.setVendorMenu();
    logger.info("Click on vendor menu");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
    Thread.sleep(2000);
    vc.clickvcmanagement().click();
    logger.info("Click on vendor category management ");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.AddNewvcManagement()));
    vc.AddNewvcManagement().click();
    logger.info("Click on add new vendor category management ");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogryname()));
    vc.addvendorcateogryname().sendKeys(vendorcategoryname);
    logger.info("entered vendor category name ");
    
    fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogrycode()));
    vc.addvendorcateogrycode().sendKeys(vendorcategorycode);
    logger.info("entered vendor category code ");
    vc.ClickOnAdd().click();
	String save = f.getExcelData("AssertMessage",38, 3);
//	String save1 = ql.saveSuccessfullyassert().getText();
	String actualValue = vc.verifyWarningMesForDuplicateVendorCategory().getText();
	Thread.sleep(4000);
	Assert.assertEquals(actualValue,save);
	Reporter.log("assertTrue",true);
	Thread.sleep(4000);
	vc.clickancel().click();
	Thread.sleep(2000);

    }
	
	

	@Test(priority=3,testName="B",enabled= true)
	public void VeiwvendorCategoryDetails() throws InterruptedException, EncryptedDocumentException, IOException {
	Reporter.log("VeiwvendorCategoryDetails",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	////To veiw vendor user details
	HomePage h=new HomePage(driver);
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	
	h.setVendorMenu();
	Thread.sleep(2000);
	vc.clickvcmanagement().click();
	List<WebElement> list =vc.VeiwVendorcDeatils();
	System.out.println(list.size());
	for (WebElement element : list) {
	System.out.println(element.getText());
	vc.ClickNextPage();
	System.out.println(element.getText());
	}
	}
	
	@Test(priority=4,testName="B",enabled= true)
	public void searchVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {
	Reporter.log("SearchvendorCategoryDetails",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	////To veiw vendor user details
	HomePage h=new HomePage(driver);
	h.setVendorMenu();
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	UsersListPage au=new UsersListPage(driver);
	FileLib f=new FileLib();
	String validData = f.getExcelData("AddVendorCategory",1, 3);
	String invalidData = f.getExcelData("AddVendorCategory",1, 5);
	fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
	Thread.sleep(2000);
	vc.clickvcmanagement().click();
	vc.CategorySearch().sendKeys(validData);
	//au.searchUser().sendKeys(validData);
	if(au.verify_Data().size()>0) {
		Assert.assertTrue(au.verifyUser(validData).isDisplayed());
	}else {
		Assert.fail();
	}
	vc.CategorySearch().clear();
	
	vc.CategorySearch().sendKeys(invalidData);
	
	if(au.verify_Data().size()>0) {
		Assert.fail();
	}else {
		Assert.assertTrue(vc.verify_NoDataText().isDisplayed());
	}
	logger.info("Verfied successfully");
	}
	
	@Test(priority=5,testName="B",enabled= true)
	public void AddITVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {

		Reporter.log("AddVendorCategory",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		FileLib f=new FileLib();
		String vendorcategoryname= f.getExcelData("AddVendorCategory",3, 3);
		String vendorcategorycode= f.getExcelData("AddVendorCategory",3, 4);
		HomePage h=new HomePage(driver);
		 h.setVendorMenu();
		VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	    logger.info("Click on vendor menu");
	    fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
	    Thread.sleep(2000);
	    vc.clickvcmanagement().click();
	    logger.info("Click on vendor category management ");
	    fWait.until(ExpectedConditions.visibilityOf(vc.AddNewvcManagement()));
	    vc.AddNewvcManagement().click(); 
	    logger.info("Click on add new vendor category management ");
	    fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogryname()));
	    vc.addvendorcateogryname().sendKeys(vendorcategoryname);
	    logger.info("entered vendor category name ");
	    
	    fWait.until(ExpectedConditions.visibilityOf(vc.addvendorcateogrycode()));
	    vc.addvendorcateogrycode().sendKeys(vendorcategorycode);
	    logger.info("entered vendor category code ");
	    vc.ClickOnAdd().click();
	    logger.info("Added a new vendor category management successfully ");
	    String actualText = vc.GetActualUserCreated(vendorcategoryname).getText(); //added parameters
	    Assert.assertEquals(actualText,vendorcategoryname);

	    }
}